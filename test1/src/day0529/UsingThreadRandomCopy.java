package day0529;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * ���̸߳����ļ�
 */
public class UsingThreadRandomCopy {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.mp4");
        startThread(30, file.length(), "C:\\Users\\Administrator\\Desktop\\1.mp4",
                "C:\\Users\\Administrator\\Desktop\\14.mp4");
    }

    /**
     * �������̸߳���
     * 
     * @param threadnum
     *            �߳���
     * @param fileLength
     *            �ļ���С������ȷ��ÿ���߳����ض��ٶ�����
     * @param sourseFilePath
     *            Դ�ļ�Ŀ¼
     * @param targerFilePath
     *            Ŀ���ļ�Ŀ¼
     */
    public static void startThread(int threadnum, long fileLength, String sourseFilePath, String targerFilePath) {
        System.out.println("================");
        System.out.println(fileLength);
        long modLength = fileLength % threadnum;
        System.out.println("modLength:" + modLength);
        long targetLength = fileLength / threadnum;
        System.out.println("targetLength:" + targetLength);
        for (int i = 0; i < threadnum; i++) {
            System.out.println((targetLength * i) + "-----" + (targetLength * (i + 1)));
            new FileWriteThread((targetLength * i), (targetLength * (i + 1)), sourseFilePath, targerFilePath).start();
        }
        if (modLength != 0) {
            System.out.println("�����ļ�д��");
            System.out.println((targetLength * threadnum) + "-----" + (targetLength * threadnum + modLength));
            new FileWriteThread((targetLength * threadnum), targetLength * threadnum + modLength + 1, sourseFilePath,
                    targerFilePath).start();
        }
    }

    /**
     * д�̣߳�ָ���ļ���ʼλ�á�Ŀ��λ�á�Դ�ļ���Ŀ���ļ���
     */
    static class FileWriteThread extends Thread {
        private long begin;
        private long end;
        private RandomAccessFile soursefile;
        private RandomAccessFile targerFile;

        public FileWriteThread(long begin, long end, String sourseFilePath, String targerFilePath) {
            this.begin = begin;
            this.end = end;
            try {
                this.soursefile = new RandomAccessFile(sourseFilePath, "rw");
                this.targerFile = new RandomAccessFile(targerFilePath, "rw");
            } catch (FileNotFoundException e) {
            }
        }

        public void run() {
            try {
                soursefile.seek(begin);
                targerFile.seek(begin);
                int hasRead = 0;
                byte[] buffer = new byte[1];
                while (begin < end && -1 != (hasRead = soursefile.read(buffer))) {
                    // System.out.println("hasRead:"+hasRead);
                    begin += hasRead;
                    targerFile.write(buffer, 0, hasRead);
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    soursefile.close();
                    targerFile.close();
                } catch (Exception e) {
                }
            }
        }
    }
}