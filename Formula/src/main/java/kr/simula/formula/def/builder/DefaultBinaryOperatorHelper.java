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
import java.math.MathContext;
import java.math.RoundingMode;

import kr.simula.formula.core.Operator.Binary;
import kr.simula.formula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.formula.core.factory.impl.CompareBinaryOperatorFactory;
import kr.simula.formula.core.factory.impl.DecimalBinaryOperatorFactory;
import kr.simula.formula.core.factory.impl.LogicalBinaryOperatorFactory;
import kr.simula.formula.core.factory.impl.StringBinaryOperatorFactory;
import kr.simula.formula.def.ExprTokens;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DefaultBinaryOperatorHelper extends BinaryOperatorHelper {

	public static final MathContext DIVIDE_MATH_CONTEXT = new MathContext(10, RoundingMode.HALF_UP);
	
	@Override
	protected void initDefaults() {
		super.initDefaults();

		setFactory(ExprTokens.OP_MULTI, new DecimalBinaryOperatorFactory(MULTIFLY));
		setFactory(ExprTokens.OP_DIVIDE, new DecimalBinaryOperatorFactory(DIVIDE));
		setFactory(ExprTokens.OP_MOD, new DecimalBinaryOperatorFactory(MOD));
		setFactory(ExprTokens.OP_PLUS, new DecimalBinaryOperatorFactory(ADD));
		setFactory(ExprTokens.OP_MINUS, new DecimalBinaryOperatorFactory(SUBTRACT));
		setFactory(ExprTokens.OP_EQ, new CompareBinaryOperatorFactory(EQUALS));
		setFactory(ExprTokens.OP_NOT_EQ, new CompareBinaryOperatorFactory(NOT_EQUALS));
		setFactory(ExprTokens.OP_EQ_GT, new CompareBinaryOperatorFactory(EQUALS_GT));
		setFactory(ExprTokens.OP_GT, new CompareBinaryOperatorFactory(GT));
		setFactory(ExprTokens.OP_EQ_LT, new CompareBinaryOperatorFactory(EQUALS_LT));
		setFactory(ExprTokens.OP_LT, new CompareBinaryOperatorFactory(LT));
		setFactory(ExprTokens.OP_AND, new LogicalBinaryOperatorFactory(AND));
		setFactory(ExprTokens.OP_OR, new LogicalBinaryOperatorFactory(OR));
		setFactory(ExprTokens.OP_CONCAT, new StringBinaryOperatorFactory(CONCAT));
	}

	public static final Binary<BigDecimal,BigDecimal,BigDecimal> MULTIFLY = new Binary<BigDecimal,BigDecimal,BigDecimal>() {
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
			return val1.divide(val2, DIVIDE_MATH_CONTEXT);
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
	

	public static final Binary<Boolean, Comparable<?>, Comparable<?>> EQUALS = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean eval(Comparable<?> val1, Comparable<?> val2) {
			return val1.equals(val2);
		};
		
		public String toString() { return "EQUALS";}

	};

	public static final Binary<Boolean, Comparable<?>, Comparable<?>> NOT_EQUALS = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean eval(Comparable<?> val1, Comparable<?> val2) {
			return !val1.equals(val2);
		};
		
		public String toString() { return "NOT_EQUALS";}

	};

	public static final Binary<Boolean, Comparable<?>, Comparable<?>> EQUALS_GT = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Boolean eval(Comparable val1, Comparable val2) {
			return (val1.compareTo(val2) >= 0);
		};
		
		public String toString() { return "EQUALS_GT";}

	};

	public static final Binary<Boolean, Comparable<?>, Comparable<?>> GT = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Boolean eval(Comparable val1, Comparable val2) {
			return (val1.compareTo(val2) > 0);
		};
		
		public String toString() { return "GT";}

	};
	public static final Binary<Boolean, Comparable<?>, Comparable<?>> EQUALS_LT = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Boolean eval(Comparable val1, Comparable val2) {
			return (val1.compareTo(val2) <= 0);
		};
		
		public String toString() { return "EQUALS_LT";}

	};

	public static final Binary<Boolean, Comparable<?>, Comparable<?>> LT = new Binary<Boolean, Comparable<?>, Comparable<?>>() {
		private static final long serialVersionUID = 1L;

		@SuppressWarnings({ "rawtypes", "unchecked" })
		@Override
		public Boolean eval(Comparable val1, Comparable val2) {
			return (val1.compareTo(val2) < 0);
		};
		
		public String toString() { return "LT";}

	};
	

	public static final Binary<Boolean, Boolean, Boolean> AND = new Binary<Boolean, Boolean, Boolean>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean eval(Boolean val1, Boolean val2) {
			return val1 && val2;
		};
		
		public String toString() { return "AND";}

	};
	

	public static final Binary<Boolean, Boolean, Boolean> OR = new Binary<Boolean, Boolean, Boolean>() {
		private static final long serialVersionUID = 1L;

		@Override
		public Boolean eval(Boolean val1, Boolean val2) {
			return val1 || val2;
		};
		
		public String toString() { return "OR";}

	};
	

	public static final Binary<String, Object, Object> CONCAT = new Binary<String, Object, Object>() {
		private static final long serialVersionUID = 1L;

		@Override
		public String eval(Object val1, Object val2) {
			StringBuilder buf = new StringBuilder();
			buf.append(val1).append(val2);
			return buf.toString();
		};
		
		public String toString() { return "CONCAT";}

	};
}
