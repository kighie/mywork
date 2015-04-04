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
package kr.simula.formula.core.factory.helper;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.Ref;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.ref.FieldRef;
import kr.simula.formula.core.ref.ParameterRef;

/**
 * <pre>
 * LiteralHelper creates Literal Nodes (string, number, boolean, date, etc.)
 * </pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class RefHelper {

	/**
	 * TODO
	 * <pre>
	 * </pre>
	 * @param context
	 * @param name
	 * @return
	 */
	public Ref get(BuildContext context, String name){
		QName qname = makeQName(context, name);
		Ref ref = context.getRef(qname);
		
		if(ref != null){
			return ref;
		}
		
		ref = newRef(context, null, qname);
		return ref;
	}

	
	/**
	 * TODO
	 * <pre>
	 * </pre>
	 * @param context
	 * @param parent
	 * @param name
	 * @return
	 */
	public Ref get(BuildContext context, Ref parent, String name){
		QName qname = makeQName(context, parent, name);
		Ref ref = context.getRef(qname);
		
		if(ref != null){
			return ref;
		}
		
		ref = newRef(context, parent, qname);
		return ref;
	}
	
	protected Ref newRef(BuildContext context, Ref parent, QName qname) {
		Ref ref = create(parent, qname);
		context.registerRef(qname, ref);
		return ref;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Ref create(Ref parent, QName qname){
		if(parent != null){
			return new FieldRef(qname, (Gettable<?>)parent);
		} else {
			return new ParameterRef(qname);
		}
	}
	
	/**<pre>
	 * </pre>
	 * @param context
	 * @param parent
	 * @param name
	 */
	protected QName makeQName(BuildContext context, Ref parent, String name) {
		return new QName(parent.qualifiedName(), name);
	}

	/**
	 * TODO 
	 * <pre>
	 * </pre>
	 * @param context
	 * @param exprToken
	 * @param qname
	 * @return
	 */
	protected QName makeQName(BuildContext context, String name) {
		return new QName(name);
	}
}
