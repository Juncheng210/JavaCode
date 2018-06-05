package demo.demo01;
/**
 * 自定义的USB接口类
 * 开，关
 *
 */
public interface USB {
	public abstract void open();  //启动
	public abstract void close();  //关闭
}
