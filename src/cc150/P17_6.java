/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Given an array of integers, write a method to find indices mand n such that if you sortedelementsmthroughn,theentirearraywouldbesorted.Minimizen - m(that is, find the smallest such sequence).
 */
public class P17_6 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] a = {{1, 2, 1, 4}, {1, 2, 3, 4}, {4, 3, 2, 1}, {1}};
		for( int i = 0; i < a.length; i++) {
			System.out.print(Arrays.toString(a[i]));
			System.out.println(findSubToSort(a[i]));
		}
	}
	
	static class Result {
		int m, n;
		Result(int m, int n) {
			this.m = m;
			this.n = n;
		}
		
		@Override
		public String toString() {
			return "Needs sort from " + m + " to " + n;
		}
	}
	
	//this solution uses stack. There are extra space of O(n). The method
	//is not so easy to understand, too. The method on the book is better
	//in that it uses O(1) extra space. Time complexity is O(N) for both methods
	public static Result findSubToSort(int[] array) {
		if(array.length <= 0) {
			return null;
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(0);
		int i, m, n;
		for(i = 1; i < array.length; i++) {
			while(!stack.isEmpty() && array[i] < array[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				break;
			}
			if(i - stack.peek() == 1) {
				stack.push(i);
			}
		}
		m = stack.isEmpty() ? 0 : stack.pop() + 1;
		
		stack = new Stack<Integer>();
		stack.push(array.length - 1);
		for(i = array.length - 2; i >= m; i--) {
			while(!stack.isEmpty() && array[i] > array[stack.peek()]) {
				stack.pop();
			}
			if(stack.isEmpty()) {
				return new Result(m, array.length - 1);
			}
			if(i - stack.peek() == -1) {
				stack.push(i);
			}
		}
		
		n = stack.pop() - 1;
		if(n < m) {
			n = m;
		}
		return new Result(m, n);
	}

}
