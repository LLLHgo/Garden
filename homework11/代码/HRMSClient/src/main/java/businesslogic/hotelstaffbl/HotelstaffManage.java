package businesslogic.hotelstaffbl;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Calendar;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import dataservice.hotelstaffdataservice.HotelstaffDataService_Stub;
import po.HotelstaffPO;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffManage implements HotelstaffBLService{
	//桩测试
	HotelstaffDataService data = new HotelstaffDataService_Stub();
	HotelstaffPO po;
	HotelstaffVO vo;
	
	@Override
	public String getBasicinfo(String hotelID) {
		try {
			if(data.findBasicInfo(hotelID)==null){
				return null;
			}
			return data.findBasicInfo(hotelID).getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
	
	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		if(password.equals("")){
			return ResultMessage.VOIDPASSWORD;
		}
		po = new HotelstaffPO();
		po.setHotelID(hotelID);
		po.setPassword(password);
		boolean result = false;
		try {
			result = data.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.update(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
		if(result==true){
			return ResultMessage.SUCCESS;
		}else{
			return ResultMessage.FAIL;
		}
	}

	@Override
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		try {
			po = data.findBasicInfo(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		vo = new HotelstaffVO(po.getHotelID(),po.getPassword(),po.getTel());
		return vo;
	}

	//TODO
	@Override
	public boolean checkAccount(String hotelID, String password) {
		po = new HotelstaffPO(hotelID,password);
		boolean result = false;
		try {
			result = data.checkAccount(po);
		} catch (RemoteException e) {
			e.printStackTrace();
			return false;
		}
		return result;
	}

}
