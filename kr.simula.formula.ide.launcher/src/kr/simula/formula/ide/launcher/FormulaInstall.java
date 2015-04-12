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
package kr.simula.formula.ide.launcher;

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.dltk.launching.AbstractInterpreterInstall;
import org.eclipse.dltk.launching.IInterpreterInstallType;
import org.eclipse.dltk.launching.IInterpreterRunner;

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
	

	public IInterpreterRunner getInterpreterRunner(String mode) {
		IInterpreterRunner runner = super.getInterpreterRunner(mode);
		if (runner != null) {
			return runner;
		}

		if (mode.equals(ILaunchManager.RUN_MODE)) {
			return new FormulaInterpreterRunner(this);
		}
		/*
		 * else if (mode.equals(ILaunchManager.DEBUG_MODE)) { return new
		 * JavaScriptInterpreterDebugger(this); }
		 */
		return null;
	}

//	private static final String BUILTINS_JS = "builtins.fo"; //$NON-NLS-1$
//
//	public String getBuiltinModuleContent(String name) {
//		InputStream stream = GenericJavaScriptInstall.class
//				.getResourceAsStream(BUILTINS_JS);
//		DataInputStream st = new DataInputStream(stream);
//		StringBuffer buf = new StringBuffer();
//		try {
//			while (st.available() >= 0) {
//				String line = st.readLine();
//				if (line == null)
//					break;
//				buf.append(line);
//				buf.append('\n');
//			}
//
//		} catch (IOException e) {
//			// should not happen
//		}
//		return buf.toString();
//	}

//	public String[] getBuiltinModules() {
//		return new String[] { "builtins.js" }; //$NON-NLS-1$
//	}
//
//	public long lastModified() {
//		try {
//			return GenericJavaScriptInstall.class.getResource(BUILTINS_JS)
//					.openConnection().getLastModified();
//		} catch (IOException e) {
//			return 0;
//		}
//	}
}