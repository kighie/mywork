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
package kr.simula.formula.core.builder;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import kr.simula.formula.core.QName;
import kr.simula.formula.core.Ref;

/**
 * 
 * @author IkChan Kwon
 * @date 2012. 10. 10.
 * @since	1.0
 */
public class ScopeBuildContext implements BuildContext {
	private BuildContext parent;
	
	private Map<QName, Ref> referenceMap = new HashMap<QName, Ref>();
	
	public ScopeBuildContext(BuildContext parent) {
		this.parent = parent;
	}

	/**
	 * @return the parent
	 */
	public BuildContext getParent() {
		return parent;
	}
	
	public Ref getRef(QName qname){
		Ref ref = referenceMap.get(qname);
		if(ref == null){
			if( parent != null ){
				ref = parent.getRef(qname);
			}
		}
		return ref;
	}

	public Iterable<Entry<QName, Ref>> references() {
		return new Refs();
	}

	public void registerRef(QName qname, Ref ref){
		referenceMap.put(qname, ref);
	}
	
	protected class Refs implements Iterable<Entry<QName, Ref>> {
		@Override
		public Iterator<Entry<QName, Ref>> iterator() {
			return new RefIterator(ScopeBuildContext.this);
		}
	}

	protected static class RefIterator implements Iterator<Entry<QName, Ref>> {
		
		private BuildContext context;
		private Iterator<Entry<QName, Ref>> iterator;
		
		/**
		 * @param context
		 */
		public RefIterator(BuildContext context) {
			this.context = context;
			iterator = context.references().iterator();
		}

		@Override
		public boolean hasNext() {
			boolean b = iterator.hasNext();
			if(!b && context.getParent() != null){
				context = context.getParent();
				iterator = context.references().iterator();
				b = iterator.hasNext();
			}
			return b;
		}
		
		@Override
		public Entry<QName, Ref> next() {
			return iterator.next();
		}

		@Override
		public void remove() {
			iterator.remove();
		}
	}
}
