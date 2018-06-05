package demo.demo02;

public class Trade {
	public static void main(String[] args) {
		//定义银行
		Bank.bankName = "中国工商银行";
		//打印欢迎语句
		Bank.welcome();
		//通过构造方法进行开户
		Bank bank = new Bank("张三", "1234567", 200.00);
		//进行存款操作
		bank.deposit(500.00);
		//取款时密码输入错误，取款失败
		bank.withdrawal("123456", 200.00);
		//取款时余额不足，取款失败
		bank.withdrawal("1234567", 1000.00);
		//取款时密码正确，余额充足，取款成功
		bank.withdrawal("1234567", 200.00);
		//打印道别语句
		Bank.welcomeNext();
	}
}
