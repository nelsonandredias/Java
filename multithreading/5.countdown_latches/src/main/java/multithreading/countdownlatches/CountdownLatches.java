package multithreading.countdownlatches;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/*
 * CountDownLatch class:
 *  really usefull for thread synchronization, because it is thread safe.
 *  
 *  That means, we can safely access countDownLatch class from multiple threads
 *  without worrying about thread synchronization.
 *  
 * */

class Processor implements Runnable {

	private CountDownLatch latch;
	
	//constructor
	public Processor(CountDownLatch latch) {
		this.latch = latch;
	}

	public void run() {
		
		// get current thread instance
        Thread t = Thread.currentThread();
        
		System.out.println("Started thread num- " + t.getId());
		
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// decrement the current latch number
		latch.countDown();
		
		System.out.println("Finished thred num- " + t.getId());
		
	}	
	
}


public class CountdownLatches {

	
	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(3);
		
		//create a thread pool with 3 threads
		ExecutorService executor = Executors.newFixedThreadPool(3);
		
		//tasks to be executed
		for(int i=0; i < 3; i++) {
			
			executor.submit(new Processor(countDownLatch));
		}
		
		//wait for latch to be countdown to zero
		try {
			countDownLatch.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed!!!");
	}

}
