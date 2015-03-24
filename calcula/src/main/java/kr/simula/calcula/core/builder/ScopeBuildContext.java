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
package kr.simula.calcula.core.builder;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import kr.simula.calcula.CalculaException;
import kr.simula.calcula.core.QName;
import kr.simula.calcula.core.Ref;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since	1.0
 */
public class ScopeBuildContext implements BuildContext {
	private BuildContext parent;
	
	private Map<String, Ref> variableMap = new HashMap<String, Ref>();
	
	public ScopeBuildContext(BuildContext parent) {
		this.parent = parent;
	}

	/**
	 * @return the parent
	 */
	public BuildContext getParent() {
		return parent;
	}
	
	/**
	 * if typeChecked is false, variable type will not be checked in compile time.  
	 * @return typeChecked
	 */
	public boolean isTypeChecked() {
		return parent.isTypeChecked();
	}
	
	public void registerVariable(String name, Ref ref){
		variableMap.put(name, ref);
	}
	
	public Ref getVariable(String name){
		Ref ref = variableMap.get(name);
		if(ref == null){
			if( parent != null ){
				ref = parent.getVariable(name);
			}
		}
		
		return ref;
	}

	public Iterable<Entry<String, Ref>> variables() {
		return variableMap.entrySet();
	}

	public QName getQName(String name){
		return parent.getQName(name);
	}

	public void registerQName(String name, QName qname){
		parent.registerQName(name,qname);
	}
	
	public Ref getRef(QName qname){
		return parent.getRef(qname);
	}

	public Iterable<Entry<QName, Ref>> references() {
		return parent.references();
	}

	public void registerRef(QName qname, Ref ref){
		parent.registerRef(qname, ref);
	}
	
	public void registerConstant(String name, Ref ref){
		throw new CalculaException("Declaring constant is no allowed. ");
	}
	
	public Ref getConstant(String name) {
		return parent.getConstant(name);
	}
	
	
}
