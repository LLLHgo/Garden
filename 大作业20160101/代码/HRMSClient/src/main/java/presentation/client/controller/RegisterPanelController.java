package presentation.client.controller;

import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogicservice.clientblservice.ClientBLService;
import vo.clientVO.ClientVO;
/**
 * 注册界面控制器
 * @author ClaraLee
 *
 */
public class RegisterPanelController {
	ClientBLService client=new ClientManage();
	public ClientVO getclient(String clientID){
		return client.getclient(clientID);
	}
	public boolean updateInfo(ClientVO vo){
	ResultMessage res=client.updateInfo(vo);
	if(res!=null)return true;
	else return false;
	}
}
