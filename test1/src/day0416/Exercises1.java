package day0416;

import java.util.Random;

public class Exercises1 {

	public static void main(String[] args) {
		//һ��5*5�Ķ�ά���飬���������Ϊ�丳ֵ���������Խ����ϵ�Ԫ��
		int[][] arr = new int[5][5];  //��������
		
		Random rand = new Random();
		//��ʼ������
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rand.nextInt(1000);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//�Խ���1������-���£�
		System.out.print("���Խ���Ԫ��Ϊ��");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
		
		//�Խ���2������-���£�
		System.out.print("���Խ���Ԫ��Ϊ��");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i+j==4) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
	}

}
