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
package kr.simula.calcula.antlr;

import kr.simula.calcula.antlr.CalculaParser.FormulaExpressionContext;
import kr.simula.calcula.antlr.CalculaParser.OperatorExpressionContext;
import kr.simula.calcula.core.builder.CalculaBuilder;
import kr.simula.calcula.def.builder.ExpressionBuilder;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.junit.Test;

/**
 * @author kighie@gmail.com
 *
 */
public class CalculaParserTests {

	static final String FormulaExpression1 = "=(1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth())";
	static final String OperatorExpression1 = "1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth()";
	
	private CalculaParser createExpressionParser(String expression){

		CalculaBuilder calculaBuilder = new ExpressionBuilder();
		CharStream input = new ANTLRInputStream(FormulaExpression1);
		CalculaLexer lexer = new CalculaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		CalculaParser parser =new CalculaParser(tokenStream, calculaBuilder);
		
		return parser;
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
