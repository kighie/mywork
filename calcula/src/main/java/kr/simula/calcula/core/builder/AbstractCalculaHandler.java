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

import java.util.List;

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.calcula.core.factory.helper.BlockHelper;
import kr.simula.calcula.core.factory.helper.FunctionCallHelper;
import kr.simula.calcula.core.factory.helper.LiteralHelper;
import kr.simula.calcula.core.factory.helper.MethodCallHelper;
import kr.simula.calcula.core.factory.helper.RefHelper;
import kr.simula.calcula.core.factory.helper.UnaryOperatorHelper;

/**
 * @author kighie@gmail.com
 *
 */
public abstract class AbstractCalculaHandler implements CalculaHandler {
	protected final RootBuildContext rootContext;

	
	protected final BlockHelper blockHelper;
	protected final LiteralHelper literalHelper;
	protected final RefHelper refHelper;
	protected final BinaryOperatorHelper binaryOperatorHelper;
	protected final UnaryOperatorHelper unaryOperatorHelper ;
	protected final FunctionCallHelper functionCallHelper ;
	protected final MethodCallHelper methodCallHelper ;

	protected BuildContext current;
	
	protected Node rootNode;
	
	
	/**
	 * @param rootContext
	 * @param blockHelper
	 * @param literalHelper
	 * @param refHelper
	 * @param binaryOperatorHelper
	 * @param unaryOperatorHelper
	 * @param functionCallHelper
	 * @param methodCallHelper
	 */
	public AbstractCalculaHandler(RootBuildContext rootContext,
			BlockHelper blockHelper, LiteralHelper literalHelper,
			RefHelper refHelper, BinaryOperatorHelper binaryOperatorHelper,
			UnaryOperatorHelper unaryOperatorHelper,
			FunctionCallHelper functionCallHelper,
			MethodCallHelper methodCallHelper) {
		super();
		current = this.rootContext = rootContext;
		
		this.blockHelper = blockHelper;
		this.literalHelper = literalHelper;
		this.refHelper = refHelper;
		this.binaryOperatorHelper = binaryOperatorHelper;
		this.unaryOperatorHelper = unaryOperatorHelper;
		this.functionCallHelper = functionCallHelper;
		this.methodCallHelper = methodCallHelper;
	}

	
	@Override
	public Node getRootNode() {
		return rootNode;
	}

	@Override
	public BuildContext current(){
		return current;
	}
	

	protected void beginScope(){
		ScopeBuildContext scope = new ScopeBuildContext(current);
		current = scope;
	}
	
	protected void endScope(){
		BuildContext parent = current.getParent();
		if(parent == null){
			throw new BuildException("Current step exceeds BuildScope.");
		}
		
		current = parent;
	}
	
	
	@Override
	public Block block(String token){
		Block block = blockHelper.create(current, token);
		beginScope();
		return block;
	}
	
	@Override
	public void endBlock() {
		endScope();
	}
	
	@Override
	public Node operator(String token, Node node) {
		return unaryOperatorHelper.create(current, token, node);
	}


	@Override
	public Node operator(String token, Node left, Node right) {
		return binaryOperatorHelper.create(current, token, left, right);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Literal literal(String token, String value) {
		return literalHelper.create(current, token, value);
	}

	@Override
	public Ref reference(String name) {
		return refHelper.create(current,name);
	}
	
	@Override
	public Ref reference(Ref parent, String name) {
		return refHelper.create(current, parent, name);
	}
	
	@SuppressWarnings("rawtypes")
	@Override
	public Gettable functionCall(String name, List<Node> args) {
		return functionCallHelper.create(current, name, args);
	}

	@Override
	public Node methodCall(Ref parent, String name, List<Node> args) {
		return methodCallHelper.create(current, parent, name, args);
	}

}
