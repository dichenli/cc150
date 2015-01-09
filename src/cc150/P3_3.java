/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Imagine a (literal) stack of plates. If the stack gets too high, 
 * it might topple. Therefore, in real life, we would likely start 
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
public class P3_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SetOfStacks<Integer> s = new SetOfStacks<Integer>();
		System.out.println(s.isEmpty());
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(6);
		System.out.println(s.pop());
		System.out.println(s.popAt(1));
		System.out.println(s.popAt(1));
		System.out.println(s.pop());
		System.out.println(s.peek());
		System.out.println(s.pop());
	}

}
