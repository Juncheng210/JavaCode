package day6;

import java.util.Random;

public class Guess {

	public static void main(String[] args) {
		//��֤����Ȳ��롱����������Ȼ���������������Ͷ������� 3 �ټ� 1������
		//ż�����Ͷ������� 2�������õ�һ���������ٰ��������������м��㣬һֱ��
		//����ȥ�����ձ�Ȼ�õ� 1
		int maxNum = 100000;
		
		Random rand = new Random();
		int randNum = rand.nextInt(maxNum);
		System.out.println("���ɵ������Ϊ��"+randNum);
		
		while(randNum!=1) {
			if(randNum%2==0) {
				randNum /= 2;
			} else {
				randNum = randNum*3+1;
			}
		}
		System.out.println(randNum);
		
	}

}
