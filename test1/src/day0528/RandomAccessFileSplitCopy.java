package day0528;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class RandomAccessFileSplitCopy {
	public static void main(String[] args) {
		int size = 100000;//ÿ��Ĵ�С
		try {
			RandomAccessFile raf = new RandomAccessFile("D:/test/111/aaa.jpg", "r");
			ArrayList<RandomAccessFile> list = new ArrayList<RandomAccessFile>();
					
			int block = (int)Math.ceil(raf.length()*1.0/size);//��Ϊ����
			for(int i=0; i<block; i++) {
				list.add(new RandomAccessFile("D:/test/aaa"+(i+1)+".jpg", "rw"));
			}
			
			for(int i=0; i<block; i++) {
				raf.seek(size*i);//ÿ��ѭ���ƶ�ָ��
				int length = 0;//��¼�Ѿ�д��ĳ���
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
