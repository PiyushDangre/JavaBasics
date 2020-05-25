package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class ListInterface {

	public static void main(String[] args) {

		/**
		 * Java ArrayList class can contain duplicate elements. Java ArrayList class
		 * maintains insertion order. Java ArrayList class is non synchronized. Java
		 * ArrayList allows random access because array works at the index basis. So its
		 * fast. In Java ArrayList class, manipulation is slow because a lot of shifting
		 * needs to occur if any' element is removed from the array list.
		 */
		ArrayList<String> arr2 = new ArrayList();
		arr2.add("a");
		arr2.add("b");
		arr2.add("c");

		System.out.println(arr2);

		// Add at specified index
		arr2.add(2, "K");
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

		// clear all elements
		morePpl.clear();
		System.out.println(morePpl);

		/**
		 * Convert arraylist into array of objects. Note that the list can be conveterd
		 * into an array of Object. So we can only use to read'em with methods defined
		 * in Objcet class. Its not possible to typecast into Person object as it gives
		 * compilation error.
		 */
		Object[] obj = ppl.toArray();

		for (Object o : obj) {
			System.out.println(o);
		}

		/**
		 * In order to convert arraylist into an array of appropriate class, we use the
		 * .toArray(T[] t) method. We pass an array of required type as method
		 * parameter. The toArray(T[] t) method returns the array of the objects of type
		 * that which we passed while invoking. Then we can read easily through for loop
		 * as we have got Person object instead of Object without typecasting.
		 */
		Person[] pplarray = ppl.toArray(new Person[2]);
		System.out.println("People array- ");

		for (Person p : pplarray) {
			System.out.println(p);
		}

		/**
		 * .contains is used to check if the passed value is present into the
		 * collection. Make sure that the .equals() and .hashCode() method is
		 * implemented in the arraylist element class. Otherwise the result will be
		 * false even if the values of objects are equal as it only compares the
		 * reference variable in that case.
		 */
		boolean contain = ppl.contains(new Person("Vaibhavi", 35));
		System.out.println("IS the object present- " + contain);

		/**
		 * This returns the position of object in list. Requires equals method to be
		 * implemneted.
		 */
		int index = ppl.indexOf(new Person("Vaibhavi", 35));
		System.out.println("The object is present at popsition - " + index);

		/**
		 * replaceAll() is used to transform all elements of the arraylist. We need to
		 * pass on an instace of implementation of UnaryOperator interface which has
		 * apply() method in it. The logic for transformation is present in apply()
		 * method of the class which implements UnaryOperator interface. Do not confuse
		 * this with the Collections.replaceAll() method which actually finds and
		 * replaces the matching objects with objects that we have passed on to the
		 * method.
		 */
		ppl.replaceAll(new MyOperator());
		System.out.println("All names tranformed in Uppercase - " + ppl);
		// Collections.replaceAll(list, oldVal, newVal) -- This method is completely
		// different from above.

		/**
		 * .retainAll(Collection<?> C) only keeps the matching objects from the
		 * parameter and the current list into the current list. The objects not
		 * matching(or equal) are removed from the current list. .equals() method needs
		 * to be implemented.
		 */
		morePpl = new ArrayList();
		morePpl.add(new Person("VAIBHAVI", 35));
		morePpl.add(new Person("DANGRE", 45));
		morePpl.add(new Person("MANGESH", 55));

		ppl.retainAll(morePpl);

		System.out.println("All elements retained from morePpl -" + ppl);

		/**
		 * .set(index, element) is used to replace an element in arraylist with another
		 * object. Only the index of the object and another new object is reqired as
		 * parameter. Below we are Replacing DANGRE Object with PIYUSH object --
		 */
		ppl = new ArrayList<Person>();
		ppl.add(new Person("VAIBHAVI", 35));
		ppl.add(new Person("DANGRE", 45));
		ppl.add(new Person("MANGESH", 55));

		ppl.set(ppl.indexOf(new Person("DANGRE", 45)), new Person("PIYUSH", 55));
		System.out.println("Replacing DANGRE Object with PIYUSH object- ");
		System.out.println(ppl);

		/**
		 * Sort() method takes implementation of Comparator interface. The instance of
		 * comparator interaface has compare method which takes two Person parameters as
		 * the arraylist of type Person. It has the logic for compariosn accroding to
		 * name. For sorting based on multiple fields , we have to use the
		 * Collections.sort() method and Comparator interface and implement method
		 * chaaining to obtain the result.
		 */
		ppl.sort(new SortAlphabetically());
		System.out.println("Sorted aaccording to Name field- " + ppl);

		/**
		 * Ways to iterate the elements of the collection in java
		 * 
		 * By Iterator interface.
		 *  By for-each loop. 
		 *  By ListIterator interface. 
		 *  By forloop. 
		 *  By forEach() method. 
		 *  By forEachRemaining() method.
		 */
		
		/**
		 * Iterating over arrayList using foreach method.
		 * See that the forEach method accepts instance of consumer 
		 * interface.
		 */
        List<String> items = new ArrayList<>();

        items.add("coins");
        items.add("pens");
        items.add("keys");
        items.add("sheets");

        items.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				// TODO Auto-generated method stub
				System.out.println(t);
			}
        	
        });

		/**
		 * STARTING LINKED LIST HERE
		 */
		LinkedList<String> ll = new LinkedList<>(Arrays.asList("Vaibhavi", "Dangre"));
		ll.add("Piyush");
		ll.add("Mangesh");
		ll.add("Dangre");

		System.out.println("Linked List is -");
		System.out.println(ll);

		ll.addFirst("Hey");
		ll.addLast("Man");

		System.out.println("After adding first and last");
		System.out.println(ll);
		
		System.out.println(ll.peekFirst());
		ll.set(ll.indexOf("Dangre"), "Dream");
		System.out.println(ll);
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

class MyOperator implements UnaryOperator<Person> {

	@Override
	public Person apply(Person arg0) {
		arg0.name = arg0.name.toUpperCase();
		return arg0;
	}

}

class SortAlphabetically implements Comparator<Person> {

	@Override
	public int compare(Person arg0, Person arg1) {
		// TODO Auto-generated method stub
		return arg0.name.compareTo(arg1.name);
	}

}
