package day0521;

import java.io.File;

public class Test {
	private static long sum;
	
	public static void main(String[] args) {
		//ͳ��һ��Ŀ¼�Ĵ�С
		String s = "D:\\test";
		getDirectorySize(s);
		System.out.println(sum);
		//��ӡһ��Ŀ¼�����е�ͼƬ�ļ��ľ���·����
		String ss = "D:\\juncheng210";
		getImagePath(ss);
		
		File f = new File(s);
		File[] file = f.listFiles();
		for(File f1 : file) {
			System.out.println(f1+"---"+f1.length());
		}
	}
	/**
	 * ��ȡһ��Ŀ¼�Ĵ�С
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
	 * ��ӡһ��Ŀ¼�����е�ͼƬ�ļ��ľ���·����
	 * @param dir ·��
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