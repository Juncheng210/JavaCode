package demo;

import java.util.Random;

public class Ball {

	public static void main(String[] args) {
		/*
		 ģ��˫ɫ��6+1
		 ǰ��6�����򣬷�Χ��[1,33]
		 ����1���򣬷�Χ��[1,16]
		 ǰ��6���������ظ����������������һ��˫ɫ�򿪽�����
		 ���磺1 3 9 2 11 33-15
		*/
		int[] arr = new int[7];
		Random rand = new Random();
		for(int i=0; i<arr.length-1; i++) {  //������ÿһ�ֵ
			arr[i] = rand.nextInt(33)+1;
			for(int j=0; j<i; j++) {  //�����Ѿ���ֵ��������Ԫ��
				if(arr[j]==arr[i]) {  //�ж��Ѿ���ֵ������Ԫ���Ƿ���µ���������
					i--;
					break;
				}
			}
		}
		
		arr[arr.length-1] = rand.nextInt(16)+1;  //Ϊ���һ�ֵ
		
		for(int i=0; i<arr.length; i++) {  //��������
			if(i==arr.length-2) {  //���������ʽ
				System.out.print(arr[i]+"-");
			} else {
				System.out.print(arr[i]+" ");
			}
			
		}

	}

}
