package multithreading.threadSynchronization;

/*
 * Problems coming from multiple threads sharing the same data:
 * 1. data being cached
 * 		Solution: Use the keyword "volatile" to prevent thread caching variables when they are not
 *                changed from within that thread.
 * 2. Thread interleaving
 * 	    Solution: Use the keyword "synchronized" to make shared data synchronized between multiple threads.
 * 
 * What is thread interleaving?
 * Interference that happens when two operations, running in different threads, but acting on the same data,
 *  interleave.
 * */


public class KeywordSynchronizeToShareData {

	//variable data shared between multiple threads
	private int count = 0;
	
	// method to be synchronize between multiple threads -> use keyword "synchronized"
	public synchronized void increment() {
		count++;
	}
	
	public static void main(String[] args) {
		
		KeywordSynchronizeToShareData kstsd = new KeywordSynchronizeToShareData();
		
		kstsd.doWork();
		
	}
	
	// method with some threads running
	public void doWork() {
		
		// thread1 with custom runnable
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				
				for(int i=0; i<10000; i++) {
					increment();
				}
				
			}
		});
		
		// thread2 with custom runnable
		Thread thread2 = new Thread(new Runnable() {

			public void run() {

				for(int i=0; i<10000; i++) {
					increment();
				}

			}
		});
		
		thread1.start();
		thread2.start();
		
		// wait for threads to finish 
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// we should expect to get the count of 20000
		System.out.println("Count is: " + count);
	}

}
