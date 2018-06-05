package day0524;

public class Tortoise extends Thread {
	private String name;
	
	public Tortoise(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		int s = 0;
		while(true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
			s++;
			if(s%100==0) {
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(this.name+":"+s);
			if(s==1000) {
				System.out.println(this.name+"µΩ¥Ô÷’µ„");
				System.exit(0);
			}
		}
	}
	
}
