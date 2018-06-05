package day0509.lianxi;
/**
 * 求从1到100之间所有奇数的平方和（用for、while和do……while编写程序）
 * @author Administrator
 */
public class Demo3_4 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=100; i+=2) {
			sum += Math.pow(i, 2);
		}
		System.out.println(sum);
	}
}
