/* 
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
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class MathTests extends ExpressionTests {

	@Test
	public void ABS(){
		testExpression("=ABS(1+3 * (4 - 15) - 31.5 / 10)", new BigDecimal("35.15"));
		testExpression("=ABS(1+3 * ABS(4 - 15) - 31.5 / 10)", new BigDecimal("30.85"));
		testExpression("=1+ABS(3 * 4 - 15) - 31.5 / 10", new BigDecimal("0.85"));
		testExpression("=ABS(3 * 4 - 15)", new BigDecimal("3"));
		testExpression("=3 * ABS(4 - 15)", new BigDecimal("33"));
	}

	@Test
	public void ACOS(){
		testExpression("=ACOS(0.43)", new BigDecimal("1.126303550"));
		testExpression("=ACOS(0.53)", new BigDecimal("1.012195761"));
		testExpression("=ACOS(0.63)", new BigDecimal("0.889243115"));
		testExpression("=ACOS(0.73)", new BigDecimal("0.752474376"));
		testExpression("=ACOS(0.83)", new BigDecimal("0.591688642"));
		testExpression("=ACOS(-0.43)", new BigDecimal("2.015289104"));
		testExpression("=ACOS(-0.53)", new BigDecimal("2.129396892"));
		testExpression("=ACOS(-0.63)", new BigDecimal("2.252349538"));
		testExpression("=ACOS(-0.73)", new BigDecimal("2.389118277"));
		testExpression("=ACOS(-0.83)", new BigDecimal("2.549904011"));

		testExpression("=ACOS((1+3 * (4 - 15) - 31.5 / 10)/100)", new BigDecimal("1.929969192"));
		
		
	}

	@Test
	public void CEILING(){
		testExpression("=CEILING(4.42, 0.05)", new BigDecimal("4.45"));
		testExpression("=CEILING(100.012345, 0.05)", new BigDecimal("100.05"));
		testExpression("=CEILING(100.012345, 0.003)", new BigDecimal("100.014"));
		testExpression("=CEILING(100.012345, 0.002)", new BigDecimal("100.014"));
		testExpression("=CEILING(100.012345, 0.0001)", new BigDecimal("100.0124"));
		testExpression("=CEILING(100.012345, 0.0005)", new BigDecimal("100.0125"));
		testExpression("=CEILING(100.012345, 0.0008)", new BigDecimal("100.0128"));
	}

	@Test
	public void COMBIN(){
		testExpression("=COMBIN(8,2)", new BigDecimal("28"));
		testExpression("=COMBIN(8,3)", new BigDecimal("56"));
		testExpression("=COMBIN(8,4)", new BigDecimal("70"));
		testExpression("=COMBIN(8,5)", new BigDecimal("56"));
		testExpression("=COMBIN(8,6)", new BigDecimal("28"));
		testExpression("=COMBIN(8,7)", new BigDecimal("8"));
	}

	@Test
	public void EVEN(){
		testExpression("=EVEN(234.9341)", new BigDecimal("236"));
		testExpression("=EVEN(13.34)", new BigDecimal("14"));
	}

	@Test
	public void EXP(){
		testExpression("=EXP(3)", new BigDecimal("20.08553692"));
		testExpression("=EXP(5)", new BigDecimal("148.4131591"));
		testExpression("=EXP(8)", new BigDecimal("2980.957987"));
		testExpression("=EXP(10)", new BigDecimal("22026.46579"));
		testExpression("=EXP(12)", new BigDecimal("162754.7914"));
		testExpression("=EXP(13)", new BigDecimal("442413.3920"));
		testExpression("=EXP(15)", new BigDecimal("3269017.372"));
		testExpression("=EXP(20)", new BigDecimal("485165195.4"));
	}

	@Test
	public void FACT(){
		testExpression("=FACT(3)", new BigDecimal("6"));
		testExpression("=FACT(5)", new BigDecimal("120"));
		testExpression("=FACT(8)", new BigDecimal("40320"));
		testExpression("=FACT(10)", new BigDecimal("3628800"));
		testExpression("=FACT(12)", new BigDecimal("479001600"));
		testExpression("=FACT(13)", new BigDecimal("6227020800"));
		
		try {
			testExpression("=FACT(15)", new BigDecimal("1.30767E+12"));
			testExpression("=FACT(20)", new BigDecimal("2.4329E+18"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
