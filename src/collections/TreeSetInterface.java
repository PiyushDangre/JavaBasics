package collections;

import java.util.Iterator;
import java.util.TreeSet;


public class TreeSetInterface {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		/**
		 * Ordering in the set is provided by default in treeset in natural
		 * order whether or not a comparator is provided. So , it does not follow
		 * insertion order.
		 */
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("P");
		ts.add("M");
		ts.add("D");
		System.out.println("Initial ="+ts);
		System.out.println(ts.descendingSet());
	}

}
