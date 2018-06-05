package day0516;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class C {
	private static Random r = new Random();
	
	public static void main(String[] args) {
		//练习题：
		//1.有一群学生，每个学生每天都会通过做临时工赚取一定的学费。
		//数据格式如下：姓名-日期-学费
//		如下：
//		yt-2018/05/01-50
//		hmm-2018/05/01-150
//		yt-2018/05/02-100
//		……
//		利用随机数想办法构造出50个学生一个月内，从2018/05/01到
//		2018/05/31之间的数据.多弄点
//		问题：
//		每来一条数据就存到List中，月末31号的时候，进行汇总。
//		计算出每个同学这个月总共赚了多少银子？利用Map来存储与计算。
		
		List li = new ArrayList();
		int len = 1000;
		for(int i=0;i<len;i++){
			String s = generateName()+"-"+generateDate()+"-"+generateMoney();
			li.add(s);
		}
		System.out.println(li);
		
		Map map = new TreeMap();
		for(int i=0;i<li.size();i++){
			String[] s = ((String)li.get(i)).split("-");
			String name = s[0];
			int money = Integer.parseInt(s[2]);
			if(map.containsKey(name)){//含有
				map.put(name, (int)map.get(name) + money);
			}else{//没有
				map.put(name, money);
			}
		}
		System.out.println(map);
	}
	
	/**
	 * 利用随机数产生3到8位的英文名字
	 * @return
	 */
	public static String generateName(){
		int length = r.nextInt(6)+3;//3到8位长度的名字
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<1;i++){
			sb.append((char)(r.nextInt(26)+97));
		}
		return sb.toString();
	}
	
	public static String generateDate(){
		StringBuilder sb = new StringBuilder("2018/05/");
		
		int t = r.nextInt(31)+1;
		sb.append(t<10?"0"+t:t);
		return sb.toString();
	}
	
	public static String generateMoney(){
		return r.nextInt(1000)+"";
	}
}
