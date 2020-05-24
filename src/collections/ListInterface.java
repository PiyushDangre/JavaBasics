package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class ListInterface {

	public static void main(String[] args) {

		/**
		 * Java ArrayList class can contain duplicate elements.
			Java ArrayList class maintains insertion order.
			Java ArrayList class is non synchronized.
			Java ArrayList allows random access because array works at the index basis. So its fast.
			In Java ArrayList class, manipulation is slow because a lot of shifting needs to occur if any'
			 element is removed from the array list.
		 */
		ArrayList<String> arr2 = new ArrayList();
		arr2.add("a");
		arr2.add("b");
		arr2.add("c");
		
		System.out.println(arr2);
		
		// Add at specified index
		arr2.add(2, "K") ; 
		System.out.println(arr2);
		
		// Playing with ArrayList of objects
		ArrayList<Person> ppl = new ArrayList();
		ppl.add(new Person("Piyush", 35));
		ppl.add(new Person("Dangre", 45));
		ppl.add(new Person("Mangesh", 55));
		System.out.println(ppl);
		
		// Adding other list elements in above list
		ArrayList<Person> morePpl = new ArrayList();
		morePpl.add(new Person("Vaibhavi", 35));
		morePpl.add(new Person("Dangre", 45));
		morePpl.add(new Person("Mangesh", 55));
		ppl.addAll(morePpl);
		System.out.println(ppl);
		
		// Adding another list at specific index
		ppl.addAll(2, morePpl);
		System.out.println(ppl);
		
		//clear all elements
		morePpl.clear();
		System.out.println(morePpl);
		
		/**
		 * Convert arraylist into array of objects. Note that the list can be 
		 * conveterd into an array of Object. So we can only use to read'em
		 * with methods defined in Objcet class. Its not possible to typecast
		 * into Person object as it gives compilation error.
		 */
		Object[] obj = ppl.toArray();
		
		for(Object o : obj) {
			System.out.println(o);
		}
		
		/**
		 * In order to convert arraylist into an array of appropriate class, we
		 * use the .toArray(T[] t) method. We pass an array of required type as
		 * method parameter. The toArray(T[] t) method returns the array of the 
		 * objects of type that which we passed while invoking. Then we can read
		 * easily through for loop as we have got Person object instead of Object
		 * without typecasting.
		 */
		Person[] pplarray = ppl.toArray(new Person[2]);
		System.out.println("People array- ");

		for(Person p : pplarray) {
			System.out.println(p);
		}
		
		/**
		 * .contains is used to check if the passed value is present into the 
		 * collection. Make sure that the .equals() and .hashCode() method is 
		 * implemented in the arraylist element class. Otherwise the result will
		 * be false even if the values of objects are equal as it only compares 
		 * the reference variable in that case.
		 */
		boolean contain = ppl.contains(new Person("Vaibhavi", 35));
		System.out.println("IS the object present- " + contain);
		
		/**
		 * This returns the position of object in list. Requires equals method to be
		 * implemneted.
		 */
		int index = ppl.indexOf(new Person("Vaibhavi", 35));
		System.out.println("The object is present at popsition - "+index);
	}

}

class Person {
	String name;
	int age;

	public Person() {

	}

	public Person(String name, Integer age) {
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	

}
