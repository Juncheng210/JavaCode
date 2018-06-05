package day0511;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Test {
	public static void main(String[] args) {
		Student[] stu = new Student[3];
		stu[0] = new Student("001", "a", "01", 18, 98);
		stu[1] = new Student("002", "b", "02", 19, 88);
		stu[2] = new Student("003", "c", "03", 20, 78);
		
		StringBuilder sb = new StringBuilder("{");
		sb.append("\"class\":[{");
		for(int i=0; i<stu.length; i++) {
			sb.append("\"student\":{");
			sb.append("\"id\":").append("\"").append(stu[i].getId()).append("\",");
			sb.append("\"name\":{\"firstname\":").append("\"").append(stu[i].getFirstName()).append("\",").append("\"lastname\":").append("\"").append(stu[i].getLastName()).append("\"},");
			sb.append("\"age\":").append("\"").append(stu[i].getAge()).append("\",");
			sb.append("\"score\":").append("\"").append(stu[i].getScore()).append("\"");
			sb.append("}");
			if(i!=stu.length-1) {
				sb.append(",");
			}
		}
		sb.append("}]}");
		
		try {
			FileOutputStream fos = new FileOutputStream("D:/json.json");
			fos.write(sb.toString().getBytes());
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
