package dataservice.hotelinfodataservice;

import java.rmi.RemoteException;
import java.util.List;

import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataService_Driver {
	public void drive(HotelinfoDataService hotelstaffDataService){
		try {
			hotelstaffDataService.init();
			hotelstaffDataService.delete(new RoominfoPO());

			//获得酒店信息
			HotelinfoPO Hpo=hotelstaffDataService.findhotelinfo("H0000000");
			if(Hpo!=null)System.out.println("获得酒店信息成功");

			//获得酒店房间信息列表
			List<RoominfoPO> roominfolist=hotelstaffDataService.getRoominfoList("H0000000");
			if(roominfolist.size()>0)System.out.println("获得酒店房间信息列表成功");

			hotelstaffDataService.updatehotelinfo(new HotelinfoPO());
			hotelstaffDataService.updateroominfo(new RoominfoPO());
			hotelstaffDataService.finish();
		} catch (RemoteException e) {
			e.printStackTrace();
		}

	}
}
