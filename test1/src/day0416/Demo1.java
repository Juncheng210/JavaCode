package day0416;

import java.util.Random;

public class Demo1 {
	public static void main(String[] args) {
		//������Ԫ�ص����ֵ����λ�ã�����Сֵ����λ�ã���ƽ��ֵ����
		
		int[] arr = new int[10];
		Random rand = new Random();
		for(int i=0; i<arr.length; i++) {
			arr[i] = rand.nextInt(100);
			System.out.print(arr[i] + " ");
		}
		
		int arrMax = arr[0];
		int index = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>arrMax) {
				arrMax = arr[i];
				index = i;
			}
		}
		System.out.println("�������ֵΪ��"+ arrMax + "����Ӧλ��Ϊ����" + (index+1) + "��");
		
		System.out.println("---------------------------------------------------------------");
		
		//�����������������-ǰ�������ֵ
		int max = arr[1] - arr[0];
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i+1]-arr[i]>max) {
				max = arr[i+1]-arr[i];
			}
		}
		System.out.println("��������֮�����ֵΪ��"+max);
	}
}
