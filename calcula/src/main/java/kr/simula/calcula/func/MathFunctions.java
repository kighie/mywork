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

import javax.naming.OperationNotSupportedException;

import kr.simula.calcula.CalculaException;

/**
 * @author kighie@gmail.com
 *
 */
public final class MathFunctions extends FunctionBase {
	private MathFunctions() {}

	public static BigInteger abs(BigInteger number){
		return number.abs();
	}

	public static BigDecimal abs(BigDecimal number){
		return number.abs();
	}
	
	public static int abs (int number) {
        return (number < 0) ? -number : number;
    }

    public static long abs(long number) {
        return (number < 0) ? -number : number;
    }

    public static float abs(float number) {
        return (number <= 0.0F) ? 0.0F - number : number;
    }

    public static double abs(double number) {
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
    public static double acos(final double number) {
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
    public static BigDecimal acos(final double number, int scale, RoundingMode rounding) {
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
    public static BigDecimal acos(final BigDecimal number) {
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
    public static double acosh(final double number) {
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
    public static BigDecimal acosh(final double number, int scale, RoundingMode rounding) {
    	double ret = acosh(number);
    	return decimal(ret, scale, rounding);
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
    public static double asin(final double number) {
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
    public static BigDecimal asin(final double number, int scale, RoundingMode rounding) {
    	double ret = asin(number);
    	return decimal(ret, scale, rounding);
    }
    

    /**
     * <pre>
     * Returns an aggregate in a list or database. 
     * The AGGREGATE function can apply different aggregate functions to a list or database with the option to ignore hidden rows and error values.
     * 
     * AGGREGATE(function_num, options, array, [k])
     * 
     * </pre>
     * @param number
     * @return
     */
    /**
     * <pre>
     * Returns an aggregate in a list or database. 
     * The AGGREGATE function can apply different aggregate functions to a list or database with the option to ignore hidden rows and error values.
     * 
     * AGGREGATE(function_num, options, array, [k])
     * </pre>
     * @param function_num  A number 1 to 19 that specifies which function to use.
     * @param options A numerical value that determines which values to ignore in the evaluation range for the function.
     * @param ref1 The first numeric argument for functions that take multiple numeric arguments for which you want the aggregate value. 
     * @param ref2 Optional. Numeric arguments 2 to 253 for which you want the aggregate value.
     * @return
     */
    public static double aggregate(final int function_num, int options, Object ref, Object...ref2) {
    	throw new FunctionNotImplementedException("AGGREGATE");
    }

    /**
     * <pre>
     * Returns the inverse hyperbolic sine of a number. 
     * The inverse hyperbolic sine is the value whose hyperbolic sine is number, 
     * so ASINH(SINH(number)) equals number.
     * </pre>
     * @param number  Any real number.
     * @return
     */
    public static double asinh(final double number) {
    	return Math.log( number + Math.sqrt( number * number + 1 ) );
    }

    /**
     * <pre>
     * Returns the inverse hyperbolic sine of a number. 
     * The inverse hyperbolic sine is the value whose hyperbolic sine is number, 
     * so ASINH(SINH(number)) equals number.
     * </pre>
     * @param number  Any real number.
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal asinh(final double number, int scale, RoundingMode rounding) {
    	check(number);
    	double ret = asinh(number);
    	return decimal(ret, scale, rounding);
    }
    

    /**
     * <pre>
     * Returns the arctangent, or inverse tangent, of a number. 
     * The arctangent is the angle whose tangent is number. 
     * The returned angle is given in radians in the range -pi/2 to pi/2.
     * </pre>
     * @param number The tangent of the angle you want.
     * @return
     * @see Math#atan(double)
     */
    public static double atan(final double number) {
    	return Math.atan(number);
    }
    

    /**
     * <pre>
     * Returns the arctangent, or inverse tangent, of a number. 
     * The arctangent is the angle whose tangent is number. 
     * The returned angle is given in radians in the range -pi/2 to pi/2.
     * </pre>
     * @param number The tangent of the angle you want.
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal atan(final double number, int scale, RoundingMode rounding) {
    	check(number);
    	double ret = atan(number);
    	return decimal(ret, scale, rounding);
    }
    

    /**
     * <pre>
     * Returns the arctangent, or inverse tangent, of the specified x- and y-coordinates. 
     * The arctangent is the angle from the x-axis to a line containing the origin (0, 0) and a point with coordinates (x_num, y_num). 
     * The angle is given in radians between -pi and pi, excluding -pi.
     * </pre>
     * @param x_num The x-coordinate of the point.
     * @param y_num The y-coordinate of the point.
     * @return
     */
    public static double atan2(final double x_num, final double y_num) {
    	return Math.atan2(y_num, x_num);
    }
    

    public static BigDecimal atan2(final double x_num, final double y_num, 
    		int scale, RoundingMode rounding) {
    	check(x_num);
    	check(y_num);
    	double ret = atan2(x_num, y_num);
    	return decimal(ret, scale, rounding);
    }
    

    /**
     * <pre>
     * Returns the inverse hyperbolic tangent of a number. 
     * Number must be between -1 and 1 (excluding -1 and 1). 
     * The inverse hyperbolic tangent is the value whose hyperbolic tangent is number, so ATANH(TANH(number)) equals number.
     * </pre>
     * @param number Any real number between 1 and -1.
     * @return
     */
    public static double atanh(final double number) {
    	return Math.log( (1 + number) / (1 - number) ) / 2;
    }

    public static BigDecimal atanh(final double number, int scale, RoundingMode rounding) {
    	check(number);
    	double ret = atanh(number);
    	return decimal(ret, scale, rounding);
    }

    /**
     * <pre>
     * Returns number rounded up, away from zero, to the nearest multiple of significance. 
     * 
     * For example, if you want to avoid using pennies in your prices and your product is priced at $4.42, 
     * use the formula =CEILING(4.42,0.05) to round prices up to the nearest nickel.
     * </pre>
     * @param number  The value you want to round.
     * @param significance The multiple to which you want to round.
     * @return
     */
    public static double ceiling(final double number, final double significance) {
    	final double ret = number / significance;
		if (ret < 0) {
			throw new CalculaException("#NUM! because signum of args not equal in CEILING");
		}
		return roundUp( ret ) * significance;
    }


    public static BigDecimal ceiling(final double number, final double significance, 
    		int scale, RoundingMode rounding) {
    	check(number);
    	double ret = ceiling(number, significance);
    	return decimal(ret, scale, rounding);
    }
    

    /**
     * <pre>
     * Returns the number of combinations for a given number of items. 
     * Use COMBIN to determine the total possible number of groups for a given number of items.
     * 
     * =COMBIN(8,2) : Possible two-person teams that can be formed from 8 candidates - 28
     * </pre>
     * @param number The number of items.
     * @param number_chosen  The number of items in each combination.
     * @return
     */
    public static double combin(final int number, final int number_chosen) {
    	
		return 0;
    }
    
	/*


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
