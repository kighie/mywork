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
package kr.simula.calcula.func;

import java.math.BigDecimal;

import kr.simula.calcula.core.RtException;
import kr.simula.calcula.def.AbstractFunction;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
@SuppressWarnings("serial")
public abstract class NumericFunction extends AbstractFunction<BigDecimal>{

	/**
	 * @param returnType
	 */
	public NumericFunction() {
		super(BigDecimal.class);
	}
	
	protected static BigDecimal toDecimal(Object value){
		if(value == null){
			return null;
		}
		
		if(value instanceof BigDecimal){
			return (BigDecimal)value;
		} else if(value instanceof Number){
			return new BigDecimal(value.toString());
		} else {
			throw new RtException("Argument is not numeric value; " + value);
		}
	}
}