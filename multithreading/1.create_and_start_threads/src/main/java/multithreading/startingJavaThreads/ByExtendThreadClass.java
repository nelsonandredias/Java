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

//1. Extend Thread class
class Runner1 extends Thread {

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

public class ByExtendThreadClass {

	
	public static void main(String[] args) {
		
		Runner1 runner1 = new Runner1();
		runner1.start(); // it will run the method run() on its own special thread

		Runner1 runner2 = new Runner1();
		runner2.start(); // it will run the method run() on its own special thread
	}

}
