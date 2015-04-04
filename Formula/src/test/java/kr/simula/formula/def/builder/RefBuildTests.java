/* 
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

import kr.simula.formula.ExpressionTests;
import kr.simula.formula.core.RootContext;

import org.junit.Test;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class RefBuildTests extends ExpressionTests {

	@Test
	public void basic(){
		RootContext context = new RootContext();
		context.setParameter("A1", new BigDecimal(30));
		
		testExpression("=A1", context, new BigDecimal("30"));
	}

	/**
	 * <pre>
	 * 30	0.12	-17	-1.3	=A1/ABS(B1 + C1/5)*D1 + 3
	 * 
	 * -8.890243902
	 * </pre>
	 */
	@Test
	public void formula(){
		RootContext context = new RootContext();
		context.setParameter("A1", new BigDecimal(30));
		context.setParameter("B1", new BigDecimal("0.12"));
		context.setParameter("C1", new BigDecimal("-17"));
		context.setParameter("D1", new BigDecimal("-1.3"));
		
		testExpression("=A1/ABS(B1 + C1/5)*D1 + 3", context, new BigDecimal("-8.8902439019"));
	}


	@Test
	public void objectRef(){
		RootContext context = new RootContext();
		
		SampleData data = new SampleData();
		data.setBoolC(true);
		data.setNumA(new BigDecimal(10));
		data.setNumB(34);
		data.setNumD(-4.7);
		data.setNumF(9);
		data.setTextE("text value...");
		context.setParameter("data", data);

//		System.out.println(new BigDecimal(100.0D).equals(new BigDecimal("100")));;
		testExpression("=data.textE", context, "text value...");
		
		testExpression("=data.numA + data.numB + data.numD + data.numF", context, new BigDecimal("48.3"));
		
//		BigDecimal result = (BigDecimal)eval("=data.numA + data.numB + data.numD * 10 + data.numF", context);
//		if( !result.equals(new BigDecimal("100.0"))){
//			System.err.println(result + "<> 100" );
//		}
		testExpression("=data.numA + data.numB + data.numD * 10 + data.numF", context, new BigDecimal("6.0"));
		
		
		testExpression("=data.numA/ABS(data.numB + data.numD/5)*data.numF + 3", context, new BigDecimal("5.7223230492"));
	}


	@Test
	public void methodRef(){
		RootContext context = new RootContext();
		
		SampleData data = new SampleData();
		data.setBoolC(true);
		data.setNumA(new BigDecimal(10));
		data.setNumB(34);
		data.setNumD(-4.7);
		data.setNumF(9);
		data.setTextE("text value...");
		
		context.setParameter("data", data);
		
		
		
		testExpression("=data.textE & (data.addAB()/data.numD)", context, "text value...-9.361702128");
	}
}
