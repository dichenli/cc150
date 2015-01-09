/**
 * 
 */
package P8_6;

/**
 * @author dichenli
 * a puzzle piece class
 */
public abstract class Piece {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	int edges; 
	
	Piece() {}
	
	public abstract boolean fitWith(Piece piece);
	
	public boolean isDone() {
		return edges == 0;
	}
	
}
