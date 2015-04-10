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
package kr.simula.formula.ide.search;

import org.eclipse.dltk.ast.ASTNode;
import org.eclipse.dltk.ast.expressions.CallExpression;
import org.eclipse.dltk.ast.expressions.Expression;
import org.eclipse.dltk.ast.references.VariableReference;
import org.eclipse.dltk.core.search.matching.MatchLocator;
import org.eclipse.dltk.core.search.matching.MatchLocatorParser;
import org.eclipse.dltk.core.search.matching.PatternLocator;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FormulaMatchLocatorParser extends MatchLocatorParser {

	/**
	 * @param locator
	 */
	protected FormulaMatchLocatorParser(MatchLocator locator) {
		super(locator);
	}
	
	protected void processStatement(ASTNode node, PatternLocator locator) {
		super.processStatement(node, locator);
//		if (node instanceof ExtendedVariableReference) {
//			ExtendedVariableReference ref = (ExtendedVariableReference) node;
//			int expressionCount = ref.getExpressionCount();
//			for (int i = 0; i < expressionCount; i++) {
//				Expression e = ref.getExpression(i);
//				if (ref.isCall(i) && e instanceof VariableReference) {
//					CallExpression call = new CallExpression(null,
//							((VariableReference) e).getName(), null);
//					call.setStart(e.sourceStart());
//					call.setEnd(e.sourceEnd());
//					locator.match(call, getNodeSet());
//				} else if (e instanceof VariableReference) {
//					locator.match(node, getNodeSet());
//				}
//			}
//		}
//		if (node instanceof VariableReference) {
//			locator.match(node, getNodeSet());
//		}
	}
}
