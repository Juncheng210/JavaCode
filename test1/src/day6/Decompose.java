package day6;

public class Decompose {
	public static void main(String[] args) {
		//��һ���������ֽ������������磺����90 ����ӡ�� 90=2*3*3*5
		int integer = 90;
		/*
		System.out.print(integer+"=");
		for(int i=2; i<integer/2; i++) {
			while(integer%i==0) {
				integer /= i;
				System.out.print(i+"*");
			}
		}
		if(integer!=1) {
			System.out.println(integer);
		}
		*/
		int i = 2;
		while(true) {
			if(integer%i==0) {
				integer /= i;
				System.out.print(i+"*");
			} else {
				i++;
			}
			if(integer==1) {
				break;
			}
		}
	}
}
