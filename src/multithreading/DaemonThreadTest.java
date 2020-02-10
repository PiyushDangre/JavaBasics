package multithreading;

public class DaemonThreadTest extends Thread {
	
	
	/**
	 * Daemon thread is a service thread that runs in the background to support 
	 * user thread. It is low priority thread.
	 * @param Args
	 */
	public static void main(String Args[]) {
		DaemonThreadTest d1 = new DaemonThreadTest();
		DaemonThreadTest d2= new DaemonThreadTest();
		DaemonThreadTest d3 = new DaemonThreadTest();
		d1.setDaemon(true);
		d1.start();
		d2.start();
		d3.start();
	}
	
	
	/**
	* Run method
	*/
	public void run() {
		
		if(Thread.currentThread().isDaemon()) {
			System.out.println("Running Daemon");	
		}else {
			System.out.println("Running User thread");
		}
		
	}

}
