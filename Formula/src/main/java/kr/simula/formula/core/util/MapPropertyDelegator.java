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
package kr.simula.formula.core.util;

import java.util.Map;

import kr.simula.formula.core.RtException;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class MapPropertyDelegator<T> implements PropertyDelegator<T> {

	private final String fieldName;
	private Class<T> type;
	
	
	

	/**
	 * @param fieldName
	 * @param type
	 * @param getter
	 * @param setter
	 */
	public MapPropertyDelegator(String fieldName) {
		super();
		this.fieldName = fieldName;
	}

	public Class<T> type(){
		return type;
	}
	
	public String getName(){
		return fieldName;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public T get(Object map){
		if(!(map instanceof Map)){
			throw new RtException("MapPropertyDelegator needs map.");
		}
		
		return (T)((Map)map).get(fieldName);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void set(Object map, Object value){
		if(!(map instanceof Map)){
			throw new RtException("MapPropertyDelegator needs map.");
		}
		((Map)map).put(fieldName, value);
	}
}
