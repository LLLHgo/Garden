package businesslogic.hoteinfobl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import Enum.HotelStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import businesslogicservice.hotelinfoblservice.HotelinfoAbstract;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.RoominfoPO;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class RoominfoManage extends HotelinfoAbstract{
	
	HotelinfoDataService data;
	
	public RoominfoManage(){
		data = new HotelinfoDataService_Stub();
	}
	
	@Override
	public RoominfoVO getroominfo(String hotelID, String roomID) {
		RoominfoPO po = null;
		try {
			po = data.getRoominfo(hotelID, roomID);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		if(po==null){
			return null;
		}
		return po2vo(po);
	}

	@Override
	public boolean updateroominfo(RoominfoVO vo,String hotelID) {
		RoominfoPO po = new RoominfoPO(
				vo.getType(),vo.getRoomNum(),vo.getPrice(),vo.getRoomState());
		boolean result = false;
		try {
			result = data.updateroominfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		
		return result;
	}
	
	@Override
	public double calculatePrice(ArrayList<HotelStrategyVO> hotelStrategyList,
			ArrayList<MarketingStrategyVO> marketingStrategyList, ClientVO vo,String hotelID,RoominfoVO roomVO,int num) {
		//获得当前时间
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int hour = cal.get(Calendar.HOUR_OF_DAY);
		int minute = cal.get(Calendar.MINUTE);
		int second = cal.get(Calendar.SECOND);
		//String time = year+month+day+hour+minute+second+"";
		cal.set(year, month, day, hour, minute, second);
		
		double originalPrice = roomVO.getPrice()*num;
		double discount = 1;
		ArrayList<String> strategyName = new ArrayList<String>();
	
		for(HotelStrategyVO hotelStrategy:hotelStrategyList){
			//生日特惠折扣
			if(hotelStrategy.getType()==HotelStrategy.BIRTHDAY){
				//客户是否是普通会员
				if(vo.getType()==VIPType.ORDINARYVIP){
					String birthday = vo.getBirth();
					String[] arraybirthday = birthday.split("-");
					if(cal.compareTo(hotelStrategy.getEndTime())<0&&
							cal.compareTo(hotelStrategy.getStartTime())>0&&
							month == Integer.parseInt(arraybirthday[1])&&
							day == Integer.parseInt(arraybirthday[2])){
						discount = discount*hotelStrategy.getDiscount();
						strategyName.add(hotelStrategy.getName());
					}
				}
				
			}
			
			//合作企业优惠折扣
			if(hotelStrategy.getType()==HotelStrategy.COMPANY){
				//客户是否是合作企业
				if(cal.compareTo(hotelStrategy.getEndTime())<0&&
						cal.compareTo(hotelStrategy.getStartTime())>0&&
						vo.getType()==VIPType.ENTERPRISEVIP){
					discount = discount*hotelStrategy.getDiscount();
					strategyName.add(hotelStrategy.getName());
				}
			}
			
			
			//特定期间优惠折扣
			if(hotelStrategy.getType()==HotelStrategy.SPECIALDAY){
				if(cal.compareTo(hotelStrategy.getEndTime())<0&&
						cal.compareTo(hotelStrategy.getStartTime())>0){
					discount = discount*hotelStrategy.getDiscount();
					strategyName.add(hotelStrategy.getName());
				}
			}
			
			//三间及以上房间优惠
			if(hotelStrategy.getType()==HotelStrategy.OVERTHREEROOMS){
				if(cal.compareTo(hotelStrategy.getEndTime())<0&&
						cal.compareTo(hotelStrategy.getStartTime())>0&&
						num>=3){
					discount = discount*hotelStrategy.getDiscount();
					strategyName.add(hotelStrategy.getName());
				}
			}
			
			//新策略
			if(hotelStrategy.getType()==HotelStrategy.CREATED){
				if(hotelStrategy.getVipKinds().contains(vo.getType())&&
					cal.compareTo(hotelStrategy.getEndTime())<0&&
					cal.compareTo(hotelStrategy.getStartTime())>0&&
					(vo.getLevel()>hotelStrategy.getLevel()||vo.getLevel()==hotelStrategy.getLevel()&&
					num>=hotelStrategy.getMinRooms()&&
					originalPrice>=hotelStrategy.getMinSum())
				){
					discount = discount*hotelStrategy.getDiscount();
					strategyName.add(hotelStrategy.getName());
				}
			}
		}
		
		
//		for(MarketingStrategyVO marketingStrategy:marketingStrategyList){
//			marketingStrategy.getType()
//		}
		return 0;
	}
	
	@Override
	public String[] getRoomType() {
		BufferedReader br = null;
		String data = "";
		String[] roomtypes = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resource/txt/RoomType.txt")));
			while((data = br.readLine())!=null)
			{
				roomtypes = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return roomtypes;
	}

	@Override
	public boolean addRoomType(String type) {
		if(type==null||type.equals("")){
			return false;
		}
		String[] roomtypes = getRoomType();
		int flag = 0;
		for(int i=0;i<roomtypes.length;i++){
			if(type.equals(roomtypes[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resource/txt/RoomType.txt"),true));
			bw.write(","+type);	
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	

	@Override
	public ArrayList<RoominfoVO> getRoominfoList(String hotelID) {
		ArrayList<RoominfoPO> listPO;
		ArrayList<RoominfoVO> listVO = new ArrayList<RoominfoVO>();
		try {
			listPO = data.getRoominfoList(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		for(int i=0;i<listPO.size();i++){
			listVO.add(po2vo(listPO.get(i)));
		}
		return listVO;
	}


	private RoominfoVO po2vo(RoominfoPO po){
		RoominfoVO vo;
		try{
			vo = new RoominfoVO(po.getType(),po.getRoomNum(),
					po.getPrice(),po.getRoomState());
		}catch(NullPointerException e){
			e.printStackTrace();
			return null;
		}
		return vo;
	}
}
