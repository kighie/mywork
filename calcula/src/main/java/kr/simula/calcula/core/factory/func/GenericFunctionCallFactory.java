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

import kr.simula.calcula.core.Function;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.builder.BuildContext;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.factory.FunctionCallFactory;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class GenericFunctionCallFactory implements FunctionCallFactory {

	protected final Function<?> function;
	protected final ArgumentValidator<?>[] validators;
	protected final int requiredArgCount;
	
	/**
	 * @param function
	 * @param validators
	 */
	public GenericFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators, int requiredArgCount) {
		this.function = function;
		this.validators = validators;
		this.requiredArgCount = requiredArgCount;
	}
	

	public GenericFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators) {
		this(function, validators, validators.length);
	}
	
	public String functionName(){
		return function.getClass().getSimpleName();
	}
	
	protected Gettable<?>[] validateArgs(Node... args) {
		int length = args.length;
		
		if(length<requiredArgCount){
			throw new BuildException("Function " + functionName() + " needs " + requiredArgCount + " args, but " + length);
		}
		
		length = Math.min(length, validators.length);
		
		Gettable<?>[] gettables = new Gettable<?>[length];
		for(int i = 0 ; i<length ; i++){
			gettables[i] = validators[i].validate(args[i]);
		}
		
		return gettables;
	}

	@Override
	public Gettable<?> create(BuildContext context, String fnName, Node... args) {
		Gettable<?>[] gettables = validateArgs(args);
		return createImpl(function,gettables);
	}


	/**<pre>
	 * </pre>
	 * @param function2
	 * @param gettables
	 * @return
	 */
	protected abstract Gettable<?> createImpl(Function<?> function, Gettable<?>[] gettables);
}
