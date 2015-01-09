/**
 * 
 */
package cc150;

import cc150.P1_5.Solution1;

/**
 * @author dichenli
 * Given an image represented by an NxN matrix, 
 * where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. 
 * Can you do this in place?
 */
public class P1_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Solution1 s1 = new P1_6().new Solution1();
		long[][] pixels1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		long[][] pixels2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {0, 1, 2, 3}, {4, 5, 6, 7}};
		s1.rotate(pixels1);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				System.out.print(pixels1[i][j]);
			}
			System.out.println();
		}
		s1.rotate(pixels2);
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				System.out.print(pixels2[i][j]);
			}
			System.out.println();
		}
	}

	//here I assume the input is a (long int)[N][N] array (4 bytes each long). 
	//The rotation is clockwise, the screen is cubic
	class Solution1 {

		public long[][] rotate(long[][] pixels) {
			int n = pixels.length;
			if(n <= 1 || n != pixels[0].length) {
				return pixels;
			}
			n--;

			for(int i = 0; i <= n / 2; i++) {
				for(int j = 0; j <= (n - 1) / 2; j++) {
					exchange(pixels, i, j, n);
				}
			}

			return pixels;
		}

		private void exchange(long[][] pixels, int y, int x, int n) {
			long temp            = pixels[y][x];
			pixels[y][x]         = pixels[n - x][y];
			pixels[n - x][y]     = pixels[n - y][n - x];
			pixels[n - y][n - x] = pixels[x][n - y];
			pixels[x][n - y]     = temp;
		}
	}

	//the solution on the book
	class Solution2 {
		public void rotate(int[][] matrix, int n) {
			for (int layer = 0; layer < n / 2; ++layer) {
				int first =layer;
				int last = n - 1 - layer;
				for(int i = first; i < last; ++i) {
					int offset = i - first; // savetop
					int top = matrix[first][i];
					// left -> top
					matrix[first][i] = matrix[last-offset][first];
					// bottom -> left
					matrix[last-offset][first] = matrix[last][last - offset];
					// right -> bottom
					matrix[last][last - offset] = matrix[i][last];
					// top -> right
					matrix[i][last] = top ;

				}  
			}
		}
	}
}
