package demo.demo03;
/**
 * ��ʦ��
 * Ա����һ�֣����ж��������
 * @author Administrator
 *
 */
public class ChuShi extends Employee implements VIP {
	public ChuShi() {}
	public ChuShi(String name,String id) {
		super(name,id);
	}
	
	public void work() {
		System.out.println(this.getId()+"��ʦ�ڳ���");
	}
	public void services() {
		System.out.println(this.getId()+"��ʦ���˼���");
	}
}
