package day0528;
/**
 * �������࣬���涼�д�ӡ��������A��ӡ10��A����B��ӡ10��B����C��ӡ10��C�����ö��߳�ʵ��������ӡABC
 */
public class Demo2 {
	public static void main(String[] args) {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		
		new Thread(new PrintA(a, b)).start();
		new Thread(new PrintB(b, c)).start();
		new Thread(new PrintC(c, a)).start();
	}
}