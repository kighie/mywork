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
package kr.simula.calcula.core.factory.helper;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import kr.simula.calcula.core.Function;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.annotation.Arguments;
import kr.simula.calcula.core.builder.BuildContext;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.factory.FunctionCallFactory;
import kr.simula.calcula.core.factory.func.ArgumentValidator;
import kr.simula.calcula.core.factory.func.BooleanFunctionCallFactory;
import kr.simula.calcula.core.factory.func.DateFunctionCallFactory;
import kr.simula.calcula.core.factory.func.NumericFunctionCallFactory;
import kr.simula.calcula.core.factory.func.ObjectFunctionCallFactory;
import kr.simula.calcula.core.factory.func.StringFunctionCallFactory;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FunctionCallHelper extends AbstractHelper<FunctionCallFactory> {

	private static Logger logger = Logger.getLogger(FunctionLoader.class.getName());

	protected final Class<?>[] EMPTY_CLASS_ARRAY = new Class<?>[0];
	protected final Node[] EMPTY_NODE_ARRAY = new Node[0];
	protected final ArgumentValidator<?>[] EMPTY_VALIDATOR_ARRAY = new ArgumentValidator<?>[0];
	
	protected final Map<Class<?>, ArgumentValidator<?>> validatorMap = new HashMap<Class<?>, ArgumentValidator<?>>();
	
	@Override
	protected void initDefaults() {
		super.initDefaults();
		initValidators();
	}
	
	protected void initValidators(){
		setValidator(BigDecimal.class, ArgumentValidator.DECIMAL_VALIDATOR);
		setValidator(String.class, ArgumentValidator.STRING_VALIDATOR);
		setValidator(Boolean.class, ArgumentValidator.BOOLEAN_VALIDATOR);
		setValidator(Date.class, ArgumentValidator.DATE_VALIDATOR);
	}
	
	protected void setValidator(Class<?> argType, ArgumentValidator<?> validator){
		validatorMap.put(argType, validator);
	}
	
	protected ArgumentValidator<?> getValidator(Class<?> argType) {
		ArgumentValidator<?> validator = validatorMap.get(argType);
		return validator == null ? ArgumentValidator.OBJECT_VALIDATOR : validator;
	}

	/**<pre>
	 * </pre>
	 * @param argTypes
	 * @return
	 */
	private ArgumentValidator<?>[] createValidators(Class<?>[] argTypes) {
		if( argTypes.length == 0 ){
			return EMPTY_VALIDATOR_ARRAY;
		}
		
		int length = argTypes.length;
		ArgumentValidator<?>[] validators = new ArgumentValidator<?>[length];
		Class<?>type;
		for(int i=0;i<length;i++){
			type = argTypes[i];
			if(BigDecimal.class.isAssignableFrom(type)){
				validators[i] = ArgumentValidator.DECIMAL_VALIDATOR;
			} else if(String.class.isAssignableFrom(type)){
				validators[i] = ArgumentValidator.STRING_VALIDATOR;
			} else if(Boolean.class.isAssignableFrom(type)){
				validators[i] = ArgumentValidator.BOOLEAN_VALIDATOR;
			} else if(Date.class.isAssignableFrom(type)){
				validators[i] = ArgumentValidator.DATE_VALIDATOR;
			} else {
				validators[i] = ArgumentValidator.OBJECT_VALIDATOR;
			}
		}
		
		return validators;
	}
	
	protected void loadAndRegisterFunctions(ClassLoader parent, String packageName) {
		try {
			for (Function<?> function : loadFunctions(this.getClass().getClassLoader(), packageName)) {
				registerFunction(function);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected List<Function<?>> loadFunctions(ClassLoader parent, String packageName) throws IOException {
		FunctionLoader loader = new FunctionLoader(parent, packageName);
		return loader.loadFunctions();
	}
	
	/**
	 * <pre>
	 * Creates FunctionCallFactory for function and register it.
	 * </pre>
	 * @param function
	 */
	public void registerFunction(Function<?> function) {
		String fnName = function.getClass().getSimpleName();
		Class<?> returnType = function.getReturnType();
		Arguments args = function.getClass().getAnnotation(Arguments.class);
		Class<?>[] argTypes;
		if(args != null){
			argTypes = args.value();
		} else {
			argTypes = EMPTY_CLASS_ARRAY;
		}
		
		FunctionCallFactory factory = createFactory(returnType, function, argTypes);
		
		factories.put(fnName, factory);
		logger.log(Level.WARNING, "Register Function " + function.getClass().getName() + " for " + function.getClass().getSimpleName() );
	}
	
	/**<pre>
	 * </pre>
	 * @param returnType
	 * @param function
	 * @param argTypes
	 * @return
	 */
	protected FunctionCallFactory createFactory(Class<?> returnType,
			Function<?> function, Class<?>[] argTypes) {
		ArgumentValidator<?>[] validators = createValidators(argTypes);
		
		if(BigDecimal.class.isAssignableFrom(returnType)) {
			return new NumericFunctionCallFactory(function, validators);
		} else if(String.class.isAssignableFrom(returnType)){
			return new StringFunctionCallFactory(function, validators);
		} else if(Boolean.class.isAssignableFrom(returnType)){
			return new BooleanFunctionCallFactory(function, validators);
		} else if(Date.class.isAssignableFrom(returnType)){
			return new DateFunctionCallFactory(function, validators);
		} else {
			return new ObjectFunctionCallFactory(function, validators);
		}
	}

	public Gettable<?> create(BuildContext context,  String name , Node ... args){
		FunctionCallFactory factory = factories.get(name);
		if(factory == null){
			throw new BuildException("FunctionCallFactory for " + name + " is not registered.");
		}
		return factory.create(context, name, args);
	}
}
