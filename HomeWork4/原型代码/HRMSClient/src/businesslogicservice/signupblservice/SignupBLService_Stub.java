package businesslogicservice.signupblservice;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public class SignupBLService_Stub implements SignupBLService{

	@Override
	public ResultMessage addclient(ClientVO vo) {
		return ResultMessage.SUCCESS;
	}

}
