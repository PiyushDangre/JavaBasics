package multithreading;

public class ThreadNameTest extends Thread{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
			ThreadNameTest t = new ThreadNameTest();
			t.start();
			System.out.println(t.getName());
	}

	
	public void run() {
		System.out.println("Running");
		System.out.println("RUN - "+this.getName());
		this.setName("Piyush's Thread");
		System.out.println("Using Reference of current thread "+Thread.currentThread().getName());
		
	}
}
