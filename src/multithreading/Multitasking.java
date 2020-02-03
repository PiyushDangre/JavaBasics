package multithreading;

public class Multitasking{

	/**
	 * Multitasking using multithreading using anonymous classes.
	 * @param Args
	 */
	 public static void main(String Args[]) {
		 
		 Thread t1 = new Thread() {
			
			 public void run() {
				 System.out.println("t1 running");
			 }
			 
		 };
		 
		 Thread t2 = new Thread() {
				
			 public void run() {
				 System.out.println("t2 running");
			 }
			 
		 };
		 
		 t1.start();
		 t2.start();
		 
		 
	 }
}
