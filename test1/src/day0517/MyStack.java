package day0517;

import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack {
	private int size = 0;//初始元素数
	private int defaultSize = 8;//初始数组大小
	private Object[] arr;//用来存储数据的数组
	
	public MyStack() {
		arr = new Object[defaultSize];//确定数组的初始大小
	}
	
	public Object push(Object obj) {
		ensureCapacity();
		arr[size] = obj;//将要添加的元素赋值给第size项
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
		//判断已添加元素的数量和原数组元素是否相等
		if( size == arr.length ) {
			arr = Arrays.copyOf(arr,arr.length * 2);//将原数组数据拷贝，并将其长度变为两倍，重新赋值给原数组
		}
	}
}
