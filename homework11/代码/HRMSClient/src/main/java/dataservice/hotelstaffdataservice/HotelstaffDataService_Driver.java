package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Driver {
	boolean result;
	HotelstaffPO hotelstaffPO;
	
	public void drive(HotelstaffDataService hotelstaffDataService) throws RemoteException{
		//初始化数据库
		System.out.println("初始化数据库...");
		hotelstaffDataService.init();

		//检查账号密码
		System.out.println("登录账号密码检查");
		result = hotelstaffDataService.checkAccount(new HotelstaffPO());
		if(result == true){
			System.out.println("登录成功");
		}else
			System.out.println("登录失败");
		
		//查找H00000000酒店工作人员的基本信息
		System.out.println("查找H00000000酒店工作人员的基本信息");
		hotelstaffPO = hotelstaffDataService.findBasicInfo("H00000000");
		System.out.println("酒店账号： "+hotelstaffPO.getHotelID()+
				"密码："+hotelstaffPO.getPassword());
		
		//更新密码
		System.out.println("更新密码...");
		result = hotelstaffDataService.update(new HotelstaffPO());
		if(result == true){
			System.out.println("登录成功");
		}else
			System.out.println("登录失败");
		
		//检查酒店工作人员账户密码
		boolean checkbool=hotelstaffDataService.checkAccount(new HotelstaffPO());
		if(checkbool)System.out.println("酒店工作人员账户密码匹配");

		//返回酒店工作人员信息
		HotelstaffPO Hpo=hotelstaffDataService.findBasicInfo("H00000000");
	    if(Hpo!=null)System.out.println("返回酒店工作人员信息成功");
		hotelstaffDataService.update(new HotelstaffPO());
		
		//结束数据库使用
		System.out.println("结束使用数据库");
		hotelstaffDataService.finish();
	}
}
