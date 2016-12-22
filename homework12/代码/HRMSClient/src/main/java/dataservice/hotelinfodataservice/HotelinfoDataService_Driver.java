package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataService_Driver {
	public void drive(HotelinfoDataService hotelinfoDataService)throws Exception{
		boolean result;
		HotelinfoPO hotelinfoPO;
		RoominfoPO roominfoPO;
		//初始化数据库
		System.out.println("初始化数据库...");
		hotelinfoDataService.init();
		
//		//删除房间信息
//		System.out.println("删除房间信息...");
//		result = hotelinfoDataService.delete(new RoominfoPO());
//		if(result == true){
//			System.out.println("成功");
//		}else
//			System.out.println("失败");
		
		//查找酒店信息
		System.out.println("查询H00000000酒店基本信息");
		hotelinfoPO = hotelinfoDataService.findhotelinfo("H0000000");
		System.out.println("酒店账号： "+hotelinfoPO.getHotelID()+
				"酒店地址： "+hotelinfoPO.getAddress()+"酒店商圈： "+hotelinfoPO.getArea()
				+"酒店简介： "+hotelinfoPO.getIntroduction()+"...");
		
		//获得H00000000酒店信息列表
		System.out.println("获得H00000000酒店信息列表");
		List<RoominfoPO> list = hotelinfoDataService.findRoominfoList("H0000000");
		for(int i=0;i<list.size();i++){
			System.out.println("房间类型： "+list.get(i).getType()+
					" 房间价格："+list.get(i).getPrice());
		}
		
		//更新酒店信息
		System.out.println("更新酒店信息");
		result = hotelinfoDataService.hotelstaffUpdatehotelinfo(new HotelinfoPO());
		if(result == true){
			System.out.println("成功");
		}else
			System.out.println("失败");
		
		//更新房间信息
		System.out.println("更新房间信息");
		result = hotelinfoDataService.updateroominfo(new RoominfoPO());
		if(result == true){
			System.out.println("成功");
		}else
			System.out.println("失败");
		
//		//结束数据库使用
//		System.out.println("结束数据库使用");
//		hotelinfoDataService.delete(new RoominfoPO());

		//获得酒店信息
		System.out.println("获得H00000000酒店信息");
		HotelinfoPO Hpo=hotelinfoDataService.findhotelinfo("H0000000");
		if(Hpo!=null)
			System.out.println("获得酒店信息成功");

		//获得酒店房间信息列表
		List<RoominfoPO> roominfolist=hotelinfoDataService.findRoominfoList("H0000000");
		if(roominfolist.size()>0)System.out.println("获得酒店房间信息列表成功");
		
		//更新酒店信息
		System.out.println("更新酒店信息");
		result = hotelinfoDataService.hotelstaffUpdatehotelinfo(new HotelinfoPO());
		if(result == true){
			System.out.println("成功");
		}else
			System.out.println("失败");
		
		//更新房间信息
		System.out.println("更新房间信息");
		result=hotelinfoDataService.updateroominfo(new RoominfoPO());
		if(result == true){
			System.out.println("成功");
		}else
			System.out.println("失败");
		
		//结束数据库使用
		System.out.println("结束数据库使用");
		hotelinfoDataService.finish();
	}
}
