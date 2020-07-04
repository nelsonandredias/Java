package multithreading.semaphores;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/*
 * Semaphores:
 * It is an object that mantains a count, and the count is the number of
 * available permits of the semaphore.
 * 
 * Typically, semaphores are used to control access to some resource.
 * 
 * A semaphore with one permit it is basically a lock and the only difference
 * is that it can be released from different threads -> 
 * a different thread can unlock the lock of another thread.
 * */


public class UseSemaphores {

	public static void main(String[] args) throws Exception {
		
		
		
		//use Executor to create a bunch of threads
		ExecutorService executors = Executors.newCachedThreadPool();
		
		//submit 200 threads to the thread pool
		for(int i= 0; i<200; i++) {
			//create a new thread and submit it
			executors.submit(new Runnable() {
				
				public void run() {
					
					//When a thread is started a new Connection instance will be created and connected
					try {
						Connection.getInstance().connect();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			});
		}
		
		//when the threads are finished running, it is time to close the executors
		executors.shutdown();
		
		System.out.println("all threads are finished running. Let's close the executors!!!");
		
		// i will wait 1 day for all threads are finished running
		executors.awaitTermination(1, TimeUnit.DAYS);
		
	}

}
