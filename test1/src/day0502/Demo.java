package day0502;

//import java.util.Arrays;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		/*int[][] arr = new int[10][10];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<=i; j++) {
				if(j==0 || j==i) {
					arr[i][j] = 1;
				} else {
					arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
				}
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			//控制空格
			for(int k=1; k<arr.length-i; k++) {
				System.out.print("\t");
			}
			//控制输出
			for(int j=0; j<=i; j++) {
				System.out.print(arr[i][j]+"\t\t");
			}
			System.out.println();
		}*/
		//有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，问最后留下的是原来第几号的那位。
		Scanner in = new Scanner(System.in);
		System.out.println("请输入人数n的值：");
		int n = in.nextInt();
		boolean[] a = new boolean[n];
		for(int i=0; i<a.length; i++) {
			a[i] = true;
		}
		
		int num = n;//剩余人数
		int index = 0;//数组下标
		int count = 0;//记录所报的数
		while(num>1) {
			if(a[index]==true) {
				count++;
				if(count==3) {
					count = 0;
					a[index] = false;
					num--;
				}
			}
			
			index++;
			if(index == n) {
				index = 0;
			}
		}
		for(int i=0; i<a.length; i++) {
			if(a[i]==true) {
				System.out.println("留下的是原来的第"+(i+1)+"位");
			}
		}
	}
}
