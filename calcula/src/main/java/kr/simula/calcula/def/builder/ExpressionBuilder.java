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

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.builder.AbstractCalculaBuilder;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.builder.RootBuildContext;
import kr.simula.calcula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.calcula.core.factory.helper.FunctionCallHelper;
import kr.simula.calcula.core.factory.helper.LiteralHelper;
import kr.simula.calcula.core.factory.helper.UnaryOperatorHelper;
import kr.simula.calcula.def.ExprTokens;

/**
 * @author kighie@gmail.com
 *
 */
public class ExpressionBuilder extends AbstractCalculaBuilder implements ExprTokens {
	

	/**
	 * @param rootContext
	 * @param literalHelper
	 * @param binaryOperatorHelper
	 * @param unaryOperatorHelper
	 * @param functionCallHelper
	 */
	public ExpressionBuilder(RootBuildContext rootContext,
			LiteralHelper literalHelper,
			BinaryOperatorHelper binaryOperatorHelper,
			UnaryOperatorHelper unaryOperatorHelper,
			FunctionCallHelper functionCallHelper) {
		super(rootContext, literalHelper, binaryOperatorHelper, unaryOperatorHelper,
				functionCallHelper);
	}

	
	@Override
	public Block block(String token){
		throw new BuildException("New block is not supported.");
	}
	
	@Override
	public Block endBlock() {
		return null;
	}
	
}
