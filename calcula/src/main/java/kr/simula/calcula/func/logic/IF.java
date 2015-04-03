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
package kr.simula.calcula.func.logic;

import kr.simula.calcula.core.annotation.Arguments;
import kr.simula.calcula.def.AbstractFunction;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class IF extends AbstractFunction<Object> {
	private static final long serialVersionUID = 1L;

	/**
	 * @param returnType
	 */
	public IF() {
		super(Object.class);
	}

	@Override
	@Arguments({Boolean.class, Object.class, Object.class})
	public Object eval(Object... args) {
		checkArgCountMoreThan(args, 1);
		
		return ((Boolean)args[0]) ? args[1] : (args.length>2) ? args[2] : null;
	}

}