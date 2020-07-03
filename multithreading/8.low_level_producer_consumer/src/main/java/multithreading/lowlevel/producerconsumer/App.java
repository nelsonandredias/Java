package multithreading.lowlevel.producerconsumer;


public class App {

	public static void main(String[] args) throws InterruptedException {

		final Processor processor = new Processor();
		
		//create a Thread1
		Thread thread1 = new Thread(new Runnable() {

			public void run() {
				try {
					processor.produce();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		});

		//create a Thread2
		Thread thread2 = new Thread(new Runnable() {

			public void run() {
				try {
					processor.consume();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
		});
		
		//start both threads
		thread1.start();
		thread2.start();
		
		//wait for threads to finish
		thread1.join();
		thread2.join();

	}

}
