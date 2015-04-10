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
package kr.simula.formula.ide.ast;

import kr.simula.formula.core.builder.FormulaHandlerFactory;
import kr.simula.formula.core.builder.RootBuildContext;
import kr.simula.formula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.formula.core.factory.helper.BlockHelper;
import kr.simula.formula.core.factory.helper.DeclarationHelper;
import kr.simula.formula.core.factory.helper.FunctionCallHelper;
import kr.simula.formula.core.factory.helper.LiteralHelper;
import kr.simula.formula.core.factory.helper.MethodCallHelper;
import kr.simula.formula.core.factory.helper.RefHelper;
import kr.simula.formula.core.factory.helper.StatementHelper;
import kr.simula.formula.core.factory.helper.UnaryOperatorHelper;
import kr.simula.formula.expr.builder.ExprBinaryOperatorHelper;
import kr.simula.formula.expr.builder.ExprFunctionCallHelper;
import kr.simula.formula.expr.builder.ExprLiteralHelper;
import kr.simula.formula.expr.builder.ExprUnaryOperatorHelper;
import kr.simula.formula.script.build.ScriptBlockHelper;
import kr.simula.formula.script.build.ScriptDeclarationHelper;
import kr.simula.formula.script.build.ScriptStatementHelper;
import kr.simula.formula.script.build.ScriptTypeHelper;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FormulaASTHandlerFactory implements FormulaHandlerFactory<FormulaASTHandler>{

	private BlockHelper blockHelper;
	private StatementHelper statementHelper;
	private DeclarationHelper declarationHelper;
	private ScriptTypeHelper typeHelper;
	private LiteralHelper literalHelper;
	private RefHelper refHelper;
	private BinaryOperatorHelper binaryOperatorHelper;
	private UnaryOperatorHelper unaryOperatorHelper;
	private FunctionCallHelper functionCallHelper;
	private MethodCallHelper methodCallHelper;
	
	
	public void init(){
		blockHelper = new ScriptBlockHelper();
		statementHelper = new ScriptStatementHelper();
		declarationHelper = new ScriptDeclarationHelper();
		typeHelper = new ScriptTypeHelper();
		literalHelper = new ExprLiteralHelper();
		refHelper = new RefHelper();
		binaryOperatorHelper = new ExprBinaryOperatorHelper();
		unaryOperatorHelper = new ExprUnaryOperatorHelper();
		functionCallHelper = new ExprFunctionCallHelper();
		methodCallHelper = new MethodCallHelper();
	}
	
	public FormulaASTHandler newHandler() {
		return newHandler(new RootBuildContext());
	}
	
	public FormulaASTHandler newHandler(RootBuildContext rootContext) {
		FormulaASTHandler handler = new FormulaASTHandler(rootContext, 
				blockHelper, literalHelper, refHelper, typeHelper, 
				binaryOperatorHelper, unaryOperatorHelper, functionCallHelper, 
				methodCallHelper, statementHelper, declarationHelper);
		
		return handler;
	}

}
