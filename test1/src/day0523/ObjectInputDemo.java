package day0523;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputDemo {
	public static void main(String[] args) {
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/test/Object.txt"));
			Student stu = (Student) ois.readObject();
			System.out.println(stu.getName()+"-"+stu.getId()+"-"+stu.getAge());
			ois.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
