package multithreading;

public class TestSleep extends Thread {

	/**
	 * Thread.sleep() pauses thread execution
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TestSleep t = new TestSleep();
		t.start();

	}
	
	public void run() {
		int i = 0 ;
		while(i < 5) {
			System.out.println("Enters Loop");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println("Exits Loop");
			i++ ;
		}
	}

}
