package day1;

public class shuixianhua {
	
	public static void main(String[] args) {
		/*
		 * ��ӡ�����е� "ˮ�ɻ��� "
		 * "ˮ�ɻ��� "��ָһ����λ�������λ���������͵��ڸ�������
		 * ���磺153��һ�� "ˮ�ɻ��� "����Ϊ153=1�����η���5�����η���3�����η���
		 * */
		int firstNum,secondNum,thirdNum;
		for(int i=100; i<1000; i++) {
			firstNum = i/100;
			secondNum = i/10%10;
			thirdNum = i%10;
			if(firstNum*firstNum*firstNum + secondNum*secondNum*secondNum + thirdNum*thirdNum*thirdNum == i){
				System.out.println("ˮ�ɻ���Ϊ��"+i);
			}
		}

	}

}
