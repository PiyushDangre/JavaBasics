package multithreading;

public class MainApp extends Thread {
	
 public static void main(String Args[]) {
	 
	 // -- Creating Thread -- ** //
	 
	 	MainApp m = new MainApp();
	 	m.start();
	 	
	 	RunnableClass r = new RunnableClass();
	 	Thread t = new Thread(r);
	 	t.start(); 
	 	
	 	System.out.println("-------------------------------------------------");
	 	
	// 	Sleeping thread
	 	RunnableClass r2 = new RunnableClass();
	 	Thread t2 = new Thread(r2);
	 	t2.start();
	 	
	 	AnotherRunnableClass r3 = new AnotherRunnableClass();
	 	Thread t3 = new Thread(r3);
	 	t3.start();	 	
	 	
	 	 	
 }
 
 
 public void run() {
	 System.out.println("Main Thread starts");
 }
	
}
