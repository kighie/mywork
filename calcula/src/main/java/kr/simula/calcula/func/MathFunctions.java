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
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @author kighie@gmail.com
 *
 */
public final class MathFunctions extends FunctionBase {
	private MathFunctions() {}

	public static BigInteger ABS(BigInteger number){
		return number.abs();
	}

	public static BigDecimal ABS(BigDecimal number){
		return number.abs();
	}
	
	public static int ABS (int number) {
        return (number < 0) ? -number : number;
    }

    public static long ABS(long number) {
        return (number < 0) ? -number : number;
    }

    public static float ABS(float number) {
        return (number <= 0.0F) ? 0.0F - number : number;
    }

    public static double ABS(double number) {
        return (number <= 0.0D) ? 0.0D - number : number;
    }

    /**
     * <pre>
     * Returns the arccosine, or inverse cosine, of a number. 
     * The arccosine is the angle whose cosine is number. 
     * The returned angle is given in radians in the range 0 (zero) to pi.
     * </pre>
     * @param number
     * @return
     */
    public static double ACOS(final double number) {
        return Math.acos(number);
    }

    /**
     * <pre>
     * Returns the arccosine, or inverse cosine, of a number. 
     * The arccosine is the angle whose cosine is number. 
     * The returned angle is given in radians in the range 0 (zero) to pi.
     * </pre>
     * @param number
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal ACOS(final double number, int scale, RoundingMode rounding) {
    	double ret = Math.acos(number);
        return new BigDecimal(ret).setScale(scale, rounding);
    }

    /**
     * <pre>
     * Returns the arccosine, or inverse cosine, of a number. 
     * The arccosine is the angle whose cosine is number. 
     * The returned angle is given in radians in the range 0 (zero) to pi.
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal ACOS(final BigDecimal number) {
        return BigDecimal.valueOf( Math.acos(number.doubleValue()) ).setScale(number.scale());
    }

    /**
     * <pre>
     * Returns the inverse hyperbolic cosine of a number. 
     * Number must be greater than or equal to 1. 
     * The inverse hyperbolic cosine is the value whose hyperbolic cosine is number, 
     * so ACOSH(COSH(number)) equals number.
     * </pre>
     * @param number
     * @return
     */
    public static double ACOSH(final double number) {
    	return Math.log( number + Math.sqrt( number * number - 1 ) );
    }


    /**
     * 
     * <pre>
     * Returns the inverse hyperbolic cosine of a number. 
     * Number must be greater than or equal to 1. 
     * The inverse hyperbolic cosine is the value whose hyperbolic cosine is number, 
     * so ACOSH(COSH(number)) equals number.
     * </pre>
     * @param number
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal ACOSH(final double number, int scale, RoundingMode rounding) {
    	double ret = ACOSH(number);
    	return new BigDecimal(ret).setScale(scale, rounding);
    }
    
    /**
     * <pre>
     * Returns the inverse hyperbolic cosine of a number. 
     * Number must be greater than or equal to 1. 
     * The inverse hyperbolic cosine is the value whose hyperbolic cosine is number, 
     * so ACOSH(COSH(number)) equals number.
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal ACOSH(final BigDecimal number) {
    	double ret = ACOSH(number.doubleValue());
    	return BigDecimal.valueOf(ret).setScale(number.scale());
    }

    /**
     * 
     * <pre>
     * Returns the arcsine, or inverse sine, of a number. 
     * The arcsine is the angle whose sine is number. 
     * The returned angle is given in radians in the range -pi/2 to pi/2.
     * </pre>
     * @param number is the sine of the angle you want and must be from -1 to 1.
     * @return
     */
    public static double ASIN(final double number) {
    	return Math.asin(number);
    }

    /**
     * <pre>
     * Returns the arcsine, or inverse sine, of a number. 
     * The arcsine is the angle whose sine is number. 
     * The returned angle is given in radians in the range -pi/2 to pi/2.
     * </pre>
     * @param number is the sine of the angle you want and must be from -1 to 1.
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal ASIN(final double number, int scale, RoundingMode rounding) {
    	double ret = ASIN(number);
    	return new BigDecimal(ret).setScale(scale, rounding);
    }
    
    
	/*

ASINH

Returns the inverse hyperbolic sine of a number

ATAN

Returns the arctangent of a number

ATAN2

Returns the arctangent from x- and y-coordinates

ATANH

Returns the inverse hyperbolic tangent of a number

CEILING

Rounds a number to the nearest integer or to the nearest multiple of significance

COMBIN

Returns the number of combinations for a given number of objects

COS

Returns the cosine of a number

COSH

Returns the hyperbolic cosine of a number

DEGREES

Converts radians to degrees

EVEN

Rounds a number up to the nearest even integer

EXP

Returns e raised to the power of a given number

FACT

Returns the factorial of a number

FACTDOUBLE

Returns the double factorial of a number

FLOOR

Rounds a number down, toward zero

GCD

Returns the greatest common divisor

INT

Rounds a number down to the nearest integer

LCM

Returns the least common multiple

LN

Returns the natural logarithm of a number

LOG

Returns the logarithm of a number to a specified base

LOG10

Returns the base-10 logarithm of a number

MDETERM

Returns the matrix determinant of an array

MINVERSE

Returns the matrix inverse of an array

MMULT

Returns the matrix product of two arrays

MOD

Returns the remainder from division

MROUND

Returns a number rounded to the desired multiple

MULTINOMIAL

Returns the multinomial of a set of numbers

ODD

Rounds a number up to the nearest odd integer

PI

Returns the value of pi

POWER

Returns the result of a number raised to a power

PRODUCT

Multiplies its arguments

QUOTIENT

Returns the integer portion of a division

RADIANS

Converts degrees to radians

RAND

Returns a random number between 0 and 1

RANDBETWEEN

Returns a random number between the numbers you specify

ROMAN

Converts an arabic numeral to roman, as text

ROUND

Rounds a number to a specified number of digits

ROUNDDOWN

Rounds a number down, toward zero

ROUNDUP

Rounds a number up, away from zero

SERIESSUM

Returns the sum of a power series based on the formula

SIGN

Returns the sign of a number

SIN

Returns the sine of the given angle

SINH

Returns the hyperbolic sine of a number

SQRT

Returns a positive square root

SQRTPI

Returns the square root of (number * pi)

SUBTOTAL

Returns a subtotal in a list or database

SUM

Adds its arguments

SUMIF

Adds the cells specified by a given criteria

SUMIFS

Adds the cells in a range that meet multiple criteria

SUMPRODUCT

Returns the sum of the products of corresponding array components

SUMSQ

Returns the sum of the squares of the arguments

SUMX2MY2

Returns the sum of the difference of squares of corresponding values in two arrays

SUMX2PY2

Returns the sum of the sum of squares of corresponding values in two arrays

SUMXMY2

Returns the sum of squares of differences of corresponding values in two arrays

TAN

Returns the tangent of a number

TANH

Returns the hyperbolic tangent of a number

TRUNC

Truncates a number to an integer
	 */
}
