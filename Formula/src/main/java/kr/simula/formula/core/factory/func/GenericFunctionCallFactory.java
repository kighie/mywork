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

import java.util.List;

import kr.simula.formula.core.Function;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.builder.BuildContext;
import kr.simula.formula.core.builder.BuildException;
import kr.simula.formula.core.factory.FunctionCallFactory;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class GenericFunctionCallFactory implements FunctionCallFactory {

	protected final Function<?> function;
	protected final ArgumentValidator<?>[] validators;


	public GenericFunctionCallFactory(Function<?> function,
			ArgumentValidator<?>[] validators) {
		this.function = function;
		this.validators = validators;
	}
	
	public String functionName(){
		return function.getClass().getSimpleName();
	}
	
	protected Gettable<?>[] validateArgs(List<Node> args) {
		int length = (args != null) ? args.size() : 0;
		
		if(length<validators.length){
			throw new BuildException("Function " + function + " needs " + validators.length + " args, but " + length);
		}
		
		int min = Math.min(length, validators.length);
		
		Gettable<?>[] gettables = new Gettable<?>[length];
		for(int i = 0 ; i<min ; i++){
			gettables[i] = validators[i].validate(args.get(i));
		}
		
		if(min < length){
			for(int i = min ; i<length ; i++){
				gettables[i] = validators[min-1].validate(args.get(i));
			}
		}
		return gettables;
	}

	@Override
	public Gettable<?> create(BuildContext context, String fnName, List<Node> args) {
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
