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

import kr.simula.calcula.antlr.CalculaLexer;
import kr.simula.calcula.antlr.CalculaParser;
import kr.simula.calcula.antlr.CalculaParser.FormulaExpressionContext;
import kr.simula.calcula.antlr.CalculaParser.OperatorExpressionContext;
import kr.simula.calcula.core.builder.CalculaHandler;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilderTests {

	static final String literalExpr1 = "=(1+3 * (4 + 15) - 30 / 10)";
	static final String literalExpr2 = "=(1+3 * 4 + 15 - 30 / 10)";
	static final String FormulaExpression1 = "=(1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth())";
	static final String OperatorExpression1 = "1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth()";
	
	
	protected ExpressionHandlerFactory builderFactory = new ExpressionHandlerFactory();

	private CalculaParser createExpressionParser(String expression){
		CalculaHandler calculaBuilder = builderFactory.newBuilder();
		CharStream input = new ANTLRInputStream(expression);
		CalculaLexer lexer = new CalculaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		CalculaParser parser =new CalculaParser(tokenStream, calculaBuilder);
		
		return parser;
	}

	private CalculaHandler buildExpression(String expression){
		CalculaHandler calculaBuilder = builderFactory.newBuilder();
		CharStream input = new ANTLRInputStream(expression);
		CalculaLexer lexer = new CalculaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		CalculaParser parser =new CalculaParser(tokenStream, calculaBuilder);
		FormulaExpressionContext ctx = parser.formulaExpression();
		System.out.println();
		System.out.println(ctx.result);
		return calculaBuilder;
	}

	@Test
	public void buildLiteralExpr1(){
		CalculaHandler builder = buildExpression(literalExpr1);
		System.out.println();
		System.out.println(builder.getRootNode());
	}


	@Test
	public void buildLiteralExpr2(){
		CalculaHandler builder = buildExpression(literalExpr2);
		System.out.println();
		System.out.println(builder.getRootNode());
	}
	
	@Test
	public void literalExpr(){
		CalculaParser parser = createExpressionParser(literalExpr1);
		FormulaExpressionContext ctx = parser.formulaExpression();
		System.out.println();
		System.out.println(ctx.children);
	}
	
	@Test
	public void testFormulaExpression(){
		CalculaParser parser = createExpressionParser(FormulaExpression1);
		FormulaExpressionContext ctx = parser.formulaExpression();
		System.out.println();
		System.out.println(ctx.children);
	}
	
	@Test
	public void testOperatorExpression1(){
		CalculaParser parser = createExpressionParser(OperatorExpression1);
		OperatorExpressionContext ctx = parser.operatorExpression();
		System.out.println();
		System.out.println(ctx.toStringTree());
	}
}
