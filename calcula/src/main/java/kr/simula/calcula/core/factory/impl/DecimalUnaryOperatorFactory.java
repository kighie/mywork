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
package kr.simula.calcula.core.factory.impl;

import java.math.BigDecimal;

import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Operator.Unary;
import kr.simula.calcula.core.factory.UnaryOperatorFactory;
import kr.simula.calcula.core.util.GettableUtils;
import kr.simula.calcula.core.wrapper.DecimalConstantExpr;
import kr.simula.calcula.core.wrapper.DecimalUnaryOperatorGettable;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DecimalUnaryOperatorFactory implements UnaryOperatorFactory {
	private Unary<BigDecimal,BigDecimal>operator;
	
	/**
	 * @param operator
	 */
	public DecimalUnaryOperatorFactory(Unary<BigDecimal, BigDecimal> operator) {
		super();
		this.operator = operator;
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Gettable<BigDecimal> create(Node operand) {
		Gettable<BigDecimal> gettable = GettableUtils.getDecimalGettable(operand);
		
		if( gettable instanceof Literal){
			BigDecimal val = GettableUtils.getDecimalValue(((Literal)gettable));
			StringBuilder buf = new StringBuilder();
			buf.append("(").append(operator).append(" ");
			buf.append(gettable.getExpression()).append(")");
			return new DecimalConstantExpr(operator.eval(val), buf.toString()) ;
		}
		
		return new DecimalUnaryOperatorGettable(operator, gettable);
	}

}
