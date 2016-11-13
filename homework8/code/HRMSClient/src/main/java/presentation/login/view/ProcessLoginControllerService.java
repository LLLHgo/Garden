package presentation.login.view;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public interface ProcessLoginControllerService {
	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否
	 */
	public boolean login(String user_id,String password);
	/**
	 * 注册新用户
	 */
	public ResultMessage addclient(ClientVO vo);
}
