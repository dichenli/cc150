/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Imagine you have a square matrix, where each cell (pixel) is either black or white. Design an algorithm to find the maximum subsquare such that all four borders are filled with black pixels.
 */
public class P18_11 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a1 = {
				{B, B, B, B},
				{B, W, B, W},
				{B, B, B, B},
				{W, W, B, B}};
		System.out.println(findLargest(a1));
		
		int[][] a2 = {
				{B, B, B, B},
				{B, W, B, W},
				{B, W, B, B},
				{W, W, B, B}};
		System.out.println(findLargest(a2));
		
		int[][] a3 = {
				{B}};
		System.out.println(findLargest(a3));
		
		int[][] a4 = {
				{W}};
		System.out.println(findLargest(a4));
		
		int[][] a5 = {
				{B, B, B, B},
				{B, B, B, B},
				{B, B, B, B},
				{B, B, B, B}};
		System.out.println(findLargest(a5));
	}
	
	public static final int BLACK = 1;
	public static final int WHITE = 0;
	public static final int B = BLACK;
	public static final int W = WHITE;
	
	static class Square {
		int row;
		int col;
		int length;
		Square(int row, int col, int length) {
			this.row = row;
			this.col = col;
			this.length = length;
		}
		
		@Override
		public String toString() {
			return "(" + row + ", " + col + ") " + "length: " + length;
		}
	}
	
	public static Square findLargest(int[][] square) {
		if(square == null || square.length <= 0 || square[0].length != square.length) {
			return null;
		}
		
		int len = square.length;
		int[][] rightBlack = new int[len][len];
		int[][] downBlack = new int[len][len];
		
		for(int i = len - 1; i >= 0; i--) {
			int countRow = 0;
			for(int j = len - 1; j >= 0; j--) {
				if(square[i][j] == BLACK) {
					countRow++;
				} else {
					countRow = 0;
				}
				rightBlack[i][j] = countRow;
			}
		}
		
		for(int i = len - 1; i >= 0; i--) {
			int countCol = 0;
			for(int j = len - 1; j >= 0; j--) {
				if(square[j][i] == BLACK) {
					countCol++;
				} else {
					countCol = 0;
				}
				downBlack[j][i] = countCol;
			}
		}
		
		//max[i][j]: record the max size all-black square with this cell as top left corner
		int[][] max = new int[len][len];
		for(int i = len - 1; i >= 0; i--) {
			Arrays.fill(max[i], 0);
		}
		int maxLen = 0;
		int maxRow = 0;
		int maxCol = 0;
		
		//Time complexity is O(N^3) but it's deeply optimized (with loss of readability) that its real performance will be very close to O(N^2)
		for(int i = 0; i < len; i++) {//each row, from top to bottom
			for(int j = len - 1; j >= 0; j--) {//each column, from right to left
				//downBlack[i][j]: a given place has so many consecutive cells at & below it that are black
				if(downBlack[i][j] > maxLen) {
					//iterate through all downBlack[i][j] number of cells left of cell(i, j) that are black. 
					//leftTopCol: the cell(i, leftTopCol) is on the left of cell(i, j), and their distance is smaller than downBlack[i][j]
					for(int leftTopCol = j; leftTopCol >= j - downBlack[i][j] + 1 
					&& leftTopCol >= 0 && square[i][leftTopCol] == BLACK; leftTopCol--) {
						//The cell(i, j) and cell(i, leftTopCol) compose the top edge of a candidate square. The next job is to confirm it's a square that all composed of black edges
						//leftBottomRow: the row number of the cell on the left bottom corner of the candidate square
						int leftBottomRow = i - leftTopCol + j;
						int candidateLen = j - leftTopCol + 1;
						//this if-statement checks if the candidate square is a real all-black square
						if(max[i][leftTopCol] < candidateLen && downBlack[i][leftTopCol] >= candidateLen 
						&& leftBottomRow >= 0 && rightBlack[leftBottomRow][leftTopCol] >= candidateLen) {
							max[i][leftTopCol] = candidateLen;
							if(downBlack[i][j] > maxLen) {
								maxLen = candidateLen;
								maxRow = i;
								maxCol = leftTopCol;
							}
						}
					}
				}
			}
		}
		
		return new Square(maxRow, maxCol, maxLen);
	}
	
}
