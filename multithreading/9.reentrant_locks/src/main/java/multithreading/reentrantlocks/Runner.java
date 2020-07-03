package multithreading.reentrantlocks;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private int count = 0;
	
	// Reentrant lock object for thread locking
	/*
	 *ReentrantLock allow threads to enter into lock on a resource more than once. 
	 *When the thread first enters into lock, a hold count is set to one. 
	 *Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one. 
	 *For every unlock request, hold count is decremented by one and when hold count is 0, 
	 *the resource is unlocked.
	 * */
	private Lock lock = new ReentrantLock();
	
	private void increment() {
		
		for (int i = 0; i < 10000; i++ ) {
		    count++;
		}		
	}
	
	
	public void firstThread() {
		
		// only one thread locks the lock object. the others quietly wait
		lock.lock();

		/*
		 * it is good practice to surround the logic in a try block, with the unlock
		 * of the lock in the finally.
		 * It will allow the thread to unlock the lock if some exception is throw
		 * in the logic block
		 * */
		try {
			increment();
		}finally {
			lock.unlock();
		}
	}
	
	public void secondThread() {
		
		// only one thread locks the lock object. the others quietly wait
		lock.lock();
		
		/*
		 * it is good practice to surround the logic in a try block, with the unlock
		 * of the lock in the finally.
		 * It will allow the thread to unlock the lock if some exception is throw
		 * in the logic block
		 * */
		try {
			increment();
		}finally {
			lock.unlock();
		}
		
		
		
	}
	
	public void finished() {
		
		System.out.println("Count is - " + count);
		
	}
	

}
