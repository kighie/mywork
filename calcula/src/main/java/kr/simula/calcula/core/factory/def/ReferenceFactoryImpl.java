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

import java.util.List;

import kr.simula.calcula.builder.BuildContext;
import kr.simula.calcula.builder.BuildException;
import kr.simula.calcula.builder.ReferenceFactory;
import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.DslException;
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Gettable;
import kr.simula.calcula.core.Node;
import kr.simula.calcula.core.QName;
import kr.simula.calcula.core.Ref;
import kr.simula.calcula.core.Settable;
import kr.simula.calcula.core.bean.MethodUtils;
import kr.simula.calcula.core.bean.PropertyUtils;
import kr.simula.calcula.core.factory.AbstractRef;
import kr.simula.calcula.core.factory.TypeMeta;

/**
 * <pre>
 * </pre>
 * @author IkChan Kwon
 * @date 2012. 10. 19.
 * @since	1.0
 */
public class ReferenceFactoryImpl implements ReferenceFactory {
	
	public Ref reference(BuildContext buildContext, String name) {
		Ref ref = buildContext.getVariable(name);
		
		if(ref != null){
			return ref;
		}  
		
		ref = buildContext.getConstant(name);
		
		if(ref != null){
			return ref;
		}  
		
		QName qname = buildContext.getQName(name);
		if(qname == null){
			qname = new QName(name);
			buildContext.registerQName(name, qname);
		}
		
		ref = buildContext.getRef(qname);
		
		if(ref != null){
			return ref;
		}
		
		if(!buildContext.isTypeChecked()){
			SimpleReference simpleRef = new SimpleReference(qname, TypeMeta.UNKNOWN_TYPE) ;
			buildContext.registerRef(qname, simpleRef);
			return simpleRef;
		}
		
		throw new BuildException("Unknown Reference : " + name );
	}

	/* (non-Javadoc)
	 * @see net.kighie.dsl.core.factory.RefFactory#ref(net.kighie.dsl.core.factory.BuildContext, net.kighie.dsl.core.Ref, java.lang.String, java.util.List)
	 */
	public Ref reference(BuildContext buildContext, Ref parent, String name, List<Node> args) {
		Gettable<?> parentGettable = (Gettable<?>)parent;
		QName qname = new QName(parent.qualifiedName(), name);
		
		if( args == null ){
			ReferenceProperty prop = new ReferenceProperty(parentGettable, qname, TypeMeta.UNKNOWN_TYPE);
			return prop;
		} else {
			Gettable<?>[] argArray = new Gettable[args.size()];
			argArray = args.toArray(argArray);
			ReferenceMethod method = new ReferenceMethod(parentGettable, qname, TypeMeta.UNKNOWN_TYPE, argArray);
			return method;
		}
	}
	
	public Ref newVariable(BuildContext buildContext, String name, TypeMeta typeMeta) {
		Ref ref = buildContext.getVariable(name);
		
		if( ref != null){
			throw new BuildException("Variable[" + name + "] is already declared.");
		}
		
		QName qname = buildContext.getQName(name);
		
		if( qname == null){
			qname = new QName(name);
			buildContext.registerQName(name, qname);
		}
		
		Variable var = new Variable(qname, typeMeta);
		buildContext.registerVariable(name, var);
		return var;
	}

	@SuppressWarnings("rawtypes")
	public Executable declareConst(BuildContext buildContext, String name,
			TypeMeta typeMeta, Gettable<?> valueNode) {
		Ref ref = buildContext.getVariable(name);
		
		if( ref != null){
			throw new BuildException("Constant name [" + name + "] is already declared as variable.");
		}
		
		ref = buildContext.getConstant(name);
		
		if( ref != null){
			throw new BuildException("Constant [" + name + "] is already declared.");
		}
		
		QName qname = buildContext.getQName(name);
		
		if( qname == null){
			qname = new QName(name);
			buildContext.registerQName(name, qname);
		}
		
		Constant constant = new Constant(qname, typeMeta);
		buildContext.registerConstant(name, constant);
		ConstantDeclaration constDecl = new ConstantDeclaration(constant, valueNode);
		
		return constDecl;
	}

	public Executable declareRef(BuildContext buildContext, String name,TypeMeta typeMeta ) {
		QName qname = buildContext.getQName(name);
		if(qname == null){
			qname = new QName(name);
			buildContext.registerQName(name, qname);
		}
		
		return declareRef(buildContext, qname, typeMeta);
	}

	public Executable declareRef(BuildContext buildContext, QName qname,TypeMeta typeMeta ) {
		Ref ref = buildContext.getRef(qname);
		
		if( ref != null){
			throw new BuildException("Ref[" + qname + "] is already declared.");
		}
	
		ref = new SimpleReference(qname, typeMeta);
		return new RefDeclaration(ref);
	}
	
	@SuppressWarnings("rawtypes")
	public class Variable extends AbstractRef implements Gettable, Settable {
		private static final long serialVersionUID = 6084505463324178448L;

		private String name;
		
		public Variable(QName qname, TypeMeta typeMeta){
			super(qname, typeMeta);
			this.name = qname.getFirstPath();
		}
		
		public TYPE refType() {
			return TYPE.VARIABLE;
		}
		
		@Override
		public Class<?> type() {
			return super.type();
		}
		
		public void set(Context context, Object value) {
			context.setVariable(name, value);
		}

		public Object get(Context context) {
			Object val = context.getVariable(name);
			if(val == null){
				throw new DslException("<VAR " + name + "> is null.");
			}
			return val;
		}
		
		@Override
		public String toString() {
			return "<VAR " + name + " : " + getTypeMeta() + ">";
		}
	}
	
	/**
	 * TODO 타입 체크
	 * <pre>
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 19.
	 * @since	1.0
	 */
	public class ConstantDeclaration implements Executable {
		private static final long serialVersionUID = -6185726185896849637L;
		
		private Constant constant;
		private Gettable<?> initValNode;
		
		public ConstantDeclaration(Constant constant, Gettable<?> initValNode) {
			this.constant = constant;
			this.initValNode = initValNode;
		}


		/**
		 * initialize variable value. 
		 */
		public void execute(Context context) {
			if( initValNode != null ){
				constant.value = initValNode.get(context);
			}
		}
		
		@Override
		public String toString() {
			return "[DECL_CONST " + constant + "=" + initValNode + "]";
		}
	}
	
	public class Constant<T> extends AbstractRef implements Gettable<T> {
		private static final long serialVersionUID = 556603970680982664L;
		
		private T value;
		
		public Constant(QName qname, TypeMeta typeMeta){
			super(qname, typeMeta);
		}
		
		public TYPE refType() {
			return TYPE.CONST;
		}
		
		@SuppressWarnings("unchecked")
		@Override
		public Class<T> type() {
			return (Class<T>)getTypeMeta().type();
		}
		
		/**
		 * @param value the value to set
		 */
		protected void setValue(T value) {
			this.value = value;
		}
		
		public T get(Context context) {
			return value;
		}
		
		@Override
		public String toString() {
			return "<CONST " + qualifiedName().getFirstPath() 
					+ " : " + getTypeMeta() + "=" + value + ">";
		}
	}

	/**
	 * 
	 * <pre>
	 * Procedure, Function, Rule argument 
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 19.
	 * @since 0.1
	 */
	public class RefDeclaration implements Executable {
		private static final long serialVersionUID = 3013685794588226586L;
		
		private Ref ref;
		
		public RefDeclaration( Ref ref ) {
			this.ref = ref;
		}


		/**
		 * initialize variable value. 
		 */
		public void execute(Context context) {
			if( context.getReference(ref.qualifiedName().getFirstPath()) == null){
				throw new DslException("Reference " + ref.qualifiedName().getFirstPath() + " is undefined.");
			}
		}
		
		@Override
		public String toString() {
			return "[DECL_REF " + ref + "]";
		}
	}
	
	/**
	 * FIXME
	 * input, output 에 값 넣고 빼기의 문제
	 * 그럼, 어떤 정책으로 처리할까?
	 * <pre>
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 22.
	 * @since	1.0
	 */
	@SuppressWarnings("rawtypes")
	public class SimpleReference extends AbstractRef implements Gettable, Settable {
		private static final long serialVersionUID = 1003424916206798095L;

		public SimpleReference(QName qname, TypeMeta typeMeta){
			super(qname, typeMeta);
		}
		
		public TYPE refType() {
			return TYPE.REF;
		}
		
		@Override
		public Class<?> type() {
			return super.type();
		}
		
		/**
		 * save value to context outputs
		 * @see {@link Context#setVariable(String, Object)}
		 */
		public void set(Context context, Object value) {
			context.setReference( qualifiedName().getFirstPath(), value);
		}

		/**
		 * retrieve value from context inputs
		 */
		public Object get(Context context) {
			Object val = context.getReference(qualifiedName().getFirstPath());
			if(val == null){
				throw new DslException("<SIMPLE_REF " + qualifiedName().getFirstPath() + "> is null.");
			}
			return val;
		}
		
		@Override
		public String toString() {
			return "<SIMPLE_REF " + qualifiedName().getFirstPath()  + " : " + getTypeMeta() + ">";
		}
	}

	/**
	 * FIXME 속도 개선 Commons BeanUtil 대체 필요 
	 * <pre>
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 22.
	 * @since	1.0
	 */
	@SuppressWarnings("rawtypes")
	public class ReferenceProperty extends AbstractRef implements Gettable, Settable {
		private static final long serialVersionUID = 1003424916206798095L;

		private Gettable<?> parent;
		private String name;
		
		public ReferenceProperty(Gettable<?> parent, QName qname, TypeMeta typeMeta){
			super(qname, typeMeta);
			this.parent = parent;
			if(parent == null){
				throw new BuildException("Reference property must have a parent reference.");
			}
			name = qname.getLastPath();
		}
		
		/**
		 * @return the parent
		 */
		public Gettable<?> getParent() {
			return parent;
		}
		
		public TYPE refType() {
			return TYPE.REF_PROPERTY;
		}
		
		@Override
		public Class<?> type() {
			return super.type();
		}
		
		/**
		 * save value to context outputs
		 * @see {@link Context#setVariable(String, Object)}
		 */
		public void set(Context context, Object value) {
			Object bean = parent.get(context);
			try {
				PropertyUtils.setProperty(bean, name, value);
			} catch (Throwable e) {
				throw new DslException( this.toString() , e);
			}
		}

		/**
		 * retrieve value from context inputs
		 */
		public Object get(Context context) {
			Object bean = parent.get(context);
			try {
				return PropertyUtils.getProperty(bean, name);
			} catch (Throwable e) {
				throw new DslException( this.toString() , e);
			}
		}
		
		@Override
		public String toString() {
			return "<REF_PROP " + qualifiedName().getFirstPath()  + " : " + getTypeMeta() + ">";
		}
	}
	

	/**
	 * FIXME 인수가 BigDecimal이 아닌 숫자 타입인 경우 처리 
	 * <pre>
	 * </pre>
	 * @author IkChan Kwon
	 * @date 2012. 10. 22.
	 * @since	1.0
	 */
	@SuppressWarnings("rawtypes")
	public class ReferenceMethod extends AbstractRef implements Gettable, Executable {
		private static final long serialVersionUID = 1003424916206798095L;

		private Gettable<?> parent;
		private String methodName;
		private Gettable<?>[] argDecls;
		private Class<?>[] parameterTypes;
		
		public ReferenceMethod(Gettable<?> parent, QName qname, TypeMeta typeMeta, Gettable<?>[] args){
			super(qname, typeMeta);
			this.parent = parent;
			if(parent == null){
				throw new BuildException("Reference method must have a parent reference.");
			}
			this.methodName = qname.getLastPath();
			this.argDecls = args;
			parameterTypes = new Class<?>[args.length];
			
			for(int i = args.length-1 ; i >= 0 ;i-- ){
				parameterTypes[i] = args[i].type();
			}
		}
		
		/**
		 * @return the parent
		 */
		public Gettable<?> getParent() {
			return parent;
		}
		
		public TYPE refType() {
			return TYPE.REF_METHOD;
		}
		
		@Override
		public Class<?> type() {
			return super.type();
		}
		
		/* (non-Javadoc)
		 * @see net.kighie.dsl.core.Executable#execute(net.kighie.dsl.core.Context)
		 */
		public void execute(Context context) {
			get(context);
		}
		
		/**
		 * retrieve value from context inputs
		 */
		public Object get(Context context) {
			Object bean = parent.get(context);
			int argLen = argDecls.length;
			Object[] args = new Object[argLen];
			
			for(int i = 0 ; i <  argLen ;i++ ){
				args[i] = argDecls[i].get(context);
			}
			
			try {
				return MethodUtils.invokeMethod(bean, methodName, args, parameterTypes);
			} catch (Throwable e) {
				throw new DslException( this.toString() , e);
			}
		}
		
		@Override
		public String toString() {
			return "<REF_METHOD " + qualifiedName() + ">";
		}
	}
}
