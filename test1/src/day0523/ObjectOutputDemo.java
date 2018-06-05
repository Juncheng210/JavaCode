package day0523;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ObjectOutputDemo {
	public static void main(String[] args) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/test/Object.txt"));
			oos.writeObject(new Student("zs", "001", 19));
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
