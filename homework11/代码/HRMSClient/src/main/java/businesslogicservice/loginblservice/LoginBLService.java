package businesslogicservice.loginblservice;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public interface LoginBLService {
	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否及登陆客户种类
	 */
	public char login(String user_id,String password);

	/**
	 * 客户注册
	 * @param vo
	 * @return 注册成功与否
	 */
	public ResultMessage addclient(ClientVO vo);
}
