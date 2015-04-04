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
package kr.simula.formula.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * @author kighie@gmail.com
 *
 */
public class RootContext implements Context {

	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Map<QName, Object> refMap = new HashMap<QName, Object>();
//	private Map<QName, Object> variables = new HashMap<QName, Object>();

	
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	public Object getReference(QName qname) {
		Object value = refMap.get(qname);
//		if(value == null){
//			value = refMap.get(qname.toString());
//			refMap.put(qname, value);
//		}
//		System.out.println(qname + " = " + value);
//		if(value == null){
//			System.out.println(refMap);
//		}
		return value;
	}
	
	public Object getParameter(String name) {
		return refMap.get(new QName(name));
	}

	public void setReference(QName qname, Object value) {
		refMap.put(qname, value);
	}
	
	public void setParameter(String name, Object value) {
		refMap.put(new QName(name), value);
	}
	
	public Iterable<Entry<String, Object>> attributes() {
		return attributes.entrySet();
	}

	public Iterable<Entry<QName, Object>> references() {
		return refMap.entrySet();
	}

//	public Object getVariable(QName name) {
//		return variables.get(name);
//	}
//
//	public void setVariable(QName name, Object value) {
//		variables.put(name, value);
//	}
//
//	public Iterable<Entry<QName, Object>> variables() {
//		return variables.entrySet();
//	}

	
}
