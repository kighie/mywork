package kr.simula.formula.ide.launcher.ui;

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.debug.core.ILaunchConfigurationType;
import org.eclipse.dltk.internal.debug.ui.launcher.AbstractScriptLaunchShortcut;

public class FormulaLaunchShortcut extends AbstractScriptLaunchShortcut {
	
	protected ILaunchConfigurationType getConfigurationType() {
		return getLaunchManager().getLaunchConfigurationType("kr.simula.formula.ide.launcher.FormulaLaunchConfigurationType");
	}

	protected String getNatureId() {
		return FormulaNature.NATURE;
	}
}
