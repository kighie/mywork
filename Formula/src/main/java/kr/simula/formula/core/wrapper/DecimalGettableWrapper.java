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

import kr.simula.formula.core.Context;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.util.TypeConverter;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DecimalGettableWrapper implements Gettable<BigDecimal>{
	
	private Gettable<?> original;
	private TypeConverter<Object, BigDecimal> converter;
	
	/**
	 * @param original
	 */
	public DecimalGettableWrapper(TypeConverter<Object, BigDecimal> converter, Gettable<?> original) {
		this.original = original;
		this.converter = converter;
	}

	@Override
	public ValueType valueType() {
		return ValueType.NUMERIC;
	}
	
	@Override
	public String getExpression() {
		return original.getExpression();
	}

	@Override
	public Class<BigDecimal> type() {
		return BigDecimal.class;
	}
	
	@Override
	public BigDecimal get(Context context) {
		Object value = original.get(context);
		
		if(value == null){
			return null;
		}
		
		return converter.convert(value);
	}

	@Override
	public String toString() {
		return original.toString();
	}
}
