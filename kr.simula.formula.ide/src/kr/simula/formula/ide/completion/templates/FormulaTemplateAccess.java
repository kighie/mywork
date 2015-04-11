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
package kr.simula.formula.ide.completion.templates;

import kr.simula.formula.ide.FormulaPlugin;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FormulaTemplateAccess extends ScriptTemplateAccess {
	 
		private static final String CUSTOM_TEMPLATES_KEY = "kr.simula.formula.ide.completion.Templates";
	 
		private static FormulaTemplateAccess instance;
	 
		public static FormulaTemplateAccess getInstance() {
			if (instance == null) {
				instance = new FormulaTemplateAccess();
			}
	 
			return instance;
		}
	 
		protected String getContextTypeId() {
			return FormulaUniversalTemplateContextType.CONTEXT_TYPE_ID;
		}
		protected String getCustomTemplatesKey() {
			return CUSTOM_TEMPLATES_KEY;
		}
	 
		protected IPreferenceStore getPreferenceStore() {
			return FormulaPlugin.getDefault().getPreferenceStore();
		}
	}
