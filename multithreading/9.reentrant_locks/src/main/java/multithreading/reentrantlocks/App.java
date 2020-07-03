package multithreading.reentrantlocks;

/*
 * Reentrant lock is an alternativo to the keyword "synchronized"
 * */


public class App {

	public static void main(String[] args) throws InterruptedException {
		
		final Runner runner = new Runner();
		
		//create thread1 with custom Runnable
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				
				runner.firstThread();
				
			}
		});

		//create thread2 with custom Runnable
		Thread thread2 = new Thread(new Runnable() {

			public void run() {

				runner.secondThread();

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
