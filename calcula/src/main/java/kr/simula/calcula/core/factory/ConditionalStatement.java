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
package kr.simula.calcula.core.factory;

import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;

/**
 * <pre>
 * if, foreach 
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 23.
 * @since	1.0
 */
public class ConditionalStatement extends AbstractBlock {
	private static final long serialVersionUID = 8736239576756322943L;

	private Gettable<Boolean> condition;
	
	public ConditionalStatement(Gettable<Boolean> condition){
		this.condition = condition;
	}
	
	/**
	 * @return the condition
	 */
	public Gettable<Boolean> getCondition() {
		return condition;
	}
	

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("CONDITIONAL_BLOCK[\n");
		buf.append(" <CONDITION : ").append(condition).append(">\n");
		for(Executable e : nodes()){
			buf.append("\t").append(e).append("\n");
		}
		buf.append("]\n");
		return buf.toString();
	}
}
