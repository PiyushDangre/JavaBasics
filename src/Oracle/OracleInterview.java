package Oracle;

import java.util.* ;

public class OracleInterview {

	public static void main(String[] args) {
		
		HashMap<String, Integer> map = new HashMap();
		map.put("a", 1);
		map.put("b",2);
		
		ArrayList<String> arr1 = new ArrayList();
		arr1.add("a");
		arr1.add("b");
		arr1.add("c");
		
		ArrayList<String> arr2 = new ArrayList();
		arr2.add("a");
		arr2.add("b");
		arr2.add("c");
		
		ArrayList<String> arr3 = new ArrayList();
		arr3.add("a");
		arr3.add("b");
		arr3.add("c");
		
		/**
		 * Here we are removing the elements present in the map from
		 * the arraylist. So, iterate the map using entryset and remove 
		 * each key from arraylist.
		 */
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			arr1.remove(entry.getKey());
		}
		
		System.out.println(arr1);
		
		/**
		 * Using iterator object of the collection, we can iterate over the 
		 * collection and remove elements from it without the iteration 
		 * getting affected. Drawback of using iterator is that we can only
		 * iterate in forward direction.
		 */
		
		Iterator<String> itr =  arr2.iterator();
		while(itr.hasNext()) {
			if(map.get(itr.next()) != null) {
				itr.remove();
			}
		}
		
		System.out.println(arr2);
		
		/**
		 * Here we use the removeAll method of collection. This method accepts
		 * collection of any type and removes it from current list. Since, 
		 * map.keySet() returns a Collection which is nothing but Set of strings,
		 * we pass it directly to removeAll(Collection<?> t) method. This is the
		 * most efficient way of removing collection from collection as there is 
		 * no need of external iteration.
		 */
		arr3.removeAll(map.keySet()) ;
		System.out.println(arr3);

	}

}
