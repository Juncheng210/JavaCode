package demo.demo03;
/**
 * 经理类
 * 员工的一种，没有VIP服务功能
 * 有奖金属性
 * @author Administrator
 *
 */
public class JingLi extends Employee {
	private double money;
	
	public JingLi() {};
	public JingLi(String name,String id,double money) {
		super(name,id);
		this.money = money;
	}

	@Override
	public void work() {
		System.out.println("经理"+this.getName()+"在管理工作");		
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
