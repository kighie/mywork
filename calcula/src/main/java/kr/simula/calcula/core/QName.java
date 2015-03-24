package kr.simula.calcula.core;

import java.io.Serializable;
import java.util.Iterator;

@SuppressWarnings("serial")
public class QName implements Serializable {
	private String[] pathArray;

	public QName(QName parent, String name){
		int plen = parent.pathArray.length;
		String[] newArray = new String[plen+1];
		System.arraycopy(parent.pathArray, 0, newArray, 0, plen);
		newArray[plen] = name;
		pathArray = newArray;
	}

	public QName(String name){
		pathArray = new String[]{name};
	}

	public QName(String[] paths){
		pathArray = paths;
	}

	public int getPathLength(){
		return pathArray.length;
	}

	public String getFirstPath(){
		return pathArray[0];
	}

	public String getLastPath(){
		return pathArray[pathArray.length-1];
	}
	
	public Iterable<String> getPaths(){
		return new PathIterable();
	}
	
	private class PathIterable implements Iterable<String> {
		public Iterator<String> iterator() {
			return new PathIterator();
		}
	}

	private class PathIterator implements Iterator<String> {
		int cursor = 0;
		
		public boolean hasNext() {
			return cursor < pathArray.length;
		}

		public String next() {
			return pathArray[cursor++];
		}

		public void remove() {
			throw new RtException("Path in qname cannot be removed.");
		}
	}
	
	@Override
	public String toString() {
		return toString(".");
	}
	
	public String toString(String pathDelimiter) {
		StringBuilder buf = new StringBuilder();
		for(String p : pathArray){
			buf.append(p).append(pathDelimiter);
		}
		buf.deleteCharAt(buf.length()-1);
		return buf.toString();
	}
}
