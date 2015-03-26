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

import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Operator.Binary;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.Settable;

/**
 * @author kighie@gmail.com
 *
 */
public class OperatorHelper {

	/**
	 * If ref's generic componentType is type, return ref. 
	 * Else if ref is not of Ref nor ref's valueType is Node.ValueType, return null
	 * @param ref
	 * @param type
	 * @return
	 */
	protected Gettable<?> getGettable(Gettable<?> ref, Class<?> type){
		if(type.isAssignableFrom( ref.type() )) {
			return ref;
		} else if( (ref instanceof Ref) 
				&& (ref.valueType() != null ) 
				&& (ref.valueType() != Node.ValueType.UNKNOWN )){
			return new GettableWrapper(ref);
		}
		return null;
	}
	
	@SuppressWarnings("rawtypes")
	public class GettableWrapper implements Gettable {
		private Gettable<?> original;
		
		public GettableWrapper(Gettable<?> original) {
			this.original = original;
		}

		public ValueType valueType() {
			return original.valueType();
		}

		public String getNodeToken() {
			return original.getNodeToken();
		}

		
		public Class<?> type() {
			return original.type();
		}

		public Object get(Context context) {
			Object val = original.get(context);
			if(type() == null){
				return val;
			}
			
			if(type().isAssignableFrom(val.getClass())){
				return val;
			} else if((type() == BigDecimal.class) &&  (val instanceof Number)) {
				return new BigDecimal(val.toString());
			}
			
			throw new IllegalArgumentException( "Type mismatch :"
					+ type() + " is expected, but  " 
					 +  " return value type is " + val.getClass().getName() );
		}
		
		@Override
		public String toString() {
			return "<WRAP " + original.toString() + ">";
		}



	}

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
//		throw new DslBuildException(ref + " is not Ref or not supported unchecked mode.");
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
//	
//	@SuppressWarnings("unchecked")
//	public Gettable<BigDecimal> negate(Gettable<?> operand) {
//		Gettable<BigDecimal> gettable = (Gettable<BigDecimal>)getGettable(operand, BigDecimal.class);
//		
//		if(gettable != null) {
//			return new Negate(gettable);
//		} else {
//			throw new DslBuildException("<Negate> Illegal operand data type " + operand);
//		}
//	}
//
//	/**
//	 * number negate
//	 * @author IkChan Kwon
//	 * @since	1.0
//	 */
//	protected class Negate implements Gettable<BigDecimal> {
//		private static final long serialVersionUID = -4556180626634778464L;
//		private Gettable<BigDecimal> operand;
//		
//		public Negate(Gettable<BigDecimal> operand) {
//			this.operand = operand;
//		}
//		
//		public Class<BigDecimal> type() {
//			return BigDecimal.class;
//		}
//		
//		public BigDecimal get(Context context) {
//			return operand.get(context).negate();
//		}
//		
//		@Override
//		public String toString() {
//			StringBuilder buf = new StringBuilder();
//			buf.append("[NEGATE ").append(operand).append("]");
//			return buf.toString();
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	public Gettable<Boolean> not(Gettable<?> operand) {
//		Gettable<Boolean> gettable = (Gettable<Boolean>)getGettable(operand, Boolean.class);
//		
//		if(gettable != null) {
//			return new Not((Gettable<Boolean>)operand);
//		} else {
//			throw new DslException("<Not> Illegal operand data type " + operand);
//		}
//	}
//	
//	/**
//	 * logical negate
//	 * @author IkChan Kwon
//	 * @since	1.0
//	 */
//	protected class Not implements Gettable<Boolean> {
//		private static final long serialVersionUID = -4556180626634778464L;
//		private Gettable<Boolean> operand;
//		
//		public  Not(Gettable<Boolean> operand) {
//			this.operand = operand;
//		}
//		
//		public Class<Boolean> type() {
//			return Boolean.class;
//		}
//		
//		public Boolean get(Context context) {
//			return !operand.get(context);
//		}
//	}
//
//	
//	@SuppressWarnings("serial")
//	protected abstract class BinaryHolder<T, O1, O2> implements Gettable<T> {
//		protected Binary<T, O1, O2> operator;
//		protected Gettable<O1> operand1;
//		protected Gettable<O2> operand2;
//		
//		public BinaryHolder(Binary<T, O1, O2> operator, Gettable<O1> operand1, Gettable<O2> operand2) {
//			this.operator = operator;
//			this.operand1 = operand1;
//			this.operand2 = operand2;
//		}
//		
//		public T get(Context context) {
//			return operator.eval(operand1.get(context), operand2.get(context));
//		}
//		
//		@Override
//		public String toString() {
//			StringBuilder buf = new StringBuilder();
//			buf.append("[").append(operator).append(" ").append(operand1).append(" ").append(operand2).append("]");
//			return buf.toString();
//		}
//	}
//
//	protected class NumberBinary extends BinaryHolder<BigDecimal, BigDecimal, BigDecimal> {
//		private static final long serialVersionUID = -8279034082814023607L;
//		
//		public NumberBinary(
//				Binary<BigDecimal, BigDecimal, BigDecimal> operator,
//				Gettable<BigDecimal> operand1, Gettable<BigDecimal> operand2) {
//			super(operator, operand1, operand2);
//		}
//		
//		public Class<BigDecimal> type() {
//			return BigDecimal.class;
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	protected NumberBinary createNumberBinary(Binary<BigDecimal, BigDecimal, BigDecimal> operator,
//			Gettable<?> operand1, Gettable<?> operand2){
//		Gettable<BigDecimal> gettable1 = (Gettable<BigDecimal>)getGettable(operand1, BigDecimal.class);
//		
//		if(gettable1 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand1);
//		}
//		
//		Gettable<BigDecimal> gettable2 = (Gettable<BigDecimal>)getGettable(operand2, BigDecimal.class);
//		
//		if(gettable2 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand2);
//		}
//		
//		NumberBinary op = new NumberBinary(operator, gettable1, gettable2);
//		
//		return op;
//	}
//
//	public static Binary<BigDecimal, BigDecimal, BigDecimal> ADD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
//		private static final long serialVersionUID = 7193497731680749528L;
//
//		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
//			return term1.add(term2);
//		}
//		public String toString() { return "ADD"; };
//	};
//
//	public static Binary<BigDecimal, BigDecimal, BigDecimal> SUBTRACT = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
//		private static final long serialVersionUID = 7193497731680749528L;
//
//		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
//			return term1.subtract(term2);
//		}
//		public String toString() { return "SUBTRACT"; };
//	};
//
//	public static Binary<BigDecimal, BigDecimal, BigDecimal> MULTIPLY = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
//		private static final long serialVersionUID = 7193497731680749528L;
//
//		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
//			return term1.multiply(term2);
//		}
//
//		public String toString() { return "MULTIPLY"; };
//	};
//
//	public static Binary<BigDecimal, BigDecimal, BigDecimal> MOD = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
//		private static final long serialVersionUID = 7193497731680749528L;
//
//		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
//			return term1.remainder(term2);
//		}
//		
//		public String toString() { return "MOD "; };
//	};
//	
//	
//
//	/**
//	 * divide half up
//	 * @see BigDecimal.ROUND_HALF_UP
//	 */
//	public static Binary<BigDecimal, BigDecimal, BigDecimal> DIVIDE = new Binary<BigDecimal, BigDecimal, BigDecimal>() {
//		private static final long serialVersionUID = 7193497731680749528L;
//
//		public BigDecimal eval(BigDecimal term1, BigDecimal term2) {
//			return term1.divide(term2,BigDecimal.ROUND_HALF_UP);
//		}
//
//		public String toString() { return "DIVIDE "; };
//	};
//
//	
//	
//	public Gettable<BigDecimal> add(Gettable<?> operand1, Gettable<?> operand2) {
//		return createNumberBinary(ADD, operand1, operand2);
//	}
//
//	public Gettable<BigDecimal> subtract(Gettable<?> operand1, Gettable<?> operand2) {
//		return createNumberBinary(SUBTRACT, operand1, operand2);
//	}
//
//	public Gettable<BigDecimal> multiply(Gettable<?> operand1,
//			Gettable<?> operand2) {
//		return createNumberBinary(MULTIPLY, operand1, operand2);
//	}
//
//	public Gettable<BigDecimal> divide(Gettable<?> operand1,
//			Gettable<?> operand2) {
//		return createNumberBinary(DIVIDE, operand1, operand2);
//	}
//
//	public Gettable<BigDecimal> mod(Gettable<?> operand1, Gettable<?> operand2) {
//		return createNumberBinary(MOD, operand1, operand2);
//	}
//
//	
//	protected class StringBinary extends BinaryHolder<String, Object, Object> {
//		private static final long serialVersionUID = -7843344378508293521L;
//
//
//		public StringBinary(Binary<String, Object, Object> operator,
//				Gettable<Object> operand1, Gettable<Object> operand2) {
//			super(operator, operand1, operand2);
//		}
//
//		public Class<String> type() {
//			return String.class;
//		}
//	}
//
//	public static Binary<String, Object, Object> CONCAT = new Binary<String, Object, Object>() {
//		private static final long serialVersionUID = 8244939992124520090L;
//		public String eval(Object val1, Object val2) {
//			StringBuilder buf = new StringBuilder();
//			buf.append(val1);
//			buf.append(val2);
//			return buf.toString();
//		}
//		public String toString() { return "CONCAT"; };
//	};
//	
//	@SuppressWarnings("unchecked")
//	public Gettable<String> concat(Gettable<?> operand1, Gettable<?> operand2) {
//		return new StringBinary(CONCAT, (Gettable<Object>)operand1, (Gettable<Object>)operand2);
//	}
//	
//
//	@SuppressWarnings("rawtypes")
//	protected class CompareBinary extends BinaryHolder<Boolean, Comparable, Comparable> {
//		private static final long serialVersionUID = 4960603565749653612L;
//
//		public CompareBinary(Binary<Boolean, Comparable, Comparable> operator,
//				Gettable<Comparable> operand1, Gettable<Comparable> operand2) {
//			super(operator, operand1, operand2);
//		}
//
//		public Class<Boolean> type() {
//			return Boolean.class;
//		}
//	}
//	
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> EQ = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = -1536350080253761897L;
//
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return val1.equals(val2);
//		}
//		public String toString() { return "EQ"; };
//	};
//
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> NOT_EQ = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = 8135499638098166188L;
//
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return !val1.equals(val2);
//		}
//		public String toString() { return "NOT_EQ"; };
//	};
//
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> EQ_GT = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = 8322598301178903435L;
//
//		@SuppressWarnings("unchecked")
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return val1.compareTo(val2) >= 0;
//		}
//		public String toString() { return "EQ_GT"; };
//	};
//
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> GT = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = 1716214016154335373L;
//
//		@SuppressWarnings("unchecked")
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return val1.compareTo(val2) > 0;
//		}
//		public String toString() { return "GT"; };
//	};
//
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> EQ_LT = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = -2326991012746003884L;
//
//		@SuppressWarnings("unchecked")
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return val1.compareTo(val2) <= 0;
//		}
//		public String toString() { return "EQ_LT"; };
//	};
//
//	@SuppressWarnings("rawtypes")
//	public static Binary<Boolean, Comparable, Comparable> LT = new Binary<Boolean, Comparable, Comparable>() {
//		private static final long serialVersionUID = 6077518262742783672L;
//
//		@SuppressWarnings("unchecked")
//		public Boolean eval(Comparable val1, Comparable val2) {
//			return val1.compareTo(val2) < 0;
//		}
//		public String toString() { return "LT"; };
//	};
//	
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	protected CompareBinary createCompareBinary(Binary<Boolean, Comparable, Comparable> operator,
//			Gettable<?> operand1, Gettable<?> operand2){
//		Gettable<Comparable> gettable1 = (Gettable<Comparable>)getGettable(operand1, Comparable.class);
//		
//		if(gettable1 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand1);
//		}
//		
//		Gettable<Comparable> gettable2 = (Gettable<Comparable>)getGettable(operand2, Comparable.class);
//		
//		if(gettable2 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand2);
//		}
//		
//		CompareBinary op = new CompareBinary(operator, gettable1, gettable2);
//		
//		return op;
//	}
//	
//
//	
//	
//	public Gettable<Boolean> eq(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(EQ, operand1, operand2);
//	}
//
//	public Gettable<Boolean> notEq(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(NOT_EQ, operand1, operand2);
//	}
//
//	public Gettable<Boolean> eqGt(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(EQ_GT, operand1, operand2);
//	}
//
//	public Gettable<Boolean> gt(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(GT, operand1, operand2);
//	}
//
//	public Gettable<Boolean> eqLt(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(EQ_LT, operand1, operand2);
//	}
//
//	public Gettable<Boolean> lt(Gettable<?> operand1, Gettable<?> operand2) {
//		return createCompareBinary(LT, operand1, operand2);
//	}
//	
//
//	protected class LogicalBinary extends BinaryHolder<Boolean, Boolean, Boolean> {
//		private static final long serialVersionUID = -2038198432230606921L;
//
//		public LogicalBinary(Binary<Boolean, Boolean, Boolean> operator,
//				Gettable<Boolean> operand1, Gettable<Boolean> operand2) {
//			super(operator, operand1, operand2);
//		}
//
//		public Class<Boolean> type() {
//			return Boolean.class;
//		}
//	}
//	
//	public static Binary<Boolean, Boolean, Boolean> AND  = new Binary<Boolean, Boolean, Boolean>() {
//		private static final long serialVersionUID = 3085262817760840162L;
//		
//		public Boolean eval(Boolean val1, Boolean val2) {
//			return (val1 && val2);
//		}
//		
//		public String toString() { return "AND"; };
//	};
//
//	public static Binary<Boolean, Boolean, Boolean> OR  = new Binary<Boolean, Boolean, Boolean>() {
//		private static final long serialVersionUID = -625569543622838365L;
//
//		public Boolean eval(Boolean val1, Boolean val2) {
//			return (val1 || val2);
//		}
//		
//		public String toString() { return "OR"; };
//	};
//	
//
//	@SuppressWarnings({ "unchecked"  })
//	protected LogicalBinary createLogicalBinary(Binary<Boolean, Boolean, Boolean> operator,
//			Gettable<?> operand1, Gettable<?> operand2){
//		Gettable<Boolean> gettable1 = (Gettable<Boolean>)getGettable(operand1, Boolean.class);
//		
//		if(gettable1 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand1);
//		}
//		
//		Gettable<Boolean> gettable2 = (Gettable<Boolean>)getGettable(operand2, Boolean.class);
//		
//		if(gettable2 == null) {
//			throw new DslBuildException("<" + operator + "> Illegal operand data type " + operand2);
//		}
//		
//		LogicalBinary op = new LogicalBinary(operator, gettable1, gettable2);
//		
//		return op;
//	}
//	
//	
//	public Gettable<Boolean> and(Gettable<?> operand1, Gettable<?> operand2) {
//		return createLogicalBinary(AND, operand1, operand2);
//	}
//	
//	public Gettable<Boolean> or(Gettable<?> operand1, Gettable<?> operand2) {
//		return createLogicalBinary(OR, operand1, operand2);
//	}
//
//	public Executable assign(Settable<?> assignee, Gettable<?> assigned) {
//		if(assignee == null){
//			throw new DslBuildException("Assignee must not be null.");
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
//				throw new DslBuildException("Assigned type[" 
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
	
}
