package day0528;
/**
 * 
 * @ClassName: Demo1  
 * @Description: 保证多线程的有序性
 * @author Administrator  
 * @date 2018年5月28日  
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		new Thread(new Child("1")).start();
		new Thread(new Child("2")).start();
		new Thread(new Child("3")).start();
		new Thread(new Child("4")).start();
		new Thread(new Child("5")).start();
		new Thread(new Child("6")).start();
		new Thread(new Child("7")).start();
		new Thread(new Child("8")).start();
		new Thread(new Child("9")).start();
		new Thread(new Child("10")).start();
	}
} 