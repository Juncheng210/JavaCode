package day5;



public class test6 {
	public static void main(String[] args) {
		long sum = 0l;
		for(int i=1; i<=10; i++) {
			for(int j=1; j<=i; j++) {
				sum += Math.pow(10, i) - 1;
				System.out.print(9);
			}
			if(i==10) {
				System.out.print("="+sum);
			} else {
				System.out.print("+");
			}
		}
		
	}
}
