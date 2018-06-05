package day6;

import java.util.Random;

public class Guess {

	public static void main(String[] args) {
		//验证“鬼谷猜想”：对任意自然数，若是奇数，就对它乘以 3 再加 1；若是
		//偶数，就对它除以 2，这样得到一个新数，再按上述计算规则进行计算，一直进
		//行下去，最终必然得到 1
		int maxNum = 100000;
		
		Random rand = new Random();
		int randNum = rand.nextInt(maxNum);
		System.out.println("生成的随机数为："+randNum);
		
		while(randNum!=1) {
			if(randNum%2==0) {
				randNum /= 2;
			} else {
				randNum = randNum*3+1;
			}
		}
		System.out.println(randNum);
		
	}

}
