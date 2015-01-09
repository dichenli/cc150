/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given a directed graph, design an algorithm to find out 
 * whether there is a route between two nodes.
 */
public class P4_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DiGraph<Integer> g = new DiGraph<Integer>();
		for(Integer i = 1; i < 7; i++) {
			g.addVertex(i);
		}
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(4, 5);
		
		System.out.println(g.hasRoute(1, 5));
		System.out.println(g.hasRoute(5, 1));
		System.out.println(g.hasRoute(1, 6));
	}
}
