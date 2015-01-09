/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * You have two numbers represented by a linked list, 
 * where each node contains a single digit. 
 * The digits are stored in reverse order, 
 * such that the 1's digit is at the head of the list. 
 * Write a function that adds the two numbers 
 * and returns the sum as a linked list.
 * FOLLOW UP
 * Suppose the digits are stored in forward order. 
 * Repeat the above problem.
 */
public class P2_5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution1();
		solution2();
	}

	public static void solution1() {
		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list1.append(9);
		list1.append(9); //list1 is 99
		list2.append(1);
		list2.append(0);
		list2.append(9); //list2 is 901

		LinkedListNode<Integer> sum = list1.addNumberReverse(list1.getHead(), list2.getHead());
		sum.printList();
	}
	
	//follow up question
	public static void solution2() {
		MyLinkedList<Integer> list1 = new MyLinkedList<Integer>();
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list1.append(9);
		list1.append(9); //list1 is 99
		list2.append(9);
		list2.append(0);
		list2.append(1); //list2 is 901

		LinkedListNode<Integer> sum = list1.addNumber(list1.getHead(), list2.getHead());
		sum.printList();
	}
}
