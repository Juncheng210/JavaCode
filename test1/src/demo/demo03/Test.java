package demo.demo03;

public class Test {
	public static void main(String[] args) {
		//����1������2������Ա��2����ʦ
		JingLi jl = new JingLi("����","A001",12345.67);
		jl.work();
		
		FuWuYuan f1 = new FuWuYuan("С��","B0001");
		FuWuYuan f2 = new FuWuYuan("С��","B0002");
		
		f1.work();
		f1.services();
		
		f2.work();
		f2.services();
		
		ChuShi c1 = new ChuShi("����", "C0001");
		ChuShi c2 = new ChuShi("����", "C0002");
		
		c1.work();
		c1.services();
		
		c2.work();
		c2.services();
	}
}
