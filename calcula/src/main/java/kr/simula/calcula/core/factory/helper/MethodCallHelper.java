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
package kr.simula.calcula.core.factory.helper;

import java.util.List;

import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.builder.BuildContext;
import kr.simula.calcula.core.builder.BuildException;
import kr.simula.calcula.core.factory.MethodCallFactory;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class MethodCallHelper extends AbstractHelper<MethodCallFactory> {

	public Node create(BuildContext context, Ref parent, String name, List<Node> args){
		MethodCallFactory factory = factories.get(name);
		if(factory == null){
			throw new BuildException("MethodCallFactory for " + name + " is not registered.");
		}
		return factory.create(context, parent, name, args);
	}
}
