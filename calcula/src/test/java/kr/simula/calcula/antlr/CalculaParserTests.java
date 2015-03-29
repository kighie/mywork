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
package kr.simula.calcula.antlr;


/**
 * @author kighie@gmail.com
 *
 */
public class CalculaParserTests {

	static final String FormulaExpression1 = "=(1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth())";
	static final String OperatorExpression1 = "1+3 * 4 + 15 / (fn4(1,2,3) + fn2() ) * aa.bb.meth()";
	
}
