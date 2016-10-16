package dataservice.hotelstaffdataservice;

import java.rmi.RemoteException;

import po.HotelstaffPO;

public class HotelstaffDataService_Driver {
	public void drive(HotelstaffDataService hotelstaffDataService) throws RemoteException{
		hotelstaffDataService.init();
		//检查酒店工作人员账户密码
		boolean checkbool=hotelstaffDataService.checkAccount(new HotelstaffPO());
		if(checkbool)System.out.println("酒店工作人员账户密码匹配");

		//返回酒店工作人员信息
		HotelstaffPO Hpo=hotelstaffDataService.findBasicInfo("H00000000");
	    if(Hpo!=null)System.out.println("返回酒店工作人员信息成功");
		hotelstaffDataService.updatePassword(new HotelstaffPO());
		hotelstaffDataService.finish();
	}
}
