package businesslogicservice.loginblservice;

public class LoginBLService_Driver {
	public void driver(LoginBLService ls){
		boolean lbs=ls.login("000001", "000000");
		if(lbs)System.out.println("Login Fin~");
	}

	
}
