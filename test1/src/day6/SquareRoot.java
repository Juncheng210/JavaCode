package day6;

public class SquareRoot {

	public static void main(String[] args) {
		//��д������һԪ���η��̵ĸ�
		double a = 1;  //���η�ϵ��
		double b = 1;  //һ�η�ϵ��
		double c = 1;  //����
		
		if(a==0) {
			System.out.println("a��ֵ����Ϊ0");
			return;
		}
		if(b*b-4*a*c > 0) {
			double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
			double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
			System.out.println("�÷���������ʵ�����ֱ�Ϊ��x1="+x1+",x2="+x2);
		} else if(b*b-4*a*c == 0) {
			double x = -b/(2*a);
			System.out.println("�÷�������ֻ��һ��ʵ����x="+x);
		} else {
			//System.out.println("�÷�����ʵ��");
			String x1 = -b/2*a+"+"+(Math.sqrt(-(b*b-4*a*c))/2*a+"i");
			String x2 = -b/2*a+"-"+(Math.sqrt(-(b*b-4*a*c))/2*a+"i");
			System.out.println("�÷���������������ֱ�Ϊ��x1="+x1+",x2="+x2);
		}
		
	}

}
