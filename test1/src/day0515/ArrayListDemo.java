package day0515;

import java.util.ArrayList;

public class ArrayListDemo {
	public static void main(String[] args) {
		//1��ɾ��Ԫ��ʱ��������remove(index)��remove(Object)������
		//����ArrayList�е�Ԫ�ذ���[1,'a',2,'b'],��ôremove(1)
		//ɾ���ĵ���1����'a'?
		ArrayList list1 = new ArrayList();
		list1.add(1);
		list1.add('a');
		list1.add(2);
		list1.add('b');
		list1.remove(1);
		System.out.println(list1);
		//2������һ������Ϊ10��ArrayList�����ݶ��������������и���
		//ɾ���������еĸ�����
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(10);
		list2.add(20);
		list2.add(-10);
		list2.add(-23);
		list2.add(45);
		list2.add(-56);
		list2.add(56);
		for(int i=0; i<list2.size(); i++) {
			if(list2.get(i) < 0) {
				list2.remove(i);
				i--; 
			}
		}
		System.out.println(list2);
		
	}
}
