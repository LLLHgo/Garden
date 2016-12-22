package datatool;

import java.io.File;
import java.sql.Date;

import Enum.VIPType;
import vo.clientVO.ClientVO;

public class ClientDataTool {
	static Date day1=new Date(1996,2,29);
	static File file=new File("credit");
	static Date day3=new Date(1992,5,29);
public static ClientVO clientVO1=new ClientVO("C00000001","justfun","ErgouWang","13747474741",
				 VIPType.ORDINARYVIP,2,"1996-02-29","",file,100);
public static ClientVO clientVO2=new ClientVO("C00000002","actullyjustfun","sangouWang","13747474742",
		 VIPType.ENTERPRISEVIP,4,null,"Fake",file,120);
public static ClientVO clientVO3=new ClientVO("C00000003","definitelyjustfun","sigouWang","13747474743",
		 VIPType.ORDINARYVIP,1,"1992-05-29","",file,200);

}
