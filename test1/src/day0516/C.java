package day0516;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class C {
	private static Random r = new Random();
	
	public static void main(String[] args) {
		//��ϰ�⣺
		//1.��һȺѧ����ÿ��ѧ��ÿ�춼��ͨ������ʱ��׬ȡһ����ѧ�ѡ�
		//���ݸ�ʽ���£�����-����-ѧ��
//		���£�
//		yt-2018/05/01-50
//		hmm-2018/05/01-150
//		yt-2018/05/02-100
//		����
//		�����������취�����50��ѧ��һ�����ڣ���2018/05/01��
//		2018/05/31֮�������.��Ū��
//		���⣺
//		ÿ��һ�����ݾʹ浽List�У���ĩ31�ŵ�ʱ�򣬽��л��ܡ�
//		�����ÿ��ͬѧ������ܹ�׬�˶������ӣ�����Map���洢����㡣
		
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
			if(map.containsKey(name)){//����
				map.put(name, (int)map.get(name) + money);
			}else{//û��
				map.put(name, money);
			}
		}
		System.out.println(map);
	}
	
	/**
	 * �������������3��8λ��Ӣ������
	 * @return
	 */
	public static String generateName(){
		int length = r.nextInt(6)+3;//3��8λ���ȵ�����
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
