package day0509.lianxi;
/**
 * 求某年某月的天数
 * @author Administrator
 */
public class Demo3_3 {
	public static void main(String[] args) {
		int year = 2018;
		int month = 2;
		switch(month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				System.out.println("31天");
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				System.out.println("30天");
				break;
			case 2:
				if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
					System.out.println("29天");
				} else {
					System.out.println("28天");
				}
				break;
			default:
				System.out.println("输入的月份有误");
				break;
		}
	}
}
