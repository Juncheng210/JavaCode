package day0525.task;

import java.util.ArrayList;
import java.util.Random;

public class Ticket implements Runnable {
	private static ArrayList<Integer> list;
	/**
	 * 生成票数，并将其存在集合
	 */
	static {
		list = new ArrayList<Integer>();
		for(int i=1; i<=100; i++) {
			list.add(i);
		}
	}
	
	@Override
	public void run(){
		while(true){
			try {
				boolean f = sell();
				if(!f){
					break;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static synchronized boolean sell() throws InterruptedException {
		Thread t = Thread.currentThread();
		Random r = new Random();
		if(list.size()>0){
			System.out.println(t.getName()+"卖出"+list.remove( r.nextInt( list.size() ) ) );
			Thread.sleep(100);
			return true;
		}else{
			return false;
		}
	}
}
