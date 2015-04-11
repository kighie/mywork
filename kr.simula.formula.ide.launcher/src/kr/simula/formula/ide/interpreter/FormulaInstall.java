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
package kr.simula.formula.ide.interpreter;

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.dltk.launching.AbstractInterpreterInstall;
import org.eclipse.dltk.launching.IInterpreterInstallType;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FormulaInstall extends AbstractInterpreterInstall {
	public FormulaInstall(IInterpreterInstallType type, String id) {
		super(type, id);
	}
 
	public String getNatureId() {
		return FormulaNature.NATURE;
	}
}