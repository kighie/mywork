package kr.simula.formula.ide.search;

import org.eclipse.dltk.core.search.AbstractSearchFactory;
import org.eclipse.dltk.core.search.IMatchLocatorParser;
import org.eclipse.dltk.core.search.matching.MatchLocator;

public class FormulaSearchFactory extends AbstractSearchFactory {

	@Override
	public IMatchLocatorParser createMatchParser(MatchLocator locator) {
		return new FormulaMatchLocatorParser(locator);
	}
}
