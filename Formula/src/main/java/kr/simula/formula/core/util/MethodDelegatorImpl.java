/* ******************************************************************************
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
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class MethodDelegatorImpl<T>  implements MethodDelegator<T> {

	public static final Object[] EMPTY_ARRAY = new Object[0];
	
	private final String name;
	private final Class<T> returnType;
	private final Method method;
	
	
	/**
	 * @param name
	 * @param returnType
	 * @param method
	 */
	public MethodDelegatorImpl(String name, Class<T> returnType, Method method) {
		this.name = name;
		this.returnType = returnType;
		this.method = method;
	}


	@SuppressWarnings("unchecked")
	@Override
	public T eval(Object bean, Object[] args) {
		try {
			return (T)method.invoke(bean, args);
		} catch (Exception e) {
			throw new RtException(e);
		}
	}
	
	@Override
	public Class<T> returnType() {
		return returnType;
	}

	@Override
	public String getName() {
		return name;
	}

}
