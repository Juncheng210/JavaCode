package day0509.lianxi;
/**
 * ��д�����ṩʵ�ָ�����ѧ����ķ������������¼��
 *��1���������ļӡ������ˡ�����
 *��2����ĳ�����෴��������������ֵ��
 *��3��ȡ�����нϴ�ĺͽ�С�ġ�
 *��4���Ը�������double�ͣ��ļ��㹦�ܡ��磺����������d��ȡ���ڻ����d����С������ȡС�ڻ����d�����������������ӽ�d������ֵ������d��ƽ��������Ȼ����log(d)�ȡ�
 *��5��������double����aΪ������bΪָ�����ݡ�
 * @author Administrator
 *
 */
public class Demo5_3 {
	public Demo5_3() {}
	/**
	 * �������
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getSum(double a, double b) {
		return a + b;
	}
	/**
	 * �������
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getJian(double a, double b) {
		return a - b;
	}
	/**
	 * �������
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getCheng(double a, double b) {
		return a * b;
	}
	/**
	 * ��������
	 * @param a
	 * @param b
	 * @return
	 */
	public static double getChu(double a, double b) {
		return a / b;
	}
	/**
	 * ���෴��
	 * @param num
	 * @return
	 */
	public static int getOppo(int num) {
		return -num;
	}
	/**
	 * ����
	 * @param num
	 * @return
	 */
	public static double getDaoShu(double num) {
		return 1.0 / num;
	}
	/**
	 * �����ֵ
	 * @param num
	 * @return
	 */
	public static double getAbs(double num) {
		return num>=0 ? num : -num;
	}
	/**
	 * ���������ֵ
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
