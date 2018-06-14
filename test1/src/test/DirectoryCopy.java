package test;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DirectoryCopy {
	public static void main(String[] args) {
		copy("src/test", "test");
	}
	
	private static void copy(String sourceSrc, String destinationSrc) {
		File sourceFile = new File(sourceSrc);
		File destinationFile = new File(destinationSrc);
		
		File[] files = sourceFile.listFiles();
		
		if(!destinationFile.exists()) {
			destinationFile.mkdirs();
		}
		
		for (File file : files) {
			if(file.isFile()) {
				fileCopy(file.getPath(), destinationSrc+File.separator+file.getName());
			} else {
				copy(file.getPath(), destinationSrc+File.separator+file.getName());
			}
		}
	}
	
	private static void fileCopy(String sourceSrc, String destinationSrc) {
		BufferedInputStream read = null;
		BufferedOutputStream write = null;
		try {
			read = new BufferedInputStream(new FileInputStream(sourceSrc));
			write = new BufferedOutputStream(new FileOutputStream(destinationSrc));
			
			byte[] buff = new byte[1024];
			int len = -1;
			try {
				while((len = read.read(buff)) != -1) {
					write.write(buff, 0, len);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				write.close();
				read.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
