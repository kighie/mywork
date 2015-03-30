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
package kr.simula.calcula.core.wrapper;

import java.math.BigDecimal;

import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Gettable;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DecimalConstantExpr implements Gettable<BigDecimal>{
	private BigDecimal value;
	private String exprStr;
	
	/**
	 * @param value
	 */
	public DecimalConstantExpr(BigDecimal value) {
		this(value, value.toString());
	}

	/**
	 * @param value
	 * @param exprStr
	 */
	public DecimalConstantExpr(BigDecimal value, String exprStr) {
		super();
		this.value = value;
		this.exprStr = exprStr;
	}

	@Override
	public ValueType valueType() {
		return ValueType.NUMERIC;
	}

	@Override
	public String getExpression() {
		return exprStr;
	}
	
	@Override
	public Class<BigDecimal> type() {
		return BigDecimal.class;
	}

	@Override
	public BigDecimal get(Context context) {
		return value;
	}

	@Override
	public String toString() {
		return getExpression();
	}
}
