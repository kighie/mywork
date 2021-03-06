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

import org.eclipse.jface.text.rules.EndOfLineRule;
import org.eclipse.jface.text.rules.IPredicateRule;
import org.eclipse.jface.text.rules.IRule;
import org.eclipse.jface.text.rules.IToken;
import org.eclipse.jface.text.rules.MultiLineRule;
import org.eclipse.jface.text.rules.RuleBasedPartitionScanner;
import org.eclipse.jface.text.rules.Token;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FormulaPartitionScanner extends RuleBasedPartitionScanner {

	/**
	 * 
	 */
	public FormulaPartitionScanner() {
		IToken string = new Token(IFormulaPartitions.FORMULA_STRING);
		IToken comment = new Token(IFormulaPartitions.FORMULA_COMMENT);
 
		List<IRule> rules = new ArrayList<IRule>();
 
		rules.add(new EndOfLineRule("//", comment));
		rules.add(new MultiLineRule("/*", "*/", comment ));
		rules.add(new MultiLineRule("\"\"\"", "\"\"\"", string, '\\'));
		rules.add(new MultiLineRule("\'\'\'", "\'\'\'", string, '\\'));
		rules.add(new MultiLineRule("\'", "\'", string, '\\'));
		rules.add(new MultiLineRule("\"", "\"", string, '\\'));
 
		IPredicateRule[] result = new IPredicateRule[rules.size()];
		rules.toArray(result);
		setPredicateRules(result);
	}
	
	
}
