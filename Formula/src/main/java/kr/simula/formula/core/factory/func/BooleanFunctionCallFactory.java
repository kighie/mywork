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
package kr.simula.formula.core.factory.func;

import kr.simula.formula.core.Function;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.builder.BuildException;
import kr.simula.formula.core.wrapper.FunctionCallWrapper.BooleanFunctionCallWrapper;

public class BooleanFunctionCallFactory extends GenericFunctionCallFactory {

	/**
	 * @param function
	 * @param validators
	 */
	public BooleanFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators) {
		super(function, validators);
	}

//	/**
//	 * @param function
//	 * @param validators
//	 * @param requiredArgCount
//	 */
//	public BooleanFunctionCallFactory(Function<?> function,
//			ArgumentValidator<?>[] validators, int requiredArgCount) {
//		super(function, validators, requiredArgCount);
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Gettable<?> createImpl(Function<?> function, Gettable<?>[] gettables) {
		if( !Boolean.class.isAssignableFrom(function.getReturnType()) ){
			throw new BuildException("Function " + functionName() + "'s return type must be Boolean.");
		}
		return new BooleanFunctionCallWrapper((Function<Boolean>)function, gettables);
	}
}