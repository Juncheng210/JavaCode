package day0518;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
	public static void main(String args[]) {
		Set set = new HashSet();
		Student stu1 = new Student();
		Student stu2 = new Student("Tom", 18);
		Student stu3 = new Student("Tom", 18);
		set.add(stu1);// ����� stu1��ʱ����Զ����� hashcode �� equals ����, ��������������, name ��ֵΪ��,���Ի���ֿ�ָ���쳣��
		set.add(stu2);
		set.add(stu3);
		System.out.println(set.size());
	}
}
