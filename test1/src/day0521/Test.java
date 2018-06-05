package day0521;

import java.io.File;

public class Test {
	private static long sum;
	
	public static void main(String[] args) {
		//统计一个目录的大小
		String s = "D:\\test";
		getDirectorySize(s);
		System.out.println(sum);
		//打印一个目录下所有的图片文件的绝对路径。
		String ss = "D:\\juncheng210";
		getImagePath(ss);
		
		File f = new File(s);
		File[] file = f.listFiles();
		for(File f1 : file) {
			System.out.println(f1+"---"+f1.length());
		}
	}
	/**
	 * 获取一个目录的大小
	 * @param dir
	 * @return
	 */
	public static void getDirectorySize(String dir) {
		File f = new File(dir);
		File[] file = f.listFiles();
		for(File file2 : file) {
			if(file2.isDirectory()) {
				getDirectorySize(file2.getPath());
			} else {
				sum += file2.length();
			}
		}
	}
	/**
	 * 打印一个目录下所有的图片文件的绝对路径。
	 * @param dir 路径
	 */
	public static void getImagePath(String dir) {
		File f = new File(dir);
		File[] file = f.listFiles();
		for(File f1 : file) {
			if(f1.isDirectory()) {
				getImagePath(f1.getPath());
			} else {
				String s = f1.getName();
				if(s.endsWith(".jpg")) {
					System.out.println(f1.getPath());
				}
			}
		}
	}
}
