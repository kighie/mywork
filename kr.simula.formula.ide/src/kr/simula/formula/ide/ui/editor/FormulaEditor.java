package kr.simula.formula.ide.ui.editor;

import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.core.FormulaLanguageToolkit;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.dltk.ui.text.ScriptTextTools;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.IDocumentExtension3;
import org.eclipse.ui.IEditorInput;

public class FormulaEditor extends ScriptEditor {

	public static final String EDITOR_ID = "kr.simula.formula.ide.ui.editor";

	public static final String EDITOR_CONTEXT = "#FormulaEditorContext";

	protected void initializeEditor() {
		super.initializeEditor();
		setEditorContextMenuId(EDITOR_CONTEXT);
	}

	public String getEditorId() {
		return EDITOR_ID;
	}

	protected IPreferenceStore getScriptPreferenceStore() {
		return FormulaPlugin.getDefault().getPreferenceStore();
	}

	public IDLTKLanguageToolkit getLanguageToolkit() {
		return FormulaLanguageToolkit.getDefault();
	}
	
	public ScriptTextTools getTextTools() {
		return FormulaPlugin.getDefault().getTextTools();
	}
	
	protected void connectPartitioningToElement(IEditorInput input,
			IDocument document) {
		if (document instanceof IDocumentExtension3) {
			IDocumentExtension3 extension = (IDocumentExtension3) document;
			if (extension.getDocumentPartitioner(IFormulaPartitions.FORMULA_PARTITIONING) == null) {
				FormulaTextTools tools = FormulaPlugin.getDefault().getTextTools();
				tools.setupDocumentPartitioner(document, IFormulaPartitions.FORMULA_PARTITIONING);
			}
		}
	}
	
	
}