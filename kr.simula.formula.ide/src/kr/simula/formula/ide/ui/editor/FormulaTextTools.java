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
package kr.simula.formula.ide.ui.editor;

import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.ui.texteditor.ITextEditor;

/**
 * <pre>
 * </pre>
 * 
 * @author Ikchan Kwon
 *
 */
public class FormulaTextTools extends ScriptTextTools {

	private final static String[] LEGAL_CONTENT_TYPES = new String[] {
			IFormulaPartitions.FORMULA_STRING,
			IFormulaPartitions.FORMULA_COMMENT };

	private IPartitionTokenScanner fPartitionScanner;

	public FormulaTextTools(boolean autoDisposeOnDisplayDispose) {
		super(IFormulaPartitions.FORMULA_PARTITIONING, LEGAL_CONTENT_TYPES,
				autoDisposeOnDisplayDispose);

		fPartitionScanner = new FormulaPartitionScanner();
	}

	public ScriptSourceViewerConfiguration createSourceViewerConfiguraton(
			IPreferenceStore preferenceStore, ITextEditor editor,
			String partitioning) {
		return new FormulaSourceViewerConfiguration(getColorManager(),
				preferenceStore, editor, partitioning);
	}

	public IPartitionTokenScanner getPartitionScanner() {
		return fPartitionScanner;
	}
	
}
