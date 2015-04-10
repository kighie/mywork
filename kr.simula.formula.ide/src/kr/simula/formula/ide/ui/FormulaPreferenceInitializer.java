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
package kr.simula.formula.ide.ui;

import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.ui.editor.IFormulaColorConstants;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.dltk.ui.CodeFormatterConstants;
import org.eclipse.dltk.ui.PreferenceConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.ui.editors.text.EditorsUI;

public class FormulaPreferenceInitializer extends AbstractPreferenceInitializer {
	public void initializeDefaultPreferences() {
		IPreferenceStore store = FormulaPlugin.getDefault().getPreferenceStore();

		EditorsUI.useAnnotationsPreferencePage(store);
		EditorsUI.useQuickDiffPreferencePage(store);

		// Initialize DLTK default values
		PreferenceConstants.initializeDefaultValues(store);

		PreferenceConverter.setDefault(store,
				IFormulaColorConstants.COMMENT, new RGB(63, 127,
						95));
		PreferenceConverter.setDefault(store,
				IFormulaColorConstants.KEYWORD,
				new RGB(127, 0, 85));
		PreferenceConverter
				.setDefault(store, IFormulaColorConstants.STRING,
						new RGB(42, 0, 255));

		store.setDefault(IFormulaColorConstants.COMMENT
				+ PreferenceConstants.EDITOR_BOLD_SUFFIX, false);
		store.setDefault(IFormulaColorConstants.COMMENT
				+ PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);

		store.setDefault(IFormulaColorConstants.KEYWORD
				+ PreferenceConstants.EDITOR_BOLD_SUFFIX, true);
		store.setDefault(IFormulaColorConstants.KEYWORD
				+ PreferenceConstants.EDITOR_ITALIC_SUFFIX, false);

		store.setDefault(PreferenceConstants.EDITOR_TAB_WIDTH, 8);
		store.setDefault(
				PreferenceConstants.EDITOR_SYNC_OUTLINE_ON_CURSOR_MOVE, true);

		store.setDefault(CodeFormatterConstants.FORMATTER_TAB_CHAR,
				CodeFormatterConstants.TAB);
		store.setDefault(CodeFormatterConstants.FORMATTER_TAB_SIZE, "8");
		store.setDefault(CodeFormatterConstants.FORMATTER_INDENTATION_SIZE, "8");
	}
}
