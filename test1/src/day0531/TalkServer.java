package day0531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;


public class TalkServer {
    //���������̣߳�
    private Map<String, ServerThread> map = new HashMap<String, ServerThread>();

    public static void main(String[] args) {
        //����������
        new TalkServer().start();
    }
    /**
     * 
     * @Title: start 
     * @Description: Ϊÿһ���ͻ��˴���һ�������߳� 
     * @return:void 
     *   
     */
    public void start(){
        //������servesocket
        ServerSocket serverSocket=null;
        //������socket
        Socket socket=null;
        try {       
            //����������
            serverSocket=new ServerSocket(8888);
            //��ѭ�������ڽ��ո���Ŀͻ���
            while(true){
                //�����̴߳���
            socket=serverSocket.accept();
            //Ϊÿһ���ͻ��˽���һ�������̡߳�
            ServerThread st=new ServerThread(socket);
            new Thread(st).start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //�ͷ���Դ
            try {
                if(serverSocket!=null) {
                    serverSocket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 
     * @ClassName: ServerThread
     * @Description: �����߳�
     *
     */
    private class ServerThread implements Runnable{
        //��Ӧ��socket
        private Socket socket = null;
        private BufferedReader in = null;
        private PrintWriter out = null;
        //ÿ�����������
        private  String name = null;
        //����ͷ
        private String meshead = null;
        //ֹͣ�̱߳�־λ
        private boolean flag = true;
        //���ı�־λ��
        private boolean sin = false;
        /**
         * 
         * <p>Title:�̹߳����� </p>
         * <p>Description:���������̣߳��Լ���ʼ�����ͽ��̼߳���map </p>
         * @param socket
         * @throws IOException
         */
        public ServerThread(Socket socket) throws IOException {
            //���socket
            this.socket = socket;
            //������������
            out = new PrintWriter(socket.getOutputStream(),true);
            //����û�����
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            name = in.readLine();
            System.out.println(name+"������");
            //��������ͷ
            meshead = name+"["+socket.getInetAddress().getHostAddress()+":"+socket.getPort()+"]";
            //���̼߳���map��keyΪ���֣�valueΪ�߳�
            map.put(name, this);
            //���������û�
            send(meshead+"������");
        }
        /**
         * 
        * @Title: send 
        * @Description: ������Ϣ��Ⱥ����
        * @param msg 
        * @return:void   
        * @throws 
        * @author peace w_peace@163.com
         */
        public void send(String msg){
            //����Ⱥ��
            for(ServerThread thread:map.values()){
                thread.out.println(msg);
            }
        }
        /**
         * 
        * @Title: Receiver 
        * @Description: ������Ϣ����ת��
        * @throws IOException 
        * @return:void   
        * @author peace w_peace@163.com
         */
        public void Receiver() throws IOException{
            String str=null;
            ServerThread qq = null;
            //������Ϣ
            while((str=in.readLine())!=null){
                //�����ϢΪquit���˳�
                if("quit".equalsIgnoreCase(str)){
                    stop();
                    //���ͻ��˷��͹ر���������
                    out.println("disconnect");
                    break;
                }
                //�ж��Ƿ�Ϊ����
                if(sin==false) {
                	if(str.equals("single")){
                		//���Ϊ���ľͻ����Ҫ��˭��
                		if((str=in.readLine())!=null){
                			//�������һ���ͻ����߳�
                			qq=map.get(str);
                			if(qq!=null) {
                				sin=true;
                			}
                		}
                    } else {
                    	//ת����Ϣ  Ⱥ��
                        send(meshead+str);  
                    }
                } else {//����ǵ��ľ͸���Ӧ�Ŀͻ��˷�����Ϣ��
                    //���Ϊq���˳�����
                    if(str.equals("q")){
                        sin=false;
                        qq.out.println(name+"�Ի�����");
                    } else {//��������Ϣ
                       qq.out.println(name+"����˵��"+str);
                    }
                }
            }
        }
        /**
         * @Title: stop 
         * @Description: ֹͣ����
         * @return:void   
         */
        public void stop(){
            flag=false;
            //������ȥ��map;
            map.remove(name);
            send(meshead+"�Ѿ�������");
        }
        /**
         * run����
         */
        @Override
        public void run() {
            try {
                while(flag){
                    //��ͣ������Ϣ
                    Receiver();
                }
            } catch(SocketException e) {
                stop();//�ͻ���ֱ�ӹر������Ĵ���
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                //�ͷ���Դ
                try {
                    if(socket!=null) {
                        socket.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}