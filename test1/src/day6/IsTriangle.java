package day6;

public class IsTriangle {

	public static void main(String[] args) {
		//���� 3 ���������ж��ܷ񹹳�һ��������
		int a = 3;
		int b = 5;
		int c = 5;
		
		if(a<=0 || b<=0 || c<=0) {
			System.out.println("����������붼�����㣡");
		} else if((a+b)>c && (a+c)>b && (b+c)>a){
			System.out.println(a+","+b+","+c+"�ܹ��������Σ�");
		} else {
			System.out.println(a+","+b+","+c+"���ܹ��������Σ�");
		}
	}

}
