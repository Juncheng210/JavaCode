package demo;

public class BuyChicken {

	public static void main(String[] args) {
		// 百钱买百鸡
		// 公鸡三元一只，母鸡两元一只，小鸡一元两只
		// 100元恰好买100只鸡，
		int count = 0;
		for(int i=1; i<=100/3; i++) {
			for(int j=1; j<=(100/2-i); j++) {
				for(int k=1; k<=(100-i-j); k++) {
					if(i+j+k==100 && 3*i+2*j+0.5*k==100) {
						System.out.println("公鸡："+i+"，母鸡："+j+"，小鸡："+k);
					}
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
