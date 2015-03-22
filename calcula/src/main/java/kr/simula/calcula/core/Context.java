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
package kr.simula.calcula.core;

import java.util.Map.Entry;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since 1.0
 */
public interface Context {

	void setAttribute(String name, Object value);

	Object getAttribute(String name);

	

	Object getVariable(String name);
	
	void setVariable(String name, Object value);
	
	Iterable<Entry<String, Object>> attributes();

	Iterable<Entry<String, Object>> variables();

//	Object getInput(String name);
//	void setOutput(String name, Object value);
//	
//	Iterable<Entry<String, Object>> inputs();
//	Iterable<Entry<String, Object>> outputs();
	
	Object getReference(String name);
	
	void setReference(String name, Object ref);
	
	Iterable<Entry<String, Object>> references();
}
