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
import java.text.ParseException;
import java.util.Date;

import kr.simula.formula.core.Literal;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.builder.BuildException;
import kr.simula.formula.core.factory.LiteralFactory;
import kr.simula.formula.core.factory.helper.LiteralHelper;
import kr.simula.formula.core.wrapper.AbstractLiteral;
import kr.simula.formula.def.ExprTokens;

/**
 * <pre>
 * LiteralHelper creates Literal Nodes (string, number, boolean, date, etc.)
 * </pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DefaultLiteralHelper extends LiteralHelper{

	@Override
	protected final void initDefaults(){
		factories.put(ExprTokens.LIT_STRING, new LiteralFactory<String>() {
			@Override
			public Literal<String> create(BuildContext context, String exprToken, String value) {
				return new AbstractLiteral.StringLiteral(value);
			}
		} );
		
		factories.put(ExprTokens.LIT_NUMBER, new LiteralFactory<BigDecimal>() {
			@Override
			public Literal<BigDecimal> create(BuildContext context, String exprToken, String value) {
				return new AbstractLiteral.NumberLiteral(new BigDecimal(value));
			}
		} );
		

		factories.put(ExprTokens.LIT_BOOLEAN, new LiteralFactory<Boolean>() {
			@Override
			public Literal<Boolean> create(BuildContext context, String exprToken, String value) {
				if("true".equals(value) ||"TRUE".equals(value) ){
					return AbstractLiteral.BooleanLiteral.TRUE;
				} else {
					return AbstractLiteral.BooleanLiteral.FALSE;
				}
				
			}
		} );
		
		factories.put(ExprTokens.LIT_DATE, new LiteralFactory<Date>() {
			@Override
			public Literal<Date> create(BuildContext context, String exprToken, String value) {
				try {
					return new AbstractLiteral.DateLiteral(value);
				} catch (ParseException e) {
					throw new BuildException(e);
				}
			}
		} );
	}
}
