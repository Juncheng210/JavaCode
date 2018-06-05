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
			if(s<10) { //控制输出格式一致
				System.out.println(h + ":" + m + ":0" + s);
			} else {
				System.out.println(h + ":" + m + ":" + s);
			}
			s++;
			if(s==60) { //秒针每到60，分钟+1；秒钟重新设置为0
				m++;
				s = 0;
			}
		}while(m<35);

	}

}
