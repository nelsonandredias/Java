package multithreading.callableandfuture;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/*
 * Callable and future:
 * these two classes allow us to get returnables from our threads.
 * and also allow our thread code to throw exceptions.
 * */


public class App {

	public static void main(String[] args) throws InterruptedException{
		
		//use Executor to create a bunch of threads
		ExecutorService executors = Executors.newCachedThreadPool();

		//executors.submit -> create a thread and submit it
		/* new Callable is an alternative to new Runnable, with the exception that
		 * it returns a value of the type defined.
		 * 
		 * We can combine class Callable with the class Future to get the returned value
		 * and use it later on. 
		 * */
		Future<Integer> future = executors.submit(new Callable<Integer>() {

			public Integer call() throws Exception {

				Random random = new Random();
				int duration = random.nextInt(4000);
				
				//force an exception
				if(duration > 2000) {
					throw new IOException("sleeping for too long!!!");
				}

				System.out.println("Thread starting.............");

				//simulate some process
				Thread.sleep(duration);

				System.out.println("Thread finishing.............");

				return duration;	
			}
		});

		//when the threads are finished running, it is time to close the executors
		executors.shutdown();
		
		System.out.println("all threads are finished running. Let's close the executors!!!");
		
		// i will wait 1 day for all threads are finished running
		executors.awaitTermination(1, TimeUnit.DAYS);
		
		//get the return value from callable via Future
		try {
			System.out.println("Return is - " + future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			System.out.println(e.getMessage());
		}

	}

}
