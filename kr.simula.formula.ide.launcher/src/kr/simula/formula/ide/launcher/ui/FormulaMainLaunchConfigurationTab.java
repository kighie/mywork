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
package kr.simula.formula.ide.launcher.ui;

import kr.simula.formula.ide.core.FormulaNature;
import kr.simula.formula.ide.launcher.FormulaLauncherPlugin;

import org.eclipse.dltk.core.PreferencesLookupDelegate;
import org.eclipse.dltk.debug.core.DLTKDebugPreferenceConstants;
import org.eclipse.dltk.debug.ui.launchConfigurations.MainLaunchConfigurationTab;

/**
 * <pre></pre>
 * 
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FormulaMainLaunchConfigurationTab extends
		MainLaunchConfigurationTab {

	public FormulaMainLaunchConfigurationTab(String mode) {
		super(mode);
	}

	protected boolean breakOnFirstLinePrefEnabled(
			PreferencesLookupDelegate delegate) {
		return delegate.getBoolean(FormulaLauncherPlugin.PLUGIN_ID,
				DLTKDebugPreferenceConstants.PREF_DBGP_BREAK_ON_FIRST_LINE);
	}

	protected boolean dbpgLoggingPrefEnabled(PreferencesLookupDelegate delegate) {
		return delegate.getBoolean(FormulaLauncherPlugin.PLUGIN_ID,
				DLTKDebugPreferenceConstants.PREF_DBGP_ENABLE_LOGGING);
	}

	/**
	 * @since 2.0
	 */
	public String getNatureID() {
		return FormulaNature.NATURE;
	}
}