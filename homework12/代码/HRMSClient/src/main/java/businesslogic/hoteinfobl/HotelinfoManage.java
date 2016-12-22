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
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelinfodataservice.HotelinfoDataService;
import dataservice.hotelinfodataservice.HotelinfoDataService_Stub;
import po.HotelinfoPO;
import po.RoominfoPO;
import rmi.RemoteHelper;
import vo.areaVO.AreaVO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.hotelinfoVO.SitemanagerAddVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.orderVO.OrderVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class HotelinfoManage{

//	//桩测试
//	HotelinfoDataService data = new HotelinfoDataService_Stub();
	HotelinfoDataService data = RemoteHelper.getInstance().hotelinfoDataService();
	HotelinfoPO po;
	HotelinfoVO vo;

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
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID(),po.getCompanyList());
		return vo;
	}

	public ArrayList<HotelinfoVO> getBasicinfoList(String area) {
		ArrayList<HotelinfoPO> listPO;
		ArrayList<HotelinfoVO> listVO = new ArrayList<HotelinfoVO>();
		try {
			listPO = data.findHotelinfoList(area);
			System.out.println(listPO.get(0).getArea());
			if(listPO == null){
				return null;
			}
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


	public HotelinfoVO clientgetBasicinfo(String hotelID){
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
				po.getFacility(),po.getTel(),po.getStar(),po.getHotelID(),po.getCompanyList());
		ArrayList<String> remark = po.getRemark();
		if(remark!=null){
			vo.setRemark(remark);
		}
		ArrayList<RoominfoVO> roominfoList = new RoominfoManage().getRoominfoList(hotelID);
		if(roominfoList!=null){
			vo.setRoominfoList(roominfoList);
		}
		return vo;
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
//hotelstaff update hotelinfo
	public ResultMessage updateBassicinfo(HotelinfoVO VO) {
		if(VO==null||VO.getAddress()==null||VO.getArea()==null||VO.getFacility()==null||
		VO.getHotelID()==null||VO.getIntroduction()==null||VO.getStar()==null||
		VO.getTel()==null){
			System.out.println("null error");
			return ResultMessage.VOIDINFO;
		}

		boolean result = false;
		try {
			po = new HotelinfoPO();
			po.setHotelID(VO.getHotelID());
			po.setAddress(VO.getAddress());
			po.setArea(VO.getArea());
			po.setCompanyList(VO.getCompany());
			po.setFacility(VO.getFacility());
			po.setIntroduction(VO.getIntroduction());
			po.setName(VO.getName());
			po.setTel(VO.getTel());
			po.setStar(VO.getStar());
			result = data.hotelstaffUpdatehotelinfo(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result == true)
			return ResultMessage.SUCCESS;
		else return ResultMessage.FAIL;

	}

	public ResultMessage saveSitemanagerAdd(SitemanagerAddVO sitemanagerAddVO, HotelstaffVO hotelstaffVO) {
		String hotelname = sitemanagerAddVO.getName();
		if(hotelname==null||hotelname.equals("")){
			return ResultMessage.VOIDINFO;
		}
		String hotelID = null;
		try {
			hotelID = data.inserthotelinfo(hotelname);
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
		ResultMessage result  = hotelstaff.saveSitemanagerAdd(hotelstaffVO);
		return result;
	}

	public String[] getArea() {
		try {
			return data.getArea();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean addArea(String area) {
		try {
			return data.addArea(area);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
	}

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
