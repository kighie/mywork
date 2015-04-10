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

import java.util.ArrayList;
import java.util.List;

import kr.simula.formula.script.edit.FormulaScriptEditSupport;

import org.eclipse.dltk.ui.text.AbstractScriptScanner;
import org.eclipse.dltk.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.IWhitespaceDetector;
import org.eclipse.jface.text.rules.IWordDetector;
import org.eclipse.jface.text.rules.WhitespaceRule;
import org.eclipse.jface.text.rules.WordRule;

/**
 * <pre>
 * </pre>
 * 
 * @author Ikchan Kwon
 *
 */
public class FormulaCodeScanner extends AbstractScriptScanner {

	private static String[] fgKeywords = FormulaScriptEditSupport.getKeywords();
	
	private static String fgTokenProperties[] = new String[] {
			IFormulaColorConstants.COMMENT,
			IFormulaColorConstants.DEFAULT,
			IFormulaColorConstants.KEYWORD };

	public FormulaCodeScanner(IColorManager manager,
			IPreferenceStore store) {
		super(manager, store);
		this.initialize();
	}

	protected String[] getTokenProperties() {
		return fgTokenProperties;
	}

	protected List<IRule> createRules() {
		List<IRule> rules = new ArrayList<IRule>();
		IToken keyword = this.getToken(IFormulaColorConstants.KEYWORD);
		IToken comment = this.getToken(IFormulaColorConstants.COMMENT);
		IToken other = this.getToken(IFormulaColorConstants.DEFAULT);
		// Add rule for single line comments.
		rules.add(new EndOfLineRule("//", comment));
		// Add generic whitespace rule.
		rules.add(new WhitespaceRule(new FormulaWhitespaceDetector()));
		// Add word rule for keywords.
		WordRule wordRule = new WordRule(new FormulaWordDetector(), other);
		for (int i = 0; i < fgKeywords.length; i++) {
			wordRule.addWord(fgKeywords[i], keyword);
		}
		rules.add(wordRule);
		this.setDefaultReturnToken(other);
		return rules;
	}

	public class FormulaWhitespaceDetector implements IWhitespaceDetector {
		public boolean isWhitespace(char character) {
			return Character.isWhitespace(character);
		}
	}

	public class FormulaWordDetector implements IWordDetector {
		public boolean isWordPart(char character) {
			return Character.isJavaIdentifierPart(character);
		}

		public boolean isWordStart(char character) {
			return Character.isJavaIdentifierStart(character);
		}
	}

}
