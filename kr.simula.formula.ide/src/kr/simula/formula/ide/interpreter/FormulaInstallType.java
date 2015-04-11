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

import java.io.IOException;

import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.environment.IDeployment;
import org.eclipse.dltk.internal.launching.AbstractInterpreterInstallType;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.osgi.framework.Bundle;

public class FormulaInstallType  extends AbstractInterpreterInstallType {
	private static final String[] INTERPRETER_NAMES = { "formula" };
 
	public String getNatureId() {
		return FormulaNature.NATURE;
	}
 
	public String getName() {
		return "Formula";
	}
 
	protected String getPluginId() {
		return FormulaPlugin.PLUGIN_ID;
	}
 
	protected String[] getPossibleInterpreterNames() {
		return INTERPRETER_NAMES;
	}
 
	protected IInterpreterInstall doCreateInterpreterInstall(String id) {
		return new FormulaInstall(this, id);
	}
 
	protected IPath createPathFile(IDeployment deployment) throws IOException {
		Bundle bundle = FormulaPlugin.getDefault().getBundle();
		return deployment.add(bundle, "scripts/path.fo");
	}
 
	protected ILog getLog() {
		return FormulaPlugin.getDefault().getLog();
	}
}
