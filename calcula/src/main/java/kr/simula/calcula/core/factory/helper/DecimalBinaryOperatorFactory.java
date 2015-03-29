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
package kr.simula.calcula.core.factory.helper;

import java.math.BigDecimal;

import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Operator.Binary;
import kr.simula.calcula.core.factory.BinaryOperatorFactory;
import kr.simula.calcula.core.util.DecimalUtils;
import kr.simula.calcula.core.wrapper.DecimalBinaryOperatorGettable;
import kr.simula.calcula.core.wrapper.DecimalConstantExpr;

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
	public Gettable<BigDecimal> create(Node operand1, Node operand2) {
		Gettable<BigDecimal> gettable1 = DecimalUtils.getDecimalGettable(operand1);
		Gettable<BigDecimal> gettable2 = DecimalUtils.getDecimalGettable(operand2);
		
		if( (gettable1 instanceof Literal) && (gettable2 instanceof Literal) ) {
			BigDecimal val1 = DecimalUtils.getValue(((Literal)gettable1));
			BigDecimal val2 = DecimalUtils.getValue(((Literal)gettable2));
			
			StringBuilder buf = new StringBuilder();
			buf.append("(").append(operator).append(" ");
			buf.append(val1).append(" ").append(val2).append(")");
			return new DecimalConstantExpr(operator.eval(val1, val2), buf.toString()) ;
		}
		
		
		return new DecimalBinaryOperatorGettable(operator, gettable1, gettable2);
	}

}
