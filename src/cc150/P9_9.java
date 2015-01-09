/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write an algorithm to print all ways of arranging 
 * eight queens on an 8x8 chess board so that none of 
 * them share the same row, column or diagonal. 
 * In this case, "diagonal" means all diagonals, not 
 * just the two that bisect the board.
 */
public class P9_9 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		printNQueens(8);
	}

	private static class Cell {
		int col;
		int row;
		Cell (int row, int col) {
			this.col = col;
			this.row = row;
		}
	}

	public static void printNQueens(int n) {
		Stack<Cell> result = new Stack<Cell>();
		boolean[][] board = new boolean[n][n]; //available spots
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = true;
			}
		}

		findNQueens(n, 0, board, result);
	}

	private static void findNQueens(int n, int row, boolean[][] board, Stack<Cell> result) {
		for(int col = 0; col < n; col++) {
			if(board[row][col]) { //the cell on board is available
				Cell queen = new Cell(row, col);
				result.push(queen);
				Stack<Cell> fliped = new Stack<Cell>();
				fliped = flipboard(n, board, queen, fliped);

				if(row == n - 1) { //find an answer
					printResult(n, result);
				} else { //recursive call
					findNQueens(n, row + 1, board, result);
				} 

				//remove the queen and reverse the marked cells on board
				flipBack(board, fliped);
				result.pop();
			}
		}
	}

	private static Stack<Cell> flipboard(int n, boolean[][] board, Cell queen, Stack<Cell> fliped) {
		for(int i = queen.row + 1; i < n; i++) {
			for(int j = 0; j < n; j++) {
				Cell thisCell = new Cell(i, j);
				if(board[i][j] == true && conflict(queen, thisCell)) {
					board[i][j] = false;
					fliped.push(thisCell);
				}
			}
		}
		return fliped;
	}

	private static boolean[][] flipBack(boolean[][] board, Stack<Cell> fliped) {
		while(!fliped.isEmpty()) {
			Cell cell = fliped.pop();
			board[cell.row][cell.col] = true;
		}
		return board;
	}

	private static void printResult(int n, Stack<Cell> result) {
		int[][] board = new int[n][n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				board[i][j] = 0;
			}
		}
		
		for(Cell c : result) {
			board[c.row][c.col] = 1;
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(" " + board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static boolean conflict(Cell c1, Cell c2) {
		if (c1.col == c2.col || c1.row == c2.row) {
			return true;
		} else {
			return Math.abs(c1.col - c2.col) == Math.abs(c1.row - c2.row);
		}
	}
}
