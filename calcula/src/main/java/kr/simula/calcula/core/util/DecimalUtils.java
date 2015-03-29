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
package kr.simula.calcula.core.util;

import java.math.BigDecimal;

import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.wrapper.DecimalGettableWrapper;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class DecimalUtils {
	public static final TypeConverter<Object, BigDecimal> NUMBER_TO_DECIMAL = new TypeConverter<Object, BigDecimal>(){
		@Override
		public BigDecimal convert(Object input) {
			return new BigDecimal(input.toString());
		}
	};
	
	public static BigDecimal getDecimal(Object value){
		if(value instanceof BigDecimal){
			return (BigDecimal)value;
		}
		
		if(value instanceof Number){
			return new BigDecimal(value.toString());
		}
		
		throw new BuildException(value + " is not numeric.");
	}
	

	public static Gettable<BigDecimal> getDecimalGettable(Node node){
		if(node instanceof Gettable){
			return getDecimalGettable((Gettable<?>)node);
		}
		throw new BuildException(node + " is not Gettable.");
	}
	
	@SuppressWarnings("unchecked")
	public static Gettable<BigDecimal> getDecimalGettable(Gettable<?> node){
		Class<?> type = node.type();
		
		if(BigDecimal.class.isAssignableFrom(type) ){
			return (Gettable<BigDecimal>)node;
		}
		
		if(Number.class.isAssignableFrom(type) ){
			return new DecimalGettableWrapper(NUMBER_TO_DECIMAL,node);
		}
		
		throw new BuildException(node + " is not numeric node.");
	}
	

	public static Gettable<BigDecimal> getGettable(Node node){
		if(node instanceof Gettable) {
			return DecimalUtils.getDecimalGettable((Gettable<?>)node);
		} 
		
		throw new BuildException("Numeric binary operator needs numeric gettable operand. But operand=" + node);
	}
	
	public static BigDecimal getValue(Literal<?> literal){
		Object value = literal.getValue();

		if(value instanceof BigDecimal) {
			return (BigDecimal)value;
		} else if(value instanceof Number) {
			return new BigDecimal(value.toString());
		} else {
			throw new BuildException("Numeric binary operator needs numeric operand. But literal operand=" + literal);
		}
	}
}
