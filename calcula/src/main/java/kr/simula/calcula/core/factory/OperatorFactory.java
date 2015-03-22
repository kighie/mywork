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
package kr.simula.calcula.core.factory;

import java.math.BigDecimal;

import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Settable;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 11.
 * @since	1.0
 */
public interface OperatorFactory {
	
	/**
	 * number negation
	 * @param operand
	 * @return
	 */
	Gettable<BigDecimal> negate(Gettable<?> operand);
	

	/**
	 * logical negation
	 * @param operand
	 * @return
	 */
	Gettable<Boolean> not(Gettable<?> operand);

	/**
	 * number plus
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<BigDecimal> add(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * number minus
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<BigDecimal> subtract(Gettable<?> operand1, Gettable<?> operand2);
	

	/**
	 * number multiply
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<BigDecimal> multiply(Gettable<?> operand1, Gettable<?> operand2);
	

	/**
	 * number divide
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<BigDecimal> divide(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * number mod 
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<BigDecimal> mod(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * string concat
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<String> concat(Gettable<?> operand1, Gettable<?> operand2);
	

	/**
	 * comparison equals
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> eq(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison not equals
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> notEq(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison greater than or equals
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> eqGt(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison greater than
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> gt(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison less than or equals
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> eqLt(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison less than
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> lt(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison less than
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> and(Gettable<?> operand1, Gettable<?> operand2);

	/**
	 * comparison less than
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Gettable<Boolean> or(Gettable<?> operand1, Gettable<?> operand2);
	
	/**
	 * 
	 * @param assignee
	 * @param assigned
	 * @return
	 */
	Executable assign(Settable<?> assignee, Gettable<?> assigned);
}
