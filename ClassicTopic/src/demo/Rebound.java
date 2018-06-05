package demo;

public class Rebound {

	public static void main(String[] args) {
		//一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？
		//第10次反弹多高？
		double height = 100;  //初始高度
		double sum = 0;  //总高度
		for(int i=1; i<=10; i++) {
			if(i==1) {
				sum = height;
			} else {
				sum = sum + 2*height;
			}
			height = height/2;
		}
		System.out.println("该球在第10次落地时共经过"+sum+"米");
		System.out.println("该球在第10次反弹高度为："+height+"米");
	}

}
