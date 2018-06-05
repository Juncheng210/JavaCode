package day0509;

import java.util.ArrayList;

public class ArrayListTest {
	public static void main(String[] args) {
//		ArrayList<String> a = new ArrayList<String>();
//		a.add("a");
//		a.add("b");
//		a.add("c");
//		a.add("d");
//		a.add(2, "e");	
		int i=1, j=8;
		  do{
		     if(i++>--j)
		        continue;
		  }while(i<4);
		  System.out.println(i);
		  System.out.println(j);

	}
}
