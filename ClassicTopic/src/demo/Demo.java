package demo;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Demo d = new Demo();
//		// ��������
//		System.out.println(d.getRabbitsNumber(10));
//		// �ж��Ƿ�Ϊ����
//		d.isLeapYear(2018);
//		// ���1��+2��+3��+��+20���ĺ�
//		d.getSum();
//		// �ж�101-200֮���ж��ٸ����������������������
//		d.isPrime();
//		// ˮ�ɻ���
//		d.getDaffodilsNumber();
//		// �ֽ�������
//		d.primeFactorization(90);
//		// ѧ���ɼ��ĵȼ�
//		d.StudentGrade(78);
//		// ���Լ������С������
//		d.getMaxAndMin(16, 24);
//		// ͳ���ַ�����
//		d.countNumber();
//		// �� s=a+aa+aaa+aaaa+aa...a ��ֵ
//		d.getMultipleSum();
//		// 1000���ڵ���������
//		d.perfectNumber();
//		// ������߶ȼ�·��
//		d.ball();
//		// ��1��2��3��4�ĸ����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
//		d.noRepeatThreeNumber();
//		// ����
//		d.bonus(56);
//		// һ��������������100����һ����ȫƽ����������168����һ����ȫƽ���������ҳ�һ��������������
//		d.getInteger();
//		// ������������x,y,z���������������С�������
//		d.numberSort(3, 42, 22);
//		// ���ӳ���
//		d.monkeyEatPeach();
//		// ����˳��
//		d.outOrder();
//		// �����������
//		d.getFractionSum();
//		// �׳�
//		System.out.println(d.getFactorial(5));
//		// ����
//		System.out.println(d.getAge(5));
//		d.getAge();
//		// �ж�λ���������ӡ
//		d.ReverseOrder(1234);
//		// �ж��Ƿ��ǻ�����
//		d.isPalindromeNumber(12321);
//		// �ж�����
//		d.week();
//		//��ӡ99�˷���
//		d.printMultiplicationTable();
//		//һ��5*5�Ķ�ά���飬���������Ϊ�丳ֵ���������Խ����ϵ�Ԫ��
//		d.diagonalElement();
//		//��ӡ�������
//		d.printYangHuiSanJiao1();
//		d.printYangHuiSanJiao2();
//		//������λ
//		d.intYiWei();
//		//��ʣ�µ���
//		d.getShengYuRenShu();
	}

	/**
	 * �ŵ����⣺��һ�����ӣ��ӳ������3������ÿ���¶���һ�����ӣ�С���ӳ����������º�ÿ��������һ�����ӣ� �������Ӷ���������ÿ���µ����Ӷ���Ϊ���٣�
	 * ��������� ���ӵĹ���Ϊ����1,1,2,3,5,8,13,21....
	 * 
	 * @param month
	 *            Ҫ�������������·�
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
	 * ��д��������һ����ݣ��ж��Ƿ�Ϊ����
	 * 
	 * @param year
	 *            ���
	 */
	public void isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
			System.out.println(year + "������");
		} else {
			System.out.println(year + "��������");
		}
	}

	/**
	 * ��дһ��Java�������1��+2��+3��+��+20���ĺ�
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
	 * �ж�101-200֮���ж��ٸ���������������������� ��Ҳ��������ֻ�ܱ�1�ͱ�������������
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
		System.out.println("�����ĸ�����" + count);
	}

	/**
	 * ��ӡ�����е� "ˮ�ɻ��� "����ν "ˮ�ɻ��� "��ָһ����λ�������λ���������͵��ڸ������� ���磺153��һ�� "ˮ�ɻ��� "����Ϊ
	 * 153=1*1*1��5*5*5��3*3*3
	 */
	public void getDaffodilsNumber() {
		int a, b, c, sum;
		for (int i = 100; i < 1000; i++) {
			a = i / 10;
			b = i / 10 % 10;
			c = i % 10;
			sum = a * a * a + b * b * b + c * c * c;
			if (i == sum) {
				System.out.println("ˮ�ɻ���Ϊ��"+i);
			}
		}
	}

	/**
	 * ����һ���������ֽ����������磺����90�����90=2*3*3*5
	 * 
	 * @param n
	 *            ������
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
	 * ѧϰ�ɼ�>=90�ֵ�ͬѧ��A��ʾ��60-89��֮�����B��ʾ��60�����µ���C��ʾ��
	 * 
	 * @param n
	 *            ѧϰ�ɼ�
	 */
	public void StudentGrade(int n) {
		if (n > 100 || n < 0) {
			System.out.println("������Ч");
		} else {
			char result;
			result = n >= 90 ? 'A' : n >= 60 ? 'B' : 'C';
			System.out.println(result);
		}
	}

	/**
	 * �������������� m �� n ���������Լ������С��������
	 * 
	 * @param m
	 *            ��һ��������
	 * @param n
	 *            �ڶ���������
	 */
	public void getMaxAndMin(int m, int n) {
		// ���Լ��
		for (int i = Math.min(m, n); i > 0; i--) {
			if (m % i == 0 && n % i == 0) {
				System.out.println(m + "��" + n + "�����Լ��Ϊ��" + i);
				break;
			}
		}

		// ��С������
		for (int i = Math.max(m, n); i >= m; i++) { // i>=m��ʡ��
			if (i % m == 0 && i % n == 0) {
				System.out.println(m + "��" + n + "����С������Ϊ��" + i);
				break;
			}
		}
	}

	/**
	 * ����һ���ַ����ֱ�ͳ�Ƴ����� Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
	 */
	public void countNumber() {
		int number = 0;
		int letter = 0;
		int blank = 0;
		int other = 0;
		char[] ch = null;
		System.out.println("��������Ҫͳ�Ƶ��ַ���");
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
		System.out.println("���ָ�����" + number);
		System.out.println("Ӣ����ĸ������" + letter);
		System.out.println("�ո������" + blank);
		System.out.println("�����ַ�������" + other);
	}

	/**
	 * �� s=a+aa+aaa+aaaa+aa...a ��ֵ������ a ��һ�����֡�
	 * ����2+22+222+2222+22222(��ʱ����5�������)������������ɼ��̿���
	 */
	public void getMultipleSum() {
		long b = 0, sum = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("������a��ֵ��");
		int a = in.nextInt();
		System.out.println("��������ӵ�����n��ֵ");
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
	 * һ�������ǡ�õ�����������֮�ͣ�������ͳ�Ϊ"����"������6=1��2��3.����ҳ�1000���ڵ�����������
	 */
	public void perfectNumber() {
		System.out.println("1000���ڵ������У�");
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
	 * һ���100�׸߶��������£�ÿ����غ�����ԭ�߶ȵ�һ�룬�����£� �����ڵ�10�����ʱ�������������ף� ��10�η�����ߣ�
	 */
	public void ball() {
		// h��¼��ĳ�ʼ�߶�
		double h = 100;
		// up��¼С�򷴵��ľ���
		double up = 0;
		// down��¼С������ľ���
		double down = 0;

		for (int i = 1; i < 10; i++) {
			down = down + h;
			up = up + h / 2;
			h = h / 2;
		}
		System.out.println("10����ع�����������" + (down + up + h));
		System.out.println("��10�η����߶�" + h / 2);
	}

	/**
	 * ��1��2��3��4�ĸ����֣�����ɶ��ٸ�������ͬ�����ظ����ֵ���λ�������Ƕ��٣�
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
		System.out.println("����" + count + "����λ��");
	}

	/**
	 * ��ҵ���ŵĽ������������ɡ� ������ڻ����10��Ԫʱ���������10%�� �������10��Ԫ������20��Ԫʱ������10��Ԫ�Ĳ��ְ�10%��ɣ�
	 * ����10��Ԫ�Ĳ��֣������7.5%�� 20��40��֮��ʱ������20��Ԫ�Ĳ��֣������5%�� 40��60��֮��ʱ����40��Ԫ�Ĳ��֣������3%��
	 * 60��100��֮��ʱ������60��Ԫ�Ĳ��֣������1.5%�� ����100��Ԫʱ������100��Ԫ�Ĳ��ְ�1%��ɣ� �Ӽ������뵱��������Ӧ���Ž���������
	 * 
	 * @param profit
	 *            �������󣨵�λ����Ԫ��
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
		System.out.println("Ӧ���ŵĽ�����" + y + "��");
	}

	/**
	 * һ��������������100����һ����ȫƽ�������ټ���168����һ����ȫƽ���������ҳ�һ��������������
	 */
	public void getInteger() {
		for (int i = 1; i < 100000; i++) {
			if (Math.sqrt(i + 100) % 1 == 0 && Math.sqrt(i + 268) % 1 == 0) {
				System.out.println(i);
			}
		}
	}

	/**
	 * ������������x,y,z���������������С�������
	 * 
	 * @param x
	 *            ��һ������
	 * @param y
	 *            �ڶ�������
	 * @param z
	 *            ����������
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
	 * ���ӵ�һ��ժ�����ɸ����ӣ���������һ�룬����񫣬�ֶ����һ���� �ڶ������Ͻ�ʣ�µ����ӳԵ�һ�룬�ֶ����һ���� �Ժ�ÿ�����϶�����ǰһ��ʣ�µ�һ����һ����
	 * ����10���������ٳ�ʱ����ֻʣ��һ�������ˡ� ���һ�칲ժ�˶���
	 */
	public void monkeyEatPeach() {
		int x = 1;
		for (int i = 9; i > 0; i--) {
			x = (x + 1) * 2;
			System.out.println("��" + i + "����" + x + "������");
		}
	}

	/**
	 * ����ƹ����ӽ��б������������ˡ� �׶�Ϊa,b,c���ˣ��Ҷ�Ϊx,y,z���ˡ� �ѳ�ǩ���������������������Ա����������������
	 * a˵������x�ȣ�c˵������x,z�ȣ� �������ҳ��������ֵ�������
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
	 * ��һ�������У�2/1��3/2��5/3��8/5��13/8��21/13...���������е�ǰ20��֮��
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
	 * ���õݹ鷽����5!
	 */
	public int getFactorial(int n) {
		if (n == 1 || n == 0) {
			return 1;
		} else {
			return n * getFactorial(n - 1);
		}
	}

	/**
	 * ��5��������һ���ʵ�����˶����ꣿ��˵�ȵ�4���˴�2�ꡣ �ʵ�4������������˵�ȵ�3���˴�2�ꡣ �ʵ������ˣ���˵�ȵ�2�˴����ꡣ
	 * �ʵ�2���ˣ�˵�ȵ�һ���˴����ꡣ ����ʵ�һ���ˣ���˵��10�ꡣ ���ʵ�����˶��
	 * 
	 * @param num
	 *            �������˴�ӦΪ5��
	 */
	public int getAge(int num) {
		if (num == 1) {
			return 10;
		} else {
			return 2 + getAge(num - 1);
		}
	}

	/**
	 * ��5��������һ���ʵ�����˶����ꣿ��˵�ȵ�4���˴�2�ꡣ �ʵ�4������������˵�ȵ�3���˴�2�ꡣ �ʵ������ˣ���˵�ȵ�2�˴����ꡣ
	 * �ʵ�2���ˣ�˵�ȵ�һ���˴����ꡣ ����ʵ�һ���ˣ���˵��10�ꡣ ���ʵ�����˶��
	 */
	public void getAge() {
		int age = 10;
		for (int i = 1; i < 5; i++) {
			age = age + 2;
		}
		System.out.println(age);
	}

	/**
	 * ��һ��������5λ����������Ҫ��һ�������Ǽ�λ�������������ӡ����λ���֡�
	 * 
	 * @param n
	 *            ������5λ��������
	 */
	public void ReverseOrder(int n) {
		String str = Integer.toString(n);
		char[] ch = str.toCharArray();
		System.out.println("�������һ��" + ch.length + "λ��");
		for (int i = ch.length - 1; i >= 0; i--) {
			System.out.print(ch[i]);
		}
	}

	/**
	 * һ��5λ�����ж����ǲ��ǻ���������12321�ǻ���������λ����λ��ͬ��ʮλ��ǧλ��ͬ
	 * 
	 * @param n
	 *            һ��5λ��
	 */
	public void isPalindromeNumber(int n) {
//		String str = String.valueOf(n);
		String str = n + "";
		char[] ch = str.toCharArray();

		if (ch[0] == ch[4] && ch[1] == ch[3]) {
			System.out.println("����һ��������");
		} else {
			System.out.println("�ⲻ��һ��������");
		}
	}

	/**
	 * ���������ڼ��ĵ�һ����ĸ���ж�һ�������ڼ��������һ����ĸһ����������жϵڶ�����ĸ
	 */
	public void week() {
		System.out.println("�������һ����ĸ");
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
			System.out.println("������ڶ�����ĸ");
			char ch2 = getChar();
			if (ch2 == 'U') {
				System.out.println("Tuesday");
			} else if (ch2 == 'H') {
				System.out.println("Thursday");
			} else {
				System.out.println("û������д��");
			}
			break;
		case 'S':
			System.out.println("������ڶ�����ĸ");
			char ch3 = getChar();
			if (ch3 == 'U') {
				System.out.println("Sunday");
			} else if (ch3 == 'A') {
				System.out.println("Saturday");
			} else {
				System.out.println("û������д��");
			}
			break;
		default:
			break;
		}
	}
	/**
	 * ��week�������ú�������ͬ�ַ�������ø÷�������ڶ����ַ������ж�
	 * @return ���صڶ�������ĵ�һ���ַ�
	 */
	public static char getChar() {
		Scanner in = new Scanner(System.in);
		String str = in.nextLine();
		in.close();
		char ch = str.charAt(0);
		if (ch < 'A' || ch > 'Z') {
			System.out.println("�����������������");
			ch = getChar();
		}
		return ch;
	}
	
	/**
	 * ��ӡ99�˷���
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
	 * һ��5*5�Ķ�ά���飬���������Ϊ�丳ֵ���������Խ����ϵ�Ԫ��
	 */
	public void diagonalElement() {
		//һ��5*5�Ķ�ά���飬���������Ϊ�丳ֵ���������Խ����ϵ�Ԫ��
		int[][] arr = new int[5][5];  //��������
		
		Random rand = new Random();
		//��ʼ������
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				arr[i][j] = rand.nextInt(1000);
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		//�Խ���1������-���£�
		System.out.print("���Խ���Ԫ��Ϊ��");
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(i==j) {
					System.out.print(arr[i][j]+" ");
				}
			}
		}
		System.out.println();
		
		//�Խ���2������-���£�
		System.out.print("���Խ���Ԫ��Ϊ��");
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
	 * ��ӡ������ǣ�����һ����ά���飩
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
			//���ƿո�
			for(int k=1; k<arr.length-i; k++) {
				System.out.print("\t");
			}
			//�������
			for(int j=0; j<=i; j++) {
				System.out.print(arr[i][j]+"\t\t");
			}
			System.out.println();
		}
	}
	/**
	 * ��ӡ������ǣ���������һά���飩
	 */
	public void printYangHuiSanJiao2() {
		int[] arr = new int[10];
		arr[0] = 1;
		for(int i=1; i<=arr.length; i++) {
			//��ӡ�ո�
			for(int k=1; k<=arr.length-i; k++) {
				System.out.print("\t");
			}
			//��ӡ����
			for(int j : arr) {
				if(j!=0) {
					System.out.print(j + "\t\t");
				}
			}
			System.out.println();
			//����һ�е�����Ԫ��������һ�е�����Ԫ��
			for(int j=arr.length-1; j>=1; j--) {
				arr[j] = arr[j-1] + arr[j];
			}
		}
	}
	/**
	 * ��n��������ʹ��ǰ�����˳�������m��λ�ã����m���������ǰ���m����
	 */
	public void intYiWei() {
		Scanner in = new Scanner(System.in);
		System.out.println("������n��ֵ��");
		int n = in.nextInt();
		int[] a = new int[n];
		System.out.println("������"+n+"��������");
		for(int i=0; i<n; i++) {
			a[i] = in.nextInt();
		}
		System.out.println("���������Ϊ��"+Arrays.toString(a));
		System.out.println("����������ƶ���λ����");
		int m = in.nextInt();
		int[] b = new int[n];
		for(int i=0; i<a.length; i++) {
			b[i] = a[(n-m+i)%n];
		}
		System.out.println("�ƶ��������Ϊ"+Arrays.toString(b));
		in.close();
	}
	/**
	 * ��n����Χ��һȦ��˳���źš��ӵ�һ���˿�ʼ��������1��3��������������3�����˳�Ȧ�ӣ�
	 * ��������µ���ԭ���ڼ��ŵ���λ��
	 */
	public void getShengYuRenShu() {
		Scanner in = new Scanner(System.in);
		System.out.println("����������n��ֵ��");
		int n = in.nextInt();
		in.close();
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
