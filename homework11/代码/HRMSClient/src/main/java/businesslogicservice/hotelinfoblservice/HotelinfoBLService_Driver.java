package businesslogicservice.hotelinfoblservice;

import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import Enum.Star;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoBLService_Driver{

	public void drive(HotelinfoBLService hotelinfoBLService){
		//酒店名称
		String name;
		//酒店地址
		String address;
		//酒店所在商圈
		String area;
		//酒店电话
		String tel;
		//酒店所包含的房间
		ArrayList<RoominfoVO> roominfoList;
		//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
		Star star;
		//酒店评价
		ArrayList<String> remark;
		//酒店简介
		String introduction;
		//酒店ＩＤ
		String hotelID;

		//查找酒店基本信息
		System.out.println("查找ID为H00000000的酒店信息...");
		HotelinfoVO hotelinfoVO = hotelinfoBLService.getBasicinfo("H00000000");
		name = hotelinfoVO.getName();
		address = hotelinfoVO.getAddress();
		area = hotelinfoVO.getArea();
		tel = hotelinfoVO.getTel();
		roominfoList = hotelinfoVO.getRoominfoList();
		star = hotelinfoVO.getStar();
		remark = hotelinfoVO.getRemark();
		introduction = hotelinfoVO.getIntroduction();
		hotelID = hotelinfoVO.getHotelID();
		System.out.println("查找成功");
		//System.out.println("名称： "+name);

		//查找酒店信息列表
		System.out.println("查找客户需要的酒店信息列表...");
		List<HotelinfoVO> hotellist = hotelinfoBLService.getBasicinfoList("栖霞区商圈");
		if(hotellist.size()>0)System.out.println("查找成功");

		//查找某酒店某类型的房间信息
		System.out.println("查找ID为H00000000的酒店，类型为四人间的酒店房间信息...");
		RoominfoVO roominfoVO  = hotelinfoBLService.getroominfo("H00000000", "四人间");
		if(roominfoVO!=null)System.out.println("查找成功");

		//查找某酒店的所有房间信息
		System.out.println("查找ID为H00000000的酒店的所有房间信息...");
		List<RoominfoVO> roominfolist = hotelinfoBLService.getRoominfoList("H00000000");
		if(roominfolist.size()>0)System.out.println("查找成功");

		//更新酒店基本信息
		System.out.println("更新酒店基本信息...");
		ResultMessage resultMessage = hotelinfoBLService.updateBassicinfo(new HotelinfoVO());
		if(resultMessage==ResultMessage.SUCCESS)System.out.println("更新成功");

		//保存网站工作人员对酒店信息的修改
		System.out.println("更新酒店工作人员的修改...");
		ResultMessage result = hotelinfoBLService.saveSitemanagerAdd(new SitemanagerAddVO("h00000001"),new HotelstaffVO());
		if(result == ResultMessage.SUCCESS)
			System.out.println("更新成功！");
		else
			System.out.println("更新失败==");
//		//计算房间价格
//		System.out.println("计算使用促销策略后的房间价格价格...");
//		double price = hotelinfoBLService.calculatePrice(new ArrayList<HotelStrategyVO>(), new ArrayList<MarketingStrategyVO>(),
//				new ClientVO(), 666.6);
//		System.out.println("使用策略后的价格为： "+price);
		
		//获得酒店基本信息
		HotelinfoVO HVO=hotelinfoBLService.getBasicinfo("H00000000");
		if(HVO!=null)System.out.println("获得酒店基本信息成功！");

		//获得房间信息
		RoominfoVO Rvo=hotelinfoBLService.getroominfo("H00000000","413-2");
		if(Rvo!=null)System.out.println("获得房间信息成功！");
	}

}
