package day5;

public class ZuoYe2 {

	public static void main(String[] args) {
		//һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ "���� "��
		//����6=1��2��3.����ҳ�1000���ڵ���������
		
		for(int i=1; i<=1000; i++) {
			int sum = 0;  //���ڼ�¼ĳ�����ӵĺ�
			for(int j=1; j<i/2+1; j++) {
				if(i%j==0) {
					sum += j;  //����ÿ�����ӵĺ�
				}
			}
			if(sum == i) {
				System.out.println(i);
			}
		}
	}
}
