package streamsapi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Since Stream operations are lazy, the iteration is done only
 * when terminal operator is present.
 * 
 * Terminal operation typically returns a single value.
 * 
 * Terminal Operation normally does not return a Stream instance unlike non-terminatory.
 * 
 * Resource --> http://tutorials.jenkov.com/java-functional-programming/streams.html
 * 
 * @author Piyush Dangre
 *
 */
public class _3TerminalStreamOps {
	
	public static void main(String args[]) {
	
	/**
	 *	.anyMatch() accepts PREDICATE INTERFACE .
	 * - If there is a matching element it returns true or 
	 *	 else returns false. 
	 *  - Returns boolean.
	 *  - All iteration is done internally
	 */
		List<String> stringList = new ArrayList<String>();

		stringList.add("One flew over the cuckoo's nest");
		stringList.add("To kill a muckingbird");
		stringList.add("Gone with the wind");
		
		Stream<String> stream = stringList.stream();

		boolean anyMatch = stream.anyMatch((value) -> { return value.startsWith("One"); });
		System.out.println(anyMatch); // Prints true
		
		/**
		 * .allMatch() accepts PREDICATE INTERFACE.
		 * If all elements of the collection match the given predicate, then true returned,
		 * or else returns false.
		 */
		Stream<String> stream2 = stringList.stream();
		boolean allMatch = stream2.allMatch((value) -> value.startsWith("One"));
		System.out.println(allMatch); // Prints false
		
		/**
		 * .noneMatch() gives true if no elements match and 
		 * false if any one element or more of the stream matches
		 * It accepts PREDICATE INTERFACE
		 */
		String a = "a";
		Stream<UserDetails> users = JSONUtility.getCollectionFromFile().stream();
		boolean anyElementStartsWithB = users.noneMatch((element) -> {
			return element.getFirstName().startsWith(a);
		});
		System.out.println("Does no element start with a? -"+anyElementStartsWithB);
		
		/**
		 * .collect() method is a terminal operator that collects the stream 
		 * in some kind of collection or object.
		 * 
		 * It accepts Collectors class to collect stream element into desired
		 * collection of choice. 
		 */
		Stream<UserDetails> users_ = JSONUtility.getCollectionFromFile().stream();
		List<UserDetails> usersList = users_
		.limit(10)
		.map((element)-> {
			element.setFirstName(element.getFirstName().toUpperCase());
			return element ;
		})
		
		.collect(Collectors.toList());
		
		Iterator itr = usersList.iterator() ;
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		/**
		 * count counts the number of elements
		 */

		long count = JSONUtility.getCollectionFromFile().stream()
		.limit(10).count();
		System.out.println("Count-"+ count); // Prints 10
		
		
		/**
		 * Create stream with of --> (Static Method)
		 */
		Stream<String> strStream = Stream.of("Piyush", "Mangesh", "Dangre");
		
		/**
		 * Concat streams --> (Static Method)
		 */
		
		Stream<String> strStream2 = Stream.of("Piyush", "Nagpur", "Wardha");
		Stream<String> concatStream = Stream.concat(strStream, strStream2);
		System.out.println(concatStream.collect(Collectors.toSet())); // Eradicated duplicates using toSet()
		
		/**
		 * .forEach() is terminal operation which starts internal iteration
		 * It accepts CONSUMER INTERFACE
		 */
		strStream2 = Stream.of("Piyush", "Nagpur", "Wardha");
		strStream2.map((v)-> {
			return v.toUpperCase();
		})
		.forEach((v)-> System.out.println(v));
		
		/**
		 * OPTIONAL is a class which is used to get rid of nullPointerException
		 * READ --> https://www.geeksforgeeks.org/java-8-optional-class/ 
		 */
		
		/**
		 * findAny() returns optional wrt any element if present in stream.
		 * findFirst() returns optional wrt to finding the first element of stream.
		 */
		strStream2 = Stream.of("Piyush", "Nagpur", "Wardha");
		Optional<String> first = strStream2.findFirst();
		System.out.println(first.isPresent()); // Is the value present? --> Prints true
		System.out.println(first.get()); // Return the value --> Prints Piyush (1st element)
		
		/**
		 * min() returns Optional wrt the lowest element
		 * max() returns Optional wrt to the highest element.
		 * 
		 * Which is low or high is defined by the Comparator interface passed to
		 * the min() or max() method.
		 * 
		 * Returns Optional
		 */
		Optional<String> minElement = Stream.of("Piyush", "Nagpur", "Wardha").min((val1, val2)->{
			return val1.compareTo(val2);
		});
		System.out.println(minElement.get()); // Prints Nagpur
		
		
	}

}
