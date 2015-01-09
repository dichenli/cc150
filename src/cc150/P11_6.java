/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Given an MX N matrix in which each row and each column is 
 * sorted in ascending order, write a method to find an element.
 */
public class P11_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 4},
						  {2, 4, 8},
				          {6, 7, 9}};
		for(int i = 1; i <= 9; i++) {
			System.out.println(findElem(matrix, i));
		}
	}

	static class Point {
		int x;
		int y;
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public String toString() {
			return "(" + x + ", " + y + ")";
		}
	}
	
	public static Point findElem(int[][] matrix, int key) {
		if(matrix.length <= 0 || matrix[0].length <= 0) {
			return null;
		}
		
		int rows = matrix.length;
		int cols = matrix[0].length;
		int y = rows - 1;
		int x = 0;
		
		while(x < cols && y >= 0) {
			if(matrix[y][x] == key) {
				return new Point(x, y);
			}
			else if (matrix[y][x] < key) {
				x++;
			} else if (matrix[y][x] > key) {
				y--;
			}
		}
		
		return null;
	}
}
