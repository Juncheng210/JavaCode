package day0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

/**
 * 
 * @ClassName: TalkClinet
 * @Description: ����ͻ��ˣ�
 *
 */
public class TalkClinet {
	// ��ÿ���̨����
	private BufferedReader sysin = null;
	// socket
	private Socket s = null;
	private BufferedReader in = null;
	private PrintWriter out = null;
	// �߳�ֹͣflag
	private boolean flag = true;
	// ���ı�־
	private final static String single = "single";

	public static void main(String[] args) {
		// �����ͻ��ˣ�
		new TalkClinet().start();
	}

	/**
	 * 
	 * @Title: start
	 * @Description: ��Ҫ���ã��������ͺͽ�������
	 * @return:void
	 * @throws @author
	 *             peace w_peace@163.com
	 */
	public void start() {
		try {
			// ���ϵͳ���룺
			sysin = new BufferedReader(new InputStreamReader(System.in, "utf-8"));
			// �������֣�
			System.out.println("�������û�����");
			String name = sysin.readLine();
			// �����ͻ���socket
			s = new Socket("192.168.1.172", 8888);
			// ���socket���out
			out = new PrintWriter(s.getOutputStream(), true);
			out.println(name);
			// ���socket���� in
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			// ���������̣߳�ԭ���ȡϵͳ������������߳�
			new Thread(new ClinetThread()).start();
			// ������Ϣ��
			String str = null;
			while (flag && ((str = sysin.readLine()) != null)) {
				// �ж��Ƿ�Ϊ���ı�־��������ǵ��ģ���Ⱥ����Ϣ
				if (single.equalsIgnoreCase(str)) {
					System.out.println("���������˭�� ��");
					// ��ȡϵͳ���룺
					if (flag && ((str = sysin.readLine()) != null)) {
						// ���͵��ı�־
						out.println(single);
					}
				}
				// �����˷������ݣ�
				out.println(str);
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// �ر���Դ
			if (sysin != null) {
				try {
					sysin.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (s != null) {
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private class ClinetThread implements Runnable {
		/**
		 * 
		 * @Title: recive
		 * @Description: ������Ϣ������ϢΪdisconnectʱ�˳�����ȥ��Ҫ�ڰ���һ�λس�������ֹϵͳ���룻
		 * @return:void
		 */
		private void recive() {
			try {
				// ���շ������Ϣ
				String str = in.readLine();
				if (str != null) {
					// ����ǽ������죬���˳��߳�
					if ("disconnect".equals(str)) {
						stop();
						System.out.println("�س��˳�:");
					} else {
						// ������ʾ��Ϣ
						System.out.println(str);
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// �߳�ֹͣ����
		public void stop() {
			flag = false;
		}

		// �߳���Ҫ����
		@Override
		public void run() {
			while (flag) {
				// ������Ϣ��������
				recive();
			}
		}
	}
}