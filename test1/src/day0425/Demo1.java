package day0425;

public class Demo1 {
	public static void main(String[] args) {
		G1();
		System.out.println("----------华丽的分割线----------");
		G2();
		System.out.println("----------华丽的分割线----------");
		G3();
		System.out.println("----------华丽的分割线----------");
		G4();
		System.out.println("----------华丽的分割线----------");
		G5();
		System.out.println("----------华丽的分割线----------");
		G6();
		System.out.println("----------华丽的分割线----------");
		G7();
		System.out.println("----------华丽的分割线----------");
		G8();
		System.out.println("----------华丽的分割线----------");
		G9();
		System.out.println("----------华丽的分割线----------");
		G10();
	}
	
	/**
	 * 打印左边正三角形
	 */
	public static void G1() {
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

	}
	
	/**
	 * 打印左边倒三角形
	 */
	public static void G2() {
		for (int i = 6; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
	}
	/**
	 * 打印右正三角形
	 */
	public static void G3() {
		for (int i = 5; i > 0; i--) {
			for (int j = 1; j < 6; j++) {
				if (i > j) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}
	/**
	 * 打印右倒三角形
	 */
	public static void G4() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				if (i > j) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 打印正中三角形
	 * 每行 5 6 7 8 9 每行空格 4 3 2 1
	 */
	public static void G5() {
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < (5 + i); j++) {
				// 5-i 1+2*i
				if (j < (6 - i)) {
					System.out.print("  ");
				} else {
					System.out.print("* ");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 打印倒中三角形
	 * i= 9 8 7 6 5 j= 8 7 6 5 4 i=9 j<0 i=8 j<1
	 */
	public static void G6() {

		for (int i = 9; i > 4; i--) {
			for (int j = 0; j < i; j++) {
				// j 01234..i (9-i)
				if (j < (9 - i)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}
			System.out.println();
		}
	}

	/**
	 * 打印正人字状
	 * i = 0 1 2 3 4 04 4 13 15 6 22 26 8 31 37 10 40 48 12
	 */
	public static void G7() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if ((i + j) == 4) {
					System.out.print("*");
				} else if ((i + j) == (i * 2 + 4)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
	}
	/**
	 * 打印中正空三角形
	 */
	public static void G8() {
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				if (i == 4) {
					System.out.print("*");
				} else {

					if ((i + j) == 4) {
						System.out.print("*");
					} else if ((i + j) == (i * 2 + 4)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

	/**
	 * 打印中倒空三角形
	 * i = 0 1 2 3 4 04 4 13 15 6 22 26 8 31 37 10 40 48 12
	 */
	public static void G9() {
		for (int i = 4; i > -1; i--) {
			for (int j = 0; j < 9; j++) {
				if (i == 4) {
					System.out.print("*");
				} else {

					if ((i + j) == 4) {
						System.out.print("*");
					} else if ((i + j) == (i * 2 + 4)) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}

			}
			System.out.println();
		}
	}

	public static void G10() {
		int cengNum = 5;//控制上半部分打印层数
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
