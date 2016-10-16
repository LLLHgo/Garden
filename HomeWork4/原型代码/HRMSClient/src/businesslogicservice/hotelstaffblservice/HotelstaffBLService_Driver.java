package businesslogicservice.hotelstaffblservice;

import java.util.List;

import Enum.ResultMessage;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.HotelOrderVO;
import vo.strategyVO.HotelStrategyVO;

public class HotelstaffBLService_Driver {

	public void drive(HotelstaffBLService hotelstaffBLService){
		//登录时检测账号密码
		boolean checkAccountBool=hotelstaffBLService.checkAccount("H00000000", "000000");
		if(checkAccountBool)System.out.println("登录成功！");

		//获得酒店工作人员信息
		HotelstaffBasicinfoVO Hvo=hotelstaffBLService.getBasicinfo("H00000000");
		if(Hvo!=null)System.out.println("获得酒店工作人员信息成功！");

		//获得酒店基本信息
		HotelinfoVO HVO=hotelstaffBLService.gethotelinfoVO(new HotelinfoVO());
		if(HVO!=null)System.out.println("获得酒店基本信息成功！");

		//酒店订单列表
		List<HotelOrderVO> Hlist=hotelstaffBLService.gethotelOrderList("H00000000");
		if(Hlist.size()>0)System.out.println("获得酒店订单列表成功！");

		//获得酒店促销策略
		HotelStrategyVO HSvo=hotelstaffBLService.gethotelStrategy("H00000000");
		if(HSvo!=null)System.out.println("获得酒店促销策略成功！");

		//获得房间信息
		RoominfoVO Rvo=hotelstaffBLService.getroominfo("413-2");
		if(Rvo!=null)System.out.println("获得房间信息成功！");

		//返回酒店工作人员信息
		HotelstaffVO HSTvo=hotelstaffBLService.returnSitemanagerAccount("H00000000");
		if(HSTvo!=null)System.out.println("获得酒店工作人员信息成功！");

	    //保存酒店工作人员信息更改
		boolean hsbls=hotelstaffBLService.saveSitemanagerUpdate(new HotelstaffVO());
		if(hsbls)System.out.println("保存酒店工作人员信息更改成功！");

		//设置密码
		ResultMessage setPasswordResult=hotelstaffBLService.setPassword("000000");
		if(setPasswordResult==ResultMessage.SUCCESS)System.out.println("修改密码成功");

		//将酒店促销策略持久化保存
		ResultMessage updatehotelStrategyResult=hotelstaffBLService.updatehotelStrategy(new HotelStrategyVO());
		if(updatehotelStrategyResult==ResultMessage.SUCCESS)System.out.println("酒店促销策略持久化保存成功");


		//设置OrderState
		ResultMessage updateOrderState=hotelstaffBLService.updateOrderState("H00000000", 0);
		if(updateOrderState==ResultMessage.SUCCESS)System.out.println("设置OrderState");

		//更新房间信息
		ResultMessage updateroominfoResult=hotelstaffBLService.updateroominfo(new HotelinfoVO());
		if(updateroominfoResult==ResultMessage.SUCCESS)System.out.println("更新房间信息成功");
	}
}
