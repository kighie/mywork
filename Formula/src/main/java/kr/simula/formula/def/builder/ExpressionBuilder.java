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
package kr.simula.formula.def.builder;

import kr.simula.formula.antlr.FormulaLexer;
import kr.simula.formula.antlr.FormulaParser;
import kr.simula.formula.antlr.FormulaParser.FormulaExpressionContext;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.builder.FormulaBuilder;
import kr.simula.formula.core.builder.FormulaHandler;
import kr.simula.formula.core.builder.FormulaHandlerFactory;
import kr.simula.formula.core.builder.RootBuildContext;
import kr.simula.formula.core.factory.helper.BinaryOperatorHelper;
import kr.simula.formula.core.factory.helper.BlockHelper;
import kr.simula.formula.core.factory.helper.FunctionCallHelper;
import kr.simula.formula.core.factory.helper.LiteralHelper;
import kr.simula.formula.core.factory.helper.MethodCallHelper;
import kr.simula.formula.core.factory.helper.RefHelper;
import kr.simula.formula.core.factory.helper.UnaryOperatorHelper;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilder extends FormulaHandlerFactory implements FormulaBuilder {

	protected BlockHelper blockHelper;
	protected LiteralHelper literalHelper = new DefaultLiteralHelper();
	protected RefHelper refHelper = new RefHelper();
	protected BinaryOperatorHelper binaryOperatorHelper = new DefaultBinaryOperatorHelper();
	protected UnaryOperatorHelper unaryOperatorHelper = new DefaultUnaryOperatorHelper();
	protected FunctionCallHelper functionCallHelper = new DefaultFunctionCallHelper();
	protected MethodCallHelper methodCallHelper = new MethodCallHelper();
	
	
	@Override
	public FormulaHandler newHandler(RootBuildContext rootContext) {
		return new ExpressionHandler(rootContext, 
				blockHelper, literalHelper, refHelper, binaryOperatorHelper, unaryOperatorHelper, 
				functionCallHelper, methodCallHelper);
	}
	
	@Override
	public FormulaHandler newHandler() {
		return newHandler(new RootBuildContext() );
	}

	
	
	@Override
	public Node buildExpression(String expression) {
		FormulaHandler handler = newHandler();
		return buildExpression(handler, expression);
	}
	
	@Override
	public Node buildExpression(String expression, RootBuildContext rootContext) {
		FormulaHandler handler = newHandler(rootContext);
		return buildExpression(handler, expression);
	}

	/**
	 * <pre>
	 * {@link FormulaParser#formulaExpression()}
	 * </pre>
	 * @param handler
	 * @param expression
	 * @return
	 */
	public Node buildExpression(FormulaHandler handler, String expression){
		CharStream input = new ANTLRInputStream(expression);
		FormulaLexer lexer = new FormulaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		FormulaParser parser =new FormulaParser(tokenStream);
		parser.setHandler(handler);
		FormulaExpressionContext ctx = parser.formulaExpression();
		return ctx.result;
	}
}
