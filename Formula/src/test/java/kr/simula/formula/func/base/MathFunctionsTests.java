/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package kr.simula.formula.func.base;

import java.math.BigDecimal;
import java.math.RoundingMode;

import kr.simula.formula.func.NumericFunction;
import kr.simula.formula.func.base.MathFunctions;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author kighie@gmail.com
 *
 */
public class MathFunctionsTests {

	static final double EXCEL_JAVA_GAP = 0.000000001;
	static final int SCALE = 9;
	
	@Test
	public void testACOS(){
		double acos1 = MathFunctions.acos(0.3);
		BigDecimal acos2 = MathFunctions.acos(new BigDecimal("0.3"));
		
		Assert.assertEquals( 1.266103673D, acos1, EXCEL_JAVA_GAP);
		Assert.assertEquals( acos1, acos2.doubleValue(), 0);
//		System.out.println(acos1 + " = " + acos2);
	}
	

	@Test
	public void testACOSH(){
		double acos1 = MathFunctions.acosh(1.2);
		BigDecimal acos3 = MathFunctions.acosh(1.2, SCALE, RoundingMode.HALF_EVEN);
		
		Assert.assertEquals( 0.622362504D, acos1, EXCEL_JAVA_GAP);
		Assert.assertEquals( 0.622362504D, acos3.doubleValue(), 0);
//		System.out.println(acos1 + " = " + acos2);
	}
	

	@Test
	public void gcd(){
		Assert.assertEquals(2, MathFunctions.gcd(4, 6));
		Assert.assertEquals(2, MathFunctions.gcd(4, 6, 8));
		Assert.assertEquals(14, MathFunctions.gcd(42, 56));
		Assert.assertEquals(7, MathFunctions.gcd(42, 56, 49));
	}
	

	@Test
	public void lcm(){
		Assert.assertEquals(12, MathFunctions.lcm(4, 6));
		Assert.assertEquals(24, MathFunctions.lcm(4, 6, 8));
		Assert.assertEquals(168, MathFunctions.lcm(42, 56));
		Assert.assertEquals(392, MathFunctions.lcm(42, 56, 49));
	}
	
	@Test
	public void test(){
		System.out.println(NumericFunction.toDecimal(11));
		System.out.println(new BigDecimal(1));
		System.out.println(new BigDecimal(1.0));
		System.out.println(new BigDecimal("1"));
		System.out.println(new BigDecimal("1.0"));
	}
}
