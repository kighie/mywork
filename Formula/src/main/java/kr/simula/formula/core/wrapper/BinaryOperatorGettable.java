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
import kr.simula.formula.core.Operator.Binary;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class BinaryOperatorGettable<T, O1, O2> implements Gettable<T> {

	protected Binary<T, O1, O2> operator;
	protected Gettable<? extends O1> operand1;
	protected Gettable<? extends O2> operand2;
	
	/**
	 * @param operator
	 * @param operand1
	 * @param operand2
	 */
	public BinaryOperatorGettable(Binary<T, O1, O2> operator,
			Gettable<? extends O1> operand1, 
			Gettable<? extends O2> operand2) {
		super();
		this.operator = operator;
		this.operand1 = operand1;
		this.operand2 = operand2;
	}
	
	@Override
	public String getExpression() {
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(operator).append(" ").append(operand1.getExpression())
			.append(" ").append(operand2.getExpression()).append(")");
		return buf.toString();
	}
	
	@Override
	public T get(Context context) {
		return operator.eval(operand1.get(context), operand2.get(context));
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(operator).append(" ").append(operand1).append(" ").append(operand2).append(")");
		return buf.toString();
	}
}
