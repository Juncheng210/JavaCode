package demo.demo01;
/**
 * ����ʼǱ���
 * ���ܣ��������ػ���ʹ��USB�豸
 */
public class Computer {
	private USB[] usbArr = new USB[4];  //���������ϵ�USB�������
	
	
	public void openComputer() {
		System.out.println("���������");
	}
	
	public void closeComputer() {
		System.out.println("������ػ�");
	}
	
	//������������USB�豸
	public void useUSB(USB usb) {
		//�������в��
		int i;
		for(i=0; i<usbArr.length; i++) {
			//�ж���û�пյĲ��
			if(usbArr[i] == null) {
				//����USB�豸
				usbArr[i] = usb;
				usb.open();
				break;  //����ѭ��
			}
		}
		if(i==usbArr.length) {
			System.out.println("û�в����������");
		}
	}
	
	//ж���豸
	public void uninstallUSB(USB usb) {
		//�������в��
		for(int i=0; i<usbArr.length; i++) {
			//�жϲ���Ƿ�����豸
			if(usbArr[i] != null) {
				//����USB�豸
				usbArr[i] = null;
				usb.close();
				break;  //����ѭ��
			}
		}
	}
}
