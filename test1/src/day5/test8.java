package day5;

public class test8 {

	public static void main(String[] args) {
		//����һ���ַ����ֱ�ͳ�Ƴ�����Ӣ����ĸ���ո����ֺ������ַ��ĸ���
		String str = "sdfjdj435 wreFJDS *&#%$#";
		
		int zimu = 0;
		int kongge =  0;
		int shuzi = 0;
		int qita = 0;
		
		for(int i=0; i<str.length(); i++) {
			char c = str.charAt(i);
			if(c>='0' && c<='9') {
				shuzi++;
			} else if(c>='A' && c<='Z' || c>='a' && c<='z') {
				zimu++;
			} else if(c==32) {
				kongge++;
			} else {
				qita++;
			}
		}
		System.out.println("���ָ���Ϊ��"+shuzi);
		System.out.println("��ĸ����Ϊ��"+zimu);
		System.out.println("�ո����Ϊ��"+kongge);
		System.out.println("�����ַ�����Ϊ��"+qita);
	}

}
