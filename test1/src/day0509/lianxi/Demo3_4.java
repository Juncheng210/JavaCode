package day0509.lianxi;
/**
 * ���1��100֮������������ƽ���ͣ���for��while��do����while��д����
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
