package pojo.user;

/*
 * UserNameAndPwd类封装了登录注册时的字段：name和password
 */
public class UserNameAndPwd {

	private String user_name;
	private String user_password;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	@Override
	public String toString() {
		return "UserNameAndPwd [user_name=" + user_name + ", user_password=" + user_password + "]";
	}
}
