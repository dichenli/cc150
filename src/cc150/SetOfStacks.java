/**
 * 
 */
package cc150;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author dichenli
 * P3_3
 * Imagine a (literal) stack of plates. If the stack gets too high, 
 * it migh t topple. Therefore, in real life, we would likely start 
 * a new stack when the previous stack exceeds some threshold. 
 * Implement a data structure SetOfStacks that mimics this. 
 * SetOf- Stacks should be composed of several stacks and should 
 * create a new stack once the previous one exceeds capacity. 
 * SetOfStacks.push() and SetOfStacks. pop() should behave identically 
 * to a single stack (that is, pop() should return the same values
 * as it would if there were just a single stack).
 * FOLLOW UP
 * Implement a function popAt(int index) which performs a pop operation 
 * on a specific sub-stack.
 */
public class SetOfStacks<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P3_3.main(null);
	}
	
	ArrayList<Stack<T>> stackList;
	Stack<T> top;
	final int capacity;
	
	SetOfStacks(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.capacity = capacity;
		stackList = new ArrayList<Stack<T>>();
		top = new Stack<T>();
		stackList.add(top);
	}
	
	SetOfStacks() {
		this(2);
	}
	
	public T push(T value) {
		if(top.size() >= capacity) {
			top = new Stack<T>();
			stackList.add(top);
		}
		return top.push(value);
	}
	
	private void removeEmpty() {
		while(top.isEmpty() && stackList.size() > 1) {
			stackList.remove(top);
			top = stackList.get(stackList.size() - 1);
		}
	}
	
	public T pop() {
		removeEmpty();
		return top.pop();
	}
	
	public boolean isEmpty() {
		removeEmpty();
		return top.isEmpty();
	}
	
	public T peek() {
		removeEmpty();
		return top.peek();
	}
	
	public T popAt(int index) {
		Stack<T> stack = stackList.get(index);
		return stack.pop();
	}
}
