package multithreading.lockingqueues;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;

public class LockingQueues {

	//thread safe class that will have at least 10 integer in queue
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	
	public static void main(String[] args) throws InterruptedException {
		
		//creation of thread1 that will produce integers to the queue
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		//creation of thread2 that will consume integers from the queue
		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});

		thread1.start();
		thread2.start();
		
		//wait until threads are finished
		thread1.join();
		thread2.join();
		
	}

	//method that will produce integer and add it to the queue
	private static void producer() throws InterruptedException {
		
		Random random = new Random();
		
		while (true) {
			
			//add random integers to the queue
			queue.put(random.nextInt(100));
			System.out.println("producer has just added new integer to the queue");
		}
		
	}
	
	//method that will consume integers from the queue
	private static void consumer() throws InterruptedException {
		
		Random random = new Random();
		
		while (true) {
			
			Thread.sleep(100);
			
			// if the random number from 0 to 10 is 0, then we will take an integer from the queue
			if( random.nextInt(5) == 0) {
				
				Integer value = queue.take();
				System.out.println("taken value from the queue: " + value + "; Queue size: " + queue.size());	
			}

		}
		
	}
	
}
