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
package kr.simula.formula.def;

/**
 * @author kighie@gmail.com
 *
 */
public interface ExprTokens {

	String LIT_NUMBER 		= "LIT_NUMBER";
	String LIT_BOOLEAN 		= "LIT_BOOLEAN";
	String LIT_DATE 		= "LIT_DATE";
	String LIT_STRING 		= "LIT_STRING";
	String OP_NUM_NEGATION 	= "OP_NUM_NEGATION";
	String OP_MINUS 		= "OP_MINUS";
	String OP_PLUS 			= "OP_PLUS";
	String OP_MULTI 		= "OP_MULTI";
	String OP_DIVIDE 		= "OP_DIVIDE";
	String OP_MOD 			= "OP_MOD";
	String OP_NOT	 		= "OP_NOT";
	String OP_AND	 		= "OP_AND";
	String OP_OR	 		= "OP_OR";
	String OP_CONCAT 		= "OP_CONCAT";
	String OP_EQ	 		= "OP_EQ";
	String OP_NOT_EQ		= "OP_NOT_EQ";
	String OP_EQ_LT 		= "OP_EQ_LT";
	String OP_EQ_GT	 		= "OP_EQ_GT";
	String OP_LT 			= "OP_LT";
	String OP_GT	 		= "OP_GT";
	String IDENT 			= "IDENT";
	String REF				= "REF";
	String METHOD_CALL		= "METHOD_CALL";
	String FUNC_CALL		= "FUNC_CALL";
	

}
