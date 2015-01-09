/**
 * 
 */
package cc150;

import java.util.EmptyStackException;

/**
 * @author dichenli
 * for problem P3_2
 * How would you design a stack which, 
 * in addition to push and pop, also has a function min 
 * which returns the minimum element? Push, pop and min 
 * should all operate in 0(1) time.
 */
public class MinStack extends MyStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//a min stack that grows and shrinks together with the value stack
	int[] min;
	
	public MinStack(int capacity) {
		super(capacity);
		min = new int[capacity];
	}
	
	public MinStack() {
		this(100);
	}
	
	@Override
	public void push(int value) {
		super.push(value);
		//top is at the first empty position, top - 1 is the position value just got pushed in
		if(super.top >= 2 && min[super.top - 2] <= value) {
			min[super.top - 1] = min[super.top - 2];
		} else {
			min[super.top - 1] = value;
		}
	}
	
	public int min() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return min[super.top - 1];
	}
}
