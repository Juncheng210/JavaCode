/**
 * ������ѡ�������..������
 */
package client.tools;

import java.util.*;
import java.io.*;
import client.view.*;
public class ManageQqFriendList {

	private static HashMap hm=new HashMap<String, QqFriendList>();
	
	public static void addQqFriendList(String qqid,QqFriendList qqFriendList){
		
		hm.put(qqid, qqFriendList);
	}
	
	public static QqFriendList getQqFriendList(String qqId)
	{
		return (QqFriendList)hm.get(qqId);
	}
}
