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
package kr.simula.calcula.core.factory;

import kr.simula.calcula.core.QName;
import kr.simula.calcula.core.Ref;

/**
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 19.
 * @since	1.0
 */
public abstract class AbstractRef implements Ref {
	private static final long serialVersionUID = 1L;
	
	private QName qname;
	private TypeMeta typeMeta;
	
	public AbstractRef(QName qname, TypeMeta typeMeta) {
		this.qname = qname;
		this.typeMeta = typeMeta;
	}

	/**
	 * @see kr.simula.calcula.core.Ref#qualifiedName()
	 */
	public QName qualifiedName() {
		return qname;
	}
	
	/**
	 * @return the typeMeta
	 */
	public TypeMeta getTypeMeta() {
		return typeMeta;
	}
	
	/**
	 * 
	 * @return typeMeta.type()
	 */
	public Class<?> type() {
		return typeMeta.type();
	}
	
}
