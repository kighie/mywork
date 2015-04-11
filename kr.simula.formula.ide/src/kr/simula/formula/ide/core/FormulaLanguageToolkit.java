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
package kr.simula.formula.ide.core;

import kr.simula.formula.ide.ast.FormulaASTHandlerFactory;

import org.eclipse.dltk.core.AbstractLanguageToolkit;
import org.eclipse.dltk.core.IDLTKLanguageToolkit;

public class FormulaLanguageToolkit extends AbstractLanguageToolkit {
	private static FormulaLanguageToolkit toolkit;

	private FormulaASTHandlerFactory handlerFactory;
	
	public static IDLTKLanguageToolkit getDefault() {
		if (toolkit == null) {
			toolkit = new FormulaLanguageToolkit();
		}
		return toolkit;
	}
 
	public String getLanguageName() {
		return "Formula";
	}
 
	public String getNatureId() {
		return FormulaNature.NATURE;
	}
 
	public String getLanguageContentType() {
		return "kr.simula.formula.ide.formula-content-type";
	}
	

	/**
	 * @return the handlerFactory
	 */
	public synchronized FormulaASTHandlerFactory getHandlerFactory() {
		if (handlerFactory == null) {
			handlerFactory= new FormulaASTHandlerFactory();
			handlerFactory.init();
		}
		return handlerFactory;
	}
	
}
