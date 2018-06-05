package day0524;

public class CustomExceptionTest {
	public static void main(String[] args) {
		try {
			throw new CustomException("自定义异常");
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
}
