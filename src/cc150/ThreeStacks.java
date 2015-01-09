/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class ThreeStacks {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int capacity;
	int[] array;
	int[] top;
	
	public ThreeStacks(int capacity) {
		if(capacity <= 0) {
			throw new IllegalArgumentException();
		}
		
		this.capacity = capacity;
		array = new int[capacity * 3];
		top = new int[3];
		top[0] = 0;
		top[1] = capacity;
		top[2] = capacity * 2;
	}
	
	public ThreeStacks() {
		this(100);
	}
	
	public boolean isEmpty(int stackNum) {
		return top[stackNum - 1] == capacity * (stackNum - 1);
	}
	
	public int peek(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		return array[top[stackNum - 1] - 1];
	}
	
	public boolean isFull(int stackNum) {
		return top[stackNum - 1] >= capacity * stackNum;
	}
	
	public int pop(int stackNum) {
		if(isEmpty(stackNum)) {
			throw new EmptyStackException();
		}
		top[stackNum - 1]--;
		return array[top[stackNum - 1]];
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
	
	public void push(int stackNum, int value) {
		if(isFull(stackNum)) {
			throw new IllegalArgumentException("stack overflow");
		}
		array[top[stackNum - 1]] = value;
		top[stackNum - 1]++;
	}
	
}
