package day0524;

public class Rabbit extends Thread {
	private String name;
	
	public Rabbit(String name) {
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
			s += 5;
			if(s%20==0) {
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
