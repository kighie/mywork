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
package kr.simula.formula.def.builder;

import java.math.BigDecimal;

import kr.simula.formula.ExpressionTests;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilderTests extends ExpressionTests {

	@Test
	public void buildLiteralNumeric(){
		testExpression("=1+3 * (4 + 15) - 31.5 / 10", new BigDecimal("54.85"));
		testExpression("=(1+3 * 4 + 15 - 30 / 10)", new BigDecimal(25));
		testExpression("=(1+3 * 4 + 15 - 30 % 10)", new BigDecimal(28));
		
		testExpression("=(5 * -3 + 7)", new BigDecimal(-8));
	}

	@Test
	public void buildLiteralCompare(){
		testExpression("=(1+3 * 4 + 15 - 30 / 10)=25", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)>10", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)>=10", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<=75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<>75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)!=75", true);
	}
	
	@Test
	public void buildLiteralLogical(){
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) and (100/2 = 50)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) and (100/2 = 30)", false);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) or (100/2 = 30)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=30 ) or (100/2 = 30)", false);
		

		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) and not(100/2 = 30)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=30 ) or not(100/2 = 30)", true);
	}

	@Test
	public void buildLiteralString(){
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) & \" : ddd\"", "true : ddd");
		testExpression("=(1+3 * 4 + 15 - 30 / 10) & \" : aaa\"", "25 : aaa");
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) & ' : ABC'", "true : ABC");
		testExpression("=(1+3 * 4 + 15 - 30 / 10) & ' : ABC'", "25 : ABC");
		
		testExpression("=\"ddd:\" & ( (1+3 * 4 + 15 - 30 / 10)=25 ) ", "ddd:true");
		testExpression("=\"aaa:\" & (1+3 * 4 + 15 - 30 / 10)" , "aaa:25");
	}
}
