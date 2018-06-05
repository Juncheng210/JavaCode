package day0509.lianxi;
/**
 * 编写程序，计算邮局汇款的汇费：
 *   如果汇款金额小于100元，汇费为1元，
 *   如果金额在100元与500元之间，按1%收取汇费，
 *   如果金额大于500元，汇费为50元。
 * @author Administrator
 */
public class Demo3_2 {
	public static void main(String[] args) {
		int money = 140;//汇款金额
		double hf = 0;//汇费
		
		hf = money<100 ? 1 : money<500 ? money*0.01 : 50;
		
		System.out.println("汇款"+money+"元的汇费为"+hf+"元");
	}
}
