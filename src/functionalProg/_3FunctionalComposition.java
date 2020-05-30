package functionalProg;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Resources --> http://tutorials.jenkov.com/java-functional-programming/functional-composition.html#java-functional-composition-example
 * @author Piyush Dangre
 *
 */
public class _3FunctionalComposition {
	/**
	 * ** What is FUNCTIONAL COMPOSITION
	 * - Functional Composition is combining multiple functions to get one function.
	 * - Java comes with inbuilt support for combining multiple functions which
	 * can be individual lambda expressions. 
	 * @param args
	 */
	public static void main(String args[]) {
			
		/**
		 * Manual way of functional composition using two different 
		 * lambda expressions. 
		 * 
		 * We start with defining two functions of Predicate type.
		 */
		Predicate<String> startsWithA = (x) -> x.startsWith("A");
		Predicate <String> endsWithK = (x) -> x.endsWith("k");
		
		// Then define one function which is a mixture of two.
		// We are manually filling in logic in the test method of this
		// Predicate using the above two predicates.
		Predicate<String> startsWithAandEndsWithK = (x) -> startsWithA.test(x) && endsWithK.test(x);
		
		// Call the composed function
		boolean result = startsWithAandEndsWithK.test("America is drunk");
		System.out.println(result); // Prints true
		
		
		/**
		 * ** USING JAVA's INBUILT METHODS **
		 * 
		 * ** PREDICATE INTERFACE**
		 * Java provides inbuilt static and default methods in functions
		 * for composition of methods. Here, we use Predicate to perform
		 * the same task as done above. .and() and .or() methods are available
		 * in Predicate interface.
		 */
		
		// Using .and() method
		Predicate<String> startsWithAandEndsWithK_and = startsWithA.and(endsWithK);
		
		//Using .or() method
		Predicate<String> startsWithAandEndsWithK_or = startsWithA.or(endsWithK);
		
		boolean cond1 = startsWithAandEndsWithK_and.test("America is drunk");
		boolean cond2 = startsWithAandEndsWithK_or.test("America is drunk");
		
		System.out.println(cond1); // Prints true as both conditions are satisfied (its and) .
		System.out.println(cond2); // Prints true as any one of the two condition is satisfied (its or).
		
		/**
		 * ** FUNCTION INTERFACE
		 * Function interface has .compose() and .andThen() methods 
		 * available for functional composition.
		 */
		Function<String, Integer> doubleLength = (x) -> x.length() * 2 ;
		Function<Integer , Integer> tripleLength = (x) -> x * 3;
		
		/**
		 * Here we are fetching the string and doubling its length first,
		 * then we are tripling the length and returning the result as
		 * integer. Note here that doubleLength function runs first and then
		 * triplelength function runs. The function as the parameter to the 
		 * .compose() function always is the before function that is, it 
		 * always runs first. 
		 */
		Function<String, Integer> mixed_1 = tripleLength.compose(doubleLength);
		Integer tripledLength = mixed_1.apply("Man");
		System.out.println("Tripled Length is "+ tripledLength); // Prints 18
		
		/**
		 * The opposite of above behaviour happens in .andThen() method. Here,
		 * the function passed in the parameter of andThen() method runs 
		 * later. The result is same but notice the slight change in caller and
		 *  parameter in below statements.
		 */
		Function<String, Integer> mixed_2 = doubleLength.andThen(tripleLength);
		Integer tripledLength_ = mixed_2.apply("Man");
		System.out.println("Tripled Length is "+ tripledLength_); // Prints 18

	}
}
