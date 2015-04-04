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
package kr.simula.formula.core.factory.helper;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import kr.simula.formula.core.Function;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public class FunctionLoader extends ClassLoader {
	private static Logger logger = Logger.getLogger(FunctionLoader.class.getName());
	
	private  String packageName;
	
	/**
	 * @param parent
	 */
	public FunctionLoader(ClassLoader parent, String packageName) {
		super(parent);
		this.packageName = packageName;
	}

	public List<Function<?>> loadFunctions(){
		String path = packageName.replace('.', '/');
		
		List<Function<?>> list = new LinkedList<Function<?>>();
		
	    Enumeration<URL> resources;
		try {
			resources = getResources(path);
		} catch (IOException e) {
			logger.log(Level.WARNING, "Cannot load Function classes in " + packageName, e);
			return list;
		}
		
	    List<File> dirs = new ArrayList<File>();
	    while (resources.hasMoreElements()) {
	        URL resource = resources.nextElement();
	        dirs.add(new File(resource.getFile()));
	    }
	    
	    
	    for (File directory : dirs) {
	    	findFunctions(directory, packageName, list);
	    }
		return list;
	}
	

	private static void findFunctions(File directory, String packageName, List<Function<?>> list)  {
	    if (!directory.exists()) {
	        return;
	    }
	    
	    File[] files = directory.listFiles();
	    for (File file : files) {
	        if (file.isDirectory()) {
	            assert !file.getName().contains(".");
	            findFunctions(file, packageName + "." + file.getName(), list);
	        } else if (file.getName().endsWith(".class")) {
	        	String clzName = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
	        	Class<?> clz = null;
	        	try {
					clz = Class.forName(clzName);
					
					if(Function.class.isAssignableFrom(clz)
							&& !clz.isInterface()
							&& !Modifier.isAbstract( clz.getModifiers() )){
						Function<?> func = (Function<?>) clz.newInstance();
						list.add( func );
						
					}
				} catch (ClassNotFoundException e) {
					logger.log(Level.WARNING, "Cannot find Function class " + clzName, e);
				} catch (InstantiationException e) {
					logger.log(Level.WARNING, "Cannot instantiate Function instance " + clzName, e);
				} catch (IllegalAccessException e) {
					logger.log(Level.WARNING, "Cannot access to Function constructor " + clzName, e);
				}
	        	
	        }
	    }
	}
}
