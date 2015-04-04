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
package kr.simula.formula.core.factory.func;

import java.math.BigDecimal;
import java.util.Date;

import kr.simula.formula.core.Gettable;
import kr.simula.formula.core.Node;
import kr.simula.formula.core.util.GettableUtils;

/**
 * <pre></pre>
 * @author kighie@gmail.com
 * @since 1.0
 */
public interface ArgumentValidator<T> {

	/**
	 * <pre>
	 * validate argument type and convert Gettable
	 * </pre>
	 * @param node
	 * @return
	 */
	public abstract Gettable<T> validate(Node node);
	

	public static ArgumentValidator<Object> OBJECT_VALIDATOR = new ArgumentValidator<Object>(){
		@SuppressWarnings("unchecked")
		@Override
		public Gettable<Object> validate(Node node) {
			return (Gettable<Object>)GettableUtils.checkGettable(node);
		}
	};

	public static ArgumentValidator<BigDecimal> DECIMAL_VALIDATOR = new ArgumentValidator<BigDecimal>(){
		@Override
		public Gettable<BigDecimal> validate(Node node) {
			return GettableUtils.getDecimalGettable(node);
		}
	};

	public static ArgumentValidator<String> STRING_VALIDATOR = new ArgumentValidator<String>()  {
		@Override
		public Gettable<String> validate(Node node) {
			return GettableUtils.getStringGettable(node);
		}
	};
	
	public static ArgumentValidator<Boolean> BOOLEAN_VALIDATOR = new ArgumentValidator<Boolean>() {
		@Override
		public Gettable<Boolean> validate(Node node) {
			return GettableUtils.getBooleanGettable(node);
		}
	};
	

	public static ArgumentValidator<Date> DATE_VALIDATOR = new ArgumentValidator<Date>() {
		@Override
		public Gettable<Date> validate(Node node) {
			return GettableUtils.getDateGettable(node);
		}
	};
}
