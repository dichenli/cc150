/**
 * 
 */
package cc150;

import java.util.Stack;

/**
 * @author dichenli
 * for problem P3_2
 * Improvements over MinStack. This stack only push to a min stack when pushed value <= min.peek()
 */
public class MinStack2<T extends Comparable<T>> extends Stack<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Stack<T> min;
	
	public MinStack2() {
		min = new Stack<T>();
	}
	
	public T min() {
		return min.peek();
	}
	
	@Override
	public T push(T value) {
		if(min.isEmpty() || value.compareTo(min()) <= 0) {
			min.push(value);
		}
		return super.push(value);
	}
	
	@Override
	public T pop() {
		T value = super.pop();
		if(value.compareTo(min()) == 0) {
			min.pop();
		}
		return value;
	}
}
