package demo;

public class MonkeyEatPeach {

	public static void main(String[] args) {
		//猴子吃桃问题。
		//猴子第一天摘下若干个桃子，当时就吃了一半，还不过瘾，就又吃了一个。
		//第二天又将剩下的桃子吃掉一半，又多吃了一个。
		//以后每天都吃前一天剩下的一半零一个。到第 10 天在想吃的时候就剩一个桃子了,
		//求第一天共摘下来多少个桃子
		int sum = 1;  //第十天剩余的桃子数
		int day = 10;
		for(int i=10; i>1; i--) {
			sum = (sum+1)*2;
			day--;
			System.out.println("第"+day+"天的桃子数为："+sum);
		}
		
	}

}
