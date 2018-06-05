package day0521;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class Test4 {
	public static void main(String[] args) {
		ArrayList<RandomAccessFile> list = new ArrayList<RandomAccessFile>();
		try {
			RandomAccessFile raf = new RandomAccessFile("D:/test/b.jpg", "rw");
			for(int i=0; i<6; i++) {
				list.add(new RandomAccessFile("D:/test/aaa"+(i+1)+".jpg", "r"));
			}
			byte[] arr = new byte[1024];
			int len = -1;
			for(int i=0; i<list.size(); i++) {
				while((len=list.get(i).read(arr)) != -1) {
					raf.write(arr, 0, len);
				}
				list.get(i).close();
			}
			raf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
