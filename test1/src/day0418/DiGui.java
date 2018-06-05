package day0418;

public class DiGui {
	
	public static void main(String[] args) {
		/*
		古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，
		 小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，
		 问每个月的兔子总数为多少？
		 兔子的规律为数列1,1,2,3,5,8,13,21.... 
		 */
		DiGui digui = new DiGui();
		int month = 10;
		System.out.println("第"+month+"个月的兔子总数为："+digui.getRabbitNum(month));
		
		System.out.println("------------------华丽的分割线---------------------------");
		
		//用递归实现n！
		int n = 5;
		System.out.println(n+"的阶乘为："+digui.getFactorial(n));
		
		System.out.println("------------------华丽的分割线---------------------------");
		
		//汉诺塔问题
		System.out.println(digui.hanNuoTa(3));
	}
	/**
	 * 求兔子数量
	 * @param month 第几个月
	 * @return 兔子总数
	 */
	public int getRabbitNum(int month) {
		if(month==1 || month==2) {
			return 1;
		} else {
			return getRabbitNum(month-1) + getRabbitNum(month-2);
		}
	}
	/**
	 * 求n的阶乘
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
	 * 汉诺塔问题（递推公式：a[n]=2*a[n-1]+1）
	 * @param n 塔的层数
	 * @return 总共需要的步数
	 */
	public int hanNuoTa(int n) {
		if(n==1) {
			return 1;
		}
		return 2*hanNuoTa(n-1)+1;
	}
}
