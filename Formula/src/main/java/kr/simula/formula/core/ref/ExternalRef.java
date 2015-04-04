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
package kr.simula.formula.core.ref;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.QName;
import kr.simula.formula.core.builder.BuildException;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class ExternalRef<T> extends GenericRef implements Gettable<T> {

	private Class<T> type;
	
	/**
	 * @param qname
	 */
	public ExternalRef(QName qname) {
		super(qname);
	}

	@Override
	public Class<? extends T> type() {
		return type;
	}

	public void setRequiredType(Class<T> requiredType) {
		if((this.type != null) && (requiredType.isAssignableFrom( this.type) )){
			throw new BuildException("Ambiguous Ref type:" + this.type + "<>" + requiredType );
		}
		this.type = requiredType;
	}
	
}
