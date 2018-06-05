package day0530.homework;

import java.util.Scanner;

public class XMLDemoTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String filepath = "src/day0530/homework/exam1.xml";
		
		while(true) {
			System.out.println("添加用户：【a】	删除用户：【b】	查询成绩：【c】");
			System.out.print("请输入操作类型：");
			String input = sc.next();
			if(input.equalsIgnoreCase("a")) {
				XMLDemo.addUserMsg(filepath);
				System.out.print("还需要继续操作吗？（确认请输入“Y”,否则输入其它字母）：");
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else if(input.equalsIgnoreCase("b")) {
				XMLDemo.deleteUserMsg(filepath);
				System.out.print("还需要继续操作吗？（确认请输入“Y”,否则输入其它字母）：");
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else if(input.equalsIgnoreCase("c")) {
				XMLDemo.queryUserMsg(filepath);
				System.out.print("还需要继续操作吗？（确认请输入“Y”,否则输入其它字母）：");
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				String in = sc.next();
				if(in.equalsIgnoreCase("Y")) {
					continue;
				} else {
					break;
				}
			} else {
				System.out.print("请输入方括号中的单个字母：");
			}
		}
//		sca.close();
	}
}
