package kr.simula.formula.ide.launcher;

import org.eclipse.dltk.core.DLTKIdContributionSelector;
import org.eclipse.dltk.core.PreferencesLookupDelegate;

public class FormulaDebuggingEngineSelector extends DLTKIdContributionSelector {

	/* (non-Javadoc)
	 * @see org.eclipse.dltk.core.DLTKIdContributionSelector#getSavedContributionId(org.eclipse.dltk.core.PreferencesLookupDelegate)
	 */
	@Override
	protected String getSavedContributionId(PreferencesLookupDelegate delegate) {
		return delegate.getString(FormulaLauncherPlugin.PLUGIN_ID,
				FormulaDebugConstants.DEBUGGING_ENGINE_ID_KEY);
	}

}
