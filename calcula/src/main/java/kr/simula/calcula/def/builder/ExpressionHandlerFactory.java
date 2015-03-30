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
package kr.simula.calcula.def.builder;

import kr.simula.calcula.core.builder.CalculaHandler;
import kr.simula.calcula.core.builder.CalculaHandlerFactory;
import kr.simula.calcula.core.builder.RootBuildContext;
import kr.simula.calcula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.calcula.core.factory.helper.BlockHelper;
import kr.simula.calcula.core.factory.helper.FunctionCallHelper;
import kr.simula.calcula.core.factory.helper.LiteralHelper;
import kr.simula.calcula.core.factory.helper.MethodCallHelper;
import kr.simula.calcula.core.factory.helper.RefHelper;
import kr.simula.calcula.core.factory.helper.UnaryOperatorHelper;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class ExpressionHandlerFactory extends CalculaHandlerFactory {
	
	
	protected BlockHelper blockHelper;
	protected LiteralHelper literalHelper = new DefaultLiteralHelper();
	protected RefHelper refHelper;
	protected BinaryOperatorHelper binaryOperatorHelper = new DefaultBinaryOperatorHelper();
	protected UnaryOperatorHelper unaryOperatorHelper ;
	protected FunctionCallHelper functionCallHelper = new DefaultFunctionCallHelper();
	protected MethodCallHelper methodCallHelper ;
	
	
	@Override
	public CalculaHandler newBuilder() {
		return new ExpressionHandler(new RootBuildContext(), 
				blockHelper, literalHelper, refHelper, binaryOperatorHelper, unaryOperatorHelper, 
				functionCallHelper, methodCallHelper);
	}

}
