/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Write code to partition a linked list around a value x, 
 * such that all nodes less than x come before alt nodes 
 * greater than or equal to x.
 */
public class P2_4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution1();
	}

	public static void solution1() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.append(4);
		list.append(5);
		list.append(3);
		list.append(1);
		list.append(2);
		list.partitionLinkedList(3);
		list.printList();
		
		list = new MyLinkedList<Integer>(1);
		list.partitionLinkedList(3);
		list.printList();
	}
}
