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
package kr.simula.formula.def.builder;

import java.io.IOException;
import java.util.List;

import kr.simula.formula.core.Function;
import kr.simula.formula.core.factory.helper.FunctionLoader;

import org.junit.Test;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FunctionLoaderTest {

	@Test
	public void load() throws IOException{
		FunctionLoader loader = new FunctionLoader(getClass().getClassLoader(), "kr.simula.calcula.func");
		
		List<Function<?>> list = loader.loadFunctions();
		
		for(Function<?> fc : list){
			System.out.println(fc);
		}
	}
}
