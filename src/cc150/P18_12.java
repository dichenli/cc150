/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given an NxN matrix of positive and negative integers, write code to find the submatrix with the largest possible sum.
 */
public class P18_12 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] matrix = {
				{ 1,  2, -2},
				{-5,  1,  3},
				{ 2,  0,  4}};
		System.out.println(findMax(matrix));
		
		int[][] matrix2 = {
				{ 1,  2, -2},
				{ 3, -2,  2},
				{ 2,  0,  1}};
		System.out.println(findMax(matrix2));

		int[][] matrix3 = { //overflow
				{Integer.MIN_VALUE, Integer.MIN_VALUE},
				{Integer.MIN_VALUE, Integer.MIN_VALUE}};
		System.out.println(findMax(matrix3));
	}
	
	static class Matrix {
		int x; //the left top corner coordinates x and y of the sub matrix
		int y; //x is column coordinate, y is row coord
		int rows;
		int cols;
		int sum;
		Matrix(int x, int y, int rows, int cols, int sum) {
			this.x = x;
			this.y = y;
			this.rows = rows;
			this.cols = cols;
			this.sum = sum;
		}
		
		@Override
		public String toString() {
			return "coordinate: (" + x + ", " + y + "), rows: " + rows + ", cols: " + cols + ", sum: " + sum;
		}
	}
	
	public static Matrix findMax(int[][] matrix) {
		if(matrix == null || matrix.length <= 0 || matrix.length != matrix[0].length) {
			return null;
		}
		
		Matrix maxMat = new Matrix(0, 0, 0, 0, Integer.MIN_VALUE);
		int n = matrix.length;
		
		//sum of a column of certain length
		int[][] sumCol = new int[n][n];
		for(int i = 0; i < n; i++) {
			Arrays.fill(sumCol[i], 0);
		}
//		int[][] maxSubMat = new int[n][n];
//		for(int i = 0; i < n; i++) {
//			Arrays.fill(maxSubMat[i], Integer.MIN_VALUE);
//		}
		
		//loop by rowSpan: find submatrix only of given number of rows 
		//(rowSpan + 1 is the number of rows of submatrix in current loop)
		for(int rowSpan = 0; rowSpan < n; rowSpan++) {
			for(int i = 0; i < n - rowSpan; i++) {
				for(int j = 0; j < n; j++) {
					sumCol[i][j] = sumCol[i][j] + matrix[i + rowSpan][j];
				}
			}
			
			for(int i = 0; i < n - rowSpan; i++) {
				int preSum = 0;
				int start = 0;
				for(int j = 0; j < n; j++) {
					int currMaxSum = 0;
					if(preSum > 0) {
						currMaxSum = sumCol[i][j] + preSum;
					} else {
						currMaxSum = sumCol[i][j];
						start = j;
					}
					preSum = currMaxSum;
//					if(currMaxSum > maxSubMat[i][j]) {
//						maxSubMat[i][j] = currMaxSum;
//					}
					if(currMaxSum > maxMat.sum) {
						maxMat.sum = currMaxSum;
						maxMat.cols = j - start + 1;
						maxMat.rows = rowSpan + 1;
						maxMat.x = start;
						maxMat.y = i;
					}
				}
			}
		}
		
		return maxMat;
	}
	
	

}
