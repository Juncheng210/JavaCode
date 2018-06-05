package day0419;

public class OverLoad {
	public static void main(String[] args) {
		OverLoad ol = new OverLoad();
		System.out.println(ol.sum(3, 4));
		System.out.println(ol.sum(4.0f, 5.0f));
	}
	
	public int sum(int m,int n) {
		return m+n;
	}
	public float sum(float m,float n) {
		return m+n;
	}
	public double sum(double m,double n) {
		return m+n;
	}
}
