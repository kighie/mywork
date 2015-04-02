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
import kr.simula.calcula.func.base.MathFunctions;
import kr.simula.calcula.util.StopWatch;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FunctionBuildTests extends ExpressionTests {

	private StopWatch stopwatch = new StopWatch();
	
	@Test
	public void performance(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			testExpression("=COMBIN( ABS(83/5) ,2)", new BigDecimal("120"));
		}
		System.out.println("performance : " + stopwatch.ellapsedTime());
	}
	
	@Test
	public void performanceBuild(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			buildExpression("=COMBIN( ABS(83/5) ,2)");
		}
		System.out.println("performanceBuild : " + stopwatch.ellapsedTime());
	}
	
	Gettable<?> expression = (Gettable<?>)buildExpression("=COMBIN( ABS(83/5) ,2)");
	@Test
	public void performanceExec(){
		stopwatch.start();
		
//		System.out.println();
//		System.out.println(expression.getExpression());
//		System.out.println(expression);
		
		for( int i =0;i<1000;i++){
			System.out.println(expression.get(null));
		}
		System.out.println("performanceExec : " + stopwatch.ellapsedTime());
	}

	@Test
	public void javaCode(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			double value = MathFunctions.combin(MathFunctions.abs(83/5), 2);
			
			System.out.println(value);
		}
		System.out.println("javaCode : " + stopwatch.ellapsedTime());
	}

	@Test
	public void javaCode2(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			double value = MathFunctions.combin(MathFunctions.abs(83/5), 2);
			
			System.out.println(new BigDecimal(value));
		}
		System.out.println("javaCode2 : " + stopwatch.ellapsedTime());
	}

}
