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
package kr.simula.formula.core.ref;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.Settable;

/**
 * <pre>
 * External parameter get/set delegator
 * </pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class ParameterRef<T> extends ExternalRef<T> implements Settable<T>{
	/**
	 * @param qname
	 */
	public ParameterRef(QName qname) {
		super(qname);
	}
	
	@Override
	public void set(Context context, T value) {
		context.setReference(qname, value);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public T get(Context context) {
		return (T)context.getReference(qname);
	}
}
