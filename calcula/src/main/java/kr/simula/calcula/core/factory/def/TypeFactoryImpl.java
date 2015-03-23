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
package kr.simula.calcula.core.factory.def;

import java.math.BigDecimal;
import java.util.HashMap;

import kr.simula.calcula.builder.BuildException;
import kr.simula.calcula.builder.TypeFactory;
import kr.simula.calcula.core.DataSet;
import kr.simula.calcula.core.factory.TypeMeta;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 11.
 * @since	1.0
 */
public class TypeFactoryImpl implements TypeFactory {
	public static HashMap<String, Class<?>>PREDEFINED_TYPE = new HashMap<String, Class<?>>();
	
	static {
		PREDEFINED_TYPE.put("Number", BigDecimal.class);
		PREDEFINED_TYPE.put("String", String.class);
		PREDEFINED_TYPE.put("Boolean", Boolean.class);
		PREDEFINED_TYPE.put("Char", Character.class);
		PREDEFINED_TYPE.put("DataSet", DataSet.class);
	}
	
	
	public TypeMeta parseType(String typeExpression) {
		int idx = typeExpression.indexOf('(');
		TypeMeta meta = null;
		Class<?> type = null;
		
		if(idx>0){
			meta = parseType(typeExpression.substring(0,idx), 
					typeExpression.substring(idx));
		} else {
			type = PREDEFINED_TYPE.get(typeExpression);
			
			if(type == null){
				try {
					type = Class.forName(typeExpression);
				} catch (ClassNotFoundException e) {
					throw new BuildException("Unknown type " + typeExpression);
				}
			}
			
			meta = new TypeMeta(type);
		}
		
		return meta;
	}

	public TypeMeta parseType(String typeExpression, String constraints) {
		TypeMeta meta = null;
		Class<?> type = null;
		
		if( "Number".equals( typeExpression ) ){
			type = BigDecimal.class;
		} else if( "String".equals( typeExpression ) ){
			type = String.class;
		} else {
			throw new BuildException("Constraint must be on Number or String type" + typeExpression);
		}
		
		int idx = constraints.indexOf(',');
		int precisionOrSize;
		int scale = 0;
		
		if(idx > 0){
			precisionOrSize = Integer.parseInt( constraints.substring(1,idx) );
			scale = Integer.parseInt( constraints.substring(idx+1, constraints.length()-1) );
		} else {
			precisionOrSize = Integer.parseInt( constraints.substring(1, constraints.length()-1) );
		}
		
		meta = new TypeMeta(type, precisionOrSize, scale);
		
		return meta;
	}
	
}
