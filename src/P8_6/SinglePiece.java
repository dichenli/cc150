/**
 * 
 */
package P8_6;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class SinglePiece extends Piece {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int edges; //2: corner piece, 3: flat piece, 4: inner
	private int x; //x and y coordinates (that the puzzle solver won't know, but useful for the fitWith method)
	private int y;
	ArrayList<SinglePiece> joined;
	
	SinglePiece(int x, int y, int edges) {
		this.x = x;
		this.y = y;
		this.edges = edges;
		this.joined = new ArrayList<SinglePiece>();
	}
	
	public boolean fitWith(Piece piece) {
		//TODO
		return false;
	}
	
	public boolean isDone() {
		return edges == 0;
	}

	public void joins(Piece other) {
		if(other instanceof SinglePiece) {
			this.edges--;
			this.joined.add((SinglePiece) other);
			((SinglePiece) other).joins(this);
		} else if (other instanceof Part) {
//			other.joins(this);
		}
	}
}
