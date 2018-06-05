package day0509.lianxi;
/**
 * 输入一个年份值，判断是否是闰年，输出相应的信息。
 * @author Administrator
 */
public class Demo3_1 {
	public static void main(String[] args) {
		int year = 2018;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
	}
		
}
