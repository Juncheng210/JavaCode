package day0510;
/**
 * �����ַ�����λ��ʽʵ���ַ��ı����ܡ����ܡ�(д2����ʵ�ֶ������һ�仰���ܺͽ���)
 *	hello��your password is huhu
 *	nkrru2e����
 *	ÿһ���ַ�����6λ�����µ��ַ�,���еĿո���1�����еģ����2
 * @author Administrator
 *
 */
public class Password {
	private String password;
	
	public Password(String password) {
		this.password = password;
	}
	public Password() {}
	/**
	 * �ַ�������
	 */
	public void encryption() {
		char[] pwd = this.password.toCharArray();
		this.password = "";
		for(int i=0; i<pwd.length; i++) {
			if(pwd[i]>=65 && pwd[i]<=84 || pwd[i]>=97 && pwd[i]<=116) {
				pwd[i] = (char)(pwd[i]+6);
			} else if(pwd[i]>=85 && pwd[i]<=90 || pwd[i]>=117 && pwd[i]<=122) {
				pwd[i] -= 20;
			} else if(pwd[i]==' ') {
				pwd[i] = 49;
			} else if(pwd[i]==44) {
				pwd[i] = 50;
			}
		}
		for(char i : pwd) {
			this.password += i;
		}
		System.out.println(this.password);
	}
	/**
	 * �ַ�������
	 */
	public void decrypt() {
		char[] pwd = this.password.toCharArray();
		this.password = "";
		for(int i=0; i<pwd.length; i++) {
			if(pwd[i]>=71 && pwd[i]<=90 || pwd[i]>=103 && pwd[i]<=122) {
				pwd[i] = (char)(pwd[i]-6);
			} else if(pwd[i]>=65 && pwd[i]<=70 || pwd[i]>=97 && pwd[i]<=102) {
				pwd[i] += 20;
			} else if(pwd[i]=='1') {
				pwd[i] = ' ';
			} else if(pwd[i]=='2') {
				pwd[i] = 44;
			}
		}
		for(char i : pwd) {
			this.password += i;
		}
		System.out.println(this.password);
	}
}
