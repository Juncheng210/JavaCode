package day0517;

public class LinkTest {
	public static void main(String[] args) {
		Link link = new Link();
		link.add("a");
		link.add("b");
		link.add("c");
		link.add("d");
		
		System.out.println(link.get(1));
		
		link.set(1, "11");
		System.out.println(link.get(1));
		System.out.println(link);
		
	}
}
