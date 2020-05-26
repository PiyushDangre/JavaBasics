package functionalProg;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

/**
 * -- A functional interface is the interface which contains one abstract method.
 * -- A functional interface is implemented by a Lambda expression.
 * -- There are three ways of implementing functional Interface -->
 * 		1 -> Concrete Class Implementation
 * 		2 -> Anonymous Class Implementation.
 * 		3 -> Using Lambda Expression.
 * 
 * Resources --> http://tutorials.jenkov.com/java-functional-programming/functional-interfaces.html
 * 			 --> https://www.geeksforgeeks.org/supplier-interface-in-java-with-examples/
 * 			 --> https://www.geeksforgeeks.org/stream-map-java-examples/
 * @author Piyush Dangre
 *
 */
public class _2FunctionalInterfaces {

	public static void main(String[] args) {
		
		/**
		 * A template for a lambda expression implementing functional interface.
		 * MyFunctionalInterface lambda = () ->  System.out.println("Executing...") ;
		 */
		
		/**
		 * ** FUNCTION INTERFACE **
		 * Function interface is one of the most central functional interfaces in Java.
		 * Method takes a single parameter and returns a single value of same type
		 * or some other type (Generic).

			public interface Function<T,R> {
				public <R> apply(T parameter);
			}
		 
		 
		 */
		
		/**
		 * Implementation of Function interface using concrete class.
		 */
		System.out.println(new subtractOne().apply("1001"));
		
		/**
		 * Implementation of Function interface using Anonymous class.
		 */
		Function<String, Integer> f = new Function<String, Integer>(){

			@Override
			public Integer apply(String t) {
				return Integer.parseInt(t) - 1 ;
			}
			
		} ;
		
		System.out.println(f.apply("1100"));
		
		/**
		 * Implementation of Function interface using Lambda Expression
		 */
		Function<String, Integer> functionLambda = (t) -> Integer.parseInt(t) - 1  ;
		System.out.println(functionLambda.apply("888"));
		
		// Now onwards, we will look only at Lambda expression implementations.
		
		/**
		 * ** PREDICATE INTERFACE **
		 *  -- Predicate Interface represents a function which takes single value
		 *     as parameter and return a boolean true or false.
		 *  -- It contains test(T t) method.
		 		
		 		public interface Predicate {
    				boolean test(T t);
				}
				
		 */
		
		Predicate<String> predicate = (t) -> t.equalsIgnoreCase("Hello") ;
		Boolean result1  = predicate.test("Man");
		Boolean result2 = predicate.test("Hello");
		System.out.println("Predicate 1 "+result1);
		System.out.println("Predicate 2 "+result2);
		
		/**
		 * ** UNARY OPERATOR **
		 * Represents function which takes single parameter and returns value of same type.
		 * Its useful to accept an object, modify property of the objecta and return it,
		 * possibly while using Streams API.
		 
		 public interface UnaryOperator<T>{
		 	public <T> apply(T t) ;
		 }
		 
		 */
		
		UnaryOperator<String> unaryFunction = (st)-> "Hey "+st ;
		String ss = unaryFunction.apply("Unary operator ");
		System.out.println(ss);
		
		/**
		 * ** BINARY OPERATOR **
		 * -- A function that accepts two parameters of same type and returns 
		 *    value of same type.
		 */
		
		BinaryOperator<String> bo = new BinaryOperator<String>(){

			@Override
			public String apply(String arg0, String arg1) {
				return arg0.toUpperCase() +" "+arg1.toLowerCase() ;
			}
			
		};
		
		String bo_returns = bo.apply("Hello", "World");
		System.out.println(bo_returns);
		
		/**
		 * ** SUPPLIER INTERFACE **
		 * -- Represents a function which does not take in any argument but produces a value of type T.
		 * -- Also can be called as a FactoryMethod as it supplies Value.
		 * -- It has .get() method
		 */
		
		Supplier<Double> sup = () -> Math.random() ;    // Note here the return type is Double so Supplier initiated as Supplier<Double>
		System.out.println("Some random no generated - "+sup.get());
		
		/**
		 * ** CONSUMER INTERFACE
		 * Represents method which accepts parameter of one type but does not return anything.
		 * That means return type of function is void.
		 * It has .accept(T t) method.
		 */
		
		Consumer<String> consumer = new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println("I accepted string - "+t);
			}
			
		};
		
		consumer.accept("Piyush"); // Prints --> I accepted string - Piyush
		
		}

}

/**
 * Concrete implementation of Function Interface
 * Logic written to accept string and give back integer after deducting 1
 * @author user
 *
 */
class subtractOne implements Function<String, Integer>{

	@Override
	public Integer apply(String arg0) {
		return Integer.parseInt(arg0) - 1 ;
	}
	
}

