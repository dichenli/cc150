/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * How would you design a stack which, 
 * in addition to push and pop, also has a function min 
 * which returns the minimum element? Push, pop and min 
 * should all operate in 0(1) time.
 */
public class P3_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(0);
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.min());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		MinStack2 stack2 = new MinStack2();
		stack2.push(1);
		stack2.push(2);
		stack2.push(3);
		stack2.push(0);
		System.out.println(stack2.min());
		System.out.println(stack2.pop());
		System.out.println(stack2.min());
		System.out.println(stack2.pop());
		System.out.println(stack2.min());
		System.out.println(stack2.pop());
		System.out.println(stack2.pop());
	}
}
