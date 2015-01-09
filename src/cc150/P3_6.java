/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * Write a program to sort a stack in ascending order 
 * (with biggest items on top). You may use at most one 
 * additional stack to hold items, but you may not copy 
 * the elements into any other data structure (such as an array). 
 * The stack supports the following operations: push, pop, peek, 
 * and isEmpty.
 */
public class P3_6<T extends Comparable<T>> {

	/**
	 * @param args
	 * This algorithm is0(N2) time and 0(N) space.
If we were allowed to use unlimited stacks, we could implement a modified quicksort or mergesort.
With the mergesort solution, we would create two extra stacks and divide the stack into two parts. We would recursively sort each stack, and then merge them back together in sorted order into the original stack. Note that this would require the creation of two additional stacks per level of recursion.
With the quicksort solution, we would create two additional stacks and divide the stack into the two stacks based on a pivot element. The two stacks would be recursively sorted, and then merged back together into the original stack. Like the earlier solution, this one involves creatingtwo additional stacks per level of recursion.
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P3_6<Integer> a = new P3_6();
		Stack<Integer> stack = new Stack();
		stack.push(3);
		stack.push(2);
		stack.push(5);
		stack.push(1);
		stack.push(3);
		a.sortStack(stack);
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	private boolean readyToPush(T elem, Stack<T> stack2) {
		return stack2.isEmpty() || elem.compareTo(stack2.peek()) >= 0;
	}
	
	public void sortStack(Stack<T> stack1) {
		Stack<T> stack2 = new Stack<T>();
		
		//stack2 keeps descending order
		//stack1 spills to stack2, but swallows back from stack2
		//whenever the order in stack2 is incorrect
		while(!stack1.isEmpty()) {
			T elem = stack1.pop();
			if(readyToPush(elem, stack2)) {
				stack2.push(elem);
			} else {
				while(!readyToPush(elem, stack2)) {
					stack1.push(stack2.pop());
				}
				stack2.push(elem);
			}
		}
		
		//spill stack2 back to stack1, so stack1 is in ascending order
		while(!stack2.isEmpty()) {
			stack1.push(stack2.pop());
		}
	}
}
