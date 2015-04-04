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
package kr.simula.formula.core.builder;

import java.util.List;

import kr.simula.formula.core.Block;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Literal;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.Ref;

/**
 * @author kighie@gmail.com
 *
 */
public interface FormulaHandler {
	
	/**
	 * <pre>
	 * Gets root node.
	 * </pre>
	 * @return
	 */
	Node getRootNode();
	
	/**
	 * <pre>
	 * Gets the build time cursor context
	 * </pre>
	 * @return
	 */
	BuildContext current();

	/**
	 * <pre>
	 * Start building new block and new scope context.
	 * </pre>
	 * @param token
	 * @return
	 */
	Block block(String token);
	
	/**
	 * <pre>
	 * End building block.
	 * </pre>
	 */
	void endBlock();
	
	/**
	 * <pre>
	 * Builds unary operator
	 * </pre>
	 * @param token
	 * @param node
	 * @return
	 */
	Node operator (String token, Node node);
	
	/**
	 * <pre>
	 * Builds binary operator
	 * </pre>
	 * @param token
	 * @param left
	 * @param right
	 * @return
	 */
	Node operator (String token, Node left, Node right);
	
	/**
	 * <pre>
	 * Make literal value
	 * </pre>
	 * @param token
	 * @param value
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Literal literal(String token, String value);

	/**
	 * <pre>
	 * Builds Reference
	 * </pre>
	 * @param token
	 * @param exp
	 * @return
	 */
	Ref refer(String name);
	
	/**
	 * <pre>
	 * Builds Reference
	 * </pre>
	 * @param token
	 * @param parent
	 * @param name
	 * @return
	 */
	Ref refer(Ref parent, String name);
	
	/**
	 * <pre>
	 * Builds function call expression
	 * </pre>
	 * @param name
	 * @param args
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	Gettable functionCall(String name, List<Node> args);

	/**
	 * <pre>
	 * Builds method call expression
	 * </pre>
	 * @param parent
	 * @param name
	 * @param args
	 * @return
	 */
	Ref methodCall(Ref parent, String name, List<Node> args);
	
	
}
