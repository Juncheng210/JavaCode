package demo;

public class MultipleSum {

	public static void main(String[] args) {
		//�� while ѭ�������� 1~200 ֮������ 3 �ı���֮��
		int a = 3;
		int i = 3;
		int sum = 0;
		while(i<=200) {
			if(i%3==0) {
				sum += i;
			}
			i++;
		}
		System.out.println("1~200֮������"+a+"�ı���֮��Ϊ��"+sum);
	}

}
