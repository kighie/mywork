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
package kr.simula.formula.def;

import kr.simula.formula.FormulaException;
import kr.simula.formula.core.Function;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
@SuppressWarnings("serial")
public abstract class AbstractFunction<O> implements Function<O> {
	private Class<? extends O> returnType;

	/**
	 * @param returnType
	 */
	public AbstractFunction(Class<? extends O> returnType) {
		this.returnType = returnType;
	}
	
	@Override
	public Class<? extends O> getReturnType() {
		return returnType;
	}
	
	protected void checkArgCount(Object[] args, int count) throws FormulaException {
        if (args == null && count != 0) {
            throw new FormulaException(getClass().getSimpleName() +
                    " function takes no arguments");
        }

        if (args.length != count)
            throw new FormulaException(getClass().getSimpleName() +
                    " function needs " + count + " arguments, but " + args.length);
    }
	
	protected void checkArgCountMoreThan(Object[] args, int count) throws FormulaException {
        if (args == null && count != 0) {
            throw new FormulaException(getClass().getSimpleName() +
                    " function takes no arguments");
        }

        if (args.length <= count)
            throw new FormulaException(getClass().getSimpleName() +
                    " function takes " + count + " arguments");
    }
}
