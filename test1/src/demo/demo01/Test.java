package demo.demo01;

public class Test {
	public static void main(String[] args) {
		//�����ʼǱ����󣬵��ñʼǱ�����
		Computer comp = new Computer();
		//���������
		comp.openComputer();
		
		//ʹ�����
		comp.useUSB(new Mouse());
		//ʹ�ü���
		comp.useUSB(new Keyboard());
		//ʹ����˷�
		comp.useUSB(new Mic());
		//ж�����
		comp.uninstallUSB(new Mouse());
		//ж�ؼ���
		comp.uninstallUSB(new Keyboard());
		//ж����˷�
		comp.uninstallUSB(new Mic());
		
		//������ػ�
		comp.closeComputer();
	}
}
