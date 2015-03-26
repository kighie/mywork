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
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Operator;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.builder.BuildContext;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.builder.CalculaBuilder;
import kr.simula.calcula.core.builder.RootBuildContext;
import kr.simula.calcula.def.ExprTokens;

/**
 * @author kighie@gmail.com
 *
 */
public class ExpressionBuilder implements ExprTokens, CalculaBuilder {
	protected RootBuildContext rootContext = new RootBuildContext();
	protected BuildContext current = rootContext;
	
	private Node rootNode;
	
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
	
	@SuppressWarnings("rawtypes")
	@Override
	public Operator operator(String token, Node node) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Operator operator(String token, Node left, Node right) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Literal literal(String token, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ref reference(String token, String exp) {
		// TODO Auto-generated method stub
		return null;
	}


	@SuppressWarnings("rawtypes")
	@Override
	public Gettable functionCall(String token, String name, Node... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Executable methodCall(String token, Ref parent, String name,
			Node... args) {
		// TODO Auto-generated method stub
		return null;
	}

}
