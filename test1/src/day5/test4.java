package day5;

public class test4 {
	public static void main(String[] args) {
		/*
		 * ��ӡ����
		 * */
		int cengNum = 7;//�����ϰ벿�ִ�ӡ����
		
		//�ϰ벿��
		for(int i=1; i<=cengNum; i++) {
			for(int m=cengNum-1; m>=i; m--) {//int i=1; i<=cengNum-i; i++
				System.out.print(" ");//�ո����
			}
			for(int n=1; n<=i*2-1; n++) {
				System.out.print("*");//*�ſ���
			}
			System.out.println();
		}
		
		//�°벿��(�������)
		for(int i=cengNum-1; i>=1; i--) {
			for(int m=cengNum-1; m>=i; m--) {
				System.out.print(" ");//�ո����
			}
			for(int n=1; n<=i*2-1; n++) {
				System.out.print("*");//*�ſ���
			}
			System.out.println();
		}
	}
}
