package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.*;

public class SetInterfaces {
	
	public static void main(String args[]) {
		/**
		 * List to set conversion.
		 */
		   ArrayList<String> list=new ArrayList<String>();  
           list.add("Ravi");  
           list.add("Vijay");  
           list.add("Ajay"); 
           list.add(null);
           list.add(null);  // Null can be inserted twice here. As its arraylist - it allows duplicates
           System.out.println(list);  
           
           HashSet<String> set=new HashSet<String>(list);  
           set.add("Gaurav");  
           
           // Set only allows one null value
           System.out.println(set);
           
           /**
            * List to LinkedHashSet conversion
            */
           LinkedHashSet<String> ls = new LinkedHashSet<String>(list);
           ls.add(null);
           ls.add(null);
           System.out.println(ls);
	}

}
