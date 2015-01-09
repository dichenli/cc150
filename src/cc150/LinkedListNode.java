/**
 * 
 */
package cc150;


/**
 * @author dichenli
 *
 */
public class LinkedListNode<T extends Comparable<T>> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	T value;
	LinkedListNode<T> next;

	LinkedListNode(T value) {
		this.next = null;
		this.value = value;
	}

	LinkedListNode() {
		this(null);
	}

	//for testing purpose
	public void printList() {
		for(LinkedListNode<T> ptr = this; ptr != null; ptr = ptr.next) {
			System.out.print(ptr.value + ", ");
		}
		System.out.println();
	}
}
