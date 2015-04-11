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
package kr.simula.formula.ide.interpreter.ui;

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.dltk.internal.debug.ui.interpreters.AddScriptInterpreterDialog;
import org.eclipse.dltk.internal.debug.ui.interpreters.InterpretersBlock;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.eclipse.dltk.launching.ScriptRuntime;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
@Deprecated
public class FormulaInterpretersBlock extends InterpretersBlock {
	protected AddScriptInterpreterDialog createInterpreterDialog(
			IInterpreterInstall standin) {
		FormulaInterpreterDialog dialog = new FormulaInterpreterDialog(
				this, getShell(), ScriptRuntime
						.getInterpreterInstallTypes(getCurrentNature()),
				standin);
		return dialog;
	}
 
	protected String getCurrentNature() {
		return FormulaNature.NATURE;
	}
}

