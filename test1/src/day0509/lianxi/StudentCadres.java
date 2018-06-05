package day0509.lianxi;

public class StudentCadres extends Student {
	private String position;
	
	public StudentCadres(String name, boolean sex, int age, String country, String school, String id, String position) {
		super(name, sex, age, country, school, id);
		this.position = position;
	}
	public StudentCadres() {}

	public void kaiHui() {
		System.out.println("¿ª»á");
	}
	
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	
}
