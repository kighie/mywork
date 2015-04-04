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

import kr.simula.formula.core.RtException;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class BeanPropertyDelegator<T> implements PropertyDelegator<T> {

	public static final Object[] EMPTY_ARRAY = new Object[0];
	
	private final String fieldName;
	private final Class<T> type;
	private final Method getter;
	private final Method setter;
	
	
	

	/**
	 * @param fieldName
	 * @param type
	 * @param getter
	 * @param setter
	 */
	public BeanPropertyDelegator(String fieldName, Class<T> type, Method getter,
			Method setter) {
		super();
		this.fieldName = fieldName;
		this.type = type;
		this.getter = getter;
		this.setter = setter;
	}

	public Class<T> type(){
		return type;
	}
	
	public String getName(){
		return fieldName;
	}
	
	@SuppressWarnings("unchecked")
	public T get(Object bean){
		try {
			return (T)getter.invoke(bean, EMPTY_ARRAY);
		} catch (Exception e) {
			throw new RtException(e);
		}
	}
	
	public void set(Object bean, Object value){
		try {
			setter.invoke(bean, new Object[]{value});
		} catch (Exception e) {
			throw new RtException(e);
		}
	}
}
