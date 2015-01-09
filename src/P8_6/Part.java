/**
 * 
 */
package P8_6;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class Part extends Piece {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	ArrayList<SinglePiece> pieces;
	
	Part(SinglePiece p1, SinglePiece p2) {
		pieces = new ArrayList<SinglePiece>();
		pieces.add(p1);
		pieces.add(p2);
	}
	
	@Override
	public boolean fitWith(Piece piece) {
		for(Piece p : pieces) {
			if(p.fitWith(piece)) {
				if(p instanceof SinglePiece) {

				}
				return true;
			}
		}
		return false;
	}

	public void joins(Piece other) {
		if(other instanceof SinglePiece) {
			for(SinglePiece p : pieces) {
				if(p.fitWith(other)) {
					p.joins(other);
				}
			}
		} else if(other instanceof Part) {
			for(SinglePiece p : ((Part) other).pieces) {
				this.joins(p);
			}
		}
	}
}
