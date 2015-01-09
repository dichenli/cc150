/**
 * 
 */
package cc150;



/**
 * @author dichenli
 * Implement an algorithm to find the kth to last element 
 * of a singly linked list.
 */
public class P2_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P2_2 a = new P2_2();
		a.solution();
	}

	//see MyLinkedList for its solution
	public void solution() {
		MyLinkedList<Integer> list = new MyLinkedList<Integer>();
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		System.out.println(list.kthToLast(1));
		System.out.println(list.kthToLast(5));
		list.printList();
		
		MyLinkedList<Integer> list2 = new MyLinkedList<Integer>();
		list2.append(1);
		System.out.println(list2.kthToLast(1));
		System.out.println(list2.kthToLast(2));
	}
}
