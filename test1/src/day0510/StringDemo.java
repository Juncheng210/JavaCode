package day0510;

public class StringDemo {
	private String str;
	
	
	public StringDemo(String str) {
		this.str = str;
	}
	public StringDemo() {}

	//自己实现startsWith和endsWith功能，可以使用String类的其余方法
	public boolean myStartsWith(String prefix) {
		char[] ch1 = prefix.toCharArray();
		char[] ch2 = str.substring(0, prefix.length()).toCharArray();
		int i;
		for(i=0; i<ch1.length; i++) {
			if(ch1[i] != ch2[i]) {
				return false;
			}
		}
		return true;
	}
	
	public boolean myEndsWith(String suffix) {
		String str1 = str.substring(str.length()-suffix.length(), str.length());
		int a = str1.compareTo(suffix);
		return a==0 ? true : false;
	}
}
