package day0509.lianxi;
/**
 * ��S=1+2+3+��+n֮�ͣ�S��1000�����n��ֵ
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
