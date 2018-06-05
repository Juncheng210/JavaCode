package day0510;

public class Cat {
	private String type;
	private String color;
	private double weight;
	
	public Cat(String type, String color, double weight) {
		this.type = type;
		this.color = color;
		this.weight = weight;
	}
	public Cat() {}
	
	public boolean equals(Object obj) {
		if(this == obj) {
			return true;
		}
		if(obj instanceof Cat) {
			Cat c = (Cat) obj;
//			if(this.type==c.type && this.color==c.color && this.weight==c.weight) {
			if(this.type.compareTo(c.type)==0 && this.color.compareTo(c.color)==0 && this.weight==c.weight) {
				return true;
			}
			return false;
		}
		return false;
	}
	public static void main(String[] args) {
		Cat c1 = new Cat("¿§·ÆÃ¨", "»ÆÉ«", 10);
		Cat c2 = new Cat("¿§·ÆÃ¨", "»ÆÉ«", 10);
		System.out.println(c1.equals(c2));
	}
}
