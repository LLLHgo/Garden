package presentation.hotelstaff.controller;

import Enum.ResultMessage;
import businesslogic.hotelstaffbl.HotelstaffManage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import presentation.hotelstaff.view.HotelstaffViewControllerService;
import vo.hotelstaffVO.HotelstaffBasicinfoVO;
import vo.hotelstaffVO.HotelstaffVO;

public  class HotelstaffViewController implements HotelstaffViewControllerService{

	HotelstaffBLService hotelstaff;
	
	public HotelstaffViewController(){
		hotelstaff = new HotelstaffManage();
	}
	
	@Override
	public HotelstaffBasicinfoVO getBasicinfo(String hotelID) {
		return hotelstaff.getBasicinfo(hotelID);
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return hotelstaff.setPassword(hotelID, password);
	}

	@Override
	public boolean saveSitemanagerUpdate(HotelstaffVO vo) {
		return hotelstaff.saveSitemanagerUpdate(vo);
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		return hotelstaff.returnSitemanagerAccount(hotelID);
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		return hotelstaff.checkAccount(hotelID, password);
	}

}
