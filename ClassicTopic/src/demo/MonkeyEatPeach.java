package demo;

public class MonkeyEatPeach {

	public static void main(String[] args) {
		//���ӳ������⡣
		//���ӵ�һ��ժ�����ɸ����ӣ���ʱ�ͳ���һ�룬������񫣬���ֳ���һ����
		//�ڶ����ֽ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ����
		//�Ժ�ÿ�춼��ǰһ��ʣ�µ�һ����һ�������� 10 ������Ե�ʱ���ʣһ��������,
		//���һ�칲ժ�������ٸ�����
		int sum = 1;  //��ʮ��ʣ���������
		int day = 10;
		for(int i=10; i>1; i--) {
			sum = (sum+1)*2;
			day--;
			System.out.println("��"+day+"���������Ϊ��"+sum);
		}
		
	}

}
