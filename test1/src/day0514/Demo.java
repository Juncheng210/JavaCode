package day0514;

public class Demo {
	public static void main(String[] args) {
		//给定一个字符串，判断密码是否合理（长度：6-10位，由大小写字母及数字组成）
		String pwd = "123456FDz";
//		^ 匹配一行的开头位置
//		(?![0-9]+$) 预测该位置后面不全是数字
//		(?![a-z]+$) 预测该位置后面不全是小写字母
//		(?![A-Z]+$) 预测该位置后面不全是大写字母
//		[0-9A-Za-z] {8,16} 由8-16位数字或这字母组成
//		$ 匹配行结尾位置
//		注：(?!xxxx) 是正则表达式的负向零宽断言一种形式，标识预该位置后不是xxxx字符。
		boolean bb = pwd.matches("^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,10}$");
		System.out.println(bb);
		//叠词替换
		String str1 = "张三@@@李四YYY王五*****王尼玛";
		String str2 = str1.replaceAll("(.)\\1+", "$1");
		System.out.println(str2);
		
		String str3 = "我我我我我……爱…爱爱……学…学……学编程";
		String str4 = str3.replaceAll("…", "").replaceAll("(.)\\1+", "$1");
		System.out.println(str4);
	}
}
