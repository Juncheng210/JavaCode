package day0510;
/**
 * 采用字符的移位方式实现字符文本加密、解密。(写2方法实现对任意的一句话加密和解密)
 *	hello，your password is huhu
 *	nkrru2e……
 *	每一个字符右移6位构成新的字符,所有的空格变成1；所有的，变成2
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
	 * 字符串加密
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
	 * 字符串解密
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
