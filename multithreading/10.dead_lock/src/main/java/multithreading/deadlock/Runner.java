package multithreading.deadlock;

import java.lang.Character.UnicodeScript;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	
	private Account account1 = new Account();
	private Account account2 = new Account();
	
	// Reentrant lock object for thread locking
	/*
	 *ReentrantLock allow threads to enter into lock on a resource more than once. 
	 *When the thread first enters into lock, a hold count is set to one. 
	 *Before unlocking the thread can re-enter into lock again and every time hold count is incremented by one. 
	 *For every unlock request, hold count is decremented by one and when hold count is 0, 
	 *the resource is unlocked.
	 * */
	private Lock lock1 = new ReentrantLock();
	private Lock lock2 = new ReentrantLock();
	
	
	/*
	 * method that will receive locks and unlock locked locks
	 * */
	private void acquireLocks(Lock firstLock, Lock secondLock) throws InterruptedException {
		
		while(true) {
			
			boolean gotFirstLock = false;
			boolean gotSecondLock = false;
			
			//try to acquire both locks. the result may be true or false
			try {
				gotFirstLock = firstLock.tryLock(50, TimeUnit.MILLISECONDS);
				gotSecondLock = secondLock.tryLock(50, TimeUnit.MILLISECONDS);
			}
			finally {
				//always check if both locks are acquired. if they are acquired, everyting is ok
				if(gotFirstLock && gotSecondLock) {
					System.out.println("both locks are locked");
					return;
				}
				
				// if first lock is acquired, unlock it. Otherwise, it will generate a deadlock
				if(gotFirstLock) {
					firstLock.unlock();
					System.out.println("first lock was unlocked");
				}
				
				// if second lock is acquired, unlock it. Otherwise, it will generate a deadlock
				if(gotSecondLock) {
					secondLock.unlock();
					System.out.println("second lock was unlocked");
				}
			}
			//lock not acquired. So, wait for 1ms and try it again
			Thread.sleep(1);
		}
	}
	
	public void firstThread() throws InterruptedException {
		
		Random random = new Random();
		
		//do a bunch of transfers from account1 to account2
		for(int i=0; i< 10000; i++) {
			
			//lock both accounts 
			acquireLocks(lock1, lock2);
			
			/*
			 * it is good practice to surround the logic in a try block, with the unlock
			 * of the lock in the finally.
			 * It will allow the thread to unlock the lock if some exception is throw
			 * in the logic block
			 * */
			try {
				Account.transfer(account1, account2, random.nextInt(100));
			}
			finally {
				//lock both accounts 
				lock1.unlock();
				lock2.unlock();
			}
			
		}
	}
	
	public void secondThread() throws InterruptedException {
		
		Random random = new Random();
		
		//do a bunch of transfers from account1 to account2
		for(int i=0; i< 10000; i++) {
			
			//lock both accounts
			acquireLocks(lock2, lock1);
			
			/*
			 * it is good practice to surround the logic in a try block, with the unlock
			 * of the lock in the finally.
			 * It will allow the thread to unlock the lock if some exception is throw
			 * in the logic block
			 * */
			try {
				Account.transfer(account2, account1, random.nextInt(100));
			}
			finally {
				//lock both accounts 
				lock1.unlock();
				lock2.unlock();
			}
			
		}
		
	}
	
	public void finished() {
		System.out.println("Account1 balance: " + account1.getBalance());
		System.out.println("Account2 balance: " + account2.getBalance());
		System.out.println("Total balance: " + (account1.getBalance() + account2.getBalance()) + ". (The expected total balance should be 20000)");
	}

}
