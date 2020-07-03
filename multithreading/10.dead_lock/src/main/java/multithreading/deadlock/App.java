package multithreading.deadlock;

/*
 * deadlock: 
 * Deadlock describes a situation where two or more threads are blocked forever, waiting for each other.
 *  Deadlock occurs when multiple threads need the same locks but obtain them in different order.
 * */

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		final Runner runner = new Runner();
		
		//create thread1 with custom Runnable
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				
				try {
					runner.firstThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});

		//create thread2 with custom Runnable
		Thread thread2 = new Thread(new Runnable() {

			public void run() {

				try {
					runner.secondThread();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		//start both threads
		thread1.start();
		thread2.start();
		
		//wait for both threads to finish
		thread1.join();
		thread2.join();
		
		//call finish method
		runner.finished();

	}

}
