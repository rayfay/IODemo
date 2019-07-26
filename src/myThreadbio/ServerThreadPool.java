package myThreadbio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ServerThreadPool {
	ExecutorService pool = null;
	public ServerThreadPool(int max,int capacity) {
		pool = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(),    //初始(cpu核数)
				max, 
				120l, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(capacity));
	}
	
	public void execute(Thread t) {
		pool.execute(t);
	}
	
	
}
