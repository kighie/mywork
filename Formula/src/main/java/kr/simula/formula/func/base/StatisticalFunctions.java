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


/**
 * @author kighie@gmail.com
 *
 */
public final class StatisticalFunctions extends FunctionBase {

	private StatisticalFunctions() {}
	
	/**
	 * Returns the average of the absolute deviations of data points from their mean
	 * @param numbers
	 * @return
	 */
	public static final Number AVEDEV(Number ... numbers){
		return null;
	}

	/**
	 * Returns the average of its arguments
	 * @param numbers
	 * @return
	 */
	public static final Number AVERAGE(Number ... numbers){
		int len = numbers!= null ? numbers.length : 0;
		if(len == 1){
			return new BigDecimal(numbers[0].toString());
		} else if(len>0){
			BigDecimal sum = BigDecimal.ZERO;
			for(Number n : numbers){
				sum = sum.add(new BigDecimal(n.toString()));
			}
			return sum.divide(BigDecimal.valueOf(len));
		} else {
			return BigDecimal.ZERO;
		}
	}
/*





AVERAGEA

Returns the average of its arguments, including numbers, text, and logical values

AVERAGEIF

Returns the average (arithmetic mean) of all the cells in a range that meet a given criteria

AVERAGEIFS

Returns the average (arithmetic mean) of all cells that meet multiple criteria.

BETADIST

Returns the beta cumulative distribution function

BETAINV

Returns the inverse of the cumulative distribution function for a specified beta distribution

BINOMDIST

Returns the individual term binomial distribution probability

CHIDIST

Returns the one-tailed probability of the chi-squared distribution

CHIINV

Returns the inverse of the one-tailed probability of the chi-squared distribution

CHITEST

Returns the test for independence

CONFIDENCE

Returns the confidence interval for a population mean

CORREL

Returns the correlation coefficient between two data sets

COUNT

Counts how many numbers are in the list of arguments

COUNTA

Counts how many values are in the list of arguments

COUNTBLANK

Counts the number of blank cells within a range

COUNTIF

Counts the number of cells within a range that meet the given criteria

COUNTIFS

Counts the number of cells within a range that meet multiple criteria

COVAR

Returns covariance, the average of the products of paired deviations

CRITBINOM

Returns the smallest value for which the cumulative binomial distribution is less than or equal to a criterion value

DEVSQ

Returns the sum of squares of deviations

EXPONDIST

Returns the exponential distribution

FDIST

Returns the F probability distribution

FINV

Returns the inverse of the F probability distribution

FISHER

Returns the Fisher transformation

FISHERINV

Returns the inverse of the Fisher transformation

FORECAST

Returns a value along a linear trend

FREQUENCY

Returns a frequency distribution as a vertical array

FTEST

Returns the result of an F-test

GAMMADIST

Returns the gamma distribution

GAMMAINV

Returns the inverse of the gamma cumulative distribution

GAMMALN

Returns the natural logarithm of the gamma function, Γ(x)

GEOMEAN

Returns the geometric mean

GROWTH

Returns values along an exponential trend

HARMEAN

Returns the harmonic mean

HYPGEOMDIST

Returns the hypergeometric distribution

INTERCEPT

Returns the intercept of the linear regression line

KURT

Returns the kurtosis of a data set

LARGE

Returns the k-th largest value in a data set

LINEST

Returns the parameters of a linear trend

LOGEST

Returns the parameters of an exponential trend

LOGINV

Returns the inverse of the lognormal distribution

LOGNORMDIST

Returns the cumulative lognormal distribution

MAX

Returns the maximum value in a list of arguments

MAXA

Returns the maximum value in a list of arguments, including numbers, text, and logical values

MEDIAN

Returns the median of the given numbers

MIN

Returns the minimum value in a list of arguments

MINA

Returns the smallest value in a list of arguments, including numbers, text, and logical values

MODE

Returns the most common value in a data set

NEGBINOMDIST

Returns the negative binomial distribution

NORMDIST

Returns the normal cumulative distribution

NORMINV

Returns the inverse of the normal cumulative distribution

NORMSDIST

Returns the standard normal cumulative distribution

NORMSINV

Returns the inverse of the standard normal cumulative distribution

PEARSON

Returns the Pearson product moment correlation coefficient

PERCENTILE

Returns the k-th percentile of values in a range

PERCENTRANK

Returns the percentage rank of a value in a data set

PERMUT

Returns the number of permutations for a given number of objects

POISSON

Returns the Poisson distribution

PROB

Returns the probability that values in a range are between two limits

QUARTILE

Returns the quartile of a data set

RANK

Returns the rank of a number in a list of numbers

RSQ

Returns the square of the Pearson product moment correlation coefficient

SKEW

Returns the skewness of a distribution

SLOPE

Returns the slope of the linear regression line

SMALL

Returns the k-th smallest value in a data set

STANDARDIZE

Returns a normalized value

STDEV

Estimates standard deviation based on a sample

STDEVA

Estimates standard deviation based on a sample, including numbers, text, and logical values

STDEVP

Calculates standard deviation based on the entire population

STDEVPA

Calculates standard deviation based on the entire population, including numbers, text, and logical values

STEYX

Returns the standard error of the predicted y-value for each x in the regression

TDIST

Returns the Student's t-distribution

TINV

Returns the inverse of the Student's t-distribution

TREND

Returns values along a linear trend

TRIMMEAN

Returns the mean of the interior of a data set

TTEST

Returns the probability associated with a Student's t-test

VAR

Estimates variance based on a sample

VARA

Estimates variance based on a sample, including numbers, text, and logical values

VARP

Calculates variance based on the entire population

VARPA

Calculates variance based on the entire population, including numbers, text, and logical values

WEIBULL

Returns the Weibull distribution

ZTEST

Returns the one-tailed probability-value of a z-test
*/
}
