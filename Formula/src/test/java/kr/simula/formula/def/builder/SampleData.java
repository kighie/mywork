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

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class SampleData {
	private static final MathContext MC = new MathContext(10);
	
	private BigDecimal numA;
	private Integer numB;
	private Boolean boolC;
	private Double numD;
	private String textE;
	private int numF;
	
	/**
	 * @return the numA
	 */
	public BigDecimal getNumA() {
		return numA;
	}
	/**
	 * @param numA the numA to set
	 */
	public void setNumA(BigDecimal numA) {
		this.numA = numA;
	}
	/**
	 * @return the numB
	 */
	public Integer getNumB() {
		return numB;
	}
	/**
	 * @param numB the numB to set
	 */
	public void setNumB(Integer numB) {
		this.numB = numB;
	}
	/**
	 * @return the boolC
	 */
	public Boolean getBoolC() {
		return boolC;
	}
	/**
	 * @param boolC the boolC to set
	 */
	public void setBoolC(Boolean boolC) {
		this.boolC = boolC;
	}
	/**
	 * @return the numD
	 */
	public Double getNumD() {
		return numD;
	}
	/**
	 * @param numD the numD to set
	 */
	public void setNumD(Double numD) {
		this.numD = numD;
	}
	/**
	 * @return the textE
	 */
	public String getTextE() {
		return textE;
	}
	/**
	 * @param textE the textE to set
	 */
	public void setTextE(String textE) {
		this.textE = textE;
	}
	/**
	 * @return the numF
	 */
	public int getNumF() {
		return numF;
	}
	/**
	 * @param numF the numF to set
	 */
	public void setNumF(int numF) {
		this.numF = numF;
	}

	public BigDecimal addAB(){
		return numA.add(new BigDecimal(numB));
	}
	
	public BigDecimal divideAB(){
		return numA.divide(new BigDecimal(numB), MC);
	}
}
