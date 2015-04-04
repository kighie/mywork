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

import java.util.List;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.Ref;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.ref.MethodRef;
import kr.simula.formula.core.util.GettableUtils;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class MethodCallHelper {

	
	public Ref create(BuildContext context, Ref parent, String name, List<Node> args){
		QName qname = new QName(parent.qualifiedName(), name);
		
		MethodRef<?> methodRef = newMethodRef(context, parent, qname, args);
		
		context.registerRef(qname, methodRef);
		return methodRef;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	protected MethodRef newMethodRef(BuildContext context, Ref parent, QName qname, List<Node> args) {
		Gettable<?>[] gettables = new Gettable[args.size()];

		for(int i = 0; i<gettables.length ; i++){
			gettables[i] = GettableUtils.checkGettable(args.get(i)) ;
		}
		
		MethodRef methodRef = new MethodRef(qname, (Gettable<?>)parent, gettables);
		
		return methodRef;
	}

}
