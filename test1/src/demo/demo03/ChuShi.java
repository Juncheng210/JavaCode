package demo.demo03;
/**
 * 厨师类
 * 员工的一种，具有额外服务功能
 * @author Administrator
 *
 */
public class ChuShi extends Employee implements VIP {
	public ChuShi() {}
	public ChuShi(String name,String id) {
		super(name,id);
	}
	
	public void work() {
		System.out.println(this.getId()+"厨师在炒菜");
	}
	public void services() {
		System.out.println(this.getId()+"厨师做菜加量");
	}
}
