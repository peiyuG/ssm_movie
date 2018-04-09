package pojo.user;

public class User {

	private int UserID;
	private String user_name;
	private String user_password;
	private int user_status;
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int userID) {
		UserID = userID;
	}
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
	public int getStatus() {
		return user_status;
	}
	public void setStatus(int status) {
		this.user_status = status;
	}
	@Override
	public String toString() {
		return "User [UserID=" + UserID + ", user_name=" + user_name + ", user_password=" + user_password + ", status="
				+ user_status + "]";
	}
}
