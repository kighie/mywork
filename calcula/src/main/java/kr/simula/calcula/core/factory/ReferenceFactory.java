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

import java.util.List;

import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Ref;

/**
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 19.
 * @since	1.0
 */
public interface ReferenceFactory {

	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @return
	 */
	Ref reference(BuildContext buildContext , String name );

	/**
	 * 
	 * @param buildContext
	 * @param parent
	 * @param name
	 * @param args
	 * @return
	 */
	Ref reference(BuildContext buildContext , Ref parent, String name, List<Node> args);
	
	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param type
	 * @return
	 */
	Ref newVariable(BuildContext buildContext, String name, TypeMeta typeMeta);
	

	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param type
	 * @param valueNode
	 * @return
	 */
	Executable declareConst(BuildContext buildContext, String name, TypeMeta typeMeta, Gettable<?> valueNode);
	
	/**
	 * 
	 * @param buildContext
	 * @param name
	 * @param typeMeta
	 * @return
	 */
	Executable declareRef(BuildContext buildContext, String name, TypeMeta typeMeta );
}
