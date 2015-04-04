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
package kr.simula.formula.core.builder;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonToken;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.Interval;


/**
 * 
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 22.
 * @since	1.0
 */
public class BuildException extends RuntimeException {

	private static final long serialVersionUID = 1050340953390702771L;
	
	private Token token;
	
	/**
	 * 
	 */
	public BuildException() {
		super();
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public BuildException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param arg0
	 */
	public BuildException(String message) {
		super(message);
	}


	/**
	 * @param arg0
	 */
	public BuildException(Throwable cause) {
		super(cause);
	}


	public void setToken(Token token) {
		this.token = token;
	}
	
	public Token getToken() {
		return token;
	}
	
	@Override
	public String toString() {
		if(token != null){
			StringBuilder buf = new StringBuilder();
			buf.append(super.toString());
			buf.append("\n");
			buf.append( " at [").append(token.getLine()).append(",").append(token.getCharPositionInLine()).append("] ");
			
			if(token instanceof CommonToken){
				int index = ((CommonToken)token).getStartIndex();
				buf.append("\n").append( token.getInputStream().getText(new Interval(0, index)) );
			} else {
				CharStream stream = token.getInputStream();
				buf.append("\n").append( stream.getText(new Interval(0, stream.index())) );
			}
			
			
			return buf.toString();
		} else {
			return super.toString();
		}	
	}
}
