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
public abstract class Literal<T> implements Node, Gettable<T>{
	private T value;
	
	
	/**
	 * @param value
	 */
	public Literal(T value) {
		this.value = value;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Class<? extends T> type() {
		return (Class<? extends T>)value.getClass();
	}

	@Override
	public T get(Context context) {
		return value;
	}
}
