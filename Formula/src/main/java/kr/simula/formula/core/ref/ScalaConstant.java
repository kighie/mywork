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
package kr.simula.formula.core.ref;

import java.math.BigDecimal;
import java.util.Date;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.QName;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class ScalaConstant<T> extends GenericRef implements Gettable<T> {
	protected final T value;
	
	/**
	 * @param qname
	 */
	public ScalaConstant(QName qname, T value) {
		super(qname);
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends T> type() {
		return (Class<? extends T>)value.getClass();
	}
	
	@Override
	public T get(Context context) {
		return value;
	}


	public static class StringConstant extends ScalaConstant<String>{
		/**
		 * @param qname
		 * @param value
		 */
		public StringConstant(QName qname, String value) {
			super(qname, value);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.TEXT;
		}
	}
	

	public static class NumberConstant extends ScalaConstant<BigDecimal>{
		/**
		 * @param qname
		 * @param value
		 */
		public NumberConstant(QName qname, BigDecimal value) {
			super(qname, value);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.NUMERIC;
		}
	}

	public static class BooleanConstant extends ScalaConstant<Boolean>{
		/**
		 * @param qname
		 * @param value
		 */
		public BooleanConstant(QName qname, Boolean value) {
			super(qname, value);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}
	}
	
	public static class DateConstant extends ScalaConstant<Date>{
		/**
		 * @param qname
		 * @param value
		 */
		public DateConstant(QName qname, Date value) {
			super(qname, value);
		}
		
		@Override
		public ValueType valueType() {
			return ValueType.DATE;
		}
	}

}
