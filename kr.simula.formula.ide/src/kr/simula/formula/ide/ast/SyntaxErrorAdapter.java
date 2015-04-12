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

import kr.simula.formula.core.SourceLocation;
import kr.simula.formula.core.builder.BuildException;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;
import org.eclipse.dltk.compiler.problem.DefaultProblem;
import org.eclipse.dltk.compiler.problem.IProblem;
import org.eclipse.dltk.compiler.problem.IProblemReporter;
import org.eclipse.dltk.compiler.problem.ProblemSeverities;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class SyntaxErrorAdapter extends BaseErrorListener {

	private IProblemReporter reporter;
	private String fileName;
	
	/**
	 * @param reporter
	 * @param fileName
	 */
	public SyntaxErrorAdapter(IProblemReporter reporter, String fileName) {
		super();
		this.reporter = reporter;
		this.fileName = fileName;
	}


	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		reporter.reportProblem( makeProblem(fileName, msg, e) );
	}


	public void reportBuildError(BuildException e) {
		reporter.reportProblem( makeProblem(fileName, e) );
	}


	protected static IProblem makeProblem(String fileName, String msg, RecognitionException e) {
		Token offendingToken = e.getOffendingToken();
		IProblem problem = new DefaultProblem(fileName,msg,
				IProblem.Internal,new String[0],ProblemSeverities.Fatal,
				offendingToken.getLine(), offendingToken.getCharPositionInLine(), 
				offendingToken.getStartIndex(), offendingToken.getStopIndex());
		return problem;
	}

	/**<pre>
	 * </pre>
	 * @param fileName
	 * @param e
	 * @return
	 */
	protected static IProblem makeProblem(String fileName, BuildException e) {
		Throwable cause = e.getCause();
		if(cause != null && cause instanceof RecognitionException){
			return makeProblem(fileName, e.getMessage(), (RecognitionException)cause);
		}
		
		SourceLocation loc = e.getLocation();
		IProblem problem;
		
		if(loc != null){
			problem = new DefaultProblem(fileName,e.getMessage(),
					IProblem.Unclassified,null,ProblemSeverities.Fatal, 
					loc.getStartIndex(), loc.getEndIndex(),
					loc.getLine(),loc.getCharPositionInLine());
		} else {
			problem = new DefaultProblem(fileName,e.getMessage(),
					IProblem.Unclassified,null,ProblemSeverities.Fatal, 
					-1,-1,-1,-1);
		}

		return problem;
	}

}
