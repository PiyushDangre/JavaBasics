package multithreading;

public class TestThreadTwince extends Thread{

	/**
	 * Running same thread twice throws IllegalThreadStateException
	 * @param Args
	 */
	public static void main(String Args[]) {
		TestThreadTwince t = new TestThreadTwince();
		t.start();
		t.start();
		
	}
	
	public void run() {
		System.out.println("Running");
	}
}
