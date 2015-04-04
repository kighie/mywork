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

import kr.simula.formula.core.Node;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.builder.BuildException;
import kr.simula.formula.core.factory.BinaryOperatorFactory;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class BinaryOperatorHelper extends AbstractHelper<BinaryOperatorFactory> {
	
	public Node create(BuildContext context, String expToken , Node operand1, Node operand2){
		BinaryOperatorFactory factory = factories.get(expToken);
		if(factory == null){
			throw new BuildException("BinaryOperatorFactory for " + expToken + " is not registered.");
		}
		return factory.create(context, expToken, operand1, operand2);
	}
}
