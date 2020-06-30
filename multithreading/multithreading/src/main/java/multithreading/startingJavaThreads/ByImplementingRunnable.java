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

//2. Implement runnable and pass it to the constructor of the thread class
class Runner2 implements Runnable {

	public void run() {
		
		//code to run on each separated thread
		for (int i = 0; i < 10; i++) {
			System.out.println("Hello " + i);

			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	
}

public class ByImplementingRunnable {

	public static void main(String[] args) {
		
		Thread thread1 = new Thread(new Runner2()); //pass the Runner class to the constructor of the thread class
		thread1.start();
		
		Thread thread2 = new Thread(new Runner2()); //pass the Runner class to the constructor of the thread class
		thread2.start();
	}

}
