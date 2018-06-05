/**
 * 定义包的总类
 */
package client;

public interface MessageQqType {
	String MESSAGE_SUCCEED = "1";  //表明登录成功
	String MESSAGE_LOGIN_FAIL = "2"; //表明登录失败
	String MESSAGE_COMM_MES = "3"; //普通包信息
	String MESSAGE_GET_ONLINE_FRIEND = "4";//表示在线好友
	String MESSAGE_RET_ONLINE_FRIEND = "5";//返回在先好友
}
