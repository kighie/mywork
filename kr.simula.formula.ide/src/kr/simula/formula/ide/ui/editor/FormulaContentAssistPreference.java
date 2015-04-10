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
package kr.simula.formula.ide.ui.editor;

import kr.simula.formula.ide.FormulaPlugin;

import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.dltk.ui.text.completion.ContentAssistPreference;

/**
 * <pre>
 * </pre>
 * 
 * @author Ikchan Kwon
 *
 */
public class FormulaContentAssistPreference extends ContentAssistPreference {

	private static FormulaContentAssistPreference instance;

	public static ContentAssistPreference getDefault() {
		if (instance == null) {
			instance = new FormulaContentAssistPreference();
		}
		return instance;
	}

	protected ScriptTextTools getTextTools() {
		return FormulaPlugin.getDefault().getTextTools();
	}
}
