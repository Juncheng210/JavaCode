package day0504;
/**
 * 定义一个计算器类，包括加减乘除运算
 * @author Administrator
 */
public class Calculator {
	/**
	 * 计算两个数的和
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getSum(int a,int b) {
		return a+b;
	}
	/**
	 * 计算两个数的差
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getJian(int a,int b) {
		return a-b;
	}
	/**
	 * 计算两个数的积
	 * @param a
	 * @param b
	 * @return
	 */
	public static int getCheng(int a,int b) {
		return a * b;
	}
	/**
	 * 计算两个数的商
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getChu(int a,int b) {
		return a / b;
	}
}
