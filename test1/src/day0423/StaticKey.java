package day0423;

public class StaticKey {
	public String name;
	public static String type;
	
	static {
		type = "dog";
	}
	
	public StaticKey(String name) {
//		super();
		this.name = name;
	}
	public StaticKey() {
//		super();
	}
	
	public void eat() {
		this.name = "";
		System.out.println("�Ǿ�̬����");
	}
	public static void sleep() {
//		this.name = "";//��̬������ֱ��ʹ��this�ᱨ��
		StaticKey.type = "";
		System.out.println("��̬����");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String type) {
		StaticKey.type = type;
	}
	
	
}
