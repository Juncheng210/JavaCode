package day0524;

public class CustomExceptionTest {
	public static void main(String[] args) {
		try {
			throw new CustomException("�Զ����쳣");
		} catch (CustomException e) {
			e.printStackTrace();
		}
	}
}
