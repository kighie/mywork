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
package kr.simula.calcula.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import kr.simula.calcula.core.QName;
import kr.simula.calcula.core.Ref;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since	1.0
 */
public class RootBuildContext implements BuildContext {
	private boolean typeChecked = true;

	private Map<String, QName> qnameMap = new HashMap<String, QName>();
	private Map<QName, Ref> referenceMap = new HashMap<QName, Ref>();
	private Map<String, Ref> variableMap = new HashMap<String, Ref>();
	private Map<String, Ref> constMap = new HashMap<String, Ref>();
	
	/**
	 * @return the parent
	 */
	public BuildContext getParent() {
		return null;
	}
	
	/**
	 * if typeChecked is false, variable type will not be checked in compile time.  
	 * @return typeChecked
	 */
	public boolean isTypeChecked() {
		return typeChecked;
	}
	
	/**
	 * 
	 * @param typeChecked the typeChecked to set
	 */
	public void setTypeChecked(boolean typeChecked) {
		this.typeChecked = typeChecked;
	}
	
	public void registerVariable(String name, Ref ref){
		variableMap.put(name, ref);
	}
	
	public Ref getVariable(String name){
		Ref ref = variableMap.get(name);
		return ref;
	}

	public Iterable<Entry<String, Ref>> variables() {
		return variableMap.entrySet();
	}

	public QName getQName(String name){
		return qnameMap.get(name);
	}

	public void registerQName(String name, QName qname){
		qnameMap.put(name,qname);
	}
	
	public Ref getRef(QName qname){
		return referenceMap.get(qname);
	}

	public Iterable<Entry<QName, Ref>> references() {
		return referenceMap.entrySet();
	}

	public void registerRef(QName qname, Ref ref){
		referenceMap.put(qname, ref);
	}
	
	public void registerConstant(String name, Ref ref){
		constMap.put(name, ref);
		
	}
	
	public Ref getConstant(String name) {
		return constMap.get(name);
	}
	
	
}
