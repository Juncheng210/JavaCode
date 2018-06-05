package day0509.lianxi;
/**
 * 求S=1+2+3+…+n之和，S＜1000的最大n的值
 * @author Administrator
 */
public class Demo3_5 {
	public static void main(String[] args) {
		int s = 0;
		int n = 1;
		while(true) {
			s += n;
			if(s>=1000) {
				System.out.println(n-1);
				return;
			}
			n++;
		}
	}
}
