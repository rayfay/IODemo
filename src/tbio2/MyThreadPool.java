package tbio2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {

	private ExecutorService pool = null;

	//�����̳߳�
	public MyThreadPool(int max,int capacity) {
		pool = new ThreadPoolExecutor(
				Runtime.getRuntime().availableProcessors(),    //��ʼ(cpu����)
				max, 
				120l, 
				TimeUnit.SECONDS, 
				new ArrayBlockingQueue<Runnable>(capacity));
	}
	
	public void execute(Runnable r) {
		pool.execute(r);
	}
	
}
