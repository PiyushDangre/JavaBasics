package multithreading;

public class JoinTest extends Thread{

	/**
	 * Thread.join() instance method helps in joining the current thread with the specified
	 * thread. That means in the following example -- j3 starts executing only when j2 has
	 * joined the current thread that means only when j2 has died. In other words, it causes
	 *  the currently running threads to stop executing until the thread it joins with 
	 *  completes its task.
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		JoinTest j1 = new JoinTest();
		JoinTest j2 = new JoinTest();
		JoinTest j3 = new JoinTest();
		
		j1.start();	
		j2.start();
		j2.join();
		j3.start();
	}
	
	
	public void run() {
		for(int i=1; i<=5 ; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(i);
		}
	}

}
