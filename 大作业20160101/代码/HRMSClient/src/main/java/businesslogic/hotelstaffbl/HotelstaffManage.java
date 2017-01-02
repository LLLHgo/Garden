package businesslogic.hotelstaffbl;

import java.rmi.RemoteException;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import dataservice.hotelstaffdataservice.HotelstaffDataService;
import po.HotelstaffPO;
import rmi.RemoteHelper;
import vo.hotelstaffVO.HotelstaffVO;

public class HotelstaffManage implements HotelstaffBLService{
	//桩测试
	//HotelstaffDataService data = new HotelstaffDataService_Stub();
	HotelstaffDataService data = RemoteHelper.getInstance().hotelstaffDataService();
	@Override
	public String getBasicinfo(String hotelID) {
		try {
			HotelstaffPO po = data.find(hotelID);
			if(po==null){
				return null;
			}
			return po.getPassword();
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}

	}

	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		try {
			HotelstaffPO po = data.find(hotelID);
			if(po==null){
				return ResultMessage.IDINVALID;
			}
			po.setPassword(password);
			boolean result = false;
			result = data.hotelstaffUpdate(po);
			if(result==true){
				return ResultMessage.SUCCESS;
			}else{
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.REMOTEEXCEPTION;
		}
	}

	@Override
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		HotelstaffPO po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.sitemanagerUpdate(po);
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

	public ResultMessage saveSitemanagerAdd(HotelstaffVO vo) {
		HotelstaffPO po = new HotelstaffPO(vo.getHotelID(),vo.getPassword(),vo.getTel());
		boolean result = false;
		try {
			result = data.insert(po);
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
		HotelstaffPO po;
		try {
			po = data.find(hotelID);
		} catch (RemoteException e) {
			e.printStackTrace();
			return null;
		}
		if(po == null){
			return null;
		}
		HotelstaffVO vo = new HotelstaffVO(po.getHotelID(),po.getPassword(),po.getTel());
		return vo;
	}

	@Override
	public boolean checkAccount(String hotelID, String password) {
		try {
			 HotelstaffPO po= data.find(hotelID);
			 if(po==null){
				 return false;
			 }
			 if(po.getPassword().equals(password)){
				 return true;
			 }
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getNewAddHotelID() {
		try {
			return data.gethotelID();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return null;
	}

}
