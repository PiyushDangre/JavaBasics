package multithreading;

public class RunnableClass implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("RunnableClass running");
		
		for(int i = 0 ; i < 5 ; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Running Runnable Class after sleep 500 ms");
		}

		
	}

}
