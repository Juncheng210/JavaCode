package day6;

public class IsTriangle {

	public static void main(String[] args) {
		//输入 3 个正数，判断能否构成一个三角形
		int a = 3;
		int b = 5;
		int c = 5;
		
		if(a<=0 || b<=0 || c<=0) {
			System.out.println("输入的数必须都大于零！");
		} else if((a+b)>c && (a+c)>b && (b+c)>a){
			System.out.println(a+","+b+","+c+"能构成三角形！");
		} else {
			System.out.println(a+","+b+","+c+"不能构成三角形！");
		}
	}

}
