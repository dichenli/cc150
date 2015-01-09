/**
 * 
 */
package cc150;
import java.util.*;
/**
 * @author dichenli
 * An animal shelter holds only dogs and cats, and operates 
 * on a strictly "first in, first out" basis. People must 
 * adopt either the "oldest" (based on arrival time) of 
 * all animals at the shelter, or they can select whether
 * they would prefer a dog or a cat (and will receive the 
 * oldest animal of that type). They cannot select which 
 * specific animal they would like. Create the data 
 * structures to maintain this system and implement 
 * operations such as enqueue, dequeueAny, 
 * dequeueDog and dequeueCat. You may use the built-in LinkedList 
 * data structure.
 */
public class P3_7 {

	/**
	 * @param args
	 * a simpler (in thoughts) method is to keep three stacks, first two work cooperately 
	 * as a queue (as in P3_5), the third one keeps a temporary record
	 * of dequeued elements which are not the animal type we need
	 * But here I would do this problem using java LinkedList class as queue
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		P3_7 shelter = new P3_7();
		shelter.enqueue("dog", 1);
		shelter.enqueue("dog", 2);
		shelter.enqueue("cat", 3);
		shelter.enqueue("cat", 4);
		System.out.println(shelter.dequeueAny());
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter.dequeueCat());
		System.out.println(shelter.dequeueAny());
	}
	
	public class Animal {
		String species;
		int date;
		
		Animal(String species, int date) {
			this.species = species;
			this.date = date;
		}
		
		public boolean isCat() {
			return species == "cat";
		}
		
		public boolean isDog() {
			return species == "dog";
		}
		
		@Override
		public String toString() {
			return species + ", date: " + date;
		}
	}
	
	LinkedList<Animal> queue;
	Stack<Animal> buffer;
	
	P3_7() {
		queue = new LinkedList<Animal>();
		buffer = new Stack<Animal>();
	}
	
	public void enqueue(String species, int date) {
		queue.add(new Animal(species, date));
	}
	
	//return the oldest animal available. If none, return null
	public Animal dequeueAny() {
		return queue.poll();
	}
	
	//return the oldest cat available. If no cat, return null
	public Animal dequeueCat() {
		Animal cat = null;
		while(!(queue.isEmpty() || queue.peek().isCat())) {
			buffer.push(queue.poll());
		}
		if(!queue.isEmpty()) {
			cat = queue.poll();
		}
		
		while(!buffer.isEmpty()) {
			queue.addFirst(buffer.pop());
		}
		
		return cat;
	}
	
	public Animal dequeueDog() {
		//not implemented, but the same idea as dequeueCat
		return null;
	}
}
