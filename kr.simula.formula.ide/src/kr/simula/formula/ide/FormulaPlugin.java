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
package kr.simula.formula.ide;

import kr.simula.formula.ide.ui.editor.FormulaTextTools;

import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class FormulaPlugin extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "kr.simula.formula.ide"; //$NON-NLS-1$

	// The shared instance
	private static FormulaPlugin plugin;

	private FormulaTextTools formulaTextTools;
	 
	/**
	 * The constructor
	 */
	public FormulaPlugin() {
	}

	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
	}
	
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static FormulaPlugin getDefault() {
		return plugin;
	}

	public synchronized FormulaTextTools getTextTools() {
		if (formulaTextTools == null) {
			formulaTextTools= new FormulaTextTools(true);
		}
		
		return formulaTextTools;
	}
}
