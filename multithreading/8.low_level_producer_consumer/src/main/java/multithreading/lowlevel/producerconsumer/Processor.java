package multithreading.lowlevel.producerconsumer;

import java.util.LinkedList;
import java.util.Random;

public class Processor {

	//shared data between the threads
	private LinkedList<Integer> list = new LinkedList<Integer>();
	
	private final int LIMIT = 10;
	
	//object to thread locking
	private Object lock = new Object();
	
	// add values to the list
	public void produce() throws InterruptedException {
		
		int value = 0;
		
		while(true) {	
			//synchronize this block
			synchronized (lock) {
				
				//if list is full, the thread wait for notification to proceed
				while (list.size() == LIMIT) {
					lock.wait();		
				}	
				list.add(value++);
				lock.notify();
			}
			
		}
		
	}
	
	//consume the first value of the list
	public void consume() throws InterruptedException {
		
		Random random = new Random();
		
		while(true) {
			
			synchronized (lock) {
				
				//if list is empty, the thread wait for notification to proceed
				while (list.size() == 0) {
					lock.wait();		
				}	
				
				int value = list.removeFirst();	
				System.out.println("List size - " + list.size() + "; Value is - " + value);
				
				//notify waiting thread to carry on execution
				lock.notify();
			}
			
			Thread.sleep(random.nextInt(1000));
		}
		
		
	}
	
}
