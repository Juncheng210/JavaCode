package day0418;

import java.util.Arrays;

public class ReturnValue {
	public static void main(String[] args) {
		ReturnValue rv = new ReturnValue();
		String s = rv.count(5, 10);
		String[] ss = s.split(",");
		System.out.println(Arrays.toString(ss));
		System.out.println("�ͣ�"+ss[0]);
		System.out.println("�"+ss[1]);
		System.out.println("����"+ss[2]);
		System.out.println("�̣�"+ss[3]);
	}
	
	public void eat() {
		System.out.println("�Է�");
	}
	/**
	 * �������������ĺ͡��������
	 * @param a����һ��ֵ
	 * @param b���ڶ���ֵ
	 * @return ����ֵΪ����ֵ�ĺͲ���̣�Ϊ�ַ�������
	 */
	public String count(int a,int b) {
		int sum = a + b;  //��
		int minus = a - b;  //��
		int product = a * b;  //��
		double div = a*1.0 / b;  //��
		return sum+","+minus+","+product+","+div;
	}
}
