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

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilder implements CalculaBuilder {
	
	private CalculaHandlerFactory handlerFactory = new ExpressionHandlerFactory();
	
	@Override
	public Node buildExpression(String expression) {
		CalculaHandler handler = handlerFactory.newHandler();
		return buildExpression(handler, expression);
	}
	
	@Override
	public Node buildExpression(String expression, RootBuildContext rootContext) {
		CalculaHandler handler = handlerFactory.newHandler(rootContext);
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
