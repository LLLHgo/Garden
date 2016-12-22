package Mock;

import Enum.ResultMessage;
import businesslogicservice.hotelstaffblservice.HotelstaffBLService;
import vo.hotelstaffVO.HotelstaffVO;

public class MockHotelstaffManage implements HotelstaffBLService{
	
	
	
	public ResultMessage saveSitemanagerUpdate(HotelstaffVO vo) {
		if(vo.getHotelID().equals("H00000001")){
			return ResultMessage.SUCCESS;
		}
		else if(vo.getHotelID().equals("H00000002")){
			return ResultMessage.SUCCESS;
		}
		else if(vo.getHotelID().equals("H00000003")){
			return ResultMessage.SUCCESS;
		}
		return ResultMessage.FAIL;
	}

	
	public HotelstaffVO returnSitemanagerAccount(String hotelID) {
		if(hotelID.equals("H00000001")){
			return new HotelstaffVO("H00000001","00000000","12345678");
		}
		else if(hotelID.equals("H00000002")){
			return new HotelstaffVO("H00000002","00000000","12345679");
		}
		else if(hotelID.equals("H00000003")){
			return new HotelstaffVO("H00000003","00000000","12345670");
		}
		else{
			return null;
		}
	}


	@Override
	public String getBasicinfo(String hotelID) {
		return "111111";
	}


	@Override
	public ResultMessage setPassword(String hotelID, String password) {
		return ResultMessage.SUCCESS;
	}


	@Override
	public boolean checkAccount(String hotelID, String password) {
		return true;
	}
}
