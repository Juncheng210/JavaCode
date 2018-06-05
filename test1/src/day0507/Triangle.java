package day0507;

public class Triangle {
	/**
	 * ���õ׺͸������������
	 * @param a �����εĵױ�
	 * @param h �����εĸ�
	 */
	public void getArea(int a,int h) {
		double area = a * h / 2;
		System.out.println(area);
	}
	/**
	 * �����������
	 * @param a ����������һ��
	 * @param b ����������һ��
	 * @param angle a�ߺ�b�߼нǵ�����
	 */
	public void getArea(int a,int b, double angle) {
		double area = a * b * Math.sin(angle) / 2;
		System.out.println(area);
	}
	/**
	 * ���ú��׹�ʽ�����������
	 * @param a �����ε�һ���߳�
	 * @param b �����εڶ����߳�
	 * @param c �����ε������߳�
	 */
	public void getArea(int a,int b,int c) {
		double p = (a + b + c) / 2;
		double area = Math.sqrt( p * (p - a) * (p - b) * (p - c) );
		System.out.println(area);
	}
}
