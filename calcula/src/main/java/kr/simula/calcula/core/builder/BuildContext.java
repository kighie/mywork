package kr.simula.calcula.core.builder;
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


import java.util.Map.Entry;

import kr.simula.calcula.core.QName;
import kr.simula.calcula.core.Ref;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since	1.0
 */
public interface BuildContext {
	
	BuildContext getParent() ;
	
	/**
	 * if typeChecked is false, variable type will not be checked in compile time.  
	 * @return typeChecked
	 */
	boolean isTypeChecked() ;
	
	void registerVariable(String name, Ref ref);
	
	Ref getVariable(String name);

	Iterable<Entry<String, Ref>> variables();
	
	QName getQName(String name);

	void registerQName(String name, QName qname);
	
	Ref getRef(QName qname);

	Iterable<Entry<QName, Ref>> references();

	void registerRef(QName qname, Ref ref);
	
	void registerConstant(String name, Ref ref);
	
	Ref getConstant(String name);
	
	
}