package multithreading.startingJavaThreads;

/*
 * JAVA Thread:
 * Is kind a like a separated operating system process,
 * which can run concurrently with other threads.
 * */

/*
 * The two basic ways to create and start a JAVA Thread:
 * 
 * -> 1. Extend Thread class
 * -> 2. Implement runnable and pass it to the constructor of the thread class
 * 3. Implement custom runnable in the constructor of the thread class
 */

//3. Implement custom runnable in the constructor of the thread class
public class ByImplementingCustomRunnable {

	public static void main(String[] args) {
		
		//Implement Custom runnable for thread1
		Thread thread1 = new Thread(new Runnable() {
			
			public void run() {
				
				//code to run on thread 1
				for (int i = 0; i < 5; i++) {
					System.out.println("Hello " + i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		});
		
		thread1.start();

		//Implement Custom runnable for thread2
		Thread thread2 = new Thread(new Runnable() {

			public void run() {

				//code to run on thread 2
				for (int i = 0; i < 5; i++) {
					System.out.println("Goodbye " + i);

					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}	
			}
		});

		thread2.start();
	}

}
