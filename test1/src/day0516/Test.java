package day0516;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		LinkedList li = new LinkedList();
		li.add("abc");
		li.add("def");
		li.add(123);
		li.addFirst(1);
		li.addLast(2);
		li.add(3);
		li.add(2, "g");
		System.out.println(li.size());
		System.out.println(li);
	}
}
