package day0509.lianxi;

public class E {
	public static void main(String[] args) {
		SubCar aodi = new SubCar("�µ�", 50, 80);
		SubCar benchi = new SubCar("����", 100, 90);
		
		System.out.println("������Ʒ����"+aodi.getMark());
		System.out.println(aodi.getMark()+"���ļ۸���"+aodi.getPrice());
		aodi.speed();
		aodi.drive();
		aodi.speedChange(120);
		
		System.out.println("-----------------------------");
		
		System.out.println("������Ʒ����"+benchi.getMark());
		System.out.println(benchi.getMark()+"���ļ۸���"+benchi.getPrice());
		benchi.speed();
		benchi.drive();
		benchi.speedChange(120);
	}
}
