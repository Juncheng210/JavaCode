package day0509.lianxi;
/**
 * 编写程序，提供实现各种数学计算的方法。包括如下几项。
 *（1）两个数的加、减、乘、除。
 *（2）求某数的相反数、倒数、绝对值。
 *（3）取两数中较大的和较小的。
 *（4）对浮点数（double型）的计算功能。如：给定浮点数d，取大于或等于d的最小整数，取小于或等于d的最大整数，计算最接近d的整数值，计算d的平方根、自然对数log(d)等。
 *（5）计算以double型数a为底数，b为指数的幂。
 * @author Administrator
 *
 */
public class Demo5_3 {
	public Demo5_3() {}
	/**
	 * 两数求和
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getSum(double a, double b) {
		return a + b;
	}
	/**
	 * 两数求差
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getJian(double a, double b) {
		return a - b;
	}
	/**
	 * 两数求积
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getCheng(double a, double b) {
		return a * b;
	}
	/**
	 * 两数求商
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getChu(double a, double b) {
		return a / b;
	}
	/**
	 * 求相反数
	 * @param num
	 * @return
	 */
	public static int getOppo(int num) {
		return -num;
	}
	/**
	 * 求倒数
	 * @param num
	 * @return
	 */
	public static double getDaoShu(double num) {
		return 1.0 / num;
	}
	/**
	 * 求绝对值
	 * @param num
	 * @return
	 */
	public static double getAbs(double num) {
		return num>=0 ? num : -num;
	}
	/**
	 * 两数求最大值
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getMax(double a, double b) {
		return a>b ? a :b;
	}
	public static void main(String[] args) {
		
	}
}
