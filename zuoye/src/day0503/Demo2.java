package day0503;

import java.util.Random;

public class Demo2 {
	public static void main(String[] args) {
		//���ȶ���һ��ѧ����student��ӵ����������name������age�����ĳɼ�chinese����ѧ�ɼ�math��Ӣ��ɼ�english
		//Ȼ���ʼ��100��ѧ�������������Ϊ��100��ѧ�������Ը���ֵ
		//��ÿ��ѧ���ɼ���ƽ����
		//���ܷ���ߵ�ͬѧ������
		//��ÿ��ѧ���ֽܷ�������
		Student[] s = new Student[100];
		Random r = new Random();
		for(int i=0; i<s.length; i++) {
			String m = "zhangsan"+(i+1);//����
			int n = r.nextInt(5) + 10;//����
			int o = r.nextInt(101);//���ĳɼ�
			int p = r.nextInt(101);//��ѧ�ɼ�
			int q = r.nextInt(101);//Ӣ��ɼ�
			s[i] = new Student(m, n, o, p, q);
		}
		
		//���ÿ��ѧ����ƽ����
		for(int i=0; i<s.length; i++) {
			double avg = (s[i].getChinese() + s[i].getMath() + s[i].getEnglish())*1.0 / 3;
			System.out.println(s[i].toString() + "��ƽ����Ϊ��" + avg);
		}
		
		//����ܷ���ߵ�ѧ������
		int max = s[0].getChinese() + s[0].getMath() + s[0].getEnglish();
		int index = 0;
		for(int i=1; i<s.length; i++) {
			if(max<s[i].getChinese() + s[i].getMath() + s[i].getEnglish()) {
				max = s[i].getChinese() + s[i].getMath() + s[i].getEnglish();
				index = i;
			}
		}
		System.out.println("�ɼ��ܷ���ߵ�ͬѧ�ǣ�" + s[index].getName() + ",���ܳɼ�Ϊ��" + max);
		
		//�ܷ�����
		for(int i=1; i<s.length; i++) {
			for(int j=0; j<s.length-i; j++) {
				double sum1 = s[j].getChinese() + s[j].getMath() + s[j].getEnglish();
				double sum2 = s[j+1].getChinese() + s[j+1].getMath() + s[j+1].getEnglish();
				if(sum1<sum2) {
					Student temp = s[j];
					s[j] = s[j+1];
					s[j+1] = temp;
				}
			}
		}
		for(Student i : s) {
			System.out.println(i.toString());
		}
	}
}
