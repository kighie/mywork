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
package kr.simula.formula.core;

import java.io.Serializable;




/**
 * 
 * @author IkChan Kwon
 * @since	1.0
 */
public interface Operator<T> extends Serializable {
	
	public interface Unary<T, OP> extends Operator<T> {
		T eval(OP val);
	}
	
	public interface Binary<T, OP1, OP2> extends Operator<T> {
		T eval(OP1 val1, OP2 val2);
	}
}
