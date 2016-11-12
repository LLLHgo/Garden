package businesslogicservice.loginblservice;

import Enum.ResultMessage;
import vo.clientVO.ClientVO;

public class LoginBLService_Driver {
	public void driver(LoginBLService ls){
		boolean lbs=ls.login("000001", "000000");
		if(lbs)System.out.println("Login Fin~");
		
		ClientVO vo = new ClientVO();
		ResultMessage result = ls.addclient(vo);
		if(result==ResultMessage.SUCCESS)System.out.println("Signup Success");
	}

	
}
