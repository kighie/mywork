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

import kr.simula.calcula.CalculaException;
import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node.ValueType;
import kr.simula.calcula.core.Operator.Binary;
import kr.simula.calcula.core.Operator.Unary;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.util.GettableUtils;
import kr.simula.calcula.core.wrapper.DecimalGettableWrapper;
import kr.simula.calcula.def.ExprTokens;

/**
 * @author kighie@gmail.com
 *
 */
public class OperatorHelper {

	@SuppressWarnings("unchecked")
	protected <T> Gettable<T> getGettable(Gettable<?> ref, Class<T> type){
		if(ref == null) {
			throw new BuildException("node is null.");
		}
		
		if(type.isAssignableFrom( ref.type() )) {
			return (Gettable<T>)ref;
		} else if( (ref instanceof Ref)  ){
			return (Gettable<T>)ref;
		}
		
		return null;
	}

	@SuppressWarnings("unchecked")
	protected Gettable<? extends Number> getNumericGettable(Gettable<?> ref){
		if(ref == null) {
			throw new BuildException("node is null.");
		}
		
		if(Number.class.isAssignableFrom( ref.type() )) {
			return (Gettable<? extends Number>)ref;
		} else if( (ref instanceof Ref) 
				&& (ref.valueType() == ValueType.NUMERIC )){
			
			return (Gettable<? extends Number>)ref;
		}
		throw new CalculaException(ref + " is not numeric.");
	}

	/**
	 * TODO REF
	 * <pre>
	 * </pre>
	 * @param node
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Gettable<BigDecimal> getDecimalGettable(Gettable<?> node){
		if(node == null) {
			throw new BuildException("node is null.");
		}
		
		Class<?> nodeValType = node.type();
		
		if(BigDecimal.class.isAssignableFrom( nodeValType )) {
			return (Gettable<BigDecimal>)node;
		}
		
		if(Number.class.isAssignableFrom( nodeValType )) {
			return new DecimalGettableWrapper(GettableUtils.NUMBER_TO_DECIMAL, node);
		}
		
		
		if(nodeValType == null){
			if(node instanceof Ref) {
				throw new CalculaException("TODO : REF " + node );
			}
		}
		
		throw new CalculaException(node + " is not numeric.");
	}
	
	

	protected abstract class UnaryHolder<T, O1> implements Gettable<T> {
		protected Unary<T, O1> operator;
		protected Gettable<? extends O1> operand1;
		
		public UnaryHolder(Unary<T, O1> operator, 
				Gettable<? extends O1> operand1 ) {
			this.operator = operator;
			this.operand1 = operand1;
		}
		
		public T get(Context context) {
			return operator.eval(operand1.get(context));
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("[").append(operator).append(" ").append(operand1).append("]");
			return buf.toString();
		}
	}
	
	protected abstract class BinaryHolder<T, O1, O2> implements Gettable<T> {
		protected Binary<T, O1, O2> operator;
		protected Gettable<? extends O1> operand1;
		protected Gettable<? extends O2> operand2;
		
		public BinaryHolder(Binary<T, O1, O2> operator, 
				Gettable<? extends O1> operand1, Gettable<? extends O2> operand2) {
			this.operator = operator;
			this.operand1 = operand1;
			this.operand2 = operand2;
		}
		
		public T get(Context context) {
			return operator.eval(operand1.get(context), operand2.get(context));
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("[").append(operator).append(" ").append(operand1).append(" ").append(operand2).append("]");
			return buf.toString();
		}
	}

	/* ************************************************
	 * Number Operators
	 ************************************************ */

	public Negate negate(Gettable<?> operand) {
		Gettable<? extends Number> num = getNumericGettable(operand);
		
		if(num != null) {
			return new Negate(NEGATE, num);
		} else {
			throw new BuildException("<Negate> Illegal operand data type " + operand);
		}
	}

	/**
	 * number negate
	 * @author IkChan Kwon
	 * @since	1.0
	 */
	protected class Negate extends UnaryHolder<BigDecimal, Number> {
		
		/**
		 * @param operator
		 * @param operand1
		 */
		public Negate(Unary<BigDecimal, Number> operator,
				Gettable<? extends Number> operand1) {
			super(operator, operand1);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.NUMERIC;
		}
		
		@Override
		public String getExpression() {
			return ExprTokens.OP_NUM_NEGATION;
		}
		
		public Class<BigDecimal> type() {
			return BigDecimal.class;
		}
	}
	
	public static Unary<BigDecimal, Number> NEGATE = new Unary<BigDecimal, Number>() {
		private static final long serialVersionUID = 1L;

		public String toString() { return "NEGATE"; }

		@Override
		public BigDecimal eval(Number number) {
			if(number instanceof BigDecimal){
				return ((BigDecimal)number).negate();
			} else if(number instanceof Number){
				return new BigDecimal(number.toString()).negate();
			} else {
				throw new CalculaException("Cannot negate " + number.getClass());
			}
		};
	};
	
	protected class NumberBinary extends BinaryHolder<BigDecimal, BigDecimal, BigDecimal> {
		public NumberBinary(
				Binary<BigDecimal, BigDecimal, BigDecimal> operator,
				Gettable<BigDecimal> operand1, Gettable<BigDecimal> operand2) {
			super(operator, operand1, operand2);
		}
		
		
		public Class<BigDecimal> type() {
			return BigDecimal.class;
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.NUMERIC;
		}
		
		@Override
		public String getExpression() {
			return operator.toString();
		}
	}

	protected NumberBinary createNumberBinary(Binary<BigDecimal, BigDecimal, BigDecimal> operator,
			Gettable<?> operand1, Gettable<?> operand2){
		Gettable<BigDecimal> gettable1 = (Gettable<BigDecimal>)getGettable(operand1, BigDecimal.class);
		
		if(gettable1 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand1);
		}
		
		Gettable<BigDecimal> gettable2 = (Gettable<BigDecimal>)getGettable(operand2, BigDecimal.class);
		
		if(gettable2 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand2);
		}
		
		NumberBinary op = new NumberBinary(operator, 
				getDecimalGettable(gettable1), getDecimalGettable(gettable2));
		
		return op;
	}

	public static Binary<BigDecimal, BigDecimal, BigDecimal> ADD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 7193497731680749528L;

		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
			return term1.add(term2);
		}
		public String toString() { return "ADD"; };
	};

	public static Binary<BigDecimal, BigDecimal, BigDecimal> SUBTRACT = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 7193497731680749528L;

		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
			return term1.subtract(term2);
		}
		public String toString() { return "SUBTRACT"; };
	};

	public static Binary<BigDecimal, BigDecimal, BigDecimal> MULTIPLY = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 7193497731680749528L;

		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
			return term1.multiply(term2);
		}

		public String toString() { return "MULTIPLY"; };
	};

	public static Binary<BigDecimal, BigDecimal, BigDecimal> MOD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 7193497731680749528L;

		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
			return term1.remainder(term2);
		}
		
		public String toString() { return "MOD "; };
	};
	
	

	/**
	 * divide half up
	 * @see BigDecimal.ROUND_HALF_UP
	 */
	public static Binary<BigDecimal, BigDecimal, BigDecimal> DIVIDE = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
		private static final long serialVersionUID = 7193497731680749528L;

		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
			return term1.divide(term2,BigDecimal.ROUND_HALF_UP);
		}

		public String toString() { return "DIVIDE "; };
	};

	
	
	public Gettable<BigDecimal> add(Gettable<?> operand1, Gettable<?> operand2) {
		return createNumberBinary(ADD, operand1, operand2);
	}

	public Gettable<BigDecimal> subtract(Gettable<?> operand1, Gettable<?> operand2) {
		return createNumberBinary(SUBTRACT, operand1, operand2);
	}

	public Gettable<BigDecimal> multiply(Gettable<?> operand1,
			Gettable<?> operand2) {
		return createNumberBinary(MULTIPLY, operand1, operand2);
	}

	public Gettable<BigDecimal> divide(Gettable<?> operand1,
			Gettable<?> operand2) {
		return createNumberBinary(DIVIDE, operand1, operand2);
	}

	public Gettable<BigDecimal> mod(Gettable<?> operand1, Gettable<?> operand2) {
		return createNumberBinary(MOD, operand1, operand2);
	}

	
	/* ************************************************
	 * String Operators
	 ************************************************ */
	
	protected class StringBinary extends BinaryHolder<String, Object, Object> {

		public StringBinary(Binary<String, Object, Object> operator,
				Gettable<Object> operand1, Gettable<Object> operand2) {
			super(operator, operand1, operand2);
		}

		public Class<String> type() {
			return String.class;
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.TEXT;
		}

		@Override
		public String getExpression() {
			return operator.toString();
		}
	}

	public static Binary<String, Object, Object> CONCAT = new Binary<String, Object, Object>() {
		private static final long serialVersionUID = 8244939992124520090L;
		public String eval(Object val1, Object val2) {
			StringBuilder buf = new StringBuilder();
			buf.append(val1);
			buf.append(val2);
			return buf.toString();
		}
		public String toString() { return "CONCAT"; };
	};
	
	@SuppressWarnings("unchecked")
	public Gettable<String> concat(Gettable<?> operand1, Gettable<?> operand2) {
		return new StringBinary(CONCAT, (Gettable<Object>)operand1, (Gettable<Object>)operand2);
	}
	

	/* ************************************************
	 * Compare  Operators
	 ************************************************ */
	
	@SuppressWarnings("rawtypes")
	protected class CompareBinary extends BinaryHolder<Boolean, Comparable, Comparable> {
		public CompareBinary(Binary<Boolean, Comparable, Comparable> operator,
				Gettable<Comparable> operand1, Gettable<Comparable> operand2) {
			super(operator, operand1, operand2);
		}

		public Class<Boolean> type() {
			return Boolean.class;
		}

		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}

		@Override
		public String getExpression() {
			return operator.toString();
		}
	}
	
	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> EQ = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = -1536350080253761897L;

		public Boolean eval(Comparable val1, Comparable val2) {
			return val1.equals(val2);
		}
		public String toString() { return "EQ"; };
	};

	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> NOT_EQ = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = 8135499638098166188L;

		public Boolean eval(Comparable val1, Comparable val2) {
			return !val1.equals(val2);
		}
		public String toString() { return "NOT_EQ"; };
	};

	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> EQ_GT = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = 8322598301178903435L;

		@SuppressWarnings("unchecked")
		public Boolean eval(Comparable val1, Comparable val2) {
			return val1.compareTo(val2) >= 0;
		}
		public String toString() { return "EQ_GT"; };
	};

	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> GT = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = 1716214016154335373L;

		@SuppressWarnings("unchecked")
		public Boolean eval(Comparable val1, Comparable val2) {
			return val1.compareTo(val2) > 0;
		}
		public String toString() { return "GT"; };
	};

	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> EQ_LT = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = -2326991012746003884L;

		@SuppressWarnings("unchecked")
		public Boolean eval(Comparable val1, Comparable val2) {
			return val1.compareTo(val2) <= 0;
		}
		public String toString() { return "EQ_LT"; };
	};

	@SuppressWarnings("rawtypes")
	public static Binary<Boolean, Comparable, Comparable> LT = new Binary<Boolean, Comparable, Comparable>() {
		private static final long serialVersionUID = 6077518262742783672L;

		@SuppressWarnings("unchecked")
		public Boolean eval(Comparable val1, Comparable val2) {
			return val1.compareTo(val2) < 0;
		}
		public String toString() { return "LT"; };
	};
	
	@SuppressWarnings({  "rawtypes" })
	protected CompareBinary createCompareBinary(Binary<Boolean, Comparable, Comparable> operator,
			Gettable<?> operand1, Gettable<?> operand2){
		Gettable<Comparable> gettable1 = (Gettable<Comparable>)getGettable(operand1, Comparable.class);
		
		if(gettable1 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand1);
		}
		
		Gettable<Comparable> gettable2 = (Gettable<Comparable>)getGettable(operand2, Comparable.class);
		
		if(gettable2 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand2);
		}
		
		CompareBinary op = new CompareBinary(operator, gettable1, gettable2);
		
		return op;
	}
	

	/* ************************************************
	 * Logical Operators
	 ************************************************ */
	
	@SuppressWarnings("unchecked")
	public Gettable<Boolean> not(Gettable<?> operand) {
		Gettable<Boolean> gettable = (Gettable<Boolean>)getGettable(operand, Boolean.class);
		
		if(gettable != null) {
			return new Not(NOT,(Gettable<Boolean>)operand);
		} else {
			throw new BuildException("<Not> Illegal operand data type " + operand);
		}
	}
	
	/**
	 * logical negate
	 * @author IkChan Kwon
	 * @since	1.0
	 */
	protected class Not  extends UnaryHolder<Boolean, Boolean> {
		
		/**
		 * @param operator
		 * @param operand1
		 */
		public Not(Unary<Boolean, Boolean> operator,
				Gettable<? extends Boolean> operand1) {
			super(operator, operand1);
		}

		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}
		
		@Override
		public String getExpression() {
			return ExprTokens.OP_NOT;
		}
		
		public Class<Boolean> type() {
			return Boolean.class;
		}
	}

	public static Unary<Boolean, Boolean> NOT = new Unary<Boolean, Boolean>() {
		private static final long serialVersionUID = 1L;

		public String toString() { return "NEGATE"; }

		@Override
		public Boolean eval(Boolean value) {
			return value ? Boolean.TRUE : Boolean.FALSE;
		};
	};
	

	protected class LogicalBinary extends BinaryHolder<Boolean, Boolean, Boolean> {
		public LogicalBinary(Binary<Boolean, Boolean, Boolean> operator,
				Gettable<Boolean> operand1, Gettable<Boolean> operand2) {
			super(operator, operand1, operand2);
		}

		public Class<Boolean> type() {
			return Boolean.class;
		}

		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}
		
		@Override
		public String getExpression() {
			return operator.toString();
		}
	}
	
	
	public Gettable<Boolean> eq(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(EQ, operand1, operand2);
	}

	public Gettable<Boolean> notEq(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(NOT_EQ, operand1, operand2);
	}

	public Gettable<Boolean> eqGt(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(EQ_GT, operand1, operand2);
	}

	public Gettable<Boolean> gt(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(GT, operand1, operand2);
	}

	public Gettable<Boolean> eqLt(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(EQ_LT, operand1, operand2);
	}

	public Gettable<Boolean> lt(Gettable<?> operand1, Gettable<?> operand2) {
		return createCompareBinary(LT, operand1, operand2);
	}
	

	public static Binary<Boolean, Boolean, Boolean> AND  = new Binary<Boolean, Boolean, Boolean>() {
		private static final long serialVersionUID = 3085262817760840162L;
		
		public Boolean eval(Boolean val1, Boolean val2) {
			return (val1 && val2);
		}
		
		public String toString() { return "AND"; };
	};

	public static Binary<Boolean, Boolean, Boolean> OR  = new Binary<Boolean, Boolean, Boolean>() {
		private static final long serialVersionUID = -625569543622838365L;

		public Boolean eval(Boolean val1, Boolean val2) {
			return (val1 || val2);
		}
		
		public String toString() { return "OR"; };
	};
	

	protected LogicalBinary createLogicalBinary(Binary<Boolean, Boolean, Boolean> operator,
			Gettable<?> operand1, Gettable<?> operand2){
		Gettable<Boolean> gettable1 = (Gettable<Boolean>)getGettable(operand1, Boolean.class);
		
		if(gettable1 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand1);
		}
		
		Gettable<Boolean> gettable2 = (Gettable<Boolean>)getGettable(operand2, Boolean.class);
		
		if(gettable2 == null) {
			throw new BuildException("<" + operator + "> Illegal operand data type " + operand2);
		}
		
		LogicalBinary op = new LogicalBinary(operator, gettable1, gettable2);
		
		return op;
	}
	
	
	public Gettable<Boolean> and(Gettable<?> operand1, Gettable<?> operand2) {
		return createLogicalBinary(AND, operand1, operand2);
	}
	
	public Gettable<Boolean> or(Gettable<?> operand1, Gettable<?> operand2) {
		return createLogicalBinary(OR, operand1, operand2);
	}

	/* ************************************************
	 * Assign Operators
	 ************************************************ */
	
//	public Executable assign(Settable<?> assignee, Gettable<?> assigned) {
//		if(assignee == null){
//			throw new BuildException("Assignee must not be null.");
//		}
//		Settable<?> settable = assignee;
//		Gettable<?> gettable = assigned;
//		
//		if(assigned == null){
//			
//		}
//		if(!assignee.type().isAssignableFrom(assigned.type())){
//			if(assignee.type() == TypeMeta.UNKNOWN_TYPE.type()){
//				settable = getSettable(assignee, assigned.type());
//			} else if(assigned.type() == TypeMeta.UNKNOWN_TYPE.type()){
//				gettable = getGettable(assigned, assignee.type());
//			}  else {
//				throw new BuildException("Assigned type[" 
//						+ assigned.type() + "] is not matched to assignee type[" 
//						+ assignee.type() + "].");
//			}
//		} 
//		
//		Assign assign = new Assign(settable, gettable);
//		return assign;
//	}
//
//	@SuppressWarnings({"rawtypes" , "unchecked"})
//	public class Assign implements Executable {
//		private static final long serialVersionUID = -1485725508862063137L;
//		
//		Settable  assignee = null;
//		Gettable assigned = null;
//		
//		public Assign(Settable<?> assignee, Gettable<?> assigned) {
//			this.assignee = assignee;
//			this.assigned = assigned;
//		}
//
//		public void execute(Context context) {
//			assignee.set(context, assigned.get(context));
//		}
//		
//		@Override
//		public String toString() {
//			StringBuilder buf = new StringBuilder();
//			buf.append("[ASSIGN ").append(assignee).append(" ").append(assigned).append("]");
//			return buf.toString();
//		}
//	}
//	
//	@SuppressWarnings("rawtypes")
//	public class GettableWrapper implements Gettable {
//		private Gettable<?> original;
//		
//		public GettableWrapper(Gettable<?> original) {
//			this.original = original;
//		}
//
//		public ValueType valueType() {
//			return original.valueType();
//		}
//
//		public String getExpToken() {
//			return original.getExpToken();
//		}
//
//		
//		public Class<?> type() {
//			return original.type();
//		}
//
//		public Object get(Context context) {
//			Object val = original.get(context);
//			if(type() == null){
//				return val;
//			}
//			
//			if(type().isAssignableFrom(val.getClass())){
//				return val;
//			} else if((type() == BigDecimal.class) &&  (val instanceof Number)) {
//				return new BigDecimal(val.toString());
//			}
//			
//			throw new IllegalArgumentException( "Type mismatch :"
//					+ type() + " is expected, but  " 
//					 +  " return value type is " + val.getClass().getName() );
//		}
//		
//		@Override
//		public String toString() {
//			return "<WRAP " + original.toString() + ">";
//		}
//
//
//
//	}

//	/**
//	 * If ref's generic componentType is type, return ref. 
//	 * Else if ref is not of Ref nor ref's type is not TypeMeta.UNKNOWN_TYPE.type, return null
//	 * @param ref
//	 * @param type
//	 * @return
//	 */
//	protected Settable<?> getSettable(Settable<?> ref, Class<?> type){
//		if(type.isAssignableFrom( ref.type() )) {
//			return ref;
//		} else if( (ref instanceof Ref) && (ref.type() == TypeMeta.UNKNOWN_TYPE.type() )){
//			return new SettableWrapper(ref ,  type);
//		}
//		
//		throw new BuildException(ref + " is not Ref or not supported unchecked mode.");
//	}
//	
//	@SuppressWarnings("rawtypes")
//	public class SettableWrapper implements Settable {
//		private static final long serialVersionUID = 4777136234377747561L;
//		private Class<?> type;
//		private Settable original;
//		
//		public SettableWrapper(Settable original, Class<?> type) {
//			this.original = original;
//			this.type = type;
//		}
//
//		public Class<?> type() {
//			return type;
//		}
//		
//		@SuppressWarnings("unchecked")
//		public void set(Context context, Object value) {
//			original.set(context, value);
//		}
//		
//
//		@Override
//		public String toString() {
//			return "<WRAP "+ type.getSimpleName() + " "  + original.toString() + ">";
//		}
//	}
//	\
	
}
