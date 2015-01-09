/**
 * 
 */
package cc150;

import cc150.P1_6.Solution1;

/**
 * @author dichenli
 *
 */
public class P1_7 {

	/**
	 * P1.7 Write an algorithm such that if an element in an MxN matrix is 0, 
	 * its entire row and column are set to 0
	 * @param args
	 */
	public static void main(String[] args) {
		Solution1 s1 = new P1_7().new Solution1();
		int[][] pixels1 = {{0, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] pixels2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {0, 0, 0, 0}};
		
		s1.setZero(pixels1);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(pixels1[i][j]);
			}
			System.out.println();
		}
		
		s1.setZero(pixels2);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(pixels2[i][j]);
			}
			System.out.println();
		}

	}

	class Solution1 {
		public int[][] setZero(int[][] matrix) {
			int m = matrix.length;
			if(m <= 0) {
				return matrix;
			}
			int n = matrix[0].length;
			if(n <=0) {
				return matrix;
			}
			
			boolean[] zeroRows = new boolean[m];
			boolean[] zeroCols = new boolean[n];
			for(int i = 0; i < m; i++) { 
				zeroRows[i] = false;
			}
			for(int j = 0; j < n; j++) {
				zeroCols[j] = false;
			}
			
			for(int i = 0; i < m; i++) {
				for(int j = 0; j < n; j++) {
					if(matrix[i][j] == 0) {
						zeroRows[i] = true;
						zeroCols[j] = true;
					}
				}
			}
			
			for(int i = 0; i < m; i++) {
				if(zeroRows[i]) {
					for(int j = 0; j < n; j++) {
						matrix[i][j] = 0;
					}
				}
			}
			
			for(int j = 0; j < n; j++) {
				if(zeroCols[j]) {
					for(int i = 0; i < m; i++) {
						matrix[i][j] = 0;
					}
				}
			}
			
			return matrix;
		}
	}
}
