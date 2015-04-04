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
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.RtException;
import kr.simula.formula.core.Settable;
import kr.simula.formula.core.util.PropertyDelegator;
import kr.simula.formula.core.util.RefUtils;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FieldRef<T> extends ExternalRef<T> implements Settable<T> {
	protected final Gettable<?> parent;
	protected PropertyDelegator<T> propertyDelegator;
	
	/**
	 * @param qname
	 */
	public FieldRef(QName qname, Gettable<?> parent) {
		super(qname);
		this.parent = parent;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void set(Context context, T value) {
		if(value == null){
			Object bean = getBean(context);
			
			if(bean != null){
				if(propertyDelegator == null){
					propertyDelegator = RefUtils.getPropertyDelegator(bean, qname.getName());
				}
				propertyDelegator.set(bean, value);
			} else {
				throw new RtException("Ref[" + qname + "] has no parent.");
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Context context) {
		Object value = context.getReference(qname);
		
		if(value == null){
			Object bean = getBean(context);
			
			if(bean != null){
				if(propertyDelegator == null){
					propertyDelegator = RefUtils.getPropertyDelegator(bean, qname.getName());
				}
				
				value = propertyDelegator.get(bean);
				
				if(!RefUtils.isSimpleValueType(value.getClass())){
					context.setReference(qname, value);
				}
			} else {
				throw new RtException("Ref[" + qname + "] has no parent.");
			}
		}

		return (T)value;
	}

	protected Object getBean(Context context){
		if(parent != null){
			return parent.get(context);
		}
		return null;
	}
}
