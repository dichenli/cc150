/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 *
 */
public class MyHashTable<Key, Value> {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private class Node<Key, Value> {
		Key key;
		Value value;
		
		Node(Key key, Value value) {
			this.key = key;
			this.value = value;
		}
	}
	
	LinkedList<Node<Key, Value>>[] items;
	int maxSize;
	
	public MyHashTable(int size) {
		maxSize = size;
		//you can't create an array with generics, you have to create an array 
		//of none-generics and cast it to the type you need
		items = (LinkedList<Node<Key, Value>>[]) new LinkedList[maxSize];
	}
	
	public MyHashTable() {
		this(10);
	}
	
	public int hashCodeOfKey(Key key) {
		return key.toString().length() % maxSize;
	}
	
	public void put(Key key, Value value) {
		LinkedList<Node<Key, Value>> list = items[hashCodeOfKey(key)];
		if(list == null) {
			list = new LinkedList<Node<Key, Value>>();
		}
		
		for(Node<Key, Value> node : list) {
			if(node.key == key) {
				list.remove(node);
				break;
			}
		}
		
		list.add(new Node(key, value));
	}
	
	public Value get(Key key) {
		int code = hashCodeOfKey(key);
		if(items[code] == null) {
			return null;
		}
		
		for(Node<Key, Value> node : items[code]) {
			if(node.key == key) {
				return node.value;
			}
		}
		return null;
	}
}
