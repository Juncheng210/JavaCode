package demo.demo02;

public class Trade {
	public static void main(String[] args) {
		//��������
		Bank.bankName = "�й���������";
		//��ӡ��ӭ���
		Bank.welcome();
		//ͨ�����췽�����п���
		Bank bank = new Bank("����", "1234567", 200.00);
		//���д�����
		bank.deposit(500.00);
		//ȡ��ʱ�����������ȡ��ʧ��
		bank.withdrawal("123456", 200.00);
		//ȡ��ʱ���㣬ȡ��ʧ��
		bank.withdrawal("1234567", 1000.00);
		//ȡ��ʱ������ȷ�������㣬ȡ��ɹ�
		bank.withdrawal("1234567", 200.00);
		//��ӡ�������
		Bank.welcomeNext();
	}
}
