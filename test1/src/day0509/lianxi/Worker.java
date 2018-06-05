package day0509.lianxi;

public class Worker extends Person {
	private String company;
	private int workYears;
	
	public Worker(String name, boolean sex, int age, String country, String company, int workYears) {
		super(name, sex, age, country);
		this.company = company;
		this.workYears = workYears;
	}
	public Worker() {}
	
	
	
	@Override
	public void work() {
		System.out.println("¥ÛΩ®…Ë");
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getWorkYears() {
		return workYears;
	}
	public void setWorkYears(int workYears) {
		this.workYears = workYears;
	}
}
