package day0503;

import java.util.Random;

public class Demo2 {
	public static void main(String[] args) {
		//首先定义一个学生类student，拥有属性姓名name，年龄age，语文成绩chinese，数学成绩math，英语成绩english
		//然后初始化100个学生，利用随机数为这100个学生的属性赋初值
		//求每个学生成绩的平均分
		//求总分最高的同学的名字
		//对每个学生总分降序排序
		Student[] s = new Student[100];
		Random r = new Random();
		for(int i=0; i<s.length; i++) {
			String m = "zhangsan"+(i+1);//姓名
			int n = r.nextInt(5) + 10;//年龄
			int o = r.nextInt(101);//语文成绩
			int p = r.nextInt(101);//数学成绩
			int q = r.nextInt(101);//英语成绩
			s[i] = new Student(m, n, o, p, q);
		}
		
		//输出每个学生的平均分
		for(int i=0; i<s.length; i++) {
			double avg = (s[i].getChinese() + s[i].getMath() + s[i].getEnglish())*1.0 / 3;
			System.out.println(s[i].toString() + "，平均分为：" + avg);
		}
		
		//输出总分最高的学生姓名
		int max = s[0].getChinese() + s[0].getMath() + s[0].getEnglish();
		int index = 0;
		for(int i=1; i<s.length; i++) {
			if(max<s[i].getChinese() + s[i].getMath() + s[i].getEnglish()) {
				max = s[i].getChinese() + s[i].getMath() + s[i].getEnglish();
				index = i;
			}
		}
		System.out.println("成绩总分最高的同学是：" + s[index].getName() + ",其总成绩为：" + max);
		
		//总分排序
		for(int i=1; i<s.length; i++) {
			for(int j=0; j<s.length-i; j++) {
				double sum1 = s[j].getChinese() + s[j].getMath() + s[j].getEnglish();
				double sum2 = s[j+1].getChinese() + s[j+1].getMath() + s[j+1].getEnglish();
				if(sum1<sum2) {
					Student temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
		for(Student i : s) {
			System.out.println(i.toString());
		}
	}
}
