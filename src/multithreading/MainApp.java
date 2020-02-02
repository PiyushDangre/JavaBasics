package multithreading;

public class MainApp extends Thread {
	
 public static void main(String Args[]) {
	 
	 // -- Creating Thread -- ** //
	 
	 	MainApp m = new MainApp();
	 	m.start();
	 	
	 	RunnableClass r = new RunnableClass();
	 	Thread t = new Thread(r);
	 	t.start();
 }
 
 
 public void run() {
	 System.out.println("Threadv starts");
 }
	
}
