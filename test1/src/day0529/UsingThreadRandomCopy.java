package day0529;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * 多线程复制文件
 */
public class UsingThreadRandomCopy {
    public static void main(String[] args) throws Exception {
        File file = new File("C:\\Users\\Administrator\\Desktop\\1.mp4");
        startThread(30, file.length(), "C:\\Users\\Administrator\\Desktop\\1.mp4",
                "C:\\Users\\Administrator\\Desktop\\14.mp4");
    }

    /**
     * 开启多线程复制
     * 
     * @param threadnum
     *            线程数
     * @param fileLength
     *            文件大小（用于确认每个线程下载多少东西）
     * @param sourseFilePath
     *            源文件目录
     * @param targerFilePath
     *            目标文件目录
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
            System.out.println("最后的文件写入");
            System.out.println((targetLength * threadnum) + "-----" + (targetLength * threadnum + modLength));
            new FileWriteThread((targetLength * threadnum), targetLength * threadnum + modLength + 1, sourseFilePath,
                    targerFilePath).start();
        }
    }

    /**
     * 写线程：指定文件开始位置、目标位置、源文件、目标文件，
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