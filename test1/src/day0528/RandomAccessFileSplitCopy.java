package day0528;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class RandomAccessFileSplitCopy {
	public static void main(String[] args) {
		int size = 100000;//每块的大小
		try {
			RandomAccessFile raf = new RandomAccessFile("D:/test/111/aaa.jpg", "r");
			ArrayList<RandomAccessFile> list = new ArrayList<RandomAccessFile>();
					
			int block = (int)Math.ceil(raf.length()*1.0/size);//分为几块
			for(int i=0; i<block; i++) {
				list.add(new RandomAccessFile("D:/test/aaa"+(i+1)+".jpg", "rw"));
			}
			
			for(int i=0; i<block; i++) {
				raf.seek(size*i);//每次循环移动指针
				int length = 0;//记录已经写入的长度
				byte[] arr = new byte[1024];
				int len  = raf.read(arr);
				
				while(len != -1) {
					length += len;
					if(length <= size) {
						list.get(i).write(arr, 0, len);
						len = raf.read(arr);
					} else {
						list.get(i).write(arr, 0, arr.length-(length-size));
						break;
					}
//					System.out.println(length);
				}
				list.get(i).close();
			}
			raf.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
