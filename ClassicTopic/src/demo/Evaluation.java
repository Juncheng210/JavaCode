package demo;

public class Evaluation {

	public static void main(String[] args) {
		//已知 XYZ+YZZ=532，其中，X、Y、Z 为数字，编程求出 X、Y 和 Z 的值
		int x,y,z;
		for(x=0; x<10; x++) {
			for(y=0; y<10; y++) {
				for(z=0; z<10; z++) {
					if((x*100+y*10+z)+(y*100+z*10+z)==532) {
						System.out.println("x="+x+"，y="+y+"，z="+z);
					}
				}
			}
		}
	}

}
