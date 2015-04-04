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
import kr.simula.formula.core.Literal;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.Operator.Unary;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.factory.UnaryOperatorFactory;
import kr.simula.formula.core.util.GettableUtils;
import kr.simula.formula.core.wrapper.BooleanConstantExpr;
import kr.simula.formula.core.wrapper.LogicalUnaryOperatorGettable;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class LogicalUnaryOperatorFactory implements UnaryOperatorFactory {
	private Unary<Boolean,Boolean>operator;
	
	/**
	 * @param operator
	 */
	public LogicalUnaryOperatorFactory(Unary<Boolean, Boolean> operator) {
		super();
		this.operator = operator;
	}
	

	@Override
	public Gettable<Boolean> create(BuildContext context, String exprToken, Node operand) {
		Gettable<Boolean> gettable = GettableUtils.checkGettable(operand, Boolean.class);
		
		if( gettable instanceof Literal){
			Boolean val = ((Literal<Boolean>)gettable).getValue();
			StringBuilder buf = new StringBuilder();
			buf.append("(").append(operator).append(" ");
			buf.append(gettable.getExpression()).append(")");
			return new BooleanConstantExpr(operator.eval(val), buf.toString()) ;
		}
		
		return new LogicalUnaryOperatorGettable(operator, gettable);
	}

}
