package day0509.lianxi;
/**
 * ����һ�����ֵ���ж��Ƿ������꣬�����Ӧ����Ϣ��
 * @author Administrator
 */
public class Demo3_1 {
	public static void main(String[] args) {
		int year = 2018;
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "������");
		} else {
			System.out.println(year + "��������");
		}
	}
		
}
