package multithreading.semaphores;

import java.util.concurrent.Semaphore;

// the idea is to create new connections from the connection class
public class Connection {

	private static Connection instance = new Connection();
	
	// it will tell us the number of connections in a given moment
	private int connectionsCount = 0;
	
	//limit the number of connections to 10 at a time with a Semaphore
	private Semaphore semaphore = new Semaphore(10, true);
	
	//singleton
	private Connection() {
		
	}

	public static Connection getInstance() {
		return instance;
	}

	public void connect() throws InterruptedException {
		
		/*
		 * Acquires a permit from the semaphore, if one is available and returns immediately,
		 * reducing the number of available permits by one
		 * */
		semaphore.acquire();
		
		try {
			doConnect();
		}
		finally { 
			/*
			 * Always release the permit, either there is an exception error or not
			 * 
			 * Releases a permit, increasing the number of available permits byone. 
			 * If any threads are trying to acquire a permit, 
			 * then one isselected and given the permit that was just released. 
			 */
			semaphore.release();
		}
		
		
	}
	
	public void doConnect() throws InterruptedException {
		
		//increment the number of connections
		synchronized (this) {
			connectionsCount++;
			System.out.println("Start - Current connections - " + connectionsCount);
		}
		
		Thread.sleep(2000);
		
		//decrement the number of connections
		synchronized (this) {
			connectionsCount--;
			System.out.println("End - Current connections - " + connectionsCount);
		}
			
	}

}
