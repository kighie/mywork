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
package kr.simula.formula.util;


/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class StopWatch {
	
	private long start;

	public long start(){
		return start = System.currentTimeMillis();
	}

	public long ellapsed(){
		return System.currentTimeMillis() - start;
	}
	
	public String ellapsedTime(){
		long ellapsed = ellapsed();
		long second = ellapsed / 1000;
		long millisecond = ellapsed - second;
		StringBuilder buf = new StringBuilder();
		if(second>0){
			buf.append(second).append("sec. ");
		} 
		
		buf.append(millisecond).append("ms.");
		return buf.toString();
	}
}
