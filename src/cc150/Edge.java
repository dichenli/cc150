/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * part of Digraph component, an edge between two vertices, and a weight to represent distance
 */
public class Edge<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private final Vertex<T> from, to;
	private int weight;
	
	public Edge(Vertex<T> from, Vertex<T> to, int weight) {
		if(from == null || to == null) {
			throw new IllegalArgumentException();
		}
		
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public Edge(Vertex<T> from, Vertex<T> to) {
		this(from, to, 1);
	}
	
	public Vertex<T> getFrom() {
		return from;
	}
	
	public Vertex<T> getTo() {
		return to;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
