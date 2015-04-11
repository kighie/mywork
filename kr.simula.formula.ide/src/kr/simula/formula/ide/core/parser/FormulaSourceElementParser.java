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

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.dltk.compiler.ISourceElementRequestor;
import org.eclipse.dltk.compiler.env.IModuleSource;
import org.eclipse.dltk.core.AbstractSourceElementParser;
import org.eclipse.dltk.compiler.IElementRequestor.TypeInfo;

public class FormulaSourceElementParser extends AbstractSourceElementParser {
	public void parseSourceModule(IModuleSource module) {
		ISourceElementRequestor requestor = getRequestor();
 
		requestor.enterModule();
		TypeInfo info = new TypeInfo();
		info.name = "Example type";
		requestor.enterType(info);
		requestor.exitType(0);
		requestor.exitModule(0);
	}
	
	@Override
	protected String getNatureId() {
		return FormulaNature.NATURE;
	}
}