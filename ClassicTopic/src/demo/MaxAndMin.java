package demo;

public class MaxAndMin {

	public static void main(String[] args) {
		//输入两个正整数m和n，求其最大公约数和最小公倍数
		int m = 16;
		int n = 24;
		
		//最大公约数
		for(int i=Math.min(m, n); i>0; i--) {
			if(m%i==0 && n%i==0) {
				System.out.println(m+"和"+n+"的最大公约数为："+i);
				break;
			}
		}
		
		//最小公倍数
		for(int i=Math.max(m, n); i>=m; i++) { //i>=m可省略
			if(i%m ==0 && i%n==0) {
				System.out.println(m+"和"+n+"的最小公倍数为："+i);
				break;
			}
		}
	}

}
