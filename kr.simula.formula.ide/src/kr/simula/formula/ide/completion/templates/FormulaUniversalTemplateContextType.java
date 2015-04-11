package kr.simula.formula.ide.completion.templates;

import org.eclipse.dltk.core.ISourceModule;
import org.eclipse.dltk.ui.templates.ScriptTemplateContext;
import org.eclipse.dltk.ui.templates.ScriptTemplateContextType;
import org.eclipse.jface.text.IDocument;

public class FormulaUniversalTemplateContextType extends
		ScriptTemplateContextType {

	public static final String CONTEXT_TYPE_ID = "formulaUniversalTemplateContextType";

	public FormulaUniversalTemplateContextType() {
	}

	public FormulaUniversalTemplateContextType(String id, String name) {
		super(id, name);
	}

	public FormulaUniversalTemplateContextType(String id) {
		super(id);
	}

	public ScriptTemplateContext createContext(IDocument document,
			int completionPosition, int length, ISourceModule sourceModule) {
		return new FormulaTemplateContext(this, document, completionPosition,
				length, sourceModule);
	}
}
