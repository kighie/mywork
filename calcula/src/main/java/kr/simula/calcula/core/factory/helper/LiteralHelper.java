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
package kr.simula.calcula.core.factory.helper;

import kr.simula.calcula.core.Literal;
import kr.simula.calcula.core.builder.BuildContext;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.factory.LiteralFactory;

/**
 * <pre>
 * LiteralHelper creates Literal Nodes (string, number, boolean, date, etc.)
 * </pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class LiteralHelper extends AbstractHelper<LiteralFactory<?>> {
	
	@SuppressWarnings("rawtypes")
	public Literal create(BuildContext context, String exprToken , String value){
		LiteralFactory factory = factories.get(exprToken);
		if(factory == null){
			throw new BuildException("LiteralFacotry for " + exprToken + " is not registered.");
		}
		return factory.create(context, exprToken, value);
	}
}
