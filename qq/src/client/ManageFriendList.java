package client;

import java.util.HashMap;
/**
 * 
 * @ClassName: ManageFriendList  
 * @Description: ������������б�
 * @author Administrator  
 * @date 2018��6��5��  
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
