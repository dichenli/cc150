/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Design an algorithm to figure out if someone has won a game oftic-tac-toe.
 */
public class P17_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int winTTT(int[][] board) {
		if(board.length != 3 || board[0].length != 3) {
			throw new IllegalArgumentException();
		}
		
		for(int i = 0; i < 3; i++) {
			int row = board[i][0] + board[i][1] + board[i][2];
			int col = board[0][i] + board[1][i] + board[2][i];
			if(row == 3 || col == 3) {
				return 1;
			} else if(row == -3 || col == -3) {
				return -1;
			}
		}
		int diag1 = board[0][0] + board[1][1] + board[2][2];
		int diag2 = board[2][0] + board[1][1] + board[0][2];
		if(diag1 == 3 || diag2 == 3) {
			return 1;
		} else if (diag1 == -3 || diag2 == -3) {
			return -1;
		} else {
			return 0;
		}
	}
}
