package demo.demo01;
/**
 * 定义笔记本类
 * 功能：开机，关机，使用USB设备
 */
public class Computer {
	private USB[] usbArr = new USB[4];  //定义计算机上的USB插口数量
	
	
	public void openComputer() {
		System.out.println("计算机开机");
	}
	
	public void closeComputer() {
		System.out.println("计算机关机");
	}
	
	//向计算机上连接USB设备
	public void useUSB(USB usb) {
		//遍历所有插口
		int i;
		for(i=0; i<usbArr.length; i++) {
			//判断有没有空的插口
			if(usbArr[i] == null) {
				//连接USB设备
				usbArr[i] = usb;
				usb.open();
				break;  //结束循环
			}
		}
		if(i==usbArr.length) {
			System.out.println("没有插口让你用了");
		}
	}
	
	//卸载设备
	public void uninstallUSB(USB usb) {
		//遍历所有插口
		for(int i=0; i<usbArr.length; i++) {
			//判断插口是否存在设备
			if(usbArr[i] != null) {
				//连接USB设备
				usbArr[i] = null;
				usb.close();
				break;  //结束循环
			}
		}
	}
}
