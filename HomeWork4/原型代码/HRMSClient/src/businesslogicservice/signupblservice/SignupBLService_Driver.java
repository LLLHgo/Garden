package businesslogicservice.signupblservice;

import vo.clientVO.ClientVO;

public class SignupBLService_Driver {
	public void driver(SignupBLService signupBLService){
		signupBLService.addclient(new ClientVO());
	}
}
