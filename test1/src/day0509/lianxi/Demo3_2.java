package day0509.lianxi;
/**
 * ��д���򣬼����ʾֻ��Ļ�ѣ�
 *   ��������С��100Ԫ�����Ϊ1Ԫ��
 *   ��������100Ԫ��500Ԫ֮�䣬��1%��ȡ��ѣ�
 *   ���������500Ԫ�����Ϊ50Ԫ��
 * @author Administrator
 */
public class Demo3_2 {
	public static void main(String[] args) {
		int money = 140;//�����
		double hf = 0;//���
		
		hf = money<100 ? 1 : money<500 ? money*0.01 : 50;
		
		System.out.println("���"+money+"Ԫ�Ļ��Ϊ"+hf+"Ԫ");
	}
}
