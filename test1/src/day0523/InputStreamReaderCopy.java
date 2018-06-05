package day0523;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class InputStreamReaderCopy {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream("D:/test/test.txt"));
			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:/test/test_1.txt"));
			char[] cbuf = new char[10];
			int len = -1;
			while((len = isr.read(cbuf)) != -1) {
				osw.write(cbuf, 0, len);
			}
			osw.close();
			isr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
