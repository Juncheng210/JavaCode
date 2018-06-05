package day0516;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class HashMapTest {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("aa", 11);
		hm.put("bb", 22);
		hm.put("cc", 33);
		hm.put("dd", null);
		
		System.out.println(hm.get("dd"));
		System.out.println(hm.get("ee"));
		
		Set s = hm.keySet();
		System.out.println(s);
		
		Collection c = hm.values();
		System.out.println(c);
		
		System.out.println(hm.remove("dd"));
		System.out.println(hm.remove("ee"));
		
		System.out.println(hm);
	}
}
