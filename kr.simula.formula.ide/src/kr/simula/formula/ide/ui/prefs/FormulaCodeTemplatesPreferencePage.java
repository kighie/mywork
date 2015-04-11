package kr.simula.formula.ide.ui.prefs;

import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.completion.templates.FormulaTemplateAccess;
import kr.simula.formula.ide.ui.editor.FormulaTextTools;
import kr.simula.formula.ide.ui.editor.IFormulaPartitions;
import kr.simula.formula.ide.ui.editor.SimpleFormulaSourceViewerConfiguration;

import org.eclipse.dltk.ui.templates.ScriptTemplateAccess;
import org.eclipse.dltk.ui.templates.ScriptTemplatePreferencePage;
import org.eclipse.dltk.ui.text.ScriptSourceViewerConfiguration;
import org.eclipse.jface.text.IDocument;

public class FormulaCodeTemplatesPreferencePage extends ScriptTemplatePreferencePage {
	protected ScriptSourceViewerConfiguration createSourceViewerConfiguration() {
		return new SimpleFormulaSourceViewerConfiguration(getTextTools().getColorManager(), 
				getPreferenceStore(), null,
				IFormulaPartitions.FORMULA_PARTITIONING, false);
	}
	
	protected void setDocumentParticioner(IDocument document) {
		getTextTools().setupDocumentPartitioner(document,
				IFormulaPartitions.FORMULA_PARTITIONING);
	}
	protected void setPreferenceStore() {
		setPreferenceStore(FormulaPlugin.getDefault().getPreferenceStore());
	}
	protected ScriptTemplateAccess getTemplateAccess() {
		return FormulaTemplateAccess.getInstance();
	}
	private FormulaTextTools getTextTools() {
		return FormulaPlugin.getDefault().getTextTools();
	}
}
