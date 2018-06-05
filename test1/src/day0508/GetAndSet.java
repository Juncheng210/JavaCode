package day0508;

public class GetAndSet {
	private String name;
	private String id;
	private int age;
	private float money;
	private boolean sex;
	
	public GetAndSet(String name, String id, int age, float money, boolean sex) {
		super();
		this.name = name;
		this.id = id;
		this.age = age;
		this.money = money;
		this.sex = sex;
	}
	public GetAndSet() {}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public boolean isSex() {
		return sex;
	}
	public void setSex(boolean sex) {
		this.sex = sex;
	}
}
