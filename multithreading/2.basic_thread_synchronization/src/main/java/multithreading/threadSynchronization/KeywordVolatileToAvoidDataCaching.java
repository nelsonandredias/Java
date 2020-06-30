package multithreading.threadSynchronization;

import java.io.InputStream;
import java.util.Scanner;

/*
 * Problems coming from multiple threads sharing the same data:
 * 1. data being cached
 * 		Solution: Use the keyword "volatile" to prevent thread caching variables when they are not
 *                changed from within that thread.
 * 2. Thread interleaving
 * 	    Solution: Use the keyword "synchronized" to make data shared between multiple threads synchronous.
 * 
 * What is thread interleaving?
 * Interference that happens when two operations, running in different threads, but acting on the same data,
 *  interleave.
 * */

class Processor extends Thread {

	//threads variable -> use keyword "volatile" to prevent data caching
	private volatile boolean running = true;
	
	public void run() {
		
		//code to run on each separated thread
		while (running) {
			System.out.println("Hello ");
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		}
	}
	
	public void shutdown() {
		
		running = false;
	}
	
}

public class KeywordVolatileToAvoidDataCaching {

	public static void main(String[] args) {
		
		Processor processor1 = new Processor();
		processor1.start();

		System.out.println("Press return to stop...");
		//Scan inputstream from keyboard ---> expect pressing "Enter" in the console
		Scanner scanner = new Scanner(System.in);
		scanner.nextLine();
		
		// stop the while loop
		processor1.shutdown();
		
	}

}
