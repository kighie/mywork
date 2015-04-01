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
package kr.simula.calcula.def.builder;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import kr.simula.calcula.antlr.CalculaLexer;
import kr.simula.calcula.antlr.CalculaParser;
import kr.simula.calcula.antlr.CalculaParser.FormulaExpressionContext;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.builder.CalculaBuilder;
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
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilder extends CalculaHandlerFactory implements CalculaBuilder {

	protected BlockHelper blockHelper;
	protected LiteralHelper literalHelper = new DefaultLiteralHelper();
	protected RefHelper refHelper = new DefaultRefHelper();
	protected BinaryOperatorHelper binaryOperatorHelper = new DefaultBinaryOperatorHelper();
	protected UnaryOperatorHelper unaryOperatorHelper = new DefaultUnaryOperatorHelper();
	protected FunctionCallHelper functionCallHelper = new DefaultFunctionCallHelper();
	protected MethodCallHelper methodCallHelper ;
	
	
	@Override
	public CalculaHandler newHandler(RootBuildContext rootContext) {
		return new ExpressionHandler(rootContext, 
				blockHelper, literalHelper, refHelper, binaryOperatorHelper, unaryOperatorHelper, 
				functionCallHelper, methodCallHelper);
	}
	
	@Override
	public CalculaHandler newHandler() {
		return newHandler(new RootBuildContext() );
	}

	
	
	@Override
	public Node buildExpression(String expression) {
		CalculaHandler handler = newHandler();
		return buildExpression(handler, expression);
	}
	
	@Override
	public Node buildExpression(String expression, RootBuildContext rootContext) {
		CalculaHandler handler = newHandler(rootContext);
		return buildExpression(handler, expression);
	}

	/**
	 * <pre>
	 * {@link CalculaParser#formulaExpression()}
	 * </pre>
	 * @param handler
	 * @param expression
	 * @return
	 */
	public Node buildExpression(CalculaHandler handler, String expression){
		CharStream input = new ANTLRInputStream(expression);
		CalculaLexer lexer = new CalculaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		CalculaParser parser =new CalculaParser(tokenStream, handler);
		FormulaExpressionContext ctx = parser.formulaExpression();
		return ctx.result;
	}
}
