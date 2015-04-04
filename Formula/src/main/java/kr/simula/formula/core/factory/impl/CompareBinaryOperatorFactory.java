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
import kr.simula.formula.core.wrapper.CompareBinaryOperatorGettable;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class CompareBinaryOperatorFactory implements BinaryOperatorFactory {
	private Binary<Boolean, Comparable<?>, Comparable<?>>operator;
	

	/**
	 * @param operator
	 */
	public CompareBinaryOperatorFactory(
			Binary<Boolean, Comparable<?>, Comparable<?>> operator) {
		this.operator = operator;
	}
	
	@Override
	public Gettable<Boolean> create(BuildContext context, String exprToken, Node operand1, Node operand2) {
		Gettable<Comparable<?>> gettable1 = GettableUtils.checkComparableGettable(operand1);
		Gettable<Comparable<?>> gettable2 = GettableUtils.checkComparableGettable(operand2);
		
		return new CompareBinaryOperatorGettable(operator, gettable1, gettable2);
	}

}
