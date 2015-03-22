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

import java.io.Serializable;

/**
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since	1.0
 */
public class TypeMeta implements Serializable {
	private static final long serialVersionUID = -2292759429225873687L;
	
	private static class UnknownType  implements Serializable {
		private static final long serialVersionUID = -5827833621775110569L;
	}
	
	/**
	 * Unspecified Object type 
	 */
	public static final TypeMeta UNKNOWN_TYPE = new TypeMeta(UnknownType.class) {
		private static final long serialVersionUID = -5827833621775110569L;
		public String toString() {
			return "?";
		};
	};
	
	
	private Class<?> type;
	private int precisionOrSize;
	private int scale;
	
	public TypeMeta(Class<?> type, int precisionOrSize, int scale) {
		this.type = type;
		this.precisionOrSize = precisionOrSize;
		this.scale = scale;
	}

	public TypeMeta(Class<?> type, int precisionOrSize ) {
		this(type,precisionOrSize,0);
	}

	public TypeMeta(Class<?> type) {
		this(type,-1,0);
	}

	public Class<?> type() {
		return type;
	}

	public int getPrecisionOrSize() {
		return precisionOrSize;
	}

	public int getScale() {
		return scale;
	}
	
	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append(type.getName());
		
		if(precisionOrSize > -1){
			buf.append("(").append(precisionOrSize);
			
			if(scale > 0){
				buf.append(",").append(scale);
			}
			buf.append(")");
		}
		
		return buf.toString();
	}
}
