package presentation.login.controller;

import Enum.ResultMessage;
import businesslogic.clientbl.ClientManage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogic.marketingbl.MarketingManage;
import businesslogic.sitemanagerbl.SitemanagerManage;
import businesslogicservice.clientblservice.ClientBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService_Stub;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import presentation.login.view.ProcessLoginControllerService;
import vo.clientVO.ClientVO;
import vo.sitemanagerVO.SitemanagerVO;

public class ProcessLoginViewController implements ProcessLoginControllerService{
	/**
	 *验证用户登陆账号
	 * @param user_id
	 * @param password
	 * @return 登陆成功与否及登陆客户种类
	 */
	ClientBLService client=new ClientManage();
	SitemanagerBLService sitemanager=new SitemanagerManage();
	HotelstaffBLService hotelstaff=new HotelstaffManage();
	MarketingBLService marketing=new MarketingManage();
		public char login(String user_id,String password) {

		if(user_id.charAt(0)=='C'){
			boolean k=client.checkAccount(user_id,password);
			if(k)return 'c';
			else return 'e';
			}
		else if(user_id.charAt(0)=='H'){
			boolean k=hotelstaff.checkAccount(user_id,password);
			if(k)return 'h';
			else return 'e';
		}
		else if(user_id.charAt(0)=='S'){
			ResultMessage res=sitemanager.checkAccount(new SitemanagerVO(user_id,"",password));
			if(res==ResultMessage.SUCCESS)return 's';
			else return 'e';
		}

		else if(user_id.charAt(0)=='M'){
			boolean k=marketing.checkAccount(user_id,password);
			if(k)return 'm';
			else return 'e';
		}
		else return 'e';
	}

	/**
	 * 注册新用户
	 */
	public String addclient(ClientVO vo) {
		return client.createClient(vo);
	}
}
