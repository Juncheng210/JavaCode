package day0509.lianxi;

public class E {
	public static void main(String[] args) {
		SubCar aodi = new SubCar("奥迪", 50, 80);
		SubCar benchi = new SubCar("奔驰", 100, 90);
		
		System.out.println("本车的品牌是"+aodi.getMark());
		System.out.println(aodi.getMark()+"车的价格是"+aodi.getPrice());
		aodi.speed();
		aodi.drive();
		aodi.speedChange(120);
		
		System.out.println("-----------------------------");
		
		System.out.println("本车的品牌是"+benchi.getMark());
		System.out.println(benchi.getMark()+"车的价格是"+benchi.getPrice());
		benchi.speed();
		benchi.drive();
		benchi.speedChange(120);
	}
}
