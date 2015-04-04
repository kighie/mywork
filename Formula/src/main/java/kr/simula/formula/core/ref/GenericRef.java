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

import kr.simula.formula.core.QName;
import kr.simula.formula.core.Ref;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public abstract class GenericRef implements Ref{

	protected final QName qname;
	
	
	/**
	 * @param qname
	 */
	public GenericRef(QName qname) {
		this.qname = qname;
	}

	/**
	 * @return {@link ValueType#UNKNOWN}
	 */
	@Override
	public ValueType valueType() {
		return ValueType.UNKNOWN;
	}

	@Override
	public String getExpression() {
		return qname.toString();
	}

	@Override
	public QName qualifiedName() {
		return qname;
	}
	
	@Override
	public String toString() {
		return "{ref:" + getExpression() + "}";
	}

}
