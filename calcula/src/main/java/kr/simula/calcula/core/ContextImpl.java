package kr.simula.calcula.core;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class ContextImpl implements Context {

	private Map<String, Object> attributes = new HashMap<String, Object>();
	private Map<String, Object> refMap = new HashMap<String, Object>();
	private Map<String, Object> variables = new HashMap<String, Object>();
//	private Map<String, Object> inputs = new HashMap<String, Object>();
//	private Map<String, Object> outputs = new HashMap<String, Object>();
	
	public void setAttribute(String name, Object value) {
		attributes.put(name, value);
	}

	public Object getAttribute(String name) {
		return attributes.get(name);
	}

	public Object getReference(QName qname) {
		return refMap.get(qname);
	}

	public Object getVariable(String name) {
		return variables.get(name);
	}

	public void setVariable(String name, Object value) {
		variables.put(name, value);
	}

	public Iterable<Entry<String, Object>> attributes() {
		return attributes.entrySet();
	}

	public Iterable<Entry<String, Object>> variables() {
		return variables.entrySet();
	}

	
	public Object getReference(String name) {
		return refMap.get(name);
	}
	
	/* (non-Javadoc)
	 * @see net.kighie.dsl.core.Context#setReference(java.lang.String, java.lang.Object)
	 */
	public void setReference(String name, Object ref) {
		refMap.put(name, ref);
	}
	
	public Iterable<Entry<String, Object>> references() {
		return refMap.entrySet();
	}

//	/**
//	 * @see net.kighie.dsl.core.Context#getInput(java.lang.String)
//	 */
//	public Object getInput(String name) {
//		return inputs.get(name);
//	}
//	
//	public void setInput(String name, Object value) {
//		inputs.put(name, value);
//	}
//
//	public Iterable<Entry<String, Object>> inputs() {
//		return inputs.entrySet();
//	}
	
	
//	/**
//	 * @see net.kighie.dsl.core.Context#setOutput(java.lang.String, java.lang.Object)
//	 */
//	public void setOutput(String name, Object value) {
//		outputs.put(name, value);
//	}
//	
//	public Object getOutput(String name) {
//		return outputs.get(name);
//	}
//	
//	public Iterable<Entry<String, Object>> outputs() {
//		return outputs.entrySet();
//	}
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Context[\n\tattributes=").append(attributes)
				.append(", \n\trefMap=").append(refMap)
				.append(", \n\tvariables=").append(variables).append("\n]");
		return builder.toString();
	}

	
}
