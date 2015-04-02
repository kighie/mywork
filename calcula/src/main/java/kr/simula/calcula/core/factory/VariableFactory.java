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
import kr.simula.calcula.core.builder.BuildContext;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public interface VariableFactory {

	/**
	 * <pre>
	 * </pre>
	 * @param context
	 * @param parent
	 * @param qname
	 * @return
	 */
	Ref create(BuildContext context, Ref parent, QName qname);
	

	/**
	 * <pre>
	 * </pre>
	 * @param context
	 * @param qname
	 * @return
	 */
	Ref create(BuildContext context, QName qname);
	
	
}
