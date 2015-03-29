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
package kr.simula.calcula.core.builder;

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.calcula.core.factory.helper.FunctionCallHelper;
import kr.simula.calcula.core.factory.helper.LiteralHelper;
import kr.simula.calcula.core.factory.helper.UnaryOperatorHelper;

/**
 * @author kighie@gmail.com
 *
 */
public abstract class AbstractCalculaBuilder implements CalculaBuilder {
	protected final RootBuildContext rootContext;

	protected final LiteralHelper literalHelper;
	protected final BinaryOperatorHelper binaryOperatorHelper;
	protected final UnaryOperatorHelper unaryOperatorHelper ;
	protected final FunctionCallHelper functionCallHelper ;

	protected BuildContext current;
	
	protected Node rootNode;
	
	
	/**
	 * @param rootContext
	 * @param literalHelper
	 * @param binaryOperatorHelper
	 * @param unaryOperatorHelper
	 * @param functionCallHelper
	 */
	public AbstractCalculaBuilder(
			RootBuildContext rootContext,
			LiteralHelper literalHelper,
			BinaryOperatorHelper binaryOperatorHelper,
			UnaryOperatorHelper unaryOperatorHelper,
			FunctionCallHelper functionCallHelper) {
		this.current = this.rootContext = rootContext;
		this.literalHelper = literalHelper;
		this.binaryOperatorHelper = binaryOperatorHelper;
		this.unaryOperatorHelper = unaryOperatorHelper;
		this.functionCallHelper = functionCallHelper;
	}

	@Override
	public Node getRootNode() {
		return rootNode;
	}

	@Override
	public BuildContext current(){
		return current;
	}
	
	@Override
	public Block block(String token){
		throw new BuildException("New block is not supported.");
	}
	
	@Override
	public Block endBlock() {
		return null;
	}
	
	@Override
	public Node operator(String token, Node node) {
		return unaryOperatorHelper.create(token, node);
	}


	@Override
	public Node operator(String token, Node left, Node right) {
		return binaryOperatorHelper.create(token, left, right);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Literal literal(String token, String value) {
		return literalHelper.create(token, value);
	}

	@Override
	public Ref reference(String token, String exp) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Gettable functionCall(String name, Node... args) {
		return functionCallHelper.create(name, args);
	}

	@Override
	public Node methodCall(Ref parent, String name, Node... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
