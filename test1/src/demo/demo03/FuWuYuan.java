package demo.demo03;
/**
 * ����Ա��
 * Ա����һ�֣����ж��������
 * @author Administrator
 *
 */
public class FuWuYuan extends Employee implements VIP {
	public FuWuYuan() {}
	public FuWuYuan(String name, String id) {
		super(name, id);
	}
	
	public void work() {
		System.out.println(this.getId()+"����Ա���ϲ�");
	}
	public void services() {
		System.out.println(this.getId()+"����Ա��VIP���˵���");
	}
}
