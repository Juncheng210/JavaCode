package demo;

public class Rebound {

	public static void main(String[] args) {
		//һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룻�����£������ڵ�10�����ʱ�������������ף�
		//��10�η�����ߣ�
		double height = 100;  //��ʼ�߶�
		double sum = 0;  //�ܸ߶�
		for(int i=1; i<=10; i++) {
			if(i==1) {
				sum = height;
			} else {
				sum = sum + 2*height;
			}
			height = height/2;
		}
		System.out.println("�����ڵ�10�����ʱ������"+sum+"��");
		System.out.println("�����ڵ�10�η����߶�Ϊ��"+height+"��");
	}

}
