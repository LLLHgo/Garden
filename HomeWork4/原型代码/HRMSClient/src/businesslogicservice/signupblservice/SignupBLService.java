package businesslogicservice.signupblservice;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public interface SignupBLService {
	public ResultMessage addclient(ClientVO vo);
}
