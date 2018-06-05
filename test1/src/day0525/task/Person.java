package day0525.task;

public class Person implements Runnable {
	private String name;
	private int eatFood;
	private boolean isExit;
	private static int food = 20;
	
	@Override
	public void run() {
		while(true) {
			if(food>0){
				System.out.println(Thread.currentThread().getName()+" ณิมหตฺ  "+(++this.eatFood)+" ทÝทน" );
				if(this.eatFood==6) {
					break;
				}
			}else{
				
			}
		}
	}	
}
