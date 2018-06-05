package client;

import java.util.HashMap;
/**
 * 
 * @ClassName: ManageFriendList  
 * @Description: 用来管理好友列表
 * @author Administrator  
 * @date 2018年6月5日  
 *
 */
public class ManageFriendList {
	
	private static HashMap<String, FriendList> hm = new HashMap<String, FriendList>();
	public static void addFriendList(String qqid, FriendList FriendList)
	{
		hm.put(qqid, FriendList);
	}
	public static FriendList getQqFriend(String qqId)
	{
		return (FriendList)hm.get(qqId);
	}
}
