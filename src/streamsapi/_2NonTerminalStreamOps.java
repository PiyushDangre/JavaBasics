package streamsapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * ** NON TERMINAL STREAM OPERATIONS **
 * Resource --> http://tutorials.jenkov.com/java-functional-programming/streams.html
 * @author Piyush Dangre
 *
 */
public class _2NonTerminalStreamOps {
	
	/**
	 * Non terminal functions(or operations) are used to transform or
	 * filter the elements of the stream.
	 * 
	 * When you add a non-terminal operation to a stream, you get a new
	 * stream back as result.
	 * 
	 * The new stream represents the stream of elements resulting from 
	 * the original stream with the non-terminal operation applied.
	 * @param args
	 */
	public static void main(String args[]) {
			// Creating JSON file
			ArrayList<UserDetails> users = JSONUtility.getCollectionFromFile();
			
			// creating stream
			Stream<UserDetails> st = users.stream();
			
			// Here we are creating a stream of Strings
			Stream<String> st_ = users.stream().map((x) -> x.getFirstName().toUpperCase()) ;
			
			/**
			 * .filter() accepts PREDICATE INTERFACE. Returns true or false.
			 * The below statement only returns elements with id >= 900
			 */
			Stream<UserDetails> lastThreeElements = users.stream().filter((x) -> x.getId() >= 998);
			List<UserDetails> list = lastThreeElements.collect(Collectors.toList());
			
			Iterator<UserDetails> itr = list.iterator() ;
			
			while(itr.hasNext()) {
				Logger.getLogger(_2NonTerminalStreamOps.class.getName()).info(itr.next().toString());
			}
			
			/**
			 * .map() can transform the element into something completely else. It can change type also. 
			 * It accepts the FUNCTION INTERFACE. So, return type can be completely different.
			 * The below expression takes the elements with ID above 998 and adds Mr as prefix
			 * to firstnames.
			 */
			lastThreeElements = users.stream().filter((x) -> x.getId() >= 998);
			List<UserDetails> withPrefixFirstName = lastThreeElements.map((val) -> {
				val.setFirstName("Mr." + val.getFirstName());
				return val ;
			})
			.collect(Collectors.toList());
			
			// Iterate and print list
			itr = withPrefixFirstName.iterator() ;
			while(itr.hasNext()) {
				System.out.println(itr.next());
			}
			
			/**
			 * FlatMap accepts FUNCTION INTERFACE
			 * 
			 * FlatMap operation is used to flatten multiple nested objects into
			 * single objects. Like the elements of nested list can get included 
			 * into one list.
			 * 
			 * The flatmap operation has to return the Stream<T> object
			 * of desired type.
			 * 
			 * The below example transforms the stream into a stream of strings,
			 * which has been created by splitting the email address.
			 */
			System.out.println("-----------------FlatMap example");
			
			List<String> emailsList = users.stream()
			.filter((v) -> v.getId() > 995)
			.flatMap((value) -> {
				String[] strArray = value.getEmail().split("@");
				return Arrays.asList(strArray).stream();
			})
			.collect(Collectors.toList());
			
			// Iterate and print list
			Iterator<String> itrString = emailsList.iterator() ;
			while(itrString.hasNext()) {
				System.out.println(itrString.next());
			}
			
			/**
			 * .distinct() eliminates duplicates.
			 * 	It does not accept any parameters.
			 * 
			 */
			
			List<String> stringList = new ArrayList<String>();

			stringList.add("one");
			stringList.add("two");
			stringList.add("three");
			stringList.add("one");
			
			List<String> noDuplicates = stringList.stream().distinct().collect(Collectors.toList());
			System.out.println("No Duplicates" + noDuplicates);
			
			/**
			 * Limit() returns the no. of elements specified as Stream.
			 * it does not accept params.
			 */
			List<String> onlyOne = stringList.stream().distinct()
					.limit(1)
					.collect(Collectors.toList());
			System.out.println("Only One element" + onlyOne);
			
			/**
			 * .peek() method accepts CONSUMER INTERFACE.
			 * We can use it to only look at the element and not transform it.
			 * This is because Consumer interface has accept method with void return type. 
			 * For purposes like logging.
			 */
			List<String> listOfStrings = stringList.stream()
			.peek((value) -> {
				System.out.println(value);
			})
					.collect(Collectors.toList());
			
			
			
			
	}
}
