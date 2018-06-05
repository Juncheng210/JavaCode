package day5;

public class test8 {

	public static void main(String[] args) {
		//输入一行字符，分别统计出其中英文字母、空格、数字和其它字符的个数
		String str = "sdfjdj435 wreFJDS *&#%$#";
		
		int zimu = 0;
		int kongge =  0;
		int shuzi = 0;
		int qita = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				shuzi++;
			} else if(c>='A' && c<='Z' || c>='a' && c<='z') {
				zimu++;
			} else if(c==32) {
				kongge++;
			} else {
				qita++;
			}
		}
		System.out.println("数字个数为："+shuzi);
		System.out.println("字母个数为："+zimu);
		System.out.println("空格个数为："+kongge);
		System.out.println("其它字符个数为："+qita);
	}

}
