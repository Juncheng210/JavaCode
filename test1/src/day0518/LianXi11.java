package day0518;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LianXi11 {
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String year = null;
		try {
			year = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();

		}
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("2002", "���� ");
		map.put("2006", "����� ");
		map.put("2010", "�Ϸ� ");
		if (map.containsKey(year)) {
			System.out.println(map.get(year));
		} else {
			System.out.println("��һ��û�га����籭! ");
		}

	}

}
