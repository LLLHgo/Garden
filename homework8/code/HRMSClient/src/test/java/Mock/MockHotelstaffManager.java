package Mock;

import vo.hotelstaffVO.HotelstaffVO;

public class MockHotelstaffManager {
	
	public boolean saveSitemanagerUpdate(HotelstaffVO vo) {
		if(vo.getHotelID().equals("H00000001")){
			return true;
		}
		else if(vo.getHotelID().equals("H00000002")){
			return true;
		}
		else if(vo.getHotelID().equals("H00000003")){
			return true;
		}
		return false;
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
}
