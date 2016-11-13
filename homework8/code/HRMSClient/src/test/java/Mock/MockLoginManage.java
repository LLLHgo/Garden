package Mock;



import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public class MockLoginManage {
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

	/**
	 * 注册新用户
	 */
	public ResultMessage addclient(ClientVO vo) {
		if(vo!=null)
		return ResultMessage.SUCCESS;
		else
		return ResultMessage.FAIL;
	}
}
