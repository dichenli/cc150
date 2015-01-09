/**
 * 
 */
package cc150;
import java.util.Queue;
import java.util.LinkedList;
/**
 * @author dichenli
 * Implement a MyQueue class which implements a queue using two stacks.
 */
public class P3_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// a stack is available in java.util, but a queue is not!
		// you need a class like LinkedList or ArrayDeque that implements it
		Queue<Integer> q = new LinkedList<Integer>();
		QueueByStack<Integer> qs = new QueueByStack<Integer>();
		q.add(1);
		qs.add(1);
		System.out.println(q.poll());
		System.out.println(qs.poll());
		System.out.println(q.peek());
		System.out.println(qs.peek());
		System.out.println(q.poll());
		System.out.println(qs.poll());
		q.add(2);
		qs.add(2);
		q.add(3);
		qs.add(3);
		q.add(4);
		qs.add(4);
		System.out.println(q.poll());
		System.out.println(qs.poll());
		System.out.println(q.poll());
		System.out.println(qs.poll());
		System.out.println(q.poll());
		System.out.println(qs.poll());
	}
	
	
}
