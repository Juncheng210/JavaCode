package day0418;

import java.util.Arrays;

public class ReturnValue {
	public static void main(String[] args) {
		ReturnValue rv = new ReturnValue();
		String s = rv.count(5, 10);
		String[] ss = s.split(",");
		System.out.println(Arrays.toString(ss));
		System.out.println("和："+ss[0]);
		System.out.println("差："+ss[1]);
		System.out.println("积："+ss[2]);
		System.out.println("商："+ss[3]);
	}
	
	public void eat() {
		System.out.println("吃饭");
	}
	/**
	 * 计算两个整数的和、差、积、商
	 * @param a：第一个值
	 * @param b：第二个值
	 * @return 返回值为传入值的和差积商，为字符串类型
	 */
	public String count(int a,int b) {
		int sum = a + b;  //和
		int minus = a - b;  //差
		int product = a * b;  //积
		double div = a*1.0 / b;  //商
		return sum+","+minus+","+product+","+div;
	}
}
