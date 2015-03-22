/* ******************************************************************************
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
package kr.simula.calcula.core.factory;

import java.math.BigDecimal;
import java.util.List;

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.NodeToken;
import kr.simula.calcula.core.Ref;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 11.
 * @since	1.0
 */
public interface NodeFactory {
	
	/**
	 * 
	 * @param text
	 * @return
	 */
	Gettable<String> string(BuildContext buildContext , String text);

	/**
	 * 
	 * @param numStr
	 * @return
	 */
	Gettable<BigDecimal> number(BuildContext buildContext , String numStr);
	
	/**
	 * 
	 * @param numStr
	 * @param precision
	 * @param scale
	 * @return
	 */
	Gettable<BigDecimal> number(BuildContext buildContext , String numStr, int precision, int scale);

	/**
	 * 
	 * @param numStr
	 * @return
	 */
	Gettable<Boolean> bool(BuildContext buildContext , String boolStr);

	/**
	 * create variable, constant, reference
	 * @param buildContext
	 * @param qname
	 * @return
	 */
	Ref ref(BuildContext buildContext , String qname);
	
	/**
	 *  create reference
	 * @param buildContext
	 * @param qname
	 * @return
	 */
	Ref ref(BuildContext buildContext , Ref parent, String name, List<Node> args);
	
	
	
	Node functionCall(BuildContext buildContext , String name, List<Node> args);
	
	/**
	 * Unary Operator
	 * @param token
	 * @param operand
	 * @return
	 */
	Node operator(BuildContext buildContext , NodeToken token, Node operand);

	/**
	 * Binary Operator
	 * @param token
	 * @param operand1
	 * @param operand2
	 * @return
	 */
	Node operator(BuildContext buildContext , NodeToken token, Node operand1, Node operand2);

	/**
	 * Assign
	 * @param assignee
	 * @param assigned
	 * @return
	 */
	Node assign(BuildContext buildContext , Node assignee, Node assigned);

	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param type
	 * @param valueNode
	 * @return
	 */
	Executable declareVar(BuildContext buildContext, String name, String type, Node valueNode);
	
	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param type
	 * @param valueNode
	 * @return
	 */
	Executable declareConst(BuildContext buildContext, String name, String type, Node valueNode);
	
	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param type
	 * @return
	 */
	Executable declareRef(BuildContext buildContext, String name, String type);
	

	/**
	 * 
	 * new Block node
	 * @return
	 */
	Block newBlock(BuildContext buildContext);


	/**
	 * 
	 * @param buildContext 
	 * @param condition {@link Gettable<Boolean>} 
	 * @return body node
	 */
	IfStatement ifStatement(BuildContext buildContext, Node condition);

	EvalutateWhenStatement evalutateWhenStatement(BuildContext buildContext, Node selection);
	
	CaseWhenTerm<?> caseWhenTerm(BuildContext buildContext, Node selection);
}
