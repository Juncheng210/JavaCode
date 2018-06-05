/**
 * 这是一个管理用户聊天界面的类
 */
package client.tools;

import java.util.*;
import client.view.*;
public class ManageQqChat {

	private static HashMap hm=new HashMap<String, QqChat>();
	
	//加入
	public static void addQqChat(String loginIdAnFriendId,QqChat qqChat)
	{
		hm.put(loginIdAnFriendId, qqChat);
	}
	//取出
	public static QqChat getQqChat(String loginIdAnFriendId )
	{
		return (QqChat)hm.get(loginIdAnFriendId);
	}
	
}
