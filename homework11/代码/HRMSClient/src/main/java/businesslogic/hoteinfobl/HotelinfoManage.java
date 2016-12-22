package businesslogic.hoteinfobl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelinfoblservice.HotelinfoAbstract;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.HotelinfoPO;
import po.RoominfoPO;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoManage extends HotelinfoAbstract{

	//桩测试
	HotelinfoDataService data = new HotelinfoDataService_Stub();
	HotelinfoPO po;
	HotelinfoVO vo;
	
	@Override
	public HotelinfoVO getBasicinfo(String hotelID) {
		try {
			po = data.findhotelinfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),po.getIntroduction(),
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID());
		return vo;
	}

	@Override
	public ArrayList<HotelinfoVO> getBasicinfoList(String area) {
		ArrayList<HotelinfoPO> listPO;
		ArrayList<HotelinfoVO> listVO = new ArrayList<HotelinfoVO>();
		try {
			listPO = data.findHotelinfoList(area);
			
			for(int i=0;i<listPO.size();i++){
				vo = PO2VO(listPO.get(i));
				if(vo == null){
					return null;
				}
				listVO.add(vo);
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		return listVO;
		
	}

	private HotelinfoVO PO2VO(HotelinfoPO po){
			HotelinfoVO vo = new HotelinfoVO(po.getName(),po.getAddress(),po.getArea(),
			po.getTel(),null,po.getStar(),po.getRemark(),po.getIntroduction(),
			po.getHotelID());
//			HotelinfoVO vo = new HotelinfoVO();
//			vo.setName(po.getName());
//			vo.setAddress(po.getAddress());
//			vo.setArea(po.getArea());
//			vo.setTel(po.getTel());
//			vo.setStar(po.getStar());
//			vo.setRemark(po.getRemark());
//			vo.setIntroduction(po.getIntroduction());
//			vo.setFacility(po.getFacility());
//			vo.setHotelID(po.getHotelID());
			return vo;
	}
	
	@Override
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		if(VO==null||VO.getAddress()==null||VO.getArea()==null||VO.getFacility()==null||
		VO.getHotelID()==null||VO.getIntroduction()==null||VO.getStar()==null||
		VO.getTel()==null||VO.getRemark()==null){
			return ResultMessage.VOIDINFO;
		}
		boolean result = false;
		try {
			result = data.updatehotelinfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result == true)
			return ResultMessage.SUCCESS;
		else return ResultMessage.FAIL;
			
	}
	
	@Override
	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		String hotelname = sitemanagerAddVO.getName();
		if(hotelname==null||hotelname.equals("")){
			return ResultMessage.VOIDINFO;
		}
		po = new HotelinfoPO();
		po.setName(hotelname);
		String hotelID = null;
		try {
			hotelID = data.addhotelinfofromsitemanager(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(hotelID.equals("R")){
			return ResultMessage.DUPLICATENAME;
		}
		HotelstaffBLService hotelstaff = new HotelstaffManage();
		hotelstaffVO.setHotelID(hotelID);
		//TODO 理论上没有同层调用了，怎么解决？
		ResultMessage result  = hotelstaff.saveSitemanagerUpdate(hotelstaffVO);
		return result;
	}

	@Override
	public String[] getArea() {
		BufferedReader br = null;
		String data = "";
		String[] areas = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resource/txt/Area.txt")));
			while((data = br.readLine())!=null)
			{
				areas = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return areas;
	}

	@Override
	public boolean addArea(String area) {
		if(area==null||area.equals("")){
			return false;
		}
		String[] areas = getArea();
		int flag = 0;
		for(int i=0;i<areas.length;i++){
			if(area.equals(areas[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		String data = "";
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resource/txt/Area.txt"),true));
			bw.write(","+area);	
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
	public List<AreaVO> getAreaHotels() {
		String[] areas = getArea();
		ArrayList<HotelinfoPO> hotelinfoPOList = new ArrayList<HotelinfoPO>();
		ArrayList<String> hotels;
		ArrayList<AreaVO> areaVOList= new ArrayList<AreaVO>();
		try {
			for(int i=0;i<areas.length;i++){
				hotelinfoPOList = data.findHotelinfoList(areas[i]);
				if(hotelinfoPOList!=null){
					hotels = new ArrayList<String>();
					for(int j=0;j<hotelinfoPOList.size();j++){
						hotels.add(hotelinfoPOList.get(j).getName());
					}
					if(!hotels.isEmpty()){
						AreaVO vo = new AreaVO(areas[i],hotels);
						areaVOList.add(vo);
					}
				}
			}				
			} catch (RemoteException e) {
				e.printStackTrace();
				return null;
		}
		return areaVOList;
	}

}
