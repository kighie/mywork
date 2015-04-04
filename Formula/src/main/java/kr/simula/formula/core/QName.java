package kr.simula.formula.core;

import java.io.Serializable;

@SuppressWarnings("serial")
public class QName implements Serializable {
	private QName parent;
	private QName root;
	private String qname;
	private String name;
	
	public QName(QName parent, String name){
		this.name = name;
		this.parent = parent;
		this.root = (parent != null) ? parent.root:this;
		this.qname = toString(".").intern();
	}

	public QName(String name){
		this(null,name);
	}

	/**
	 * @return the root
	 */
	public QName getRoot() {
		return root;
	}
	
	/**
	 * @return the parent
	 */
	public QName getParent() {
		return parent;
	}

	/**<pre>
	 * </pre>
	 * @return
	 */
	public String getName() {
		return name;
	}
	
	
	public String getFullName() {
		return qname;
	}
	
	@Override
	public int hashCode() {
		return qname.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if( this == obj ){
			return true;
		} else if(obj instanceof QName){
			return this.qname.equals(((QName)obj).qname);
		} else if (obj instanceof String){
			return this.qname.equals(obj);
		}
		
		return false;
	}
	
	public boolean equals(QName obj) {
		return (this.hashCode() == obj.hashCode());
	}

	public boolean equals(String obj) {
		return (obj.equals(this));
	}
	
	
	@Override
	public String toString() {
		return qname;
	}
	
	public String toString(String pathDelimiter) {
		StringBuilder buf = new StringBuilder();
		if(parent != null){
			buf.append(parent).append(pathDelimiter);
		}
		
		buf.append(name);
		return buf.toString();
	}

}
