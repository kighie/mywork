package kr.simula.formula.ide.ui;

import kr.simula.formula.ide.ui.editor.SimpleFormulaSourceViewerConfiguration;

import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;

public class FormulaUILanguageToolkit2 extends FormulaUILanguageToolkit {
	public ScriptSourceViewerConfiguration createSourceViewerConfiguration() {
		return new SimpleFormulaSourceViewerConfiguration(getTextTools()
				.getColorManager(), getPreferenceStore(), null,
				getPartitioningId(), false);
	}
}
