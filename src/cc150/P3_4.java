/**
 * 
 */
package cc150;
import java.util.Hashtable;
import java.util.Stack;
/**
 * @author dichenli
 *
 */
public class P3_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P3_4 a = new P3_4();
		a.hanoi(9);
	}

	Hashtable<Integer, String> positions;
	
	private class Move {
		int from;
		int to;
		int mid;
		int plates;

		Move(int from, int to, int plates) {
			// from, to and mid are one of 1, 2, 3. 
			// It's private class so it's my own responsibility 
			// to make sure this is true
			this.from = from;
			this.to = to;
			this.mid = 6 - from - to; 
			this.plates = plates;
		}
	}
	
	public void hanoi(int plates) {
		positions = new Hashtable<Integer, String>();
		positions.put(1, "left");
		positions.put(2, "middle");
		positions.put(3, "right");
		
		Stack<Move> stack = new Stack<Move>();
		stack.push(new Move(1, 3, plates));

		while(!stack.isEmpty()) {
			Move move = stack.pop();
			if(move.plates == 1) {
				printMove(move);
			} else {
				stack.push(new Move(move.mid, move.to, move.plates - 1));
				stack.push(new Move(move.from, move.to, 1));
				stack.push(new Move(move.from, move.mid, move.plates - 1));
			}
		}
	}

	private void printMove(Move move) {
		System.out.println("Move one plate from " + 
						positions.get(move.from) + 
						" to " + 
						positions.get(move.to));
	}
}
