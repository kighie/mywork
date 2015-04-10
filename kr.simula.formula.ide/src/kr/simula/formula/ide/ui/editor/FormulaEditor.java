package kr.simula.formula.ide.ui.editor;

import kr.simula.formula.ide.FormulaPlugin;
import kr.simula.formula.ide.core.FormulaLanguageToolkit;

import org.eclipse.dltk.core.IDLTKLanguageToolkit;
import org.eclipse.dltk.internal.ui.editor.ScriptEditor;
import org.eclipse.jface.preference.IPreferenceStore;

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
}