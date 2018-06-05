package day6;

public class SquareRoot {

	public static void main(String[] args) {
		//编写程序求一元二次方程的根
		double a = 1;  //二次方系数
		double b = 1;  //一次方系数
		double c = 1;  //常数
		
		if(a==0) {
			System.out.println("a的值不能为0");
			return;
		}
		if(b*b-4*a*c > 0) {
			double x1 = (-b + Math.sqrt(b*b-4*a*c))/(2*a);
			double x2 = (-b - Math.sqrt(b*b-4*a*c))/(2*a);
			System.out.println("该方程有两个实根，分别为：x1="+x1+",x2="+x2);
		} else if(b*b-4*a*c == 0) {
			double x = -b/(2*a);
			System.out.println("该方程有且只有一个实根：x="+x);
		} else {
			//System.out.println("该方程无实根");
			String x1 = -b/2*a+"+"+(Math.sqrt(-(b*b-4*a*c))/2*a+"i");
			String x2 = -b/2*a+"-"+(Math.sqrt(-(b*b-4*a*c))/2*a+"i");
			System.out.println("该方程有两个虚根，分别为：x1="+x1+",x2="+x2);
		}
		
	}

}
