package day0514;

public class Demo {
	public static void main(String[] args) {
		//����һ���ַ������ж������Ƿ�������ȣ�6-10λ���ɴ�Сд��ĸ��������ɣ�
		String pwd = "123456FDz";
//		^ ƥ��һ�еĿ�ͷλ��
//		(?![0-9]+$) Ԥ���λ�ú��治ȫ������
//		(?![a-z]+$) Ԥ���λ�ú��治ȫ��Сд��ĸ
//		(?![A-Z]+$) Ԥ���λ�ú��治ȫ�Ǵ�д��ĸ
//		[0-9A-Za-z] {8,16} ��8-16λ���ֻ�����ĸ���
//		$ ƥ���н�βλ��
//		ע��(?!xxxx) ��������ʽ�ĸ���������һ����ʽ����ʶԤ��λ�ú���xxxx�ַ���
		boolean bb = pwd.matches("^(?![0-9]+$)(?![a-z]+$)(?![A-Z]+$)[0-9A-Za-z]{6,10}$");
		System.out.println(bb);
		//�����滻
		String str1 = "����@@@����YYY����*****������";
		String str2 = str1.replaceAll("(.)\\1+", "$1");
		System.out.println(str2);
		
		String str3 = "���������ҡ���������������ѧ��ѧ����ѧ���";
		String str4 = str3.replaceAll("��", "").replaceAll("(.)\\1+", "$1");
		System.out.println(str4);
	}
}
