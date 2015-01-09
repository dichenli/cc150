/**
 * 
 */
package cc150;

import java.util.*;

/**
 * @author dichenli
 * P14_6
 * Implement a CircularArray class that supports an array-like 
 * data structure which can be efficiently rotated. The class 
 * should use a generic type, and should support iteration 
 * via the standard for (Obj o : circuLarArray) notation.
 */

//I implemented a linked list instead. The book method for circular array is good
//The iterator class creation is nice example
public class CircularLinkedList<E> implements Iterable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(-4 % 3);
	}
	
	private class Node {
		E value;
		Node next;
		private Node(E value) {
			this.value = value;
			this.next = null;
		}
	}

	Node dummy;
	Node tail;
	int size;
	
	CircularLinkedList() {
		this.dummy = new Node(null);
		dummy.next = dummy;
		this.tail = dummy;
		this.size = 0;
	}
	
	private void insertAfter(E elem, Node node) {
		Node temp = new Node(elem);
		temp.next = node.next;
		node.next = temp;
		size++;
	}
	
	public void add(E elem) {
		insertAfter(elem, tail);
		tail = tail.next;
	}
	
	//add to the head of array
	public void push(E elem) {
		insertAfter(elem, dummy);
	}
	
	public void insert(E elem, int index) {
		if(index == size || size == 0) {
			add(elem);
		}

		Node ptr = getPrevNode(index);
		insertAfter(elem, ptr);
	}
	
	public E get(int index) {
		return getNode(index).value; //will return null if empty since dummy.value == null
	}
	
	public void remove(int index) {
		if(size == 0) {
			return;
		}
		Node ptr = getPrevNode(index);
		if(ptr.next == tail) {
			tail = ptr;
		}
		ptr.next = ptr.next.next;
		size--;
	}
	
	public boolean isEmpty() {
		return tail == dummy;
	}
	
	public int size() {
		return size;
	}
	
	public void remove() {
		remove(-1);
	}
	
	private Node getPrevNode(int index) {
		return index == 0? dummy : getNode(index - 1);
	}
	
	private Node getNode(int index) {
		while(index < 0) {
			index += size;
		}
		index %= size;
		
		Node ptr = dummy;
		for(int count = index; count >= 0; count--) {
			ptr = ptr.next;
		}
		return ptr;
	}
	
	public void shiftRight(int offset) {
		if(offset < 0) {
			shiftLeft(-offset);
			return;
		}
		offset = offset % size;
		tail.next = dummy.next;
		for(int i = 0; i < offset; i++) {
			tail = tail.next;
		}
		
		dummy.next = tail.next;
		tail.next = dummy;
	}
	
	public void shiftLeft(int offset) {
		if(offset < 0) {
			shiftRight(-offset);
			return;
		}
		offset = size - offset % size;
		shiftRight(offset);
	}

	@Override
	public Iterator<E> iterator() {
		ArrayList<E> list = new ArrayList<E>();
		for(Node n = dummy.next; n != dummy; n = n.next) {
			list.add(n.value);
		}
		return list.iterator();
	}
}
