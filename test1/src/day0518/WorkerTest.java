package day0518;

import java.util.Collections;
import java.util.TreeSet;

public class WorkerTest {
	public static void main(String[] args) {
		/*
		List<Worker> list = new ArrayList<Worker>();
		list.add(new Worker("zhang3", 18, 3000));
		list.add(new Worker("li4", 25, 3500));
		list.add(new Worker("wang5", 22, 3200));
		list.add(1, new Worker("zhao6", 24, 3300));
		list.remove(3);
		
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getName() + "-" + list.get(i).getAge() + "-" + list.get(i).getSalary());
		}
		
		Iterator<Worker> it = list.iterator();
		while(it.hasNext()) {
			it.next().work();
		}
		*/
		TreeSet<Worker> hs = new TreeSet<Worker>();
		hs.add(new Worker("zhang3", 18, 1500));
		hs.add(new Worker("li4", 18, 1500));
		hs.add(new Worker("wang5", 18, 1600));
		hs.add(new Worker("zhao6", 17, 2000));
		
		System.out.println(hs);
	}
}
