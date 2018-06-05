package day5;

public class test4 {
	public static void main(String[] args) {
		/*
		 * 打印菱形
		 * */
		int cengNum = 7;//控制上半部分打印层数
		
		//上半部分
		for(int i=1; i<=cengNum; i++) {
			for(int m=cengNum-1; m>=i; m--) {//int i=1; i<=cengNum-i; i++
				System.out.print(" ");//空格控制
			}
			for(int n=1; n<=i*2-1; n++) {
				System.out.print("*");//*号控制
			}
			System.out.println();
		}
		
		//下半部分(倒序输出)
		for(int i=cengNum-1; i>=1; i--) {
			for(int m=cengNum-1; m>=i; m--) {
				System.out.print(" ");//空格控制
			}
			for(int n=1; n<=i*2-1; n++) {
				System.out.print("*");//*号控制
			}
			System.out.println();
		}
	}
}
