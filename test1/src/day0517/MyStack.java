package day0517;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
	private int size = 0;//��ʼԪ����
	private int defaultSize = 8;//��ʼ�����С
	private Object[] arr;//�����洢���ݵ�����
	
	public MyStack() {
		arr = new Object[defaultSize];//ȷ������ĳ�ʼ��С
	}
	
	public Object push(Object obj) {
		ensureCapacity();
		arr[size] = obj;//��Ҫ��ӵ�Ԫ�ظ�ֵ����size��
		size++;
		return obj;
	}
	
	public Object pop() {
		if(size() == 0) {
        	throw new EmptyStackException();
        }
		return size==0 ? new EmptyStackException() : arr[--size];
	}
	
	public Object peek() {
        if(size() == 0) {
        	throw new EmptyStackException();
        }
        return arr[size() - 1];
    }
	
	public int size() {
		return size;
	}
	
	@Override
	public String toString() {
		if(size()==0) {
			return "[]";
		}
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i=0; i<size(); i++) {
            sb.append(arr[i]);
            if (i==size()-1) {
                return sb.append(']').toString();
            }
            sb.append(',').append(' ');
		}
		return "";
	}

	private void ensureCapacity() {
		//�ж������Ԫ�ص�������ԭ����Ԫ���Ƿ����
		if( size == arr.length ) {
			arr = Arrays.copyOf(arr,arr.length * 2);//��ԭ�������ݿ����������䳤�ȱ�Ϊ���������¸�ֵ��ԭ����
		}
	}
}
