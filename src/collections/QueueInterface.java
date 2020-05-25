package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;


public class QueueInterface {

	/**
	 * 	- In priorityqueue elements may not be arranged in natural order always , 
		  But they are always retrieved in natural order. For eg. The head is always 
		  replaced with lower or higher element according to the order defined in comparator.
	 * @param args
	 */
	public static void main(String[] args) {
		
		PriorityQueue<String> queue=new PriorityQueue<String>();  
		queue.add("Amit");  
		queue.add("Vijay");  
		queue.add("Karan");  
		queue.add("Jai");  
		queue.add("Rahul");  
		
		System.out.println("Queue before iteration-"+queue);  // Here queue is not printed in alphabetical order
		
		System.out.println("Head before iteration -"+queue.peek());
		
		/**
		 * This is how we iterate over priority queue. Notice that natural
		 * ordering is not maintained here as iteration does not follow 
		 * alphabetical order.
		 */
		System.out.println("Iterating queue");
		
		Iterator<String> it = queue.iterator();
		
		while(it.hasNext()) {
			System.out.println("--"+it.next());
		}
		
		
	/**
	 * This is how we retrieve elements from queue. Notice that
	 * natural ordering is respected here.
	 */
		System.out.println("Retrieving elements from  queue");
		while(queue.peek() != null) {
			System.out.println("**"+queue.poll());  // Here queue is printed in alphabetical(natural) order.
		}
		
		
	/**
	 * In case of custom objects, we have to pass in a comparator instance to the 
	 * constructor of priority queue.	
	 */
		PriorityQueue<Person> pq = new PriorityQueue<Person>(new SortAlphabetically());
		pq.add(new Person("Piyush", 22));
		pq.add(new Person("Vikas", 22));
		pq.add(new Person("Animesh", 22));

		/**
		 * Retrieving elements
		 */
		System.out.println("Person queue in order-");
		while(pq.peek()!=null) {		
			System.out.println(pq.poll());
		}
	}

}
