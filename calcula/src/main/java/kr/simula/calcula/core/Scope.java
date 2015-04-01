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
package kr.simula.calcula.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


/**
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 19.
 * @since	1.0
 */
public class Scope implements Context {
	private Context parent;
	private Map<String, Object> variables = new HashMap<String, Object>();
	
	public Scope(Context parent) {
		this.parent = parent;
	}

	/**
	 * @return the parent
	 */
	public Context getParent() {
		return parent;
	}
	
	/**
	 * parent's setAttribute
	 */
	public void setAttribute(String name, Object value) {
		parent.setAttribute(name, value);
	}

	/**
	 * parent's getAttribute
	 */
	public Object getAttribute(String name) {
		return parent.getAttribute(name);
	}

	/**
	 * @see net.kighie.dsl.core.Context#getReference(net.kighie.dsl.core.QName)
	 */
	public Object getReference(String path) {
		return parent.getReference(path);
	}

	public void setReference(String name, Object ref) {
		parent.setReference(name, ref);
	}
	
	/**
	 * @see net.kighie.dsl.core.Context#getVariable(java.lang.String)
	 */
	public Object getVariable(String name) {
		Object value = variables.get(name);
		if(value == null){
			value = parent.getVariable(name);
		}
		return value;
	}

	public void setVariable(String name, Object value) {
		variables.put(name, value);
	}

	public Iterable<Entry<String, Object>> attributes() {
		return parent.attributes();
	}

	/**
	 * variables  entrySet 
	 */
	public Iterable<Entry<String, Object>> variables() {
		return variables.entrySet();
	}

	public Iterable<Entry<String, Object>> references() {
		return parent.references();
	}

//	public Object getInput(String name) {
//		return parent.getInput(name);
//	}
//
//	public void setOutput(String name, Object value) {
//		parent.setOutput(name, value);
//	}
//
//	public Iterable<Entry<String, Object>> inputs() {
//		return parent.inputs();
//	}
//
//	public Iterable<Entry<String, Object>> outputs() {
//		return parent.outputs();
//	}

}
