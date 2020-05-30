package streamsapi;

import java.util.ArrayList;
import java.util.List;
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
		
	}

}
