package day0418;

public class DiGui {
	
	public static void main(String[] args) {
		/*
		�ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�
		 С���ӳ����������º�ÿ��������һ�����ӣ��������Ӷ�������
		 ��ÿ���µ���������Ϊ���٣�
		 ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21.... 
		 */
		DiGui digui = new DiGui();
		int month = 10;
		System.out.println("��"+month+"���µ���������Ϊ��"+digui.getRabbitNum(month));
		
		System.out.println("------------------�����ķָ���---------------------------");
		
		//�õݹ�ʵ��n��
		int n = 5;
		System.out.println(n+"�Ľ׳�Ϊ��"+digui.getFactorial(n));
		
		System.out.println("------------------�����ķָ���---------------------------");
		
		//��ŵ������
		System.out.println(digui.hanNuoTa(3));
	}
	/**
	 * ����������
	 * @param month �ڼ�����
	 * @return ��������
	 */
	public int getRabbitNum(int month) {
		if(month==1 || month==2) {
			return 1;
		} else {
			return getRabbitNum(month-1) + getRabbitNum(month-2);
		}
	}
	/**
	 * ��n�Ľ׳�
	 * @param n
	 * @return
	 */
	public long getFactorial(int n) {
		if(n==1) {
			return 1;
		}
		return getFactorial(n-1)*n;
	}
	/**
	 * ��ŵ�����⣨���ƹ�ʽ��a[n]=2*a[n-1]+1��
	 * @param n ���Ĳ���
	 * @return �ܹ���Ҫ�Ĳ���
	 */
	public int hanNuoTa(int n) {
		if(n==1) {
			return 1;
		}
		return 2*hanNuoTa(n-1)+1;
	}
}
