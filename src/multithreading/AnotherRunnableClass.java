package multithreading;

public class AnotherRunnableClass implements Runnable {

	@Override
	public void run() {
		System.out.println("Another Runnable class running");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
