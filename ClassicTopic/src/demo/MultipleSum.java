package demo;

public class MultipleSum {

	public static void main(String[] args) {
		//用 while 循环，计算 1~200 之间所有 3 的倍数之和
		int a = 3;
		int i = 3;
		int sum = 0;
		while(i<=200) {
			if(i%3==0) {
				sum += i;
			}
			i++;
		}
		System.out.println("1~200之间所有"+a+"的倍数之和为："+sum);
	}

}
