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
			//���ƿո�
			for(int k=1; k<arr.length-i; k++) {
				System.out.print("\t");
			}
			//�������
			for(int j=0; j<=i; j++) {
				System.out.print(arr[i][j]+"\t\t");
			}
			System.out.println();
		}*/
		//��n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ���������µ���ԭ���ڼ��ŵ���λ��
		Scanner in = new Scanner(System.in);
		System.out.println("����������n��ֵ��");
		int n = in.nextInt();
		boolean[] a = new boolean[n];
		for(int i=0; i<a.length; i++) {
			a[i] = true;
		}
		
		int num = n;//ʣ������
		int index = 0;//�����±�
		int count = 0;//��¼��������
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
				System.out.println("���µ���ԭ���ĵ�"+(i+1)+"λ");
			}
		}
	}
}
