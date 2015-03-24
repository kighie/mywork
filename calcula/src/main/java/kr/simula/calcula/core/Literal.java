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


/**
 * @author kighie@gmail.com
 *
 */
public class Literal<T> implements Node, Gettable<T>{
	
	private Class<T> type;
	private T value;
	private String nodeToken;
	private final ValueType valueType;
	
	
	/**
	 * @param type
	 * @param value
	 * @param nodeToken
	 * @param valueType
	 */
	@SuppressWarnings("unchecked")
	public Literal(T value, String nodeToken, ValueType valueType) {
		this.type = (Class<T>)value.getClass();
		this.value = value;
		this.nodeToken = nodeToken;
		this.valueType = valueType;
	}

	
	/**
	 * <pre>
	 * Makes null value
	 * </pre>
	 * @param type
	 * @param nodeToken
	 * @param valueType
	 */
	public Literal() {
		super();
		this.valueType = ValueType.VOID;
	}


	@Override
	public Class<T> type() {
		return type;
	}

	@Override
	public T get(Context context) {
		return value;
	}

	@Override
	public ValueType getValueType() {
		return valueType;
	}
	
	@Override
	public String getNodeToken() {
		return nodeToken;
	}

}
