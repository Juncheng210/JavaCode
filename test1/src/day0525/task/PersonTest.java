package day0525.task;

public class PersonTest {
	public static void main(String[] args) {
		new Thread(new Person()).start();
		new Thread(new Person()).start();
	}
}
