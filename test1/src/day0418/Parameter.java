package day0418;

public class Parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parameter p = new Parameter();
		System.out.println( p.getMaxValue(2.1, 1.5, 2.9) );
		
		Student zhangsan = new Student();
		zhangsan.name = "����";
		zhangsan.age = 25;
		zhangsan.chinese = 68;
		zhangsan.math = 77;
		zhangsan.english = 86;
		
		System.out.println(p.stat(zhangsan));
	}
	/**
	 * ����������С�������ֵ
	 * @param a
	 * @param b
	 * @param c
	 * @return �������ֵ
	 */
	public double getMaxValue(double a,double b,double c) {
		if(a>b && a>c) {
			return a;
		}else if(b>c) {
			return b;
		}
		return c;
	}
	/**
	 * ����һ��Student��Ķ��󣬻�ȡ�ö���ɼ���ߵĿ�Ŀ
	 * @param s Student���һ������
	 * @return �ö���ɼ���ߵĿ�Ŀ
	 */
	public String stat(Student s) {
		if(s.chinese>s.math && s.chinese>s.english) {
			return "����";
		}else if(s.math>s.english) {
			return "��ѧ";
		}
		return "Ӣ��";
	}
}
