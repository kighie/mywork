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
package kr.simula.formula.def.builder;

import java.math.BigDecimal;

import kr.simula.formula.core.Operator.Unary;
import kr.simula.formula.core.factory.helper.UnaryOperatorHelper;
import kr.simula.formula.core.factory.impl.DecimalUnaryOperatorFactory;
import kr.simula.formula.core.factory.impl.LogicalUnaryOperatorFactory;
import kr.simula.formula.def.ExprTokens;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DefaultUnaryOperatorHelper extends UnaryOperatorHelper {
	
	@Override
	protected void initDefaults() {
		super.initDefaults();

		setFactory(ExprTokens.OP_NUM_NEGATION, new DecimalUnaryOperatorFactory(NEGATE));
		setFactory(ExprTokens.OP_NOT, new LogicalUnaryOperatorFactory(NOT));
	}
	

	public static final Unary<BigDecimal,BigDecimal> NEGATE = new Unary<BigDecimal,BigDecimal>() {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal eval(BigDecimal val) {
			return val.negate();
		};
		
		public String toString() { return "NEGATE";}

	};
	
	public static final Unary<Boolean,Boolean> NOT = new Unary<Boolean,Boolean>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean eval(Boolean val) {
			return !val;
		};
		
		public String toString() { return "NOT";}

	};
}
