package day0524;
/**
 * 
 * @ClassName: ThreadDemo  
 * @Description: ����ÿ��5�ף��ڹ�1�ף�����20����Ϣ500���� ,�ڹ�100����Ϣ500���룡���߳�ģ��������̡�˭������1000��˭��ʤ���]����ľͲ�����
 * @author Administrator  
 * @date 2018��5��24��  
 *
 */
public class ThreadDemo {
	public static void main(String[] args) {
		Rabbit rab = new Rabbit("����");
		Tortoise tor = new Tortoise("�ڹ�");
		rab.start();
		tor.start();
	}
}
