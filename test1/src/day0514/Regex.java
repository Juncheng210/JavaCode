package day0514;

public class Regex {
	public static void main(String[] args) {
		//判断18位的身份证号码
		String s = "12345678912345678x";
		System.out.println(s.matches("\\d{17}[\\dXx]"));
		//判断手机号是否合法
		String tel = "18812341234";
		System.out.println(tel.matches("^1[35789][\\d]{9}"));
		//判断IP地址是够合法
		String ip = "1.99.99.99";
		System.out.println(ip.matches("25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2}(\\.(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})){3}"));
	}
}
