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

import kr.simula.calcula.ExpressionTests;
import kr.simula.calcula.core.Gettable;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FunctionBuildTests extends ExpressionTests {

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
