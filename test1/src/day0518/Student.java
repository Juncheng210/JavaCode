package day0518;

class Student {
	int age;
	String name;

	public Student() {
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public int hashCode() {
		return name.hashCode() + age;
	}
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (o.getClass() != this.getClass())
			return false;

		Student stu = (Student) o;
		if (stu.name.equals(name) && stu.age == age)
			return true;
		else
			return false;

	}

}
