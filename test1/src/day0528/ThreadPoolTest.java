package day0528;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {
	public static void main(String[] args) {
//		ExecutorService pool = Executors.newFixedThreadPool(3);
//		ExecutorService pool = Executors.newCachedThreadPool();
		ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
		
		for(int j=1; j<=5; j++) {
			Runnable run = new Runnable() {
				@Override
				public void run() {
					for(int i=1; i<=5; i++) {
						try {
							Thread.sleep(50);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						System.out.println(Thread.currentThread().getName()+"¡ª¡ª"+i);
					}
				}
			};
//			pool.scheduleAtFixedRate(run, 2, 5, TimeUnit.SECONDS);
		}
		Runnable a = new Runnable() {
			@Override
			public void run() {
				Date date = new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
				System.out.println(dateFormat.format(date));
			}
		};
		pool.scheduleAtFixedRate(a, 0, 1, TimeUnit.SECONDS);
	}
}
