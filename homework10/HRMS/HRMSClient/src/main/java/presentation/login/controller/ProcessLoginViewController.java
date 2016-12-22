package presentation.login.controller;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public class ProcessLoginViewController {
	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否及登陆客户种类
	 */
		public char login(String user_id,String password) {

		if(user_id.charAt(0)=='C')return 'c';
		else if(user_id.charAt(0)=='H')return 'h';
		else if(user_id.charAt(0)=='S')return 's';
		else return 'e';
	}

	/**
	 * 注册新用户
	 */
	public ResultMessage addclient(ClientVO vo) {
		return ResultMessage.SUCCESS;
	}
}
