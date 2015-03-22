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
package kr.simula.calcula.core.factory.def;

import java.util.LinkedList;
import java.util.List;

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.Scope;
import kr.simula.calcula.core.factory.BuildContext;
import kr.simula.calcula.core.factory.ConditionalStatement;
import kr.simula.calcula.core.factory.DslBuildException;
import kr.simula.calcula.core.factory.EvalutateWhenStatement;
import kr.simula.calcula.core.factory.IfStatement;
import kr.simula.calcula.core.factory.NotImplementedException;
import kr.simula.calcula.core.factory.StatementFactory;

/**
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 23.
 * @since	1.0
 */
public class StatementFactoryImpl implements StatementFactory {

	public IfStatement ifStatement(BuildContext buildContext, Gettable<Boolean> condition) {
		IfStatementImpl ifStatement = new IfStatementImpl(condition);
		return ifStatement;
	}
	
	public EvalutateWhenStatement evalutateWhenStatement(
			BuildContext buildContext, Gettable<?> selection) {
		throw new NotImplementedException("evalutateWhenStatement");
	}
	
	/**
	 * 
	 * <pre>
	 * if statement
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 23.
	 * @since	1.0
	 */
	public static class IfStatementImpl extends ConditionalStatement implements IfStatement {
		private static final long serialVersionUID = 2516796496790620798L;
		
		private List<ConditionalStatement> list = new LinkedList<ConditionalStatement>();

		/**
		 * @param condition
		 */
		public IfStatementImpl(Gettable<Boolean> condition) {
			super(condition);
			list.add(this);
		}
		
		public Block appendElseIf(Node condition) {
			if( list.get(list.size()-1) instanceof ElseStatement ){
				throw new DslBuildException("IF statement already completed.");
			}
			if( condition instanceof Gettable ){
				Gettable<?> g = (Gettable<?>)condition;
				if( g.type() == Boolean.class ){
					@SuppressWarnings("unchecked")
					ConditionalStatement next = new ConditionalStatement((Gettable<Boolean>)condition);
					list.add(next);
					return next;
				}
			}
			throw new DslBuildException("Else if statement condition must be a logical expression but " + condition);
		}
		
		public Block appendElse() {
			if( list.get(list.size()-1) instanceof ElseStatement ){
				throw new DslBuildException("IF statement already completed.");
			}
			ElseStatement last = new ElseStatement();
			list.add(last);
			return last;
		}
		
		@Override
		public void execute(Context context) {
			for(ConditionalStatement stmt : list) {
				if( stmt.getCondition().get(context)) {
					Scope blockContext = new Scope(context);
					if(stmt == this){
						super.execute(blockContext);
					} else {
						stmt.execute(blockContext);
					}
					break;
				}
			}
		}
		

		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			for(ConditionalStatement stmt : list) {
				if(stmt == this){
					buf.append(super.toString());
				} else {
					buf.append(stmt);
				}
			}
			return buf.toString();
		}
	}
	
	public static class ElseStatement extends ConditionalStatement {
		private static final long serialVersionUID = 457205415988388100L;
		
		private static final Gettable<Boolean> TRUE = new Gettable<Boolean>() {
			private static final long serialVersionUID = 4706021078645367262L;

			public Class<Boolean> type() {
				return Boolean.class;
			}
			
			public Boolean get(Context context) {
				return Boolean.TRUE;
			}
			
			public String toString() {
				return "TRUE";
			};
		};
		
		
		/**
		 * @param condition
		 */
		public ElseStatement() {
			super(TRUE);
		}
	}
}
