package day0423;

public class Demo {

	public static void main(String[] args) {
		StaticKey a = new StaticKey();
		a.name = "����";
		StaticKey.type = "dog";
		
		StaticKey b = new StaticKey();
		b.name = "����è";
		b.type = "cat";
		
		System.out.println(a.getName());
		System.out.println(a.getType());
		
		System.out.println(b.getName());
		System.out.println(b.getType());
	}

}
