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
package kr.simula.calcula.builder.def;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.List;

import kr.simula.calcula.builder.BuildContext;
import kr.simula.calcula.builder.BuildException;
import kr.simula.calcula.builder.NodeFactory;
import kr.simula.calcula.builder.OperatorFactory;
import kr.simula.calcula.builder.ReferenceFactory;
import kr.simula.calcula.builder.StatementFactory;
import kr.simula.calcula.builder.TypeFactory;
import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.NodeToken;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.Settable;
import kr.simula.calcula.core.factory.AbstractBlock;
import kr.simula.calcula.core.factory.CaseWhenTerm;
import kr.simula.calcula.core.factory.EvalutateWhenStatement;
import kr.simula.calcula.core.factory.IfStatement;
import kr.simula.calcula.core.factory.NotImplementedException;
import kr.simula.calcula.core.factory.TypeMeta;

/**
 * 
 * @author IkChan Kwon
 * @since	1.0
 */
public class NodeFactoryImpl implements NodeFactory {


	public class NullGettable<T> implements Gettable<T> {
		private static final long serialVersionUID = -5876415114703778246L;
		
		private Class<T> type;
		
		/**
		 * @param type
		 */
		public NullGettable(Class<T> type) {
			super();
			this.type = type;
		}

		public Class<T> type() {
			return type;
		}

		public T get(Context context) {
			return null;
		}
		
		@Override
		public String toString() {
			return "NULL";
		}
	};

	public NullGettable<BigDecimal> NULL_NUMBER_GETTABLE = new NullGettable<BigDecimal>(BigDecimal.class);
	public NullGettable<String> NULL_STRING_GETTABLE = new NullGettable<String>(String.class);
	public NullGettable<Boolean> NULL_BOOLEAN_GETTABLE = new NullGettable<Boolean>(Boolean.class);
	
	
	private OperatorFactory operatorFactory;
	private ReferenceFactory refFactory;
	private TypeFactory typeFactory;
	private StatementFactory statementFactory;

	public NodeFactoryImpl() {
		this(new ReferenceFactoryImpl());
	}

	public NodeFactoryImpl(ReferenceFactory refFactory) {
		this(new OperatorFactoryImpl(), refFactory, new TypeFactoryImpl(), new StatementFactoryImpl() );
	}
	
	/**
	 * @param operatorFactory
	 * @param refFactory
	 * @param typeFactory
	 * @param statementFactory
	 */
	public NodeFactoryImpl(OperatorFactory operatorFactory,
			ReferenceFactory refFactory, TypeFactory typeFactory,
			StatementFactory statementFactory) {
		this.operatorFactory = operatorFactory;
		this.refFactory = refFactory;
		this.typeFactory = typeFactory;
		this.statementFactory = statementFactory;
	}

	/**
	 * @param statementFactory the statementFactory to set
	 */
	public void setStatementFactory(StatementFactory statementFactory) {
		this.statementFactory = statementFactory;
	}
	
	public void setOperatorFactory(OperatorFactory operatorFactory) {
		this.operatorFactory = operatorFactory;
	}
	
	public void setTypeFactory(TypeFactory typeFactory) {
		this.typeFactory = typeFactory;
	}
	
	public void setRefFactory(ReferenceFactory refFactory) {
		this.refFactory = refFactory;
	}
	
	public Gettable<String> string(BuildContext buildContext, String text) {
		return new STR(text);
	}
	
	/**
	 * 
	 * @author IkChan Kwon
	 * @date 2012. 10. 11.
	 * @since	1.0
	 */
	public class STR implements Gettable<String> {
		private static final long serialVersionUID = 1L;
		private String value;
		
		public STR(String value) {
			this.value = value;
		}
		
		public Class<String> type() {
			return String.class;
		}
		
		public String get(Context context) {
			return value;
		}
		
		@Override
		public String toString() {
			return "<STR " + value + ">";
		}
	}
	
	public Gettable<BigDecimal> number(BuildContext buildContext, String numStr) {
		return new NUM(numStr);
	}
	
	
	public Gettable<BigDecimal> number(BuildContext buildContext, String numStr, int precision, int scale) {
		return new NUM(numStr, precision, scale);
	}

	public class NUM implements Gettable<BigDecimal> {
		private static final long serialVersionUID = 1L;
		private BigDecimal value;

		NUM(BigDecimal value) {
			this.value = value;
		}

		NUM(String numStr) {
			this.value = new BigDecimal(numStr);
		}

		NUM(String numStr, int precision, int scale) {
			this.value = new BigDecimal(numStr,new MathContext(precision));
			value.setScale(scale);
		}

		public Class<BigDecimal> type() {
			return BigDecimal.class;
		}
		
		public BigDecimal get(Context context) {
			return value;
		}
		
		@Override
		public String toString() {
			return "<NUM " + value + ">";
		}
	}
	
	public Gettable<Boolean> bool(BuildContext buildContext, String value) {
		return new BOOL(value);
	}

	public class BOOL implements Gettable<Boolean> {
		private static final long serialVersionUID = 1L;
		private Boolean value;

		public BOOL(Boolean value) {
			this.value = value;
		}

		public BOOL(String value) {
			this.value = Boolean.getBoolean(value);
		}

		public Class<Boolean> type() {
			return Boolean.class;
		}
		
		public Boolean get(Context context) {
			return value;
		}
		
		@Override
		public String toString() {
			return "<BOOL " + value + ">";
		}
	}
	

	protected Gettable<?> getGettable(BuildContext buildContext, Node node){
		if(node == null){
			throw new BuildException("Node is null." );
		}
		
		if(node instanceof Gettable){
			return (Gettable<?>)node;
		} 
		
		throw new BuildException("Node " + node + " is not Gettable");
	}

	protected Settable<?> getSettable(BuildContext buildContext, Node node){
		if(node instanceof Settable){
			return (Settable<?>)node;
		} 
		
		throw new BuildException("Node " + node + " is not Settable");
	}
	
	public Node operator(BuildContext buildContext, NodeToken token, Node operand) {
		switch(token){
		case NEGATE:
			if(operand instanceof NUM){
				NUM num = (NUM)operand;
				num.value = num.value.negate();
				return num;
			} else {
				return operatorFactory.negate(getGettable(buildContext, operand));
			}
		case NOT:
			return operatorFactory.not(getGettable(buildContext, operand));
		default:
			throw new BuildException("Unknown Unary Operator " + token);
		}
	}


	public Node operator(BuildContext buildContext, NodeToken token, Node operand1, Node operand2) {
		Gettable<?> op1 = getGettable(buildContext, operand1);
		Gettable<?> op2 = getGettable(buildContext, operand2);
		
		switch(token){
		case ADD:
			return operatorFactory.add(op1, op2);
		case SUBTRACT:
			return operatorFactory.subtract(op1, op2);
		case MULTIPLY:
			return operatorFactory.multiply(op1, op2);
		case DIVIDE:
			return operatorFactory.divide(op1, op2);
		case MOD:
			return operatorFactory.mod(op1, op2);
		case CONCAT:
			return operatorFactory.concat(op1, op2);
		case EQ:
			return operatorFactory.eq(op1, op2);
		case NOT_EQ:
			return operatorFactory.notEq(op1, op2);
		case GT:
			return operatorFactory.gt(op1, op2);
		case EQ_GT:
			return operatorFactory.eqGt(op1, op2);
		case LT:
			return operatorFactory.lt(op1, op2);
		case EQ_LT:
			return operatorFactory.eqLt(op1, op2);
		case AND:
			return operatorFactory.and(op1, op2);
		case OR:
			return operatorFactory.or(op1, op2);
		default:
			throw new BuildException("Unknown Binary Operator " + token);
		}
	}
	
	public Node assign(BuildContext buildContext, Node assignee, Node assigned) {
		Settable<?> settable = getSettable(buildContext, assignee);
		Gettable<?> gettable = getGettable(buildContext, assigned);
		
		return operatorFactory.assign(settable, gettable);
	}

	public Ref ref(BuildContext buildContext, String qname) {
		return refFactory.reference(buildContext, qname);
	}
	
	/**
	 *  
	 */
	public Ref ref(BuildContext buildContext, Ref parent, String name, List<Node> args) {
		return refFactory.reference(buildContext, parent, name, args);
	}
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Executable declareVar(BuildContext buildContext, String name, String type, Node valueNode) {
		TypeMeta typeMeta = null;
		Gettable<?> initValNode = null;
		
		if( valueNode != null ){
			initValNode = getGettable(buildContext, valueNode);
		}
		
		if(type == null){
			if(initValNode == null){
				throw new BuildException("Variable type is missing. " + name);
			}
			type = initValNode.type().getName();
			typeMeta = typeFactory.parseType(type);
		} else {
			typeMeta = typeFactory.parseType(type);
		}
		
		if( initValNode != null ){
			if(!typeMeta.type().isAssignableFrom(initValNode.type())){
				throw new BuildException("Variable type[" 
						+ typeMeta + "] and value type["
						+ initValNode.type().getName() + "] are mismatched.");
			}
		} else {
			initValNode = new NullGettable(typeMeta.type());
		}
		
		Ref var = refFactory.newVariable(buildContext, name, typeMeta);
		
		Settable<?> assignee = getSettable(buildContext, var);
		
		
		return operatorFactory.assign(assignee, initValNode);
	}
	
	public Executable declareConst(BuildContext buildContext, String name,
			String type, Node valueNode) {
		TypeMeta typeMeta = null;
		Gettable<?> initValNode = getGettable(buildContext, valueNode);
		
		if(type == null){
			type = initValNode.type().getName();
			typeMeta = typeFactory.parseType(type);
		} else {
			typeMeta = typeFactory.parseType(type);
		}
		
		if(!typeMeta.type().isAssignableFrom(initValNode.type())){
			throw new BuildException("Constant type[" 
					+ typeMeta + "] and value type["
					+ initValNode.type().getName() + "] are mismatched.");
		}
		
		return refFactory.declareConst(buildContext, name, typeMeta, initValNode);
	}
	
	public Executable declareRef(BuildContext buildContext, String name, String type) {
		if(type == null){
			throw new BuildException("Ref[" + name+ "] type is null." );
		}
		
		TypeMeta typeMeta = typeFactory.parseType(type);
		
		return refFactory.declareRef(buildContext, name, typeMeta);
	}
	
	public Block newBlock(BuildContext buildContext) {
		return new SimpleBlock();
	}
	
	/**
	 * Simple block
	 * @author IkChan Kwon
	 * @date 2012. 10. 11.
	 * @since	1.0
	 */
	protected  class SimpleBlock extends AbstractBlock {
		private static final long serialVersionUID = -7237999538796190073L;
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("BLOCK[\n");
			for(Executable e : nodes()){
				buf.append("\t").append(e).append("\n");
			}
			buf.append("]\n");
			return buf.toString();
		}
	}
	
	/**
	 * TODO
	 */
	public Node functionCall(BuildContext buildContext , String name, List<Node> args) {
		throw new NotImplementedException("functionCall");
	}
	
	@SuppressWarnings("unchecked")
	public IfStatement ifStatement(BuildContext buildContext, Node condition) {
		Gettable<?> gettable = getGettable(buildContext, condition);
		if(gettable.type() == Boolean.class){
			return statementFactory.ifStatement(buildContext, (Gettable<Boolean>)condition);
		}
		throw new BuildException("Condition node must be a Gettable<Boolean>");
	}

	
	public EvalutateWhenStatement evalutateWhenStatement( BuildContext buildContext, Node selection) {
		Gettable<?> gettable = getGettable(buildContext, selection);
		return statementFactory.evalutateWhenStatement(buildContext, gettable);
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public CaseWhenTerm<?> caseWhenTerm(BuildContext buildContext, Node selection) {
		Gettable<?> gettable = getGettable(buildContext, selection);
		return new CaseWhenTermImpl (gettable, TypeMeta.UNKNOWN_TYPE.type());
	}

	public class CaseWhenTermImpl<T> implements CaseWhenTerm<T> {
		private static final long serialVersionUID = -7708050248816547779L;

		private Gettable<?> selection;
		private Class<T> returnType;
		private LinkedList<When> whenList = new LinkedList<When>();

		
		public CaseWhenTermImpl(Gettable<?> selection, Class<T> returnType ) {
			this.selection = selection;
			this.returnType = returnType;
		}
		
		public Class<T> type() {
			return returnType;
		}
		
		public T get(Context context) {
			Object compared = selection.get(context);
			
			for(When w : whenList){
				if(w.match(context, compared)){
					return w.expression.get(context);
				}
			}
			
			return null;
		}
		
		@SuppressWarnings("unchecked")
		public void appendWhen(Node selection, Node expression) {
			Gettable<?> criteria = (Gettable<?>)selection;
			Gettable<T> expressionGet = (Gettable<T>)expression;
			When when = new When(criteria, expressionGet);
			whenList.add(when);
		}

		@SuppressWarnings("unchecked")
		public void appendOther(Node expression) {
			Gettable<T> expressionGet = (Gettable<T>)expression;
			Other when = new Other( expressionGet);
			whenList.add(when);
		}
		
		@Override
		public String toString() {
			StringBuilder buf = new StringBuilder();
			buf.append("<CASE ").append(selection) .append(" { ");
			
			for(When w : whenList){
				buf.append("\n\t\t").append(w);
			}
			
			buf.append("\n\t}>");
			
			return buf.toString();
		}
		
		
		class When implements Serializable {
			private static final long serialVersionUID = 1L;
			private Gettable<?> criteria;
			Gettable<T> expression;
			
			public When(Gettable<?> criteria, Gettable<T> expression) {
				this.criteria = criteria;
				this.expression = expression;
			}
			
			public boolean match(Context context, Object compared){
				return compared.equals(criteria.get(context));
			}
			
			@Override
			public String toString() {
				StringBuilder buf = new StringBuilder();
				buf.append("<WHEN ").append(criteria) .append(" :  ");
				buf.append(expression).append(">");
				
				return buf.toString();
			}
		}
		
		class Other extends When {
			private static final long serialVersionUID = 1L;
			
			public Other(  Gettable<T> expression) {
				super(null, expression);
			}
			
			/**
			 * return true
			 */
			@Override
			public boolean match(Context context, Object compared) {
				return true;
			}

			@Override
			public String toString() {
				StringBuilder buf = new StringBuilder();
				buf.append("<OTHER ").append(expression).append(">");
				
				return buf.toString();
			}
		}
	}
}
