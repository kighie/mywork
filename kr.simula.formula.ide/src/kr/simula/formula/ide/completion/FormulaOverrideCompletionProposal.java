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
package kr.simula.formula.ide.completion;

import kr.simula.formula.ide.FormulaPlugin;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.dltk.ui.text.completion.ScriptOverrideCompletionProposal;
import org.eclipse.jface.preference.IPreferenceStore;

/**
 * <pre></pre>
 * 
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FormulaOverrideCompletionProposal extends ScriptOverrideCompletionProposal {
	
	/**
	 * @param jproject
	 * @param cu
	 * @param methodName
	 * @param paramTypes
	 * @param start
	 * @param length
	 * @param displayName
	 * @param completionProposal
	 */
	public FormulaOverrideCompletionProposal(IScriptProject jproject,
			ISourceModule cu, String methodName, String[] paramTypes,
			int start, int length, String displayName, String completionProposal) {
		super(jproject, cu, methodName, paramTypes, start, length, displayName,
				completionProposal);
	}

	protected boolean isSmartTrigger(char trigger) {
		if (trigger == '.') {
			return true;
		}
		return false;
	}

	protected boolean insertCompletion() {
		IPreferenceStore preference = FormulaPlugin.getDefault().getPreferenceStore();
		return preference.getBoolean(PreferenceConstants.CODEASSIST_INSERT_COMPLETION);
	}
}
