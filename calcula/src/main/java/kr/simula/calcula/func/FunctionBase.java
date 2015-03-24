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

package kr.simula.calcula.func;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import kr.simula.calcula.CalculaException;

/**
 * @author kighie@gmail.com
 *
 */
public abstract class FunctionBase {

	private static final double[] POW10 = { 1E-10, 1E-9, 1E-8, 1E-7, 1E-6, 1E-5, 1E-4, 1E-3, 1E-2, 1E-1, 1, 1E+1, 1E+2,
		1E+3, 1E+4, 1E+5, 1E+6, 1E+7, 1E+8, 1E+9, 1E+10 };
	
	private static final long[] FACTORIALS = { 1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600 };
	
	public static final BigDecimal PI = BigDecimal.valueOf( Math.PI );
	public static final BigDecimal TWO = BigDecimal.valueOf( 2 );
	
	public static double check(final double number) {
		if (Double.isNaN(number))
			throw new CalculaException("#NUM! (value is NaN)");
		if (Double.isInfinite(number))
			throw new CalculaException("#NUM! (value is infinite)");
		return number;
	}

	public static BigDecimal decimal(double number, int scale, RoundingMode rounding) {
		return new BigDecimal(number).setScale(scale, rounding);
	}

	public static double trunc(final double number, final int maxFrac) {
		final double shift = pow10(maxFrac);
		return roundDown(number * shift) / shift;
	}

	protected static double roundDown(final double number) {
		return 0 > number ? Math.ceil(number) : Math.floor(number);
	}

	protected static double roundUp(final double number) {
		return 0 > number ? Math.floor(number) : Math.ceil(number);
	}

	protected static double pow10(final int exponent) {
		return (exponent >= -10 && exponent <= 10) ? POW10[exponent + 10] : Math.pow(10,exponent);
	}

	protected static BigInteger factorial(int value) {
		if (value < 0 ) {
			throw new CalculaException("#NUM! because number < 0 in FACT");
		}
		
		if (value < FACTORIALS.length) {
			return BigInteger.valueOf( FACTORIALS[ value ] );
		}
		
        BigInteger n = BigInteger.ONE;
        for (int i = 2; i <= value; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        return n;
    }
	
	// protected static final String[] ZERO_ARRAY = new String[]{
	// "", "0", "00", "000","0000", "00000", "000000","0000000", "00000000",
	// "000000000","0000000000",
	// "00000000000", "000000000000", "0000000000000","00000000000000",
	// "000000000000000", "0000000000000000","00000000000000000",
	// "000000000000000000", "0000000000000000000","00000000000000000000"
	// };
	// static String decimalString(double number, int scale, RoundingMode
	// rounding){
	// StringBuilder numBuf = new StringBuilder();
	// numBuf.append(number);
	//
	// int index = numBuf.indexOf(".");
	// if(index > 0){
	// if(scale == 0){
	// numBuf = numBuf.delete(index, -1);
	// } else if(scale < 0) {
	//
	// }
	// } else if(index == 0){
	// if(scale == 0){
	//
	// }
	// } else {
	//
	// }
	//
	// return numBuf.toString();
	// }
}
