/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * The same graph as in Princeton algorithms course
 */
public class simpleGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	private LinkedList<Integer>[] adj;
	private int V;
	private int E;
	
	public simpleGraph(int V) {
		if (V <= 0) throw new IllegalArgumentException("The graph must have at least one vertex");
		adj = (LinkedList<Integer>[]) new LinkedList[V]; // LinkedList is implemented by linked list
		for(int i = 0; i < V; i++) {
			adj[i] = new LinkedList<Integer>();
		}
		
		this.V = V;
		this.E = 0;
	}
	
	public void addEdge(int v, int w) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
        if (w < 0 || w >= V) throw new IndexOutOfBoundsException();
        E++;
		adj[v].add(w);
		adj[w].add(v);
	}
	
	public Iterable<Integer> adj(int v) {
		if (v < 0 || v >= V) throw new IndexOutOfBoundsException();
		return adj[v];
	}
	
	public Integer V() {
		return V;
	}
	
	public Integer E() {
		return E;
	}
	

}
