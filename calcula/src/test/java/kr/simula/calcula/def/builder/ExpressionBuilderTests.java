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

import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;

import org.junit.Assert;
import org.junit.Test;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class ExpressionBuilderTests {

	static final String FormulaExpression1 = "=(1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth())";
	static final String OperatorExpression1 = "1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth()";
	

	protected ExpressionBuilder builder = new ExpressionBuilder();
	
	protected void testExpression(String expr, Object expected){
		Node exprNode = builder.buildExpression(expr);
		System.out.println();
		System.out.println(exprNode.getExpression());
		System.out.println(exprNode);
		
		Gettable<?> gettable = (Gettable<?>)exprNode;
		
		Object result = gettable.get(null);
		System.out.println(result);
		
		Assert.assertEquals(expected, result);
	}
	
	
	@Test
	public void buildLiteralNumeric(){
		testExpression("=1+3 * (4 + 15) - 31.5 / 10", new BigDecimal("54.85"));
		testExpression("=(1+3 * 4 + 15 - 30 / 10)", new BigDecimal(25));
		testExpression("=(1+3 * 4 + 15 - 30 % 10)", new BigDecimal(28));
		
		testExpression("=(5 * -3 + 7)", new BigDecimal(-8));
	}

	@Test
	public void buildLiteralCompare(){
		testExpression("=(1+3 * 4 + 15 - 30 / 10)=25", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)>10", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)>=10", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<=75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)<>75", true);
		testExpression("=(1+3 * 4 + 15 - 30 / 10)!=75", true);
	}
	
	@Test
	public void buildLiteralLogical(){
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) AND (100/2 = 50)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) AND (100/2 = 30)", false);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) OR (100/2 = 30)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=30 ) OR (100/2 = 30)", false);
		

		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) AND not(100/2 = 30)", true);
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=30 ) OR not(100/2 = 30)", true);
	}

	@Test
	public void buildLiteralString(){
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) & \" : ddd\"", "true : ddd");
		testExpression("=(1+3 * 4 + 15 - 30 / 10) & \" : aaa\"", "25 : aaa");
		testExpression("=( (1+3 * 4 + 15 - 30 / 10)=25 ) & ' : ABC'", "true : ABC");
		testExpression("=(1+3 * 4 + 15 - 30 / 10) & ' : ABC'", "25 : ABC");
		
		testExpression("=\"ddd:\" & ( (1+3 * 4 + 15 - 30 / 10)=25 ) ", "ddd:true");
		testExpression("=\"aaa:\" & (1+3 * 4 + 15 - 30 / 10)" , "aaa:25");
	}
}
