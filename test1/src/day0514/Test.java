package day0514;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	public static void main(String[] args) {
//		Pattern p = Pattern.compile("\\d");
//		Matcher m = p.matcher("6");
//		boolean b = m.matches();
//		System.out.println(b);
		
		Integer a1 = 123;
		Integer aa = new Integer(123);
		Integer aaa = new Integer("123");
		Integer aaaa = Integer.valueOf("123");
		System.out.println(aaaa);
		
		Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 128;
        Integer f = 128;
        Long g = 3L;

        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
	}
}
