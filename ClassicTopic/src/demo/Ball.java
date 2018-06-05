package demo;

import java.util.Random;

public class Ball {

	public static void main(String[] args) {
		/*
		 模拟双色球：6+1
		 前面6个红球，范围是[1,33]
		 后面1个球，范围是[1,16]
		 前面6个球不允许重复，利用随机数生成一组双色球开奖号码
		 例如：1 3 9 2 11 33-15
		*/
		int[] arr = new int[7];
		Random rand = new Random();
		for(int i=0; i<arr.length-1; i++) {  //给数组每一项赋值
			arr[i] = rand.nextInt(33)+1;
			for(int j=0; j<i; j++) {  //遍历已经赋值过的数组元素
				if(arr[j]==arr[i]) {  //判断已经赋值的数组元素是否和新的随机数相等
					i--;
					break;
				}
			}
		}
		
		arr[arr.length-1] = rand.nextInt(16)+1;  //为最后一项赋值
		
		for(int i=0; i<arr.length; i++) {  //遍历数组
			if(i==arr.length-2) {  //控制输出格式
				System.out.print(arr[i]+"-");
			} else {
				System.out.print(arr[i]+" ");
			}
			
		}

	}

}
