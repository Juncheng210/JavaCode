package client;

import java.util.HashMap;
/**
 * 
 * @ClassName: ManageChat  
 * @Description: ���������û��������
 * @author Administrator  
 * @date 2018��6��5��  
 *
 */
public class ManageChat {
	private static HashMap<String, Chat> hm = new HashMap<String, Chat>();

	// ����
	public static void addChat(String loginIaAnFriendId, Chat qqChat) {
		hm.put(loginIaAnFriendId, qqChat);
	}

	// ȡ��
	public static Chat getChat(String loginIaAnFriendId) {
		return (Chat) hm.get(loginIaAnFriendId);
	}
}
