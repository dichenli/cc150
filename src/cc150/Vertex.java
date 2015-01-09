/**
 * 
 */
package cc150;

import java.util.ArrayList;

/**
 * @author dichenli
 *
 */
public class Vertex<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {


	}

	private final T key;
	private ArrayList<Edge<T>> edges;
	
	public Vertex(T key) {
		this.key = key;
		this.edges = new ArrayList<Edge<T>>();
	}
	
	public Vertex() {
		this(null);
	}
	
	public T getKey() {
		return key;
	}
	
	public void addEdge(Edge node) {
		edges.add(node);
	}
	
	public Iterable<Edge<T>> getEdges() {
		return edges;
	}
	
}
