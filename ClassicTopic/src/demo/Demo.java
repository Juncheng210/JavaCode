package demo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
//		// 兔子数量
//		System.out.println(d.getRabbitsNumber(10));
//		// 判断是否为闰年
//		d.isLeapYear(2018);
//		// 输出1！+2！+3！+…+20！的和
//		d.getSum();
//		// 判断101-200之间有多少个素数，并输出所有素数。
//		d.isPrime();
//		// 水仙花数
//		d.getDaffodilsNumber();
//		// 分解质因数
//		d.primeFactorization(90);
//		// 学生成绩的等级
//		d.StudentGrade(78);
//		// 最大公约数和最小公倍数
//		d.getMaxAndMin(16, 24);
//		// 统计字符个数
//		d.countNumber();
//		// 求 s=a+aa+aaa+aaaa+aa...a 的值
//		d.getMultipleSum();
//		// 1000以内的所有完数
//		d.perfectNumber();
//		// 球下落高度及路程
//		d.ball();
//		// 有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
//		d.noRepeatThreeNumber();
//		// 奖金
//		d.bonus(56);
//		// 一个整数，它加上100后是一个完全平方数，加上168又是一个完全平方数，请找出一个这样的整数。
//		d.getInteger();
//		// 输入三个整数x,y,z，请把这三个数由小到大输出
//		d.numberSort(3, 42, 22);
//		// 猴子吃桃
//		d.monkeyEatPeach();
//		// 出场顺序
//		d.outOrder();
//		// 分数序列求和
//		d.getFractionSum();
//		// 阶乘
//		System.out.println(d.getFactorial(5));
//		// 年龄
//		System.out.println(d.getAge(5));
//		d.getAge();
//		// 判断位数并逆序打印
//		d.ReverseOrder(1234);
//		// 判断是否是回文数
//		d.isPalindromeNumber(12321);
//		// 判断星期
//		d.week();
//		//打印99乘法表
//		d.printMultiplicationTable();
//		//一个5*5的二维数组，利用随机数为其赋值，求两条对角线上的元素
//		d.diagonalElement();
//		//打印杨辉三角
//		d.printYangHuiSanJiao1();
//		d.printYangHuiSanJiao2();
//		//整数移位
//		d.intYiWei();
//		//求剩下的人
//		d.getShengYuRenShu();
	}

	/**
	 * 古典问题：有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子， 假如兔子都不死，问每个月的兔子对数为多少？
	 * 程序分析： 兔子的规律为数列1,1,2,3,5,8,13,21....
	 * 
	 * @param month
	 *            要计算兔子数的月份
	 * @return
	 */
	public int getRabbitsNumber(int month) {
		if (month == 1 || month == 2) {
			return 1;
		} else {
			return getRabbitsNumber(month - 1) + getRabbitsNumber(month - 2);
		}
	}

	/**
	 * 编写程序，输入一个年份，判断是否为闰年
	 * 
	 * @param year
	 *            年份
	 */
	public void isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "是闰年");
		} else {
			System.out.println(year + "不是闰年");
		}
	}

	/**
	 * 编写一个Java程序，输出1！+2！+3！+…+20！的和
	 */
	public void getSum() {
		int sum = 0;
		int n = 1;
		for (int i = 1; i <= 20; i++) {
			n = n * i;
			sum = sum + n;
		}
		System.out.println("sum=" + sum);
	}

	/**
	 * 判断101-200之间有多少个素数，并输出所有素数。 （也叫质数，只能被1和本身整除的数）
	 */
	public void isPrime() {
		int count = 0;
		for (int i = 101; i < 200; i += 2) {
			boolean b = false;
			for (int j = 2; j <= Math.sqrt(i); j++) {
				if (i % j == 0) {
					b = false;
					break;
				} else {
					b = true;
				}
			}
			if (b) {
				count++;
				System.out.println(i);
			}
		}
		System.out.println("素数的个数是" + count);
	}

	/**
	 * 打印出所有的 "水仙花数 "，所谓 "水仙花数 "是指一个三位数，其各位数字立方和等于该数本身。 例如：153是一个 "水仙花数 "，因为
	 * 153=1*1*1＋5*5*5＋3*3*3
	 */
	public void getDaffodilsNumber() {
		int a, b, c, sum;
		for (int i = 100; i < 1000; i++) {
			a = i / 10;
			b = i / 10 % 10;
			c = i % 10;
			sum = a * a * a + b * b * b + c * c * c;
			if (i == sum) {
				System.out.println("水仙花数为："+i);
			}
		}
	}

	/**
	 * 输入一个正整数分解质因数。如：输入90，输出90=2*3*3*5
	 * 
	 * @param n
	 *            正整数
	 */
	public void primeFactorization(int n) {
		System.out.print(n + "=");
		for (int k = 2; k <= n / 2;) {
			if (n % k == 0) {
				System.out.print(k + "*");
				n = n / k;
				k = 2;
			} else {
				k++;
			}
		}
		System.out.print(n);
		System.out.println();
	}

	/**
	 * 学习成绩>=90分的同学用A表示，60-89分之间的用B表示，60分以下的用C表示。
	 * 
	 * @param n
	 *            学习成绩
	 */
	public void StudentGrade(int n) {
		if (n > 100 || n < 0) {
			System.out.println("输入无效");
		} else {
			char result;
			result = n >= 90 ? 'A' : n >= 60 ? 'B' : 'C';
			System.out.println(result);
		}
	}

	/**
	 * 输入两个正整数 m 和 n ，求其最大公约数和最小公倍数。
	 * 
	 * @param m
	 *            第一个正整数
	 * @param n
	 *            第二个正整数
	 */
	public void getMaxAndMin(int m, int n) {
		// 最大公约数
		for (int i = Math.min(m, n); i > 0; i--) {
			if (m % i == 0 && n % i == 0) {
				System.out.println(m + "和" + n + "的最大公约数为：" + i);
				break;
			}
		}

		// 最小公倍数
		for (int i = Math.max(m, n); i >= m; i++) { // i>=m可省略
			if (i % m == 0 && i % n == 0) {
				System.out.println(m + "和" + n + "的最小公倍数为：" + i);
				break;
			}
		}
	}

	/**
	 * 输入一行字符，分别统计出其中 英文字母、空格、数字和其它字符的个数。
	 */
	public void countNumber() {
		int number = 0;
		int letter = 0;
		int blank = 0;
		int other = 0;
		char[] ch = null;
		System.out.println("请输入需要统计的字符：");
		Scanner in = new Scanner(System.in);
		String s = in.nextLine();
		in.close();
		ch = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] >= '0' && ch[i] <= '9') {
				number++;
			} else if ((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) {
				letter++;
			} else if (ch[i] == ' ') {
				blank++;
			} else {
				other++;
			}
		}
		System.out.println("数字个数：" + number);
		System.out.println("英文字母个数：" + letter);
		System.out.println("空格个数：" + blank);
		System.out.println("其他字符个数：" + other);
	}

	/**
	 * 求 s=a+aa+aaa+aaaa+aa...a 的值，其中 a 是一个数字。
	 * 例如2+22+222+2222+22222(此时共有5个数相加)，几个数相加由键盘控制
	 */
	public void getMultipleSum() {
		long b = 0, sum = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("请输入a的值：");
		int a = in.nextInt();
		System.out.println("请输入相加的项数n的值");
		int n = in.nextInt();
		in.close();

		for (int i = 0; i < n; i++) {
			b = b + a;
			sum = sum + b;
			a = a * 10;
			System.out.print("+" + b);
		}
		System.out.println("=" + sum);
	}

	/**
	 * 一个数如果恰好等于它的因子之和，这个数就称为"完数"。例如6=1＋2＋3.编程找出1000以内的所有完数。
	 */
	public void perfectNumber() {
		System.out.println("1000以内的完数有：");
		for (int i = 1; i < 1000; i++) {
			int t = 0;
			for (int j = 1; j <= i / 2; j++) {
				if (i % j == 0) {
					t = t + j;
				}
			}
			if (t == i) {
				System.out.print(t + " ");
			}
		}
		System.out.println();
	}

	/**
	 * 一球从100米高度自由落下，每次落地后反跳回原高度的一半，再落下， 求它在第10次落地时，共经过多少米？ 第10次反弹多高？
	 */
	public void ball() {
		// h记录球的初始高度
		double h = 100;
		// up记录小球反弹的距离
		double up = 0;
		// down记录小球下落的距离
		double down = 0;

		for (int i = 1; i < 10; i++) {
			down = down + h;
			up = up + h / 2;
			h = h / 2;
		}
		System.out.println("10次落地共经过多少米" + (down + up + h));
		System.out.println("第10次反弹高度" + h / 2);
	}

	/**
	 * 有1、2、3、4四个数字，能组成多少个互不相同且无重复数字的三位数？都是多少？
	 */
	public void noRepeatThreeNumber() {
		int count = 0;
		for (int x = 1; x < 5; x++) {
			for (int y = 1; y < 5; y++) {
				for (int z = 1; z < 5; z++) {
					if (x != y && x != z && y != z) {
						count++;
						System.out.print(x * 100 + y * 10 + z + " ");
					}
				}
			}
		}
		System.out.println();
		System.out.println("共有" + count + "个三位数");
	}

	/**
	 * 企业发放的奖金根据利润提成。 利润低于或等于10万元时，奖金可提10%； 利润高于10万元，低于20万元时，低于10万元的部分按10%提成，
	 * 高于10万元的部分，可提成7.5%； 20万到40万之间时，高于20万元的部分，可提成5%； 40万到60万之间时高于40万元的部分，可提成3%；
	 * 60万到100万之间时，高于60万元的部分，可提成1.5%； 高于100万元时，超过100万元的部分按1%提成； 从键盘输入当月利润，求应发放奖金总数？
	 * 
	 * @param profit
	 *            当月利润（单位：万元）
	 */
	public void bonus(double profit) {
		double y = 0;
		if (profit >= 0 && profit <= 10) {
			y = profit * 0.1;
		} else if (profit > 10 && profit <= 20) {
			y = 10 * 0.1 + (profit - 10) * 0.075;
		} else if (profit > 20 && profit <= 40) {
			y = 10 * 0.1 + 10 * 0.075 + (profit - 20) * 0.05;
		} else if (profit > 40 && profit <= 60) {
			y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + (profit - 40) * 0.03;
		} else if (profit > 60 && profit <= 100) {
			y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + (profit - 60) * 0.015;
		} else if (profit > 100) {
			y = 10 * 0.1 + 10 * 0.075 + 20 * 0.05 + 20 * 0.03 + 40 * 0.015 + (profit - 100) * 0.01;
		}
		System.out.println("应发放的奖金数" + y + "万");
	}

	/**
	 * 一个整数，它加上100后是一个完全平方数，再加上168又是一个完全平方数，请找出一个这样的整数。
	 */
	public void getInteger() {
		for (int i = 1; i < 100000; i++) {
			if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {
				System.out.println(i);
			}
		}
	}

	/**
	 * 输入三个整数x,y,z，请把这三个数由小到大输出
	 * 
	 * @param x
	 *            第一个整数
	 * @param y
	 *            第二个整数
	 * @param z
	 *            第三个整数
	 */
	public void numberSort(int x, int y, int z) {
		if (x > y) {
			int t = x;
			x = y;
			y = t;
		}
		if (x > z) {
			int t = x;
			x = z;
			z = t;
		}
		if (y > z) {
			int t = y;
			y = z;
			z = t;
		}
		System.out.println(x + " " + y + " " + z);
	}

	/**
	 * 猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个。 第二天早上将剩下的桃子吃掉一半，又多吃了一个。 以后每天早上都吃了前一天剩下的一半零一个。
	 * 到第10天早上想再吃时，见只剩下一个桃子了。 求第一天共摘了多少
	 */
	public void monkeyEatPeach() {
		int x = 1;
		for (int i = 9; i > 0; i--) {
			x = (x + 1) * 2;
			System.out.println("第" + i + "天有" + x + "个桃子");
		}
	}

	/**
	 * 两个乒乓球队进行比赛，各出三人。 甲队为a,b,c三人，乙队为x,y,z三人。 已抽签决定比赛名单。有人向队员打听比赛的名单。
	 * a说他不和x比，c说他不和x,z比， 请编程序找出三队赛手的名单。
	 */
	public void outOrder() {
		char i, j, k;
		for (i = 'x'; i <= 'z'; i++) {
			for (j = 'x'; j <= 'z'; j++) {
				for (k = 'x'; k <= 'z'; k++) {
					if (i != j && i != k && j != k) {
						if (i != 'x' && k != 'x' && k != 'z')
							System.out.println("a PK " + i + ",b PK " + j + ",c PK " + k);
					}
				}
			}
		}
	}

	/**
	 * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
	 */
	public void getFractionSum() {
		double sum = 0.0;
		int x = 2, y = 1, t;
		for (int i = 1; i <= 20; i++) {
			sum = sum + (double) x / y;
			t = y;
			y = x;
			x = y + t;
		}
		System.out.println(sum);
	}

	/**
	 * 利用递归方法求5!
	 */
	public int getFactorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * getFactorial(n - 1);
		}
	}

	/**
	 * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。 问第4个人岁数，他说比第3个人大2岁。 问第三个人，又说比第2人大两岁。
	 * 问第2个人，说比第一个人大两岁。 最后问第一个人，他说是10岁。 请问第五个人多大？
	 * 
	 * @param num
	 *            人数（此处应为5）
	 */
	public int getAge(int num) {
		if (num == 1) {
			return 10;
		} else {
			return 2 + getAge(num - 1);
		}
	}

	/**
	 * 有5个人坐在一起，问第五个人多少岁？他说比第4个人大2岁。 问第4个人岁数，他说比第3个人大2岁。 问第三个人，又说比第2人大两岁。
	 * 问第2个人，说比第一个人大两岁。 最后问第一个人，他说是10岁。 请问第五个人多大？
	 */
	public void getAge() {
		int age = 10;
		for (int i = 1; i < 5; i++) {
			age = age + 2;
		}
		System.out.println(age);
	}

	/**
	 * 给一个不多于5位的正整数，要求：一、求它是几位数，二、逆序打印出各位数字。
	 * 
	 * @param n
	 *            不多于5位的正整数
	 */
	public void ReverseOrder(int n) {
		String str = Integer.toString(n);
		char[] ch = str.toCharArray();
		System.out.println("输入的是一个" + ch.length + "位数");
		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

	/**
	 * 一个5位数，判断它是不是回文数。即12321是回文数，个位与万位相同，十位与千位相同
	 * 
	 * @param n
	 *            一个5位数
	 */
	public void isPalindromeNumber(int n) {
//		String str = String.valueOf(n);
		String str = n + "";
		char[] ch = str.toCharArray();

		if (ch[0] == ch[4] && ch[1] == ch[3]) {
			System.out.println("这是一个回文数");
		} else {
			System.out.println("这不是一个回文数");
		}
	}

	/**
	 * 请输入星期几的第一个字母来判断一下是星期几，如果第一个字母一样，则继续判断第二个字母
	 */
	public void week() {
		System.out.println("请输入第一个字母");
		char ch = getChar();
		switch (ch) {
		case 'M':
			System.out.println("Monday");
			break;
		case 'W':
			System.out.println("Wednesday");
			break;
		case 'F':
			System.out.println("Friday");
			break;
		case 'T':
			System.out.println("请输入第二个字母");
			char ch2 = getChar();
			if (ch2 == 'U') {
				System.out.println("Tuesday");
			} else if (ch2 == 'H') {
				System.out.println("Thursday");
			} else {
				System.out.println("没有这种写法");
			}
			break;
		case 'S':
			System.out.println("请输入第二个字母");
			char ch3 = getChar();
			if (ch3 == 'U') {
				System.out.println("Sunday");
			} else if (ch3 == 'A') {
				System.out.println("Saturday");
			} else {
				System.out.println("没有这种写法");
			}
			break;
		default:
			break;
		}
	}
	/**
	 * 在week方法调用后，若有相同字符，则调用该方法输入第二个字符进行判断
	 * @return 返回第二次输入的第一个字符
	 */
	public static char getChar() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();
		char ch = str.charAt(0);
		if (ch < 'A' || ch > 'Z') {
			System.out.println("输入错误，请重新输入");
			ch = getChar();
		}
		return ch;
	}
	
	/**
	 * 打印99乘法表
	 */
	public void printMultiplicationTable() {
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=i; j++) {
				System.out.print(j+"*"+i+"="+j*i+"\t");
			}
			System.out.println();
		}
	}
	
	/**
	 * 一个5*5的二维数组，利用随机数为其赋值，求两条对角线上的元素
	 */
	public void diagonalElement() {
		//一个5*5的二维数组，利用随机数为其赋值，求两条对角线上的元素
		int[][] arr = new int[5][5];  //创建数组
		
		Random rand = new Random();
		//初始化数组
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rand.nextInt(1000);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//对角线1（左上-右下）
		System.out.print("主对角线元素为：");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
		
		//对角线2（右上-左下）
		System.out.print("副对角线元素为：");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i+j==4) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
	}
	/**
	 * 打印杨辉三角，方法一（二维数组）
	 */
	public void printYangHuiSanJiao1() {
		int[][] arr = new int[10][10];
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
			//控制空格
			for(int k=1; k<arr.length-i; k++) {
				System.out.print("\t");
			}
			//控制输出
			for(int j=0; j<=i; j++) {
				System.out.print(arr[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	/**
	 * 打印杨辉三角，方法二（一维数组）
	 */
	public void printYangHuiSanJiao2() {
		int[] arr = new int[10];
		arr[0] = 1;
		for(int i=1; i<=arr.length; i++) {
			//打印空格
			for(int k=1; k<=arr.length-i; k++) {
				System.out.print("\t");
			}
			//打印数组
			for(int j : arr) {
				if(j!=0) {
					System.out.print(j + "\t\t");
				}
			}
			System.out.println();
			//由上一行的数组元素生成下一行的数组元素
			for(int j=arr.length-1; j>=1; j--) {
				arr[j] = arr[j-1] + arr[j];
			}
		}
	}
	/**
	 * 有n个整数，使其前面各数顺序向后移m个位置，最后m个数变成最前面的m个数
	 */
	public void intYiWei() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入n的值：");
		int n = in.nextInt();
		int[] a = new int[n];
		System.out.println("请输入"+n+"个整数：");
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println("输入的数组为："+Arrays.toString(a));
		System.out.println("请输入向后移动的位数：");
		int m = in.nextInt();
		int[] b = new int[n];
		for(int i=0; i<a.length; i++) {
			b[i] = a[(n-m+i)%n];
		}
		System.out.println("移动后的数组为"+Arrays.toString(b));
		in.close();
	}
	/**
	 * 有n个人围成一圈，顺序排号。从第一个人开始报数（从1到3报数），凡报到3的人退出圈子，
	 * 问最后留下的是原来第几号的那位。
	 */
	public void getShengYuRenShu() {
		Scanner in = new Scanner(System.in);
		System.out.println("请输入人数n的值：");
		int n = in.nextInt();
		in.close();
		boolean[] a = new boolean[n];
		for(int i=0; i<a.length; i++) {
			a[i] = true;
		}
		
		int num = n;//剩余人数
		int index = 0;//数组下标
		int count = 0;//记录所报的数
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
				System.out.println("留下的是原来的第"+(i+1)+"位");
			}
		}
	}
}
