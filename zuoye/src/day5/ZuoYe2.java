package day5;

public class ZuoYe2 {

	public static void main(String[] args) {
		//一个数如果恰好等于它的因子之和，这个数就称为 "完数 "。
		//例如6=1＋2＋3.编程找出1000以内的所有完数
		
		for(int i=1; i<=1000; i++) {
			int sum = 0;  //用于记录某数因子的和
			for(int j=1; j<i/2+1; j++) {
				if(i%j==0) {
					sum += j;  //计算每个因子的和
				}
			}
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
}
