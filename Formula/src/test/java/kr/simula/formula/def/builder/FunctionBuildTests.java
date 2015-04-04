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
import java.math.MathContext;

import kr.simula.formula.ExpressionTests;
import kr.simula.formula.core.Gettable;
import kr.simula.formula.func.base.MathFunctions;
import kr.simula.formula.util.StopWatch;

import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class FunctionBuildTests extends ExpressionTests {

	private StopWatch stopwatch = new StopWatch();

	String  expressionStr = "=COMBIN( ABS(83/5) ,2)";
	
	@Test
	public void performance(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			testExpression(expressionStr, new BigDecimal("120"));
		}
		System.out.println("performance : " + stopwatch.ellapsedTime());
	}
	
	@Test
	public void performanceBuild(){
		stopwatch.start();
		for( int i =0;i<1000;i++){
			buildExpression(expressionStr);
		}
		System.out.println("performanceBuild : " + stopwatch.ellapsedTime());
	}

	Gettable<?> expression = (Gettable<?>)buildExpression(expressionStr);
	@Test
	public void performanceExec(){
		stopwatch.start();
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

	@Test
	public void testDivide(){
		BigDecimal v31 = new BigDecimal("31");
		BigDecimal v328 = new BigDecimal("3.28");
		
		int min = (int)Math.min(v31.precision() +  (long)Math.ceil(10.0*v328.precision()/3.0), Integer.MAX_VALUE);
		
		System.out.println(min);
		BigDecimal val = v31.divide(v328, new MathContext(12));
		System.out.println(val);
	}
}
