package day0503;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		//大小为100的整数数组，利用随机数为其赋值，取值范围[1,100]
		//统计次数出现最多的数字
		//寻找是否含有某个特殊的数字[1,100],如50，若有，输出所有位置；没有则输出没有
		int[] arr = new int[100];
		
		Random r = new Random();
		Scanner s = new Scanner(System.in);
		
		//为数组赋值
		for(int i=0; i<arr.length; i++) {
			arr[i] = r.nextInt(100)+1;
		}
		System.out.println(Arrays.toString(arr));
		
		//统计次数出现最多的数字
		int[] num = new int[arr.length];
		int count = 0;
		for(int i=0 ;i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					count++;
				}
			}
			num[i] = count;
			count = 0;
		}
		int max = num[0];
		int index = 0;
		for(int i=0; i<num.length; i++) {
			if(num[i]>max) {
				max = num[i];
				index = i;
			}
		}
		System.out.println("出现次数最多的数为："+arr[index]);
		
		//查询位置
		System.out.print("请输入1-100之间的任意一个数来执行查询：");
		int m = s.nextInt();
		s.close();
		boolean onOff = true;
		for(int i=0; i<arr.length; i++) {
			if(m==arr[i]) {
				System.out.println("您查找的数字在第 " + (i+1) + "位");
				onOff = false;
			}
		}
		if(onOff) {
			System.out.println("数组中没有要查询的数");
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
}
