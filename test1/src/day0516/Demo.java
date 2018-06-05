package day0516;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Random;

public class Demo {
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		Random rand = new Random();
		LinkedList<String> li = new LinkedList<String>();
		LinkedList<String[]> li2 = new LinkedList<String[]>();
		LinkedHashMap<String, Integer> lhm = new LinkedHashMap<String, Integer>();
		
		String name;
		String date;
		int money;
		int renshu = 50;
		for(int i=1; i<=31; i++) {
			for(int j=1; j<=renshu; j++) {
				name = "学生" + j;
				date = "2018/05/" + i;
				money = rand.nextInt(51)+100;
				li.add(name + "-" + date + "-" + money);
			}
		}
		System.out.println(li);
		
		String[] arr;
		for(int i=0; i<li.size(); i++) {
			arr = li.get(i).split("-");
			li2.add(arr);
		}
		
//		for(int i=0; i<renshu; i++) {
//			int sum = 0;
//			for(int j=0;j<li2.size(); j++) {
//				if(li2.get(i)[0].equals(li2.get(j)[0])) {
//					sum += Integer.parseInt(li2.get(j)[2]);
//				}
//			}
//			lhm.put(li2.get(i)[0], sum);
//		}
		//优化
		for(int i=0; i<renshu; i++) {
			int sum = Integer.parseInt(li2.get(i)[2]);
			for(int j=i+50;j<li2.size(); j+=50) {
				if(li2.get(i)[0].equals(li2.get(j)[0])) {
					sum += Integer.parseInt(li2.get(j)[2]);
				}
			}
			lhm.put(li2.get(i)[0], sum);
		}
		long time2 = System.currentTimeMillis();
		System.out.println(lhm);
		System.out.println("计算时间"+(time2-time1)+"ms");
	}
}
