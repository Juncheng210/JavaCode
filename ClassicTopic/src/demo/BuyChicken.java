package demo;

public class BuyChicken {

	public static void main(String[] args) {
		// ��Ǯ��ټ�
		// ������Ԫһֻ��ĸ����Ԫһֻ��С��һԪ��ֻ
		// 100Ԫǡ����100ֻ����
		int count = 0;
		for(int i=1; i<=100/3; i++) {
			for(int j=1; j<=(100/2-i); j++) {
				for(int k=1; k<=(100-i-j); k++) {
					if(i+j+k==100 && 3*i+2*j+0.5*k==100) {
						System.out.println("������"+i+"��ĸ����"+j+"��С����"+k);
					}
					count++;
				}
			}
		}
		System.out.println(count);

	}

}
