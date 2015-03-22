package kr.simula.calcula.core.factory;

import java.util.LinkedList;

import kr.simula.calcula.core.Block;
import kr.simula.calcula.core.Context;
import kr.simula.calcula.core.Executable;
import kr.simula.calcula.core.Node;

@SuppressWarnings("serial")
public abstract class AbstractBlock implements Block {
	
	private LinkedList<Executable> nodeList = new LinkedList<Executable>();
	
	/**
	 * executes all executable nodes contained.
	 */
	public void execute(Context context) {
		for(Executable e : nodeList){
			e.execute(context);
		}
	}

	public void append(Node node) {
		if(!(node instanceof Executable)){
			throw new DslBuildException("Block has only Executable nodes. " + node);
		}
		
		nodeList.add((Executable)node);
	}
	
	protected Iterable<Executable> nodes(){
		return nodeList;
	}
}
