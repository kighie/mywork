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
 * @author kighie@gmail.com
 *
 */
public class DefaultContext implements Context {

	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Map<String, Object> refMap = new HashMap<String, Object>();
	private Map<String, Object> variables = new HashMap<String, Object>();

	
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	public Object getReference(QName qname) {
		return refMap.get(qname);
	}

	public Object getVariable(String name) {
		return variables.get(name);
	}

	public void setVariable(String name, Object value) {
		variables.put(name, value);
	}

	public Iterable<Entry<String, Object>> attributes() {
		return attributes.entrySet();
	}

	public Iterable<Entry<String, Object>> variables() {
		return variables.entrySet();
	}

	
	public Object getReference(String name) {
		return refMap.get(name);
	}
	

	public void setReference(String name, Object ref) {
		refMap.put(name, ref);
	}
	
	public Iterable<Entry<String, Object>> references() {
		return refMap.entrySet();
	}

	
}
