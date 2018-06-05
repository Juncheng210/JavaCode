package demo.demo03;
/**
 * 服务员类
 * 员工的一种，具有额外服务功能
 * @author Administrator
 *
 */
public class FuWuYuan extends Employee implements VIP {
	public FuWuYuan() {}
	public FuWuYuan(String name, String id) {
		super(name, id);
	}
	
	public void work() {
		System.out.println(this.getId()+"服务员在上菜");
	}
	public void services() {
		System.out.println(this.getId()+"服务员给VIP客人倒酒");
	}
}
