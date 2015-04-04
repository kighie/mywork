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

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Literal;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class AbstractLiteral<T> implements Literal<T>{
	protected T value;
	
	
	/**
	 * @param value
	 */
	public AbstractLiteral(T value) {
		this.value = value;
	}

	public T getValue(){
		return value;
	}
	
	@Override
	public T get(Context context) {
		return value;
	}
	
	@Override
	public String getExpression() {
		return value.toString();
	}
	
	@Override
	public String toString() {
		return value.toString();
	}
	
	public static class StringLiteral extends AbstractLiteral<String> {
		public StringLiteral(String value) {
			super(value);
		}

		@Override
		public ValueType valueType() {
			return ValueType.TEXT;
		}
		
		@Override
		public Class<String> type() {
			return String.class;
		}
		

		@Override
		public String getExpression() {
			return "'" + value + "'";
		}
		
		@Override
		public String toString() {
			return "'" + value + "'";
		}
		
	}
	

	public static class NumberLiteral extends AbstractLiteral<BigDecimal> {
		public NumberLiteral(BigDecimal value) {
			super(value);
		}

		@Override
		public ValueType valueType() {
			return ValueType.NUMERIC;
		}
		
		@Override
		public Class<BigDecimal> type() {
			return BigDecimal.class;
		}
		
	}

	public static class BooleanLiteral extends AbstractLiteral<Boolean> {
		public static final BooleanLiteral TRUE = new BooleanLiteral(true);
		public static final BooleanLiteral FALSE = new BooleanLiteral(false);
		
		public BooleanLiteral(Boolean value) {
			super(value);
		}

		@Override
		public ValueType valueType() {
			return ValueType.LOGICAL;
		}

		@Override
		public Class<Boolean> type() {
			return Boolean.class;
		}
		
	}

	public static class DateLiteral extends AbstractLiteral<Date> {
		private static final DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		public DateLiteral(Date value) {
			super(value);
		}

		public DateLiteral(String value) throws ParseException {
			super(formatter.parse(value));
		}

		@Override
		public ValueType valueType() {
			return ValueType.DATE;
		}
		
		@Override
		public Class<Date> type() {
			return Date.class;
		}
	}
}
