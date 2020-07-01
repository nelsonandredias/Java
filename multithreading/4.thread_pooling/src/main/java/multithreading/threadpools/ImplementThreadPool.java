package multithreading.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/*
 * What is thread pool?
 * 
 * It is a way of managing threads and locks at the same time.
 * Basically, it is like having a number of workers(threads) in a factory(process)
 * that execute tasks without resting until they finish.
 * */


class Processor implements Runnable {

	private int id;
	
	//constructor of the class
	public Processor(int id) {
		this.id = id;
	}

	public void run() {
		// get current thread instance
        Thread t = Thread.currentThread();
		System.out.println("Starting id: " + id + " processed by thread num - " + t.getId());
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Completed id: " + id + " processed by thread num - " + t.getId());
	}
}



public class ImplementThreadPool {

	public static void main(String[] args) {
		
		//ExecutorService will run its own managerial thread
		//method newFixedThreadPool will cread two threads in the executor
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//there will be 5 processor tasks to be executed by the two threads
		for(int i= 0; i< 5 ; i++) {
			//submit a new task i to the executor
			executor.submit(new Processor(i));
		}

		//will wait for all the threads to complete what they are doing and terminate
		executor.shutdown();
		
		System.out.println("All tasks submitted!!!!");
		
		//i am specifying the time i will be wait for all threads to finish what they are doing
		//in this case, i am waiting for 1 day
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		System.out.println("All tasks completed!!!!");
	}

}
