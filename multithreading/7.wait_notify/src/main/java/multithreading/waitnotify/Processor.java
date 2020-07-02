package multithreading.waitnotify;

import java.io.InputStream;
import java.util.Scanner;

public class Processor {
	
	public void produce() throws InterruptedException {
		
		//use the intrinsic object lock of the Processor object
		synchronized (this) {
			System.out.println("Producer thread running....");
			
			/*every object in java have an wait() method and it waits without consuming cpu resources
			* to be carry on the execution after notification
			*/
			wait();
			System.out.println("Resumed");
		}
		
	}
	
	
	public void consume() throws InterruptedException {
		
		Scanner scanner = new Scanner(System.in);		
		
		Thread.sleep(2000);
		
		synchronized (this) {
			System.out.println("Waiting for return key.");
			scanner.nextLine();
			System.out.println("Return key pressed!");
			
			// notify the waiting thread to resume is execution
			notify();
			
			Thread.sleep(5000);
		}
	}

}
