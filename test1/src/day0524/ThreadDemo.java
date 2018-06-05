package day0524;
/**
 * 
 * @ClassName: ThreadDemo  
 * @Description: 兔子每秒5米，乌龟1米，兔子20米休息500毫秒 ,乌龟100米休息500毫秒！多线程模拟比赛过程。谁先跑完1000米谁获胜？沒跑完的就不跑了
 * @author Administrator  
 * @date 2018年5月24日  
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Rabbit rab = new Rabbit("兔子");
		Tortoise tor = new Tortoise("乌龟");
		rab.start();
		tor.start();
	}
}
