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

import kr.simula.calcula.antlr.CalculaParser.FuncExpContext;
import kr.simula.calcula.builder.CalculaBuilder;

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

	@Test
	public void testSimple(){
		CalculaBuilder calculaBuilder = new CalculaBuilder();
		CharStream input = new ANTLRInputStream("  call( aaa, put2(33,11) )");
		CalculaLexer lexer = new CalculaLexer(input);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		CalculaParser parser =new CalculaParser(tokenStream, calculaBuilder);
		
		FuncExpContext ctx = parser.funcExp();
		System.out.println();
		System.out.println(ctx.children);
		
		
	}
}
