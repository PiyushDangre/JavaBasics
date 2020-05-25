package collections;

import java.util.HashMap;
import java.util.Map;

public class MapInterface {
	public static void main(String args[]) {
			
		HashMap<Integer, String> hm = new HashMap<>();
		hm.put(1, "Piyush");
		hm.put(2, "Mangesh");
		hm.put(3, "Kavita");
		hm.put(4, "Dangre");
		
		System.out.println("Hashmap - "+ hm);
		
		for(Map.Entry<Integer, String> e : hm.entrySet()) {
			System.out.println("Key-"+ e.getKey()+ " Value- "+e.getValue());
		}
		
		System.out.println("Does this key exist 4 - "+ hm.containsKey(4));
		
		/**
		 * We can replace the value of a particular key both by
		 * using put and replace.
		 */
		hm.replace(3, "Vaibhavi");
		hm.put(1, "Nagpur");
		
		System.out.println("Map after replacing");
		for(Map.Entry<Integer, String> e : hm.entrySet()) {
			System.out.println("Key-"+ e.getKey()+ " Value- "+e.getValue());
		}
	}
}
