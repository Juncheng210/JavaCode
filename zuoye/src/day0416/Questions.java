package day0416;

public class Questions {
	public static void main(String[] args) {
		//��ҵ�⣺�������������������1�������鼰�䳤�ȡ�
		//�磺1 2 6 7 8 9 5 4 5 6 2 3����������1���������У�
		//1 2, 6 7 8 9,5,4 5 6,2 3�������������Ϊ6 7 8 9���䳤��Ϊ4(��) 
		int[] arr = {1,2,6,7,8,9,5,4,5,6,2,3};
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]-arr[i]==1) {
				System.out.print(arr[i]+" ");
			}
		}
	}
}
