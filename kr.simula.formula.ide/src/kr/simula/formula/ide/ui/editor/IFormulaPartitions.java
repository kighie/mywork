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
package kr.simula.formula.ide.ui.editor;

import org.eclipse.jface.text.IDocument;

/**
 * <pre>
 * </pre>
 * @author Ikchan Kwon
 *
 */
public interface IFormulaPartitions {
	public final static String FORMULA_PARTITIONING = "__formula_partitioning";
	 
	public final static String FORMULA_COMMENT = "__formula_comment";
	public final static String FORMULA_STRING = "__formula_string";
 
	public final static String[] FORMULA_PARITION_TYPES = new String[] {
			IFormulaPartitions.FORMULA_STRING, IFormulaPartitions.FORMULA_COMMENT,
			IDocument.DEFAULT_CONTENT_TYPE };
}
