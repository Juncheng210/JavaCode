
package server;
import java.util.HashMap;
import java.util.Iterator;
public class ManagerClientThread  {

	public static HashMap hm=new HashMap<String, SerConClientThread>();
	
	public static void addClientThread(String uid, SerConClientThread ct)
	//��hm�����һ���ͻ���ͨѶ�߳�
	{
		hm.put(uid, ct);
	}
	public static SerConClientThread getClientThread(String uid)
	{
		return (SerConClientThread)hm.get(uid);
	}
	
	//���ص�ǰ�����˵����
	public static String getAllOnLineUserid()
	{
		//ʹ�õ��������
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext())
		{
			res+=it.next().toString()+" ";
		}
		return res;
	}
}
