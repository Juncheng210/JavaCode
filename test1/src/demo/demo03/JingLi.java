package demo.demo03;
/**
 * ������
 * Ա����һ�֣�û��VIP������
 * �н�������
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
		System.out.println("����"+this.getName()+"�ڹ�����");		
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}
	
	
}
