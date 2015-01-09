/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class DiGraph<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Hashtable<T, Vertex<T>> vertices;
	ArrayList<Edge<T>> edges;//redundant actually
	
	public DiGraph() {
		vertices = new Hashtable<T, Vertex<T>>();
		edges = new ArrayList<Edge<T>>();
	}
	
	public void addVertex(T key){
		vertices.put(key, new Vertex(key));
	}
	
	public boolean hasEdge(T from, T to) {
		return findEdge(from, to) != null;
	}
	
	private Edge<T> findEdge(T from, T to) {
		Vertex<T> v = vertices.get(from);
		for(Edge<T> e : v.getEdges()) {
			Vertex<T> w = e.getTo();
			if(w.getKey().equals(to)) {
				return e;
			}
		}
		return null;
	}
	
	public void addEdge(T from, T to, int weight) {
		Vertex<T> vFrom = vertices.get(from);
		Vertex<T> vTo = vertices.get(to);
		Edge<T> edge = findEdge(from, to);
		if(edge == null) {
			edge = new Edge<T>(vFrom, vTo, weight);
			edges.add(edge);
			vFrom.addEdge(edge);
		} else {
			edge.setWeight(weight);
		}
	}
	
	public void addEdge(T from, T to) {
		addEdge(from, to, 1);
	}
	
	public int sizeVertex() {
		return vertices.size();
	}
	
	public int sizeEdge() {
		return edges.size();
	}
	
	public Iterable<T> vertices() {
		return Collections.list(vertices.keys());
	}
	
	public Iterable<T> adj(T key) {
		Iterable<Edge<T>> edges = vertices.get(key).getEdges();
		ArrayList<T> adj = new ArrayList<T>();
		for(Edge<T> e : edges) {
			adj.add(e.getTo().getKey());
		}
		return adj;
	}
	
	//P4_2, use BFS to find whether there is a route
	public boolean hasRoute(T from, T to) {
		LinkedList<T> queue = new LinkedList<T>();
		Hashtable<T, Boolean> visited = new Hashtable<T, Boolean>();
		
		//mark all as unvisited
		for(T v : vertices()) {
			visited.put(v, false);
		}
		
		queue.add(from);
		
		while(!queue.isEmpty()) {
			T v = queue.poll();
			visited.put(v, true);
			for(T w : adj(v)) {
				if(w == to) { // find destination vertex
					return true;
				}
				if(!visited.get(w)) {
					queue.add(w);
				}
			}
		}
		
		return false;
	}
}
