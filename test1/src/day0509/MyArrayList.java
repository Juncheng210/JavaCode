package day0509;

import java.util.Arrays;

public class MyArrayList {
	private int size = 0;//��ʼԪ����
	private int defaultSize = 8;//��ʼ�����С
	private Object[] arr;//�����洢���ݵ�����
	
	public MyArrayList() {
		arr = new Object[defaultSize];//ȷ������ĳ�ʼ��С
	}
	/**
	 * ��ȡ����Ԫ��
	 * @param index Ҫ��ȡ������Ԫ�ض�Ӧ�±�
	 * @return arr[index] �����Ӧλ�õ�ֵ
	 */
	public Object get(int index) {
		if(index < this.size) {
			return arr[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	/**
	 * �����������Ԫ��
	 * @param ele Ҫ��ӵ�����
	 */
	public void add(Object ele) {
		isCapacityEnough();
		arr[size] = ele;//��Ҫ��ӵ�Ԫ�ظ�ֵ����size��
		size++;//û���һ��Ԫ�أ���size��1
	}
	/**
	 * ��ȡ�����е�Ԫ�ظ���
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * �ж����������Ƿ��㹻
	 */
	public void isCapacityEnough() {
		//�ж������Ԫ�ص�������ԭ����Ԫ���Ƿ����
		if( size == arr.length ) {
//			Object[] newArr = new Object[size * 2];
//			arr = Arrays.copyOf(arr,newArr.length);
			arr = Arrays.copyOf(arr,arr.length * 2);//��ԭ�������ݿ����������䳤�ȱ�Ϊ���������¸�ֵ��ԭ����
		}
	}
	
	public static void main(String[] args) {
		MyArrayList arr = new MyArrayList();
		//����ѭ�����������������
		for(int i=1; i<=100; i++) {
			arr.add(""+i);
		}
		//��������
		for(int i=0; i<arr.size(); i++) {
			System.out.println( arr.get(i) );
		}
	}
}
