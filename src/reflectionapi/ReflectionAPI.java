package reflectionapi;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author Piyush Dangre
 * @since 25/05/2020
 *
 */
public class ReflectionAPI {

	/**
	 * Reflection API is used to get more information about the classes ar runtime.
	 * It is used in many Java frameworks to read fields, annotations methods etc.
	 * It is used in IDE's to display information about classes.
	 * Used extensively while using JUnit test framework on modern java frameworks like Spring.
	 * @param args
	 */
	public static void main(String[] args) {
		
		Class<Person> personClass = null ;  // Declare Class reference which is a generic type.
		try {

			personClass = (Class<Person>) Class.forName("reflectionapi.Person");  // Load class with specific name. The name has to be case sensitively correct.

			/**
			 * We can fetch information about the fields of the class.
			 * Note that this can only be done if the fields are Public. If
			 * they are private, then fields array comes out as null.
			 */
			Field[] fields = personClass.getFields();
			
			for(Field f : fields) {
				System.out.println(f.getName() + "-" + f.getType());   // Fetching name and type of member variabes.
			}
			
			/**
			 * Here, we are reading public methods and their return types in a 
			 * similar fashion. Note that all the methods of the class including those
			 * inherited because of Object class are fetched.
			 */
			Method[] method = personClass.getMethods();
			
			for(Method m : method) {
				System.out.println("Method name-"+m.getName()+" returns - "+ m.getReturnType());
			}
			
			/**
			 * To access private fields use getDeclaredFields. Note that public fields 
			 * are also fetched in this.
			 */
			Field[] privateFields = personClass.getDeclaredFields();
			
			for(Field f : privateFields) {
				System.out.println(f.getName()+" is a private field");
			}
			
			/**
			 * Similarly, to get private methods, use getDeclaredMethods(). Note that 
			 * public methods are also fetched in this.
			 */
			Method[] privateMethods = personClass.getDeclaredMethods();
			
			for(Method m : privateMethods) {
				System.out.println("Private method -"+m.getName());
			}
			
			/**
			 * Get superclass.
			 */
			System.out.println("Superclass is "+personClass.getSuperclass().getName());
			
			/**
			 * Get interfaces
			 */
			Class[] interfaces = personClass.getInterfaces();
			
			for(Class c : interfaces) {
				System.out.println("Implements - "+ c.getName());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

class Person extends Employee implements Comparable<Person>, Serializable{
	public String name;
	public int age;
	private String phoneNo ;
	
	
	private String getPhoneNo() {
		return phoneNo;
	}
	
	private void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}


class Employee {
	
}
