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
package kr.simula.formula.ide.core.parser;

import kr.simula.formula.antlr.FormulaScriptLexer;
import kr.simula.formula.antlr.FormulaScriptParser;
import kr.simula.formula.antlr.FormulaScriptParser.FormulaScriptContext;
import kr.simula.formula.core.builder.BuildException;
import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.ast.FormulaASTHandler;
import kr.simula.formula.ide.ast.FormulaModuleDeclaration;
import kr.simula.formula.ide.ast.SyntaxErrorAdapter;
import kr.simula.formula.script.Script;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.eclipse.dltk.ast.parser.AbstractSourceParser;
import org.eclipse.dltk.ast.parser.IModuleDeclaration;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemCollector;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FormulaSourceParser extends AbstractSourceParser {

	/**
	 * 
	 */
	public FormulaSourceParser() {
	}
	
	@Override
	public IModuleDeclaration parse(IModuleSource input,
			IProblemReporter reporter) {
		final String sourceCode = input.getSourceContents();
		
		CharStream antlrInput = new ANTLRInputStream(sourceCode);
		FormulaScriptLexer lexer = new FormulaScriptLexer(antlrInput);
		TokenStream tokenStream = new CommonTokenStream(lexer);
		FormulaScriptParser parser =new FormulaScriptParser(tokenStream);
		
		FormulaASTHandler handler = FormulaPlugin.getDefault().getHandlerFactory().newHandler();
		
		parser.setHandler(handler);
		
		SyntaxErrorAdapter errorAdapter = new SyntaxErrorAdapter(reporter, input.getFileName());
		
		parser.addErrorListener(errorAdapter);
		
		Script script = null;
		
		try {
			FormulaScriptContext ctx = parser.formulaScript();
			script = ctx.script;

			System.err.println("FormulaSourceParser#parse " + script.getExpression());
			ProblemCollector collector = (ProblemCollector)reporter.getAdapter(ProblemCollector.class);
			for( IProblem p : collector.getProblems() ){
				System.err.println(p);
			}
		} catch (BuildException e) {
			errorAdapter.reportBuildError(e);
		}
		
		
		FormulaModuleDeclaration module = new FormulaModuleDeclaration(sourceCode.length());
		
		return module;
	}
	
}
