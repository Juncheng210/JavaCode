package day0529;

import java.io.IOException;
import java.io.RandomAccessFile;

public class FileThreadCopy extends Thread {
	private RandomAccessFile read;
	private RandomAccessFile write;
	private long start;
	private long end;
	
	public FileThreadCopy(long start,long end,RandomAccessFile read,RandomAccessFile write){
		this.start = start;
		this.end = end;
		this.read = read;
		this.write = write;
	}
	
	@Override
	public void run() {
		byte[] data = new byte[3];
		int len = 0;
		try {
			this.read.seek(this.start);
			this.write.seek(this.start);
			while((len=this.read.read(data))!=-1){
				this.start += len;
				if(this.start>end){
					this.write.write(data, 0, (int)(data.length-(start-end)));
					break;
				}else{
					this.write.write(data, 0, len);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			try {
				this.read.close();
				this.write.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
