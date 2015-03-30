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
package kr.simula.calcula.def.builder;

import kr.simula.calcula.core.factory.helper.FunctionCallHelper;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public class DefaultFunctionCallHelper extends FunctionCallHelper {
	
	protected final static String FUNC_CLASSPATH = "kr/simula/calcula/func";
	
	@Override
	protected void initDefaults() {
		super.initDefaults();
		
		
	}
	
//	protected final void loadFunctions(ClassLoader classLoader, String classpath){
//		FunctionClassLoader funcLoader = new FunctionClassLoader(classLoader);
//		
//		funcLoader.scanPackage(classpath, new FunctionLoader(){
//			@Override
//			public void loadFunction(Class<Function<?>> funcClass) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
//		
//	}
//	
//	protected interface FunctionLoader {
//		void loadFunction(Class<Function<?>> funcClass);
//	}
//	
//	protected class FunctionClassLoader extends ClassLoader {
//		
//		/**
//		 * @param parent
//		 */
//		protected FunctionClassLoader(ClassLoader parent) {
//			super(parent);
//		}
//		
//		protected void scanPackage(String classpath, FunctionLoader functionLoader){
//			Package pkg = getPackage(classpath);
//			this.
//		}
//	}
}
