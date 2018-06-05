package demo.demo03;

public class Test {
	public static void main(String[] args) {
		//创建1个经理，2个服务员，2个厨师
		JingLi jl = new JingLi("张三","A001",12345.67);
		jl.work();
		
		FuWuYuan f1 = new FuWuYuan("小花","B0001");
		FuWuYuan f2 = new FuWuYuan("小丽","B0002");
		
		f1.work();
		f1.services();
		
		f2.work();
		f2.services();
		
		ChuShi c1 = new ChuShi("李四", "C0001");
		ChuShi c2 = new ChuShi("王五", "C0002");
		
		c1.work();
		c1.services();
		
		c2.work();
		c2.services();
	}
}
