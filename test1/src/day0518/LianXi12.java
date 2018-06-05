package day0518;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class LianXi12 {
	public static void main(String[] args) { 
		 Map<String, String> map=new TreeMap<String, String>(); map.put("Tom", "CoreJava"); 
		 map.put("John", "Oracle"); 
		 map.put("Susan", "Oracle"); 
		 map.put("Jerry", "JDBC"); 
		 map.put("Jim", "Unix"); 
		 map.put("Kevin", "JSP"); 
		 map.put("Lucy", "JSP"); 
		 System.out.println(map.size()); 
		 map.put("Allen", "JDBC"); 
		 System.out.println(map.size()); 
		 map.remove("Lucy"); 
		 map.put("Lucy", "CoreJava"); 
		 
		 Set<String> set=map.keySet(); 
		 for(Object obj:set){
			 System.out.println(map.get((String)obj)); 
		 } 
		 for(String str:set){ 
			 if(map.get(str).equals("JSP")){ 
				 System.out.println("教 JSP 的老师有:"+str);
			} 
		 } 
	}
}
