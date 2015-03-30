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
package kr.simula.calcula.def.builder;

import java.math.BigDecimal;

import kr.simula.calcula.core.Operator.Binary;
import kr.simula.calcula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.calcula.core.factory.impl.DecimalBinaryOperatorFactory;
import kr.simula.calcula.def.ExprTokens;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DefaultBinaryOperatorHelper extends BinaryOperatorHelper {
	
	@Override
	protected void initDefaults() {
		super.initDefaults();

		setFactory(ExprTokens.OP_MULTI, new DecimalBinaryOperatorFactory(MULTIFLY));
		setFactory(ExprTokens.OP_DIVIDE, new DecimalBinaryOperatorFactory(DIVIDE));
		setFactory(ExprTokens.OP_MOD, new DecimalBinaryOperatorFactory(MOD));
		setFactory(ExprTokens.OP_PLUS, new DecimalBinaryOperatorFactory(ADD));
		setFactory(ExprTokens.OP_MINUS, new DecimalBinaryOperatorFactory(SUBTRACT));
	}

	public static final Binary<BigDecimal,BigDecimal,BigDecimal> MULTIFLY 
		= new Binary<BigDecimal,BigDecimal,BigDecimal>() {
			private static final long serialVersionUID = 1L;

			@Override
			public BigDecimal eval(BigDecimal val1, BigDecimal val2) {
				return val1.multiply(val2);
			}
			
			public String toString() { return "MULTIFLY";};
	};
	
	public static final Binary<BigDecimal, BigDecimal, BigDecimal> DIVIDE = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal eval(BigDecimal val1, BigDecimal val2) {
			return val1.divide(val2);
		}

		public String toString() { return "DIVIDE";};
	};

	public static final Binary<BigDecimal, BigDecimal, BigDecimal> MOD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal eval(BigDecimal val1, BigDecimal val2) {
			return val1.remainder(val2);
		}

		public String toString() { return "MOD";};
	};
	
	public static final Binary<BigDecimal, BigDecimal, BigDecimal> ADD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal eval(BigDecimal val1, BigDecimal val2) {
			return val1.add(val2);
		}

		public String toString() { return "ADD";};
	};
	

	public static final Binary<BigDecimal, BigDecimal, BigDecimal> SUBTRACT = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 1L;

		@Override
		public BigDecimal eval(BigDecimal val1, BigDecimal val2) {
			return val1.subtract(val2);
		}
		
		public String toString() { return "SUBTRACT";};
	};
	
	
}
