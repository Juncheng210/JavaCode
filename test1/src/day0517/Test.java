package day0517;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {
	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("abc");
		stack.push("def");
		stack.push("ghi");
		stack.push("jkl");
		stack.push("mn");
		stack.push("opq");
		System.out.println(stack);
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack);
		
		System.out.println("-----------------------------------------");
		Queue queue = new LinkedList();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		System.out.println(queue);
		queue.poll();
		System.out.println(queue.peek());
		System.out.println(queue);
		
		System.out.println("-----------------------------------------");
		Deque deque = new LinkedList();
		deque.add("a");
		deque.add("b");
		deque.add("c");
		deque.add("d");
		deque.addFirst("g");
		deque.addLast("h");
		deque.add("e");
		System.out.println(deque);
		deque.pollLast();
		System.out.println(deque.peekLast());
		System.out.println(deque);
	}
}
