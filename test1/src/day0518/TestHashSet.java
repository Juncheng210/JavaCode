package day0518;

import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
	public static void main(String args[]) {
		Set set = new HashSet();
		Student stu1 = new Student();
		Student stu2 = new Student("Tom", 18);
		Student stu3 = new Student("Tom", 18);
		set.add(stu1);// 在添加 stu1的时候会自动调用 hashcode 和 equals 方法, 而在这两方法中, name 的值为空,所以会出现空指针异常。
		set.add(stu2);
		set.add(stu3);
		System.out.println(set.size());
	}
}
