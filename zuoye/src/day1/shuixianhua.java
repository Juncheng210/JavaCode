package day1;

public class shuixianhua {
	
	public static void main(String[] args) {
		/*
		 * 打印出所有的 "水仙花数 "
		 * "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。
		 * 例如：153是一个 "水仙花数 "，因为153=1的三次方＋5的三次方＋3的三次方。
		 * */
		int firstNum,secondNum,thirdNum;
		for(int i=100; i<1000; i++) {
			firstNum = i/100;
			secondNum = i/10%10;
			thirdNum = i%10;
			if(firstNum*firstNum*firstNum + secondNum*secondNum*secondNum + thirdNum*thirdNum*thirdNum == i){
				System.out.println("水仙花数为："+i);
			}
		}

	}

}
