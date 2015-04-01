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
package kr.simula.calcula;

import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.def.builder.ExpressionBuilder;

import org.junit.Assert;
import org.junit.BeforeClass;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class ExpressionTests {
	protected static ExpressionBuilder builder;
	
	@BeforeClass
	public static void setUp(){
		builder = new ExpressionBuilder();
	}

	protected Node buildExpression(String expr){
		Node exprNode = builder.buildExpression(expr);
		return exprNode;
	}

	protected void testExpression(String expr, Object expected){
		testExpression(expr, null, expected);
	}
	
	protected void testExpression(String expr, Context context, Object expected){
		Node exprNode = builder.buildExpression(expr);
		System.out.println();
		System.out.println(exprNode.getExpression());
		System.out.println(exprNode);
		
		Gettable<?> gettable = (Gettable<?>)exprNode;
		
		Object result = gettable.get(context);
		System.out.println(result);
		
		Assert.assertEquals(expected, result);
	}
}
