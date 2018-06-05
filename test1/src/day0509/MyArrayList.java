package day0509;

import java.util.Arrays;

public class MyArrayList {
	private int size = 0;//初始元素数
	private int defaultSize = 8;//初始数组大小
	private Object[] arr;//用来存储数据的数组
	
	public MyArrayList() {
		arr = new Object[defaultSize];//确定数组的初始大小
	}
	/**
	 * 获取数组元素
	 * @param index 要获取的数组元素对应下标
	 * @return arr[index] 数组对应位置的值
	 */
	public Object get(int index) {
		if(index < this.size) {
			return arr[index];
		} else {
			throw new ArrayIndexOutOfBoundsException();
		}
	}
	/**
	 * 向数组中添加元素
	 * @param ele 要添加的数据
	 */
	public void add(Object ele) {
		isCapacityEnough();
		arr[size] = ele;//将要添加的元素赋值给第size项
		size++;//没添加一个元素，将size加1
	}
	/**
	 * 获取数组中的元素个数
	 * @return
	 */
	public int size() {
		return size;
	}
	/**
	 * 判断数组数量是否足够
	 */
	public void isCapacityEnough() {
		//判断已添加元素的数量和原数组元素是否相等
		if( size == arr.length ) {
//			Object[] newArr = new Object[size * 2];
//			arr = Arrays.copyOf(arr,newArr.length);
			arr = Arrays.copyOf(arr,arr.length * 2);//将原数组数据拷贝，并将其长度变为两倍，重新赋值给原数组
		}
	}
	
	public static void main(String[] args) {
		MyArrayList arr = new MyArrayList();
		//利用循环向数组中添加数据
		for(int i=1; i<=100; i++) {
			arr.add(""+i);
		}
		//遍历数组
		for(int i=0; i<arr.size(); i++) {
			System.out.println( arr.get(i) );
		}
	}
}
