package day0416;

import java.util.Random;

public class ArrayDemo1 {

	public static void main(String[] args) {
		//��ά����
//		int[][] arr1 = new int[3][];
//		int[][] arr2 = new int[3][2];
//		int[][] arr3 = new int[][]{{1,2,3},{4,5,6,7}};
//		int[][] arr4 = {{1},{2,3},{4,5,6}};
//		System.out.println(arr4.length);
		/*
		//�ж�һ����ά�����Ƿ���ĳ������
		int[][] arr = new int[3][5];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rand.nextInt(30);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		int num = 10;
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]==num) {
					System.out.println("�ڵ�"+(i+1)+"�У���"+(j+1)+"��");
					return;
				}
			}
		}
		*/
		int[][] arr = {{100},{2,3,40},{50,6}};
		int max = arr[0][0];
		int x = 0;
		int y = 0;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j]>max) {
					max = arr[i][j];
					x = i;
					y = j;
				}
			}
		}
		System.out.println("���ֵΪ��"+max+",��λ��Ϊ��("+(x+1)+","+(y+1)+")");
	}

}
