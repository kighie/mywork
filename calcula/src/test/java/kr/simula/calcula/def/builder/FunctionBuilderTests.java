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
package kr.simula.calcula.def.builder;

import java.math.BigDecimal;

import kr.simula.calcula.core.Gettable;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FunctionBuilderTests extends AbstractBuilderTests {


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
	public void performance(){
		for( int i =0;i<1000;i++){
			testExpression("=COMBIN( ABS(83/5) ,2)", new BigDecimal("120"));
		}
	}

	@Test
	public void performance2(){
		Gettable<?> expression = (Gettable<?>)buildExpression("=COMBIN( ABS(83/5) ,2)");
		System.out.println();
		System.out.println(expression.getExpression());
		System.out.println(expression);
		
		for( int i =0;i<1000;i++){
			System.out.println(expression.get(null));
		}
	}
	
}
