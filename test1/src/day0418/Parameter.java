package day0418;

public class Parameter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parameter p = new Parameter();
		System.out.println( p.getMaxValue(2.1, 1.5, 2.9) );
		
		Student zhangsan = new Student();
		zhangsan.name = "张三";
		zhangsan.age = 25;
		zhangsan.chinese = 68;
		zhangsan.math = 77;
		zhangsan.english = 86;
		
		System.out.println(p.stat(zhangsan));
	}
	/**
	 * 求任意三个小数的最大值
	 * @param a
	 * @param b
	 * @param c
	 * @return 返回最大值
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
	 * 传入一个Student类的对象，获取该对象成绩最高的科目
	 * @param s Student类的一个对象
	 * @return 该对象成绩最高的科目
	 */
	public String stat(Student s) {
		if(s.chinese>s.math && s.chinese>s.english) {
			return "语文";
		}else if(s.math>s.english) {
			return "数学";
		}
		return "英语";
	}
}
