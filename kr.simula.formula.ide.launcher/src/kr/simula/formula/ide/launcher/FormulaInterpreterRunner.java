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
package kr.simula.formula.ide.launcher;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchManager;
import org.eclipse.dltk.compiler.CharOperation;
import org.eclipse.dltk.compiler.util.Util;
import org.eclipse.dltk.launching.AbstractInterpreterRunner;
import org.eclipse.dltk.launching.IInterpreterInstall;
import org.eclipse.dltk.launching.InterpreterConfig;
import org.eclipse.dltk.launching.debug.DbgpConstants;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.launching.JavaRuntime;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FormulaInterpreterRunner extends AbstractInterpreterRunner {

	/**
	 * @param install
	 */
	protected FormulaInterpreterRunner(IInterpreterInstall install) {
		super(install);
	}

	

//	public static final IJavaScriptInterpreterRunnerConfig DEFAULT_CONFIG = new IJavaScriptInterpreterRunnerConfig() {
//
//		public void adjustRunnerConfiguration(VMRunnerConfiguration vconfig,
//				InterpreterConfig iconfig, ILaunch launch, IJavaProject project) {
//
//		}
//
//		public String[] computeClassPath(InterpreterConfig config,
//				ILaunch launch, IJavaProject project) throws Exception {
//			return JavaScriptInterpreterRunner.getClassPath(project);
//		}
//
//		public String[] getProgramArguments(InterpreterConfig config,
//				ILaunch launch, IJavaProject project) {
//			return CharOperation.NO_STRINGS;
//		}
//
//		public String getRunnerClassName(InterpreterConfig config,
//				ILaunch launch, IJavaProject project) {
//			return "RhinoRunner"; //$NON-NLS-1$
//		}
//
//	};
//	private IJavaScriptInterpreterRunnerConfig config = DEFAULT_CONFIG;
//
//	@Override
//	public void run(InterpreterConfig config, ILaunch launch,
//			IProgressMonitor monitor) throws CoreException {
//		doRunImpl(config, launch, this.config);
//	}
//
//	public static void doRunImpl(InterpreterConfig config, ILaunch launch,
//			IJavaScriptInterpreterRunnerConfig iconfig) throws CoreException {
//
//		IScriptProject proj = AbstractScriptLaunchConfigurationDelegate
//				.getScriptProject(launch.getLaunchConfiguration());
//		IJavaProject myJavaProject = JavaCore.create(proj.getProject());
//		IVMInstall vmInstall = myJavaProject.exists() ? JavaRuntime
//				.getVMInstall(myJavaProject) : JavaRuntime
//				.getDefaultVMInstall();
//		if (vmInstall != null) {
//			IVMRunner vmRunner = vmInstall.getVMRunner(launch.getLaunchMode());
//			if (vmRunner != null) {
//				String[] newClassPath = getClassPath(myJavaProject);
//
//				VMRunnerConfiguration vmConfig = new VMRunnerConfiguration(
//						iconfig.getRunnerClassName(config, launch,
//								myJavaProject), newClassPath);
//				IPath scriptFilePath = config.getScriptFilePath();
//				if (scriptFilePath == null) {
//					throw new CoreException(new Status(IStatus.ERROR,
//							JavaScriptDebugPlugin.PLUGIN_ID,
//							"Script File name is not specified..."));
//				}
//				List<String> args = new ArrayList<String>();
//				args.add(scriptFilePath.toOSString());
//				addDebugArguments(config, launch, args);
//				String[] newStrings = iconfig.getProgramArguments(config,
//						launch, myJavaProject);
//				if (newStrings.length != 0) {
//					args.addAll(Arrays.asList(newStrings));
//				}
//				vmConfig.setProgramArguments(args.toArray(new String[args
//						.size()]));
//				ILaunch launchr = new Launch(launch.getLaunchConfiguration(),
//						launch.getLaunchMode(), null);
//				iconfig.adjustRunnerConfiguration(vmConfig, config, launch,
//						myJavaProject);
//				vmRunner.run(vmConfig, launchr, null);
//				IDebugTarget[] debugTargets = launchr.getDebugTargets();
//				for (int a = 0; a < debugTargets.length; a++) {
//					launch.addDebugTarget(debugTargets[a]);
//				}
//				IProcess[] processes = launchr.getProcesses();
//				for (int a = 0; a < processes.length; a++)
//					launch.addProcess(processes[a]);
//				return;
//			}
//		}
//		throw new CoreException(new Status(IStatus.ERROR,
//				JavaScriptLaunchingPlugin.PLUGIN_ID, "JRE is not configured"));
//	}

	private static void addDebugArguments(InterpreterConfig config,
			ILaunch launch, List<String> args) {
		if (ILaunchManager.DEBUG_MODE.equals(launch.getLaunchMode())) {
			String host = (String) config.getProperty(DbgpConstants.HOST_PROP);
			if (host == null) {
				host = Util.EMPTY_STRING;
			}
			args.add(host);

			String port = (String) config.getProperty(DbgpConstants.PORT_PROP);
			if (port == null) {
				port = Util.EMPTY_STRING;
			}
			args.add(port);

			String sessionId = (String) config
					.getProperty(DbgpConstants.SESSION_ID_PROP);
			if (sessionId == null) {
				sessionId = Util.EMPTY_STRING;
			}
			args.add(sessionId);
		}
	}

//	public static String[] getClassPath(IJavaProject myJavaProject) {
//		final List<String> result = new ArrayList<String>();
//		ClasspathUtils
//				.collectClasspath(
//						new String[] {
//								GenericJavaScriptInstallType.EMBEDDED_RHINO_BUNDLE_ID,
//								GenericJavaScriptInstallType.DBGP_FOR_RHINO_BUNDLE_ID },
//						result);
//		try {
//			final String[] classPath = computeBaseClassPath(myJavaProject);
//			for (int i = 0; i < classPath.length; ++i) {
//				result.add(classPath[i]);
//			}
//		} catch (CoreException e) {
//		}
//		return result.toArray(new String[result.size()]);
//	}

	protected static String[] computeBaseClassPath(IJavaProject myJavaProject)
			throws CoreException {
		if (!myJavaProject.exists())
			return CharOperation.NO_STRINGS;
		return JavaRuntime.computeDefaultRuntimeClassPath(myJavaProject);
	}

//	@Override
//	protected String getProcessType() {
//		return JavaScriptLaunchConfigurationConstants.ID_JAVASCRIPT_PROCESS_TYPE;
//	}
//
//	public void setRunnerConfig(IJavaScriptInterpreterRunnerConfig config) {
//		this.config = config;
//	}
}
