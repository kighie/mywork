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
package kr.simula.calcula.core.factory.func;

import java.math.BigDecimal;

import kr.simula.calcula.core.Function;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.wrapper.FunctionCallWrapper.ObjectFunctionCallWrapper;

public class ObjectFunctionCallFactory extends GenericFunctionCallFactory {

	/**
	 * @param function
	 * @param validators
	 */
	public ObjectFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators) {
		super(function, validators);
	}

	/**
	 * @param function
	 * @param validators
	 * @param requiredArgCount
	 */
	public ObjectFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators, int requiredArgCount) {
		super(function, validators, requiredArgCount);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	protected Gettable<Object> createImpl(Function<?> function, Gettable<?>[] gettables) {
		if( !BigDecimal.class.isAssignableFrom(function.getReturnType()) ){
			throw new BuildException("Function " + functionName() + "'s return type must be BigDecimal.");
		}
		return new ObjectFunctionCallWrapper((Function<Object>)function, gettables);
	}
}