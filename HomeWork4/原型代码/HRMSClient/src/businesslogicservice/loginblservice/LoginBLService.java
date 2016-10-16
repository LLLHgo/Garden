package businesslogicservice.loginblservice;

public interface LoginBLService {
	/**
	 *验证用户登陆账号 
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否
	 */
	public boolean login(String user_id,String password);
}
