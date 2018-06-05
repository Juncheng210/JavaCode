package day0509.lianxi;
/**
 * 定义一个人类，包括属性：姓名、性别、年龄、国籍；包括方法：吃饭、睡觉，工作。
 *（1）根据人类，派生一个学生类，增加属性：学校、学号；重写工作方法（学生的工作是学习）。
 *（2）根据人类，派生一个工人类，增加属性：单位、工龄；重写工作方法（工人的工作是……自己想吧）。
 *（3）根据学生类，派生一个学生干部类，增加属性：职务；增加方法：开会。
 *（4）编写主函数分别对上述3类具体人物进行测试。
 * @author Administrator
 *
 */
public class Demo5_4 {
	public static void main(String[] args) {
		Student stu = new Student("张三", true, 20, "中国", "清华大学", "20180001");
		stu.work();
		
		Worker worker = new Worker("工人", false, 45, "中国", "中国石油", 20);
		worker.work();
		
		StudentCadres sc = new StudentCadres("干部", true, 23, "中国", "上海交大", "12345", "主席");
		sc.work();
		sc.kaiHui();
	}
}
