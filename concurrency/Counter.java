package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


public class Counter {

	public static  int count = 0;
	public static  AtomicInteger i = new AtomicInteger(count);
	public static  void inc() {
		try {
			TimeUnit.MILLISECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		count++;
		i.addAndGet(1);
	}

	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		// 同时启动1000个线程，去进行i++计算，看看实际结果
		for (int i = 0; i < 1000; i++) {
			service.execute(new Runnable() {
				@Override
				public void run() {
					Counter.inc();
					System.out.println(count);
				}
			});
		}
		service.shutdown();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("运行结果:Counter.count=" + Counter.count +" ;i="+i.get());
		// 这里每次运行的值都有可能不同,可能为1000
	}
}
