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
package kr.simula.formula.core.factory.impl;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.Operator.Binary;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.factory.BinaryOperatorFactory;
import kr.simula.formula.core.util.GettableUtils;
import kr.simula.formula.core.wrapper.StringBinaryOperatorGettable;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class StringBinaryOperatorFactory implements BinaryOperatorFactory {
	private Binary<String,Object,Object>operator;
	

	/**
	 * @param operator
	 */
	public StringBinaryOperatorFactory(
			Binary<String, Object,Object> operator) {
		this.operator = operator;
	}
	
	@Override
	public Gettable<String> create(BuildContext context, String exprToken, Node operand1, Node operand2) {
		Gettable<?> gettable1 = GettableUtils.checkGettable(operand1);
		Gettable<?> gettable2 = GettableUtils.checkGettable(operand2);
		
		return new StringBinaryOperatorGettable(operator, gettable1, gettable2);
	}

}
