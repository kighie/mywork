/* ******************************************************************************
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

import java.math.BigDecimal;
import java.util.Date;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Function;
import kr.simula.formula.core.Gettable;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public abstract class FunctionCallWrapper<T> implements Gettable<T>{

	protected final Function<T> function;
	protected final Gettable<?>[] args;
	
	
	/**
	 * @param function
	 */
	public FunctionCallWrapper(Function<T> function, Gettable<?> ... args) {
		this.function = function;
		this.args = args;
	}

	@Override
	public String getExpression() {
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(function.getClass().getSimpleName());
		for(Gettable<?> n : args){
			buf.append(" ").append(n.getExpression());
		}
		buf.append(")");
		
		return buf.toString();
	}
	
	@Override
	public Class<? extends T> type() {
		return function.getReturnType();
	}
	

	/**
	 * TODO Change arguments manipulating (using bytecode engineering)
	 */
	@Override
	public T get(Context context) {
		Object[] argArr = new Object[args.length];
		int i = 0;
		for(Gettable<?> n : args){
			argArr[i++] = n.get(context);
		}
		return function.eval(argArr);
	}

	public String toString(){
		StringBuilder buf = new StringBuilder();
		buf.append("(").append(function.getClass().getName());
		for(Gettable<?> n : args){
			buf.append(" ").append(n.toString());
		}
		buf.append(")");
		
		return buf.toString();
	}
	
	public static class ObjectFunctionCallWrapper extends FunctionCallWrapper<Object> {
		/**
		 * @param function
		 * @param args
		 */
		public ObjectFunctionCallWrapper(Function<Object> function,
				Gettable<?>[] args) {
			super(function, args);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.OBJECT;
		}
		
	}
	
	public static class NumericFunctionCallWrapper extends FunctionCallWrapper<BigDecimal> {
		/**
		 * @param function
		 * @param args
		 */
		public NumericFunctionCallWrapper(Function<BigDecimal> function,
				Gettable<?>[] args) {
			super(function, args);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.NUMERIC;
		}
		
	}
	

	public static class StringFunctionCallWrapper extends FunctionCallWrapper<String> {
		/**
		 * @param function
		 * @param args
		 */
		public StringFunctionCallWrapper(Function<String> function,
				Gettable<?>[] args) {
			super(function, args);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.TEXT;
		}
		
	}
	
	public static class BooleanFunctionCallWrapper extends FunctionCallWrapper<Boolean> {
		/**
		 * @param function
		 * @param args
		 */
		public BooleanFunctionCallWrapper(Function<Boolean> function,
				Gettable<?>[] args) {
			super(function, args);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}
		
	}

	public static class DateFunctionCallWrapper extends FunctionCallWrapper<Date> {
		/**
		 * @param function
		 * @param args
		 */
		public DateFunctionCallWrapper(Function<Date> function,
				Gettable<?>[] args) {
			super(function, args);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.DATE;
		}
		
	}
}
