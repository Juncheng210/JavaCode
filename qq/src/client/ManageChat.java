package client;

import java.util.HashMap;
/**
 * 
 * @ClassName: ManageChat  
 * @Description: 用来管理用户聊天界面
 * @author Administrator  
 * @date 2018年6月5日  
 *
 */
public class ManageChat {
	private static HashMap<String, Chat> hm = new HashMap<String, Chat>();

	// 加入
	public static void addChat(String loginIaAnFriendId, Chat qqChat) {
		hm.put(loginIaAnFriendId, qqChat);
	}

	// 取出
	public static Chat getChat(String loginIaAnFriendId) {
		return (Chat) hm.get(loginIaAnFriendId);
	}
}
