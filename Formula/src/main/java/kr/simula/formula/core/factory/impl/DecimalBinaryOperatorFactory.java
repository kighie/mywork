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

import java.math.BigDecimal;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Literal;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.Operator.Binary;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.factory.BinaryOperatorFactory;
import kr.simula.formula.core.util.GettableUtils;
import kr.simula.formula.core.wrapper.DecimalBinaryOperatorGettable;
import kr.simula.formula.core.wrapper.DecimalConstantExpr;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DecimalBinaryOperatorFactory implements BinaryOperatorFactory {
	private Binary<BigDecimal,BigDecimal,BigDecimal>operator;
	

	/**
	 * @param operator
	 */
	public DecimalBinaryOperatorFactory(
			Binary<BigDecimal, BigDecimal, BigDecimal> operator) {
		this.operator = operator;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Gettable<BigDecimal> create(BuildContext context, String exprToken, Node operand1, Node operand2) {
		Gettable<BigDecimal> gettable1 = GettableUtils.getDecimalGettable(operand1);
		Gettable<BigDecimal> gettable2 = GettableUtils.getDecimalGettable(operand2);
		
		if( (gettable1 instanceof Literal) && (gettable2 instanceof Literal) ) {
			BigDecimal val1 = GettableUtils.getDecimalValue(((Literal)gettable1));
			BigDecimal val2 = GettableUtils.getDecimalValue(((Literal)gettable2));
			
			StringBuilder buf = new StringBuilder();
			buf.append("(").append(operator).append(" ");
			buf.append(gettable1.getExpression()).append(" ").append(gettable2.getExpression()).append(")");
			return new DecimalConstantExpr(operator.eval(val1, val2), buf.toString()) ;
		}
		
		
		return new DecimalBinaryOperatorGettable(operator, gettable1, gettable2);
	}

}
