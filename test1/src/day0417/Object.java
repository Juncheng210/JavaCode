package day0417;

public class Object {

	public static void main(String[] args) {
		//������������һ������Ķ���
		Person p = new Person();
		
		p.name = "����";
		p.age = 22;
		p.height = 1.78;
		p.sex = true;
		
		System.out.println(p.name);
		System.out.println(p.age);
		System.out.println(p.height);
		System.out.println(p.sex);
		System.out.println(p.guoJi);
		
		p.eat();
	}

}
