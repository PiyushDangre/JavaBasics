package functionalProg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ** Functional Programming Paradigm **
 * 
 * -- Functions are first class objects in the language
 * -- You can create an instance of function just like other objects 
 * -- Functions can also be passed as parameters to other functions.
 * -- No state
 * -- Favor Recursion Over Looping 
 * -- Immutable Variables
 * -- Functional Interfaces (Interfaces having one abstract method)
 * -- Higher Order Functions
 * 
 * Read more about functional paradigm below link :-
 * http://tutorials.jenkov.com/java-functional-programming/index.html
 * @author Piyush Dangre
 *
 */
public class _1Intro {
	
	/**
	 * --> Pure Functions
	 * Functions are pure because the return value does not take help
	 * of any other variables or method calls.
	 * There are no side effects (like a database call) in it.
	 * This is also characterized by not having any State , as the 
	 * function does not get help of any external variable storing value.
	 * @param a
	 * @param b
	 * @return
	 */
    public int sum(int a, int b) {
        return a + b;
    }
    
    /**
     * --> Higher Order Functions.
     * The commented function below takes two functional arguments
     * and returns a function. Its called Higher Order function.
     * A function should either take one function as argument or return
     * a function to be called as higher order function.
     * Commented to avoid compilation error.
     */
    
	/*
	 * public <T> IFactory<T> createFactory(IProducer<T> producer, IConfigurator<T>
	 * configurator) { return () -> { T instance = producer.produce();
	 * configurator.configure(instance); return instance; } }
	 */
    
    public void someMethod() {
        ArrayList<String> arr = new ArrayList<>(Arrays.asList("Piyush", "Nagpur", "Denmark", "Fuji Mountain"));
        
        /**
         * Here .sort() method takes one functional argument (in form of lambda).
         * Thats why its a higher order function. Although it does not return a 
         * function.
         */
        Collections.sort(arr , (String a , String b)->{
        	return a.compareTo(b);
        });
    }

}

/**
 * --> Functional Interfaces
 *  A functional interface in Java is an interface that only has one abstract method
 *  An interface can have multiple methods, e.g. default methods and static methods,
 *  both with implementations, but as long as the interface only has one method that
 *  is not implemented, the interface is considered a functional interface.
 * @author user
 *
 */
interface MyInterface {
    public void run();
}