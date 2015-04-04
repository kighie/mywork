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
package kr.simula.formula.core.ref;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Executable;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.Ref;
import kr.simula.formula.core.RtException;
import kr.simula.formula.core.util.MethodDelegator;
import kr.simula.formula.core.util.RefUtils;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class MethodRef<T> extends ExternalRef<T> implements Ref, Gettable<T>, Executable {

	protected final Gettable<?> parent;
	protected final Gettable<?>[] args;
	private MethodDelegator<?> methodDelegator;
	
	/**
	 * @param qname
	 * @param args
	 */
	public MethodRef(QName qname, Gettable<?> parent, Gettable<?>[] args) {
		super(qname);
		this.parent = parent;
		this.args = args;
	}

	@Override
	public String getExpression() {
		return qname.toString();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(Context context) {
		Object[] argArr = new Object[args.length];
		int i = 0;
		for(Gettable<?> n : args){
			argArr[i++] = n.get(context);
		}
		
		Object bean = getBean(context);
		Object returnValue = null;
		
		if(bean != null){
			if(methodDelegator == null){
				Class<?>[] argTypes = new Class[args.length];
				i = 0;
				for(Object a : argArr){
					argTypes[i++] = a.getClass();
				}
				
				methodDelegator = RefUtils.getMethodDelegator(bean, qname.getName(), argTypes);
			}
			
			returnValue = methodDelegator.eval(bean, argArr);
		} else {
			throw new RtException("Ref[" + qname + "] has no parent.");
		}
		
		return (T) returnValue;
	}

	@Override
	public void execute(Context context) {
		get(context);
	}
	
	@Override
	public String toString() {
		return "{mehtod:" + getExpression() + "}";
	}
	

	protected Object getBean(Context context){
		if(parent != null){
			return parent.get(context);
		}
		return null;
	}
}
