package businesslogicservice.loginblservice;

public class LoginBLService_Stub implements  LoginBLService{
	String userID;
	String password;
	public  LoginBLService_Stub	(String userID,String password){
		this.userID=userID;
		this.password=password;
	}
	/**
	 *验证用户登陆账号 
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否
	 */
		public boolean login(String user_id,String password) {
		if(user_id!=null)return true;
		else return false;
	}
}
