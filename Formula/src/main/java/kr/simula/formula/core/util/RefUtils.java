/* 
 * Copyright (c) 2012 IkChan Kwon kighie@gmail.com
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package kr.simula.formula.core.util;

import java.lang.reflect.Method;
import java.net.URI;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import kr.simula.formula.core.RtException;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class RefUtils {
	public static final Class<?>[] EMPTY_CLASS_ARRAY = new Class[0];
	private static final Map<Class<?>, Class<?>> primitiveWrapperTypeMap = new HashMap<Class<?>, Class<?>>(13);


	static {
		primitiveWrapperTypeMap.put(Boolean.class, boolean.class);
		primitiveWrapperTypeMap.put(Byte.class, byte.class);
		primitiveWrapperTypeMap.put(Character.class, char.class);
		primitiveWrapperTypeMap.put(Double.class, double.class);
		primitiveWrapperTypeMap.put(Float.class, float.class);
		primitiveWrapperTypeMap.put(Integer.class, int.class);
		primitiveWrapperTypeMap.put(Long.class, long.class);
		primitiveWrapperTypeMap.put(Short.class, short.class);
	}

	public static boolean isSimpleValueType(Class<?> clazz) {
		return isPrimitiveOrWrapper(clazz) || clazz.isEnum() ||
				CharSequence.class.isAssignableFrom(clazz) ||
				Number.class.isAssignableFrom(clazz) ||
				Date.class.isAssignableFrom(clazz) ||
				clazz.equals(URI.class) || clazz.equals(URL.class) ||
				clazz.equals(Locale.class) || clazz.equals(Class.class);
	}

	public static boolean isPrimitiveWrapper(Class<?> clazz) {
		return primitiveWrapperTypeMap.containsKey(clazz);
	}
	
	public static boolean isPrimitiveOrWrapper(Class<?> clazz) {
		return (clazz.isPrimitive() || isPrimitiveWrapper(clazz));
	}

	public static boolean isPrimitiveArray(Class<?> clazz) {
		return (clazz.isArray() && clazz.getComponentType().isPrimitive());
	}
	

	static Method getGetter(Class<?>clz, String getterName){
		try {
			return clz.getMethod(getterName, EMPTY_CLASS_ARRAY);
		} catch (Exception e) {
			// DO NOTHING
		}
		return null;
	}

	static Method getSetter(Class<?>clz, String setterName, Class<?> type){
		try {
			return clz.getMethod(setterName, new Class[]{type});
		} catch (Exception e) {
			// DO NOTHING
		}
		return null;
	}

	@SuppressWarnings({ "rawtypes" })
	public static PropertyDelegator getPropertyDelegator(Object bean, String fieldName){
		if( bean instanceof Map ){
			return getMapPropertyDelegator(bean, fieldName);
		} else {
			return getBeanPropertyDelegator(bean, fieldName);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	public static PropertyDelegator getMapPropertyDelegator(Object bean, String fieldName){

		if(!(bean instanceof Map)){
			throw new RtException("MapPropertyDelegator needs map.");
		}
		return new MapPropertyDelegator(fieldName);
		
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static BeanPropertyDelegator getBeanPropertyDelegator(Object bean, String fieldName){
		StringBuilder buf = new StringBuilder(fieldName);
		char u = Character.toUpperCase(buf.charAt(0)) ;
		buf.setCharAt(0, u);
		String getterName = "get" + buf.toString();
		String setterName = "set" + buf.toString();
		Class<?>clz = bean.getClass();
		
		Class<?> type = null;
		Method getter = getGetter(clz, getterName);
		Method setter = null;
		
		if( getter != null ){
			type = getter.getReturnType();
			setter = getSetter(clz, setterName, type);
		}
		
		return new BeanPropertyDelegator(fieldName, type, getter, setter);
		
	}
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static MethodDelegator getMethodDelegator(Object bean, String methodName, Class[] argTypes){
		Class<?>clz = bean.getClass();
		
		if(argTypes == null){
			argTypes = EMPTY_CLASS_ARRAY;
		}
		
		Method method;
		try {
			method = clz.getMethod(methodName,argTypes);
		} catch ( Exception e) {
			throw new RtException(e);
		}

		Class<?> returnType = method.getReturnType();
		
		return new MethodDelegatorImpl(methodName, returnType, method);
		
	}
	
}
