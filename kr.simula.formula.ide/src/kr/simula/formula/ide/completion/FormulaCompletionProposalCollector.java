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

import kr.simula.formula.ide.core.FormulaNature;

import org.eclipse.dltk.core.IScriptProject;
import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposal;
import org.eclipse.dltk.ui.text.completion.ScriptCompletionProposalCollector;
import org.eclipse.swt.graphics.Image;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FormulaCompletionProposalCollector extends ScriptCompletionProposalCollector {
	protected final static char[] VAR_TRIGGER = { '\t', ' ', '=', ';', '.' };
	 
	protected char[] getVarTrigger() {
		return VAR_TRIGGER;
	}
 
	public FormulaCompletionProposalCollector(ISourceModule module) {
		super(module);
	}
 
	// Specific proposals creation. May be use factory?
	protected ScriptCompletionProposal createScriptCompletionProposal(
			String completion, int replaceStart, int length, Image image,
			String displayString, int i) {
		return new FormulaCompletionProposal(completion, replaceStart, length,
				image, displayString, i);
	}
 
	protected ScriptCompletionProposal createScriptCompletionProposal(
			String completion, int replaceStart, int length, Image image,
			String displayString, int i, boolean isInDoc) {
		return new FormulaCompletionProposal(completion, replaceStart, length,
				image, displayString, i, isInDoc);
	}
 
	protected ScriptCompletionProposal createOverrideCompletionProposal(
			IScriptProject scriptProject, ISourceModule compilationUnit,
			String name, String[] paramTypes, int start, int length,
			String displayName, String completionProposal) {
		return new FormulaOverrideCompletionProposal(scriptProject, compilationUnit,
				name, paramTypes, start, length, displayName,
				completionProposal);
	}

	@Override
	protected String getNatureId() {
		return FormulaNature.NATURE;
	}
}
