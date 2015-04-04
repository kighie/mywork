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
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

import cern.colt.matrix.DoubleFactory2D;
import cern.colt.matrix.DoubleMatrix2D;
import cern.colt.matrix.linalg.Algebra;
import kr.simula.formula.FormulaException;
import kr.simula.formula.core.RtException;
import kr.simula.formula.func.FunctionNotImplementedException;

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
     * @param number The cosine of the angle you want and must be from -1 to 1.
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
     * @param number The cosine of the angle you want and must be from -1 to 1.
     * @param scale
     * @param rounding
     * @return
     */
    public static BigDecimal acos(final double number, int scale, RoundingMode rounding) {

    	if(number >=-1 && number <= 1) {
    		 return BigDecimal.valueOf( Math.acos(number) );
    	}
    	double ret = Math.acos(number);
        return new BigDecimal(ret).setScale(scale, rounding);
    }

    /**
     * <pre>
     * Returns the arccosine, or inverse cosine, of a number. 
     * The arccosine is the angle whose cosine is number. 
     * The returned angle is given in radians in the range 0 (zero) to pi.
     * </pre>
     * @param number The cosine of the angle you want and must be from -1 to 1.
     * @return
     */
    public static BigDecimal acos(final BigDecimal number) {
    	if(NEGAT_ONE.compareTo(number) <= 0 && ONE.compareTo(number) >= 0) {
    		 return BigDecimal.valueOf( Math.acos(number.doubleValue()) );
    	}
       throw new RtException("acos(..) argument must be in range -1 to 1" );
    }

    public static BigDecimal acos(final BigDecimal number, final MathContext mc) {
    	if(NEGAT_ONE.compareTo(number) <= 0 && ONE.compareTo(number) >= 0) {
    		 return new BigDecimal( Math.acos(number.doubleValue()) , mc);
    	}
       throw new RtException("acos(..) argument must be in range -1 to 1" );
    }

    public static BigDecimal acos(final BigDecimal number, final int scale, final RoundingMode rounding) {
    	if(NEGAT_ONE.compareTo(number) <= 0 && ONE.compareTo(number) >= 0) {
    		 return new BigDecimal( Math.acos(number.doubleValue())).setScale(scale, rounding);
    	}
       throw new RtException("acos(..) argument must be in range -1 to 1" );
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
			throw new FormulaException("#NUM! because signum of args not equal in CEILING");
		}
		return roundUp( ret ) * significance;
    }

    public static BigDecimal ceiling(final BigDecimal number, final BigDecimal significance) {
    	double ret = ceiling(number.doubleValue(), significance.doubleValue());
    	
    	return decimal(ret, significance.scale(), RoundingMode.HALF_DOWN);
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
    	return factorial(number).divide(
                factorial(number_chosen).multiply(factorial(number - number_chosen))).doubleValue();
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
    public static BigDecimal combin(final BigDecimal number, final BigDecimal number_chosen) {
    	if( number.compareTo(number_chosen) < 0){
    		throw new RtException("combin(number,number_chosen) number must be greater than number_chosen");
    	}
    	return new BigDecimal(combin(number.intValue(), number_chosen.intValue()));
    }
    

    /**
     * <pre>
     * Returns the cosine of the given angle.
     * </pre>
     * @param angle
     * @return
     * @see Math#cos(double)
     */
    public static double cos(final double angle) {
		return Math.cos(angle);
    }

    /**
     * <pre>
     * Returns the hyperbolic cosine of the given angle.
     * </pre>
     * @param angle
     * @return
     * @see Math#cosh(double)
     */
    public static double cosh(final double angle) {
		return Math.cosh(angle);
    }

    /**
     * <pre>
     * Converts radians to degrees
     * </pre>
     * @param angle
     * @return converted radians
     * @see #radians(double)
     */
    public static double degree(final double angle) {
		return angle * 180 / Math.PI;
    }

    /**
     * <pre>
     * Converts radians to degrees
     * </pre>
     * @param angle
     * @param mc
     * @return
     * @see #radians(BigDecimal, MathContext)
     */
    public static BigDecimal degree(final double angle, MathContext mc) {
		return degree( BigDecimal.valueOf(angle), mc );
    }
    

    /**
     * <pre>
     * Converts radians to degrees
     * </pre>
     * @param angle
     * @param mc
     * @return
     */
    public static BigDecimal degree(BigDecimal angle, MathContext mc) {
		return angle.multiply( BigDecimal.valueOf( 180 ) ,mc ).divide( PI, mc );
    }
    

    /**
     * <pre>
     * Rounds a number up to the nearest even integer
     * </pre>
     * @param number
     * @return
     */
    public static double even(final double number) {
    	return roundUp( number / 2 ) * 2;
    }
    


    /**
     * <pre>
     * Rounds a number up to the nearest even integer
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal even( BigDecimal number) {
    	final BigDecimal rounded = number.divide( TWO, 0, RoundingMode.UP );
		return rounded.multiply( TWO );
    }
    

    /**
     * <pre>
     * Returns e raised to the power of a given number
     * </pre>
     * @param number
     * @return
     */
    public static double exp(final double number) {
    	return Math.exp(number);
    }

    /**
     * <pre>
     * Returns e raised to the power of a given number
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal exp(final BigDecimal number) {
    	return new BigDecimal(Math.exp(number.doubleValue()));
    }

    /**
     * <pre>
     * Returns e raised to the power of a given number
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal exp(final BigDecimal number, MathContext mc) {
    	return new BigDecimal(Math.exp(number.doubleValue()), mc);
    }
    

    /**
     * <pre>
     * Returns the factorial of a number
     * </pre>
     * @param number
     * @return
     */
    public static BigInteger fact(final int number) {
		return factorial( number );
    }

    /**
     * <pre>
     * Returns the factorial of a number
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal fact(final BigDecimal number) {
		return new BigDecimal(factorial( number.intValue()));
    }
    

    public static BigDecimal fact(final BigDecimal number, MathContext mc) {
		return new BigDecimal(factorial( number.intValue()), mc);
    }
    
    
    /**
     * <pre>
     * Rounds number down, toward zero, to the nearest multiple of significance.
     * </pre>
     * @param number
     * @param significance
     * @return
     */
    public static double floor(final double number, final double significance) {
    	final double a = number / significance;
    	
    	if (a < 0) {
    		throw new FormulaException("#NUM! because signum of args not equal in FLOOR");
    	}
    	
    	return roundDown( a ) * significance;
    }

    /**
     * <pre>
     * Rounds number down, toward zero, to the nearest multiple of significance.
     * </pre>
     * @param number
     * @param significance
     * @param mc
     * @return
     */
    public static BigDecimal floor(BigDecimal number, BigDecimal significance, MathContext mc ) {
    	BigDecimal a = number.divide( significance, mc );
    	
    	if (a.signum() < 0) {
    		throw new FormulaException("#NUM! because signum of args not equal in FLOOR");
    	}
    	
    	return a.setScale( 0, RoundingMode.DOWN ).multiply( significance, mc );
    }
    

    /**
     * <pre>
     * Returns the greatest common divisor of two or more integers. 
     * The greatest common divisor is the largest integer that divides both number1 and number2... without a remainder.
     * </pre>
     * @param number1
     * @param numbers optional. 1 to 255 values. If any value is not an integer, it is truncated.
     * @return
     */
    public static long gcd(long number1, long ... numbers) {
    	if(numbers == null){
    		return number1;
    	}
    	
    	int length = numbers.length;
    	long gcd = number1;
    	
    	for(int i =0;i<length;i++){
    		gcd = gcd(gcd, numbers[i]);
    	}
    	return gcd;
    }
    

    public static long gcd(long number1, long number2) {
    	while (number2 != 0) {
    		long temp = number1 % number2;
    		number1 = number2;
    		number2 = temp;
    	}
    	return Math.abs(number1);
    }
    

    /**
     * <pre>
     * Rounds a number down to the nearest integer.
     * </pre>
     * @param number
     * @return
     */
    public static BigInteger INT(final double number ) {
    	return BigInteger.valueOf((long)number);
    }
    
    /**
     * <pre>
     * Rounds a number down to the nearest integer.
     * </pre>
     * @param number
     * @return
     */
    public static BigDecimal INT(final BigDecimal number ) {
    	return number.setScale( 0, RoundingMode.FLOOR );
    }
    
    /**
     * <pre>
     * Returns the least common multiple of integers. 
     * The least common multiple is the smallest positive integer that is a multiple of all integer arguments number1, number2. 
     * Use LCM to add fractions with different denominators.
     * </pre>
     * @param number1
     * @param number2
     * @return
     */
    public static long lcm(final long number1, final long number2) {
    	if(number1 == number2){
    		return number1;
    	}
    	
        return number1 * (number2 / gcd(number1, number2));
    }


    /**
     * <pre>
     * Returns the least common multiple of integers. 
     * The least common multiple is the smallest positive integer that is a multiple of all integer arguments number1, number2, and so on. 
     * Use LCM to add fractions with different denominators.
     * </pre>
     * @param number1
     * @param numbers
     * @return
     */
    public static long lcm(final long number1, final long ... numbers) {
		long result = numbers[0];
		
		for (int i = 0; i < numbers.length; i++)
			result = lcm(result, numbers[i]);
		return result;
	}
    
    /**
     * <pre>
     * Returns the natural logarithm of a number. 
     * Natural logarithms are based on the constant e (2.71828182845904).
     * </pre>
     * @param number The positive real number for which you want the natural logarithm.
     * @return
     */
	public static double ln(final double number) {
		return Math.log(number);
	}

	public static BigDecimal ln(final BigDecimal number) {
		return decimal( Math.log(number.doubleValue()) );
	}
	

	/**
	 * <pre>
	 * Returns the logarithm of a number to the base you specify.
	 * </pre>
	 * @param number The positive real number for which you want the logarithm.
	 * @param base The base of the logarithm. 
	 * @return
	 */
	public static double log(final double number, final double base) {
		return Math.log( number ) / Math.log( base );
	}
	
	/**
	 * <pre>
	 * Returns the logarithm of a number to the base you specify.
	 * </pre>
	 * @param number The positive real number for which you want the logarithm.
	 * @param base The base of the logarithm. 
	 * @return
	 */
	public static BigDecimal log(final BigDecimal number,final BigDecimal base) {
		return decimal( log(number.doubleValue(), base.doubleValue()) );
	}
	
	/**
	 * <pre>
	 * Returns the logarithm of a number to 10.
	 * </pre>
	 * @param number The positive real number for which you want the logarithm.
	 * @return
	 */
	public static double log(final double number) {
		return Math.log( number ) / Math.log( 10 );
	}

	/**
	 * <pre>
	 * Returns the logarithm of a number to 10.
	 * </pre>
	 * @param number The positive real number for which you want the logarithm.
	 * @return
	 */
	public static BigDecimal log(final BigDecimal number) {
		return decimal( log(number.doubleValue() ) );
	}
	
	

	/**
	 * <pre>
	 * Returns the base-10 logarithm of a number.
	 * </pre>
	 * @param number The positive real number for which you want the base-10 logarithm.
	 * @return
	 */
	public static double log10(final double number) {
		return Math.log10( number );
	}

	/**
	 * <pre>
	 * Returns the base-10 logarithm of a number.
	 * </pre>
	 * @param number The positive real number for which you want the base-10 logarithm.
	 * @return
	 */
	public static BigDecimal log10(final BigDecimal number) {
		return decimal( Math.log10( number.doubleValue() ) );
	}
	
	/**
	 * <pre>
	 * Returns the matrix determinant of an array.
	 * </pre>
	 * @param squareMatrix  A numeric array with an equal number of rows and columns.
	 * @param sideLength
	 * @return
	 */
	public static double mdeterm(double[] squareMatrix, int sideLength) {
		final DoubleFactory2D factory2D = DoubleFactory2D.dense;
		final DoubleMatrix2D matrix2D = factory2D.make(squareMatrix, sideLength);
		return Algebra.DEFAULT.det(matrix2D);
	}
	
	/**
	 * <pre>
	 * Returns the matrix determinant of an array.
	 * </pre>
	 * @param squareMatrix  A numeric array with an equal number of rows and columns.
	 * @param sideLength
	 * @return
	 */
	public static BigDecimal mdeterm(BigDecimal[] squareMatrix, int sideLength) {
		double ret = mdeterm(toDoubleArray(squareMatrix) , sideLength);
		return decimal(ret);
	}

	/**
	 * TODO NOT Implemented.
	 * <pre>
	 * Returns the inverse matrix for the matrix stored in an array.
	 * 
	 * Array can be given as a cell range, 
	 * such as A1:C3; as an array constant, such as {1,2,3;4,5,6;7,8,9}; or as a name for either of these.
	 * </pre>
	 * @param squareMatrix A numeric array with an equal number of rows and columns.
	 * @param sideLength
	 * @return
	 */
	public static double minverse(double[] squareMatrix, int sideLength) {
		throw new FunctionNotImplementedException("MINVERSE is not implemented.");
	}

	/**
	 * TODO NOT Implemented.
	 * <pre>
	 * Returns the matrix product of two arrays. 
	 * The result is an array with the same number of rows as squareMatrix1 and the same number of columns as squareMatrix2.
	 * </pre>
	 * @param squareMatrix1  The arrays you want to multiply.
	 * @param squareMatrix2  The arrays you want to multiply.
	 * @param sideLength
	 * @return
	 */
	public static double mmult(double[] squareMatrix1,double[] squareMatrix2, int sideLength) {
		throw new FunctionNotImplementedException("MMULT is not implemented.");
	}
	
	

	/**
	 * <pre>
	 * Returns the remainder after number is divided by divisor. The result has the same sign as divisor.
	 * </pre>
	 * @param number The number for which you want to find the remainder.
	 * @param divisor The number by which you want to divide number.
	 * @return
	 */
	public static double mod(double number, double divisor) {
		final double remainder = number % divisor;

		if (remainder != 0 && Math.signum(remainder) != Math.signum(divisor)) {
			return remainder + divisor;
		} else {
			return remainder;
		}
	}
	

	/**
	 * <pre>
	 * Returns the remainder after number is divided by divisor. The result has the same sign as divisor.
	 * </pre>
	 * @param number The number for which you want to find the remainder.
	 * @param divisor The number by which you want to divide number.
	 * @return
	 */
	public static BigDecimal mod(BigDecimal number, BigDecimal divisor) {
		final BigDecimal remainder = number.remainder(divisor);
		if (remainder.signum() != 0 && remainder.signum() != divisor.signum()) {
			return remainder.add(divisor);
		} else {
			return remainder;
		}
	}
	

	/**
	 * TODO NOT Implemented.
	 * <pre>
	 * Returns a number rounded to the desired multiple.
	 * </pre>
	 * @param number The value to round.
	 * @param multiple The multiple to which you want to round number.
	 * @return
	 */
	public static double mround(double number, double multiple) {
		throw new FunctionNotImplementedException("MROUND is not implemented.");
	}
	

	/**
	 * TODO NOT Implemented.
	 * <pre>
	 * Returns the ratio of the factorial of a sum of values to the product of factorials.
	 * </pre>
	 * @param number1 1 to 255 values for which you want the multinomial.
	 * @param numbers 1 to 255 values for which you want the multinomial.
	 * @return
	 */
	public static double multinominal(double number1, double ... numbers) {
		throw new FunctionNotImplementedException("MROUND is not implemented.");
	}
	

	/**
	 * <pre>
	 * Returns number rounded up to the nearest odd integer.
	 * </pre>
	 * @param number The value to round.
	 * @return
	 */
	public static double odd(double number) {
		if (0 > number) {
			return Math.floor((number - 1) / 2) * 2 + 1;
		} else {
			return Math.ceil((number + 1) / 2) * 2 - 1;
		}
	}
	
	/**
	 * <pre>
	 * Returns number rounded up to the nearest odd integer.
	 * </pre>
	 * @param number The value to round.
	 * @return
	 */
	public static BigDecimal fun_ODD(BigDecimal number) {
		switch (number.signum()) {
		case -1:
			return number.subtract(ONE).divide(TWO, 0, RoundingMode.UP).multiply(TWO).add(ONE);
		case 1:
			return number.add(ONE).divide(TWO, 0, RoundingMode.UP).multiply(TWO).subtract(ONE);
		default: 
			return ONE;
		}
	}
	

	/**
	 * <pre>
	 * Returns the value of pi
	 * </pre>
	 * @return
	 */
	public static BigDecimal pi() {
		return PI;
	}
	

	/**
	 * <pre>
	 * Returns the result of a number raised to a power.
	 * </pre>
	 * @param number The base number. It can be any real number.
	 * @param power The exponent to which the base number is raised.
	 * @return
	 */
	public static double power(double number, double power) {
		return Math.pow(number, power);
	}

	/**
	 * <pre>
	 * Returns the result of a number raised to a power.
	 * </pre>
	 * @param number The base number. It can be any real number.
	 * @param power The exponent to which the base number is raised.
	 * @return
	 */
	public static BigDecimal power(BigDecimal number, BigDecimal power, MathContext mc) {
		BigDecimal normalized = power.stripTrailingZeros();
		
		if (normalized.scale() <= 0) {
			int p = normalized.intValueExact();
			if (p >= 0 && p <= 999999999) {
				return number.pow( p, mc );
			}
		}
		
		return decimal( Math.pow( number.doubleValue(), power.doubleValue() ) );
	}
	

	/**
	 * <pre>
	 * Multiplies all the numbers given as arguments and returns the product. 
	 * For example, PRODUCT(A1, A2, A3, A4) to multiply those 4 numbers together. 
	 * </pre>
	 * @param numbers more than one numbers you want to multiply, up to a maximum of 255 arguments.
	 * @return
	 */
	public static double product(double ... numbers) {
		if(numbers == null){
			throw new FormulaException("PRODUCT function needs more than one args.");
		}
		if(numbers.length == 1){
			return numbers[0];
		}
		
		double ret = 1;
		for( int i = 0; i<numbers.length;i++){
			ret = ret * numbers[i];
		}
		
		return ret;
	}
	
	
	/**
	 * <pre>
	 * Multiplies all the numbers given as arguments and returns the product. 
	 * For example, PRODUCT(A1, A2, A3, A4) to multiply those 4 numbers together. 
	 * </pre>
	 * @param numbers more than one numbers you want to multiply, up to a maximum of 255 arguments.
	 * @return
	 */
	public static BigDecimal product(MathContext mc , BigDecimal ... numbers) {
		if(numbers == null){
			throw new FormulaException("PRODUCT function needs more than one args.");
		}
		if(numbers.length == 1){
			return numbers[0];
		}
		
		BigDecimal ret = ONE;
		for( int i = 0; i<numbers.length;i++){
			ret = ret.multiply(numbers[i], mc);
		}
		
		return ret;
	}
	

	/**
	 * <pre>
	 * Returns the integer portion of a division. 
	 * Use this function when you want to discard the remainder of a division.
	 * </pre>
	 * @param numerator The dividend. 
	 * @param denominator The divisor.
	 * @return
	 */
	public static long quotient(double numerator, double denominator) {
		return (long)(numerator / denominator);
	}
	
	/**
	 * <pre>
	 * Returns the integer portion of a division. 
	 * Use this function when you want to discard the remainder of a division.
	 * </pre>
	 * @param numerator The dividend. 
	 * @param denominator The divisor.
	 * @return
	 */
	public static BigDecimal quotient(BigDecimal numerator, BigDecimal denominator) {
		return numerator.divide(denominator, 0, RoundingMode.DOWN);
	}

	/**
	 * <pre>
	 * Converts degrees to radians.
	 * </pre>
	 * @param angle An angle in degrees that you want to convert.
	 * @return converted degrees
	 * @see #degree(double)
	 */
	public static double radians(double angle) {
		return (angle * Math.PI) / 180;
	}
	
	
	/**
	 * <pre>
	 * Converts degrees to radians.
	 * </pre>
	 * @param angle An angle in degrees that you want to convert.
	 * @param mc 
	 * @return converted degrees
	 * @see #degree(BigDecimal, MathContext)
	 */
	public static BigDecimal radians(BigDecimal angle, MathContext mc) {
		final BigDecimal ret = angle.multiply(PI, mc);
		return ret.divide(BigDecimal.valueOf(180), mc);
	}
	

	/**
	 * <pre>
	 * Returns an evenly distributed random real number greater than or equal to 0 and less than 1. 
	 * A new random real number is returned every time the worksheet is calculated.
	 * </pre>
	 * @return a random number between 0 and 1
	 */
	public static double rand() {
		return RANDOM.nextDouble();
	}
	

	/**
	 * <pre>
	 * Returns a random integer number between the numbers you specify. 
	 * </pre>
	 * @param bottom The smallest integer RANDBETWEEN will return.
	 * @param top The largest integer RANDBETWEEN will return.
	 * @return
	 */
	public static int randbetween(int bottom, int top) {
		return bottom + (int)(Math.random() * top); 
	}
	
	/*

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
