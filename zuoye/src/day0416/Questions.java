package day0416;

public class Questions {
	public static void main(String[] args) {
		//作业题：求数组中最长的连续增加1的子数组及其长度。
		//如：1 2 6 7 8 9 5 4 5 6 2 3中依次增加1的子数组有：
		//1 2, 6 7 8 9,5,4 5 6,2 3其中最长的子数组为6 7 8 9，其长度为4(答案) 
		int[] arr = {1,2,6,7,8,9,5,4,5,6,2,3};
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]-arr[i]==1) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
