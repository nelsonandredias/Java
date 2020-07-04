package multithreading.interruptingthreads;

import java.util.Random;

/*
 * Interrupting threads:
 * Even though the best way to gracefully stop a thread is by using the volatile keyword,
 * there is another way.
 * 
 * The other option of stopping a thread is 
 * */

public class App {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				
				Random random = new Random();
				System.out.println("Before calculating sin");
				for(int i = 0; i< 1E8; i++) {
					System.out.println("i - " + i);
					//enquiry the current thread if it was interrupted or not via the method interrupt()
					if(Thread.currentThread().isInterrupted()) {
						System.out.println("Confirm. Current thread " + Thread.currentThread().getId() + " is interrupted!!!");
						break;
					}
					
					Math.sin(random.nextDouble());
				}
				System.out.println("After calculating sin");
			}
		});
		
		System.out.println("Starting thread1");
		
		//start the trhead1
		thread1.start();
		
		// after starting the thread, let's sleep the thread
		thread1.sleep(500);
		
		//and interrupt the thread
		/*
		 * method interrupt() does not interrupt the thread but sets a flag that tells the thread
		 * that it has been interrupted 
		 * */
		thread1.interrupt();
		System.out.println("Thread was interrupted.");
		
		//wait the thread1 to finish
		thread1.join();
		
		System.out.println("Finishing thread1");
		
	}

}
