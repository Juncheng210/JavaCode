package day0518;

public class Worker implements Comparable {
	private int age;
	private String name;
	private double salary;

	public Worker() {
	}

	public Worker(String name, int age, double salary) {
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void work(){ 
	System.out.println(name + "work"); 
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Worker) {
			Worker w = (Worker)obj;
			if(this.name.equals(w.name) && this.age==w.age && this.salary==w.salary) {
				return true;
			}
		}
		return false;
	}
	

	@Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Object o) {
		if(this.age!=((Worker)o).age){ 
			return this.age-((Worker)o).age; 
		} else if(this.salary!=((Worker)o).salary){ 
			return new Double(this.salary).compareTo(new Double(((Worker)o).salary));
		} else if(this.name.equals(((Worker)o).name)){ 
			return this.name.compareTo(((Worker)o).name); 
		}
		return 0; 
	}
}
