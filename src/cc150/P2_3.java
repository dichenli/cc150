/**
 * 
 */
package cc150;

/**
 * @author dichenli
 * Implement an algorithm to delete a node in the 
 * middle of a singly linked list, given only access to that node.
 */
public class P2_3 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		solution1();
	}
	
	public static void solution1() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		LinkedListNode<Integer> ptr = list.getHead();
		
		ptr = ptr.next.next;
		
		list.deleteThisNode(ptr);
		list.printList();
	}
}
