package streamsapi;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * ** STREAMS API **
 * Stream is a component that is capable of internal iteration of its elements.
 * There is no need of using external iteration like for loop unlike in collections.
 * Streams has listeners attached, these listeners are called once for each element,
 * in the stream. The listeners do some action per element. This is called Stream 
 * Processing.
 * @author Piyush Dangre
 *
 */
public class _1StreamsAPI {
	
	/**
	 * The listeners can form a chain. They return a new element or same element
	 * depending on the purpose of the listener.
	 * 
	 * Ways to obtain a stream --
	 * @param args
	 */
	public static void main(String args[]) {
			
		List<String> items = new ArrayList<String>();

		items.add("one");
		items.add("two");
		items.add("three");

		Stream<String> stream = items.stream();    // We obtain the stream here.
		
		/**
		 * We have terminal and terminal operations in the stream.
		 * Non Terminal -> Attaches listener to the stream and does nothing else.
		 * Terminal -> Collects all the elements and returns as result.
		 */
		
	}
}
