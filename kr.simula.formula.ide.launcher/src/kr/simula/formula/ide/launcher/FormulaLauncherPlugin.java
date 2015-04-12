package kr.simula.formula.ide.launcher;

import java.io.IOException;

import org.eclipse.core.runtime.IPath;
import org.eclipse.dltk.core.environment.IDeployment;
import org.eclipse.dltk.core.environment.IExecutionEnvironment;
import org.eclipse.dltk.core.environment.IFileHandle;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FormulaLauncherPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "kr.simula.formula.ide.launcher"; //$NON-NLS-1$

	// The shared instance
	private static FormulaLauncherPlugin plugin;
	
	/**
	 * The constructor
	 */
	public FormulaLauncherPlugin() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FormulaLauncherPlugin getDefault() {
		return plugin;
	}


	public IFileHandle getConsoleProxy(IExecutionEnvironment exeEnv)
			throws IOException {
		IDeployment deployment = exeEnv.createDeployment();
		if (deployment == null) {
			return null;
		}
		IPath path = deployment.add(this.getBundle(), "console");
		path.append("ConsoleProxy.fo");
		return deployment.getFile(path);
	}

}
