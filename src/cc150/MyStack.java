/**
 * 
 */
package cc150;

import java.util.EmptyStackException;

/**
 * @author dichenli
 *
 */
public class MyStack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int[] array;
	int capacity;
	int top;
	
	public MyStack(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.capacity = capacity;
		array = new int[capacity];
		top = 0;
	}
	
	public MyStack() {
		this(100);
	}
	
	public boolean isEmpty() {
		return top == 0;
	}
	
	public int peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return array[top - 1];
	}
	
	public boolean isFull() {
		return top >= capacity;
	}
	
	public int pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		top--;
		return array[top];
	}
	
	public void printList() {
		for(int i = 0; i < 3 * capacity; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println();
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public void push(int value) {
		if(isFull()) {
			throw new IllegalArgumentException("stack overflow");
		}
		array[top] = value;
		top++;
	}
}
