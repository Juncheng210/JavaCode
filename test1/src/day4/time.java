package day4;

public class time {

	public static void main(String[] args) {
		int h = 14;
		int m = 30;
		int s = 0;
		
//		while(s <= 59) {
//			s++;
//			
//			if(s == 60 && m < 35) {
//				m++;
//				s = 0;
//			}
//			
//			System.out.println(h + ":" + m + ":" + s);
//		}
		
		do {
			if(s<10) { //���������ʽһ��
				System.out.println(h + ":" + m + ":0" + s);
			} else {
				System.out.println(h + ":" + m + ":" + s);
			}
			s++;
			if(s==60) { //����ÿ��60������+1��������������Ϊ0
				m++;
				s = 0;
			}
		}while(m<35);

	}

}
