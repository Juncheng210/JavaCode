package demo;

public class MaxAndMin {

	public static void main(String[] args) {
		//��������������m��n���������Լ������С������
		int m = 16;
		int n = 24;
		
		//���Լ��
		for(int i=Math.min(m, n); i>0; i--) {
			if(m%i==0 && n%i==0) {
				System.out.println(m+"��"+n+"�����Լ��Ϊ��"+i);
				break;
			}
		}
		
		//��С������
		for(int i=Math.max(m, n); i>=m; i++) { //i>=m��ʡ��
			if(i%m ==0 && i%n==0) {
				System.out.println(m+"��"+n+"����С������Ϊ��"+i);
				break;
			}
		}
	}

}
