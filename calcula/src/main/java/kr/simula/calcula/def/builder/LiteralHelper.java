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
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.factory.LiteralFactory;
import kr.simula.calcula.def.ExprTokens;

/**
 * <pre>
 * LiteralHelper creates Literal Nodes (string, number, boolean, date, etc.)
 * </pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class LiteralHelper {

	protected HashMap<String, LiteralFactory<?>> factories = new HashMap<String, LiteralFactory<?>>();
	
	
	/**
	 * 
	 */
	public LiteralHelper() {
		initDefaults();
	}
	
	protected final void initDefaults(){
		factories.put(ExprTokens.LIT_STRING, new LiteralFactory<String>() {
			@Override
			public Literal<String> create(String value) {
				return new StringLiteral(value);
			}
		} );
		
		factories.put(ExprTokens.LIT_NUMBER, new LiteralFactory<BigDecimal>() {
			@Override
			public Literal<BigDecimal> create(String value) {
				return new NumberLiteral(new BigDecimal(value));
			}
		} );
		

		factories.put(ExprTokens.LIT_BOOLEAN, new LiteralFactory<Boolean>() {
			@Override
			public Literal<Boolean> create(String value) {
				if("true".equals(value) ||"TRUE".equals(value) ){
					return BooleanLiteral.TRUE;
				} else {
					return BooleanLiteral.FALSE;
				}
				
			}
		} );
		
		factories.put(ExprTokens.LIT_DATE, new LiteralFactory<Date>() {
			@Override
			public Literal<Date> create(String value) {
				try {
					return new DateLiteral(value);
				} catch (ParseException e) {
					throw new BuildException(e);
				}
			}
		} );
	}
	
	public LiteralFactory<?> getFactory(String expToken) {
		return factories.get(expToken);
	}
	
	public LiteralFactory<?> setFactory(String expToken, LiteralFactory<?> factory) {
		return factories.put(expToken, factory);
	}
	
	public void setFactories(Map<String, ? extends LiteralFactory<?>> m) {
		factories.putAll(m);
	}

	@SuppressWarnings("rawtypes")
	public Literal create(String expToken , String value){
		LiteralFactory factory = factories.get(expToken);
		if(factory == null){
			throw new BuildException("Literal Facotry for " + expToken + " is not registered.");
		}
		return factory.create(value);
	}
	
	
	
	protected static class StringLiteral extends Literal<String> {
		public StringLiteral(String value) {
			super(value);
		}

		@Override
		public ValueType valueType() {
			return ValueType.TEXT;
		}
		
	}
	

	protected static class NumberLiteral extends Literal<BigDecimal> {
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

	protected static class BooleanLiteral extends Literal<Boolean> {
		static final BooleanLiteral TRUE = new BooleanLiteral(true);
		static final BooleanLiteral FALSE = new BooleanLiteral(false);
		
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

	protected static class DateLiteral extends Literal<Date> {
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
		public String getExpression() {
			return ExprTokens.LIT_DATE;
		}
	}
	
}
