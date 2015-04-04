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
package kr.simula.formula.core.wrapper;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Operator.Unary;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class UnaryOperatorGettable<T, O1> implements Gettable<T> {

	protected Unary<T, O1> operator;
	protected Gettable<? extends O1> operand;
	
	public UnaryOperatorGettable(Unary<T, O1> operator, 
			Gettable<? extends O1> operand1 ) {
		this.operator = operator;
		this.operand = operand1;
	}
	
	public T get(Context context) {
		return operator.eval(operand.get(context));
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(operator).append(" ").append(operand).append(")");
		return buf.toString();
	}
	

	@Override
	public String getExpression() {
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(operator).append(" ").append(operand.getExpression()).append(")");
		return buf.toString();
	}
}
