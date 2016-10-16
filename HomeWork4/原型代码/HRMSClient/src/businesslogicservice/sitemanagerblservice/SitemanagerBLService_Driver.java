package businesslogicservice.sitemanagerblservice;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;

import Enum.ResultMessage;
import Enum.Star;
import Enum.VIPType;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class SitemanagerBLService_Driver {
	public void drive(SitemanagerBLService sitemanagerBLService){
		ResultMessage result;
		//Date date;
		ClientVO clientAccountVO = null;
		MarketingVO marketingAccountVO=null;
		HotelinfoVO hotelInfoVO=null;
		HotelstaffVO hotelstaffVO=null;
		SitemanagerVO sitemanagerVO=null;
		
		// 修改客户账户
		System.out.println("修改客户账户:");
		result=sitemanagerBLService.clientAccountUpdate(new ClientVO("C00000009","000","Kerry","17999982876",VIPType.ENTERPRISEVIP,2,null,"SAP",new File("C00000009")));
		if(result==ResultMessage.SUCCESS){
			System.out.println("修改成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("修改失败");
		}
		//System.out.println(clientAccountVO.getClient_name()+" "+clientAccountVO.getClient_tel()+clientAccountVO.getClient_birth());
		
		// 删除账户
		System.out.println("删除客户账户:");
		result=sitemanagerBLService.accountDelete("H00000090");
		if(result==ResultMessage.SUCCESS){
			System.out.println("删除成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("删除失败");
		}
	
		// 管理界面得到客户账户信息
		System.out.println("得到客户账户信息:");
		clientAccountVO=sitemanagerBLService.clientAccountFind("C00000009");
		System.out.print("显示客户账户信息:");
		//System.out.println(clientAccountVO.getClient_name()+clientAccountVO.getVip_type());
		System.out.println("这里是账户的详细信息");
		
		// 修改网站营销人员账户
		System.out.println("修改网站营销人员账户:");
		result=sitemanagerBLService.MarketingAccountUpdate(new MarketingVO("Liu","liu123","M00000008","13777879889"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("修改成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("修改失败");
		}
		//System.out.println(marketingAccountVO.getName()+" "+marketingAccountVO.getTelephone());
		
		// 添加网站营销人员
		System.out.println("添加网站营销人员:");
		result=sitemanagerBLService.MarketingAccountUpdate(new MarketingVO("Tony","tony1234","M00000009","17889987656"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("添加成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("添加失败");
		}
		
		// 管理界面得到网站营销人员账户信息
		System.out.println("得到网站营销人员账户信息:");
		marketingAccountVO=sitemanagerBLService.MarketingAccountFind("M00000008");
		System.out.print("显示网站营销人员账户信息:");
		//System.out.println(marketingAccountVO.getMarketingID()+marketingAccountVO.getName());
		System.out.println("这里是账户的详细信息");
		
		// 添加酒店
		System.out.println("添加酒店:");
		result=sitemanagerBLService.MarketingAccountAdd(new HotelinfoVO("caesar","Charls road No.1","LVegas","010-00233",
				new ArrayList<RoominfoVO>(),Star.FIVE,new ArrayList<String>(),"Best in LV","H00000105" ));
		if(result==ResultMessage.SUCCESS){
			System.out.println("添加酒店成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("添加酒店失败");
		}
		
		// 管理界面得到酒店工作人员账户信息
		System.out.println("得到酒店工作人员账户信息:");
		hotelstaffVO=sitemanagerBLService.HotelStaffAccountFind("H00000008");
		System.out.print("显示酒店工作人员账户信息:");
		System.out.println(hotelstaffVO.getClass()+hotelstaffVO.getTel());
		System.out.println("这里是账户的详细信息");
		
		// 修改酒店工作人员账户
		System.out.println("修改酒店工作人员账户:");
		result=sitemanagerBLService.HotelStaffAccountUpdate(new HotelstaffVO("H00000006","h123","17889967883"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("修改成功");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("修改失败");
		}
		System.out.println(hotelstaffVO.getHotelID()+" "+hotelstaffVO.getTel());
		
		// 检查登录的网站管理人员账户密码是否正确
		System.out.println("检查登录的网站管理人员账户密码是否正确:");
		result=sitemanagerBLService.checkAccount(new SitemanagerVO("S00000001","010-08923","IAMSITEMANAGER"));
		if(result==ResultMessage.SUCCESS){
			System.out.println("登录帐号密码正确");
		}
		else if(result==ResultMessage.FAIL){
			System.out.println("登录帐号密码错误");
		}
		
	}
}
