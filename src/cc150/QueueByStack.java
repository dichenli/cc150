/**
 * 
 */
package cc150;
import java.util.EmptyStackException;
import java.util.Stack;
import java.lang.Exception;
/**
 * @author dichenli
 * P3_5
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class QueueByStack<T> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Stack<T> inStack, outStack;
	int size;
	
	QueueByStack() {
		inStack = new Stack<T>();
		outStack = new Stack<T>();
	}
	
	public boolean isEmpty() {
		return inStack.isEmpty() && outStack.isEmpty();
	}
	
	public boolean add(T value) {
		inStack.push(value);
		return true;
	}
	
	public T poll() {
		carry();
		try {
			return outStack.pop();
		} catch (EmptyStackException e) {
			return null;
		}
	}
	
	private void carry() {
		if(outStack.isEmpty()) {
			while(!inStack.isEmpty()) {
				outStack.push(inStack.pop());
			}
		}
	}
	
	public T peek() {
		carry();
		try {
			return outStack.peek();
		} catch (EmptyStackException e) {
			return null;
		}
	}
	
	public int size() {
		return inStack.size() + outStack.size();
	}
}
