package multithreading.multipleLocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
 * when we use the keyword "synchronized", we are acquiring the intrinsic lock of the object
 * 
 * public synchronized void task1() { ------------> will get the lock of the class object "worker"
 * 
 * private Object lock1 = new Object();
 * synchronized (lock1) { ------------------------> will get the lock of the object lock1
 * 
 * 
 * */

public class Worker {

	private Random randomNumber = new Random();
	
	//create lock object 1
	private Object lock1 = new Object();
	//create lock object 2
	private Object lock2 = new Object();
	
	// private instance data
	private List<Integer> list1 = new ArrayList<Integer>();
	
	private List<Integer> list2 = new ArrayList<Integer>();
	
	// all workers may perform task1 -> add to list a random number after thinking for 1ms
	public void task1() {
		
		/*
		 * with synchronized blocks, two threads can run the same method task1() at the same time,
		 * because one thread will acquire the lock1, and the second thread will wait for the
		 * code block to be free.
		 * 
		 * In the meantime, it will run the second method task2().
		 * */
		
		//synchronized code block1
		synchronized (lock1) {
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list1.add(randomNumber.nextInt(100));
			
		}
	}
	
	//all worker may perform task2 -> add to list a random number after thinking for 1ms
	public void task2() {
		
		//synchronized code block
		synchronized (lock2) {
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			list2.add(randomNumber.nextInt(100));
			
		}
		
	}
	
	// process both tasks sequentally
	public void process() {
		
		for (int i = 0; i < 1000; i++) {
			task1();
			task2();
		}
		
	}
	
	
	public void morningGreetings() {
		
		System.out.println("Hello all, good morning");
		
		//moment process starts
		long start = System.currentTimeMillis();
		
		//create thread1
		Thread thread1 = new Thread(new Runnable() {
			public void run() {
				//execute both tasks at the same time
				process();
			}
		});
		
		//create thread2
		Thread thread2 = new Thread(new Runnable() {
			public void run() {
				//execute both tasks at the same time
				process();
			}
		});
		
		//start and wait for thread1 and thread2 to finish
		try {
			
			//start thread1
			thread1.start();
			//start thread2
			thread2.start();
			
			//wait for thread1 to finish
			thread1.join();
			//wait for thread2 to finish
			thread2.join();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//moment process ends
		long end = System.currentTimeMillis();
		
		System.out.println("time take: " + (end-start));
		
		System.out.println("list1: " + list1.size() + "; List2: " + list2.size());
		
	}

}
