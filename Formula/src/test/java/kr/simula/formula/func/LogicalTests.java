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
package kr.simula.formula.func;

import java.math.BigDecimal;

import kr.simula.formula.ExpressionTests;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class LogicalTests  extends ExpressionTests {

	@Test
	public void AND(){
		testExpression("=AND(true, true, false)", false);
	}

	@Test
	public void OR(){
		testExpression("=OR(false, false, false, true)", true);
	}

	@Test
	public void IF(){
		testExpression("=IF(true, 'YES', 'NO')", "YES");
		testExpression("=IF(false, 'YES', 'NO')", "NO");
		testExpression("=IF(true, 10, 20) * 10", new BigDecimal(10));
		testExpression("=IF(false, 10, 20)", new BigDecimal(20));
	}

}
