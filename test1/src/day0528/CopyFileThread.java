package day0528;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyFileThread implements Runnable{
	private int block;
    private int blockNum;
    private String startFileUrl;
    private String endFileUrl;
    
	public CopyFileThread(int block, int blockNum, String startFileUrl, String endFileUrl) {
		this.block = block;
		this.blockNum = blockNum;
		this.startFileUrl = startFileUrl;
		this.endFileUrl = endFileUrl;
	}

	@Override
	public void run() {
		try {
            RandomAccessFile raf =  new RandomAccessFile(startFileUrl,"r");
            RandomAccessFile raf2 =  new RandomAccessFile(endFileUrl,"rw");
            
            //Դ�ļ���С
            long size = raf.length();
            //ÿһ��Ĵ�С
            long blockSize = size / block;
            //���ʣ�ಿ��
            long odd = size % block;
            //��ʼ��λ��
            long startPos = blockNum * blockSize;
            
            int len = -1;
            long length = 0;
            
            //������
            byte[] buff = new byte[1024];
            //������Ҫ��ȡ��λ��  
            raf.seek(startPos);
            raf2.seek(startPos);
            
            while( (len = raf.read(buff)) != -1 && length<blockSize  ){
            	raf2.write(buff,0,len);
                length += len;
            }
            if(odd != 0) {
            	raf2.seek(raf2.length());
            	raf2.write(buff,0,(int)odd);
            }
            
            raf.close();
            raf2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
	}
}