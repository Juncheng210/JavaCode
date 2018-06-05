package client.model;

import client.common.*;
public class QqClientUser {

	public boolean checkUser(User u)
	{
		return new QqClientConServer().sendLoginInfoToServer(u);
	}
	
}
