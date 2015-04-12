package kr.simula.formula.ide.launcher.ui;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.EnvironmentTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;
import org.eclipse.dltk.debug.ui.launchConfigurations.InterpreterTab;

public class FormulaTabGroup extends AbstractLaunchConfigurationTabGroup {
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		final FormulaMainLaunchConfigurationTab main = new FormulaMainLaunchConfigurationTab(mode);
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { main,
				new FormulaArgumentsTab(), new InterpreterTab(main),
				new EnvironmentTab(),
				// new SourceContainerLookupTab(),
				// new CommonTab()
				new FormulaCommonTab() };
		setTabs(tabs);
	}
}
