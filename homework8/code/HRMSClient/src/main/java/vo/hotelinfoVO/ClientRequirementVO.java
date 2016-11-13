package vo.hotelinfoVO;

public class ClientRequirementVO {
	//酒店账号
	String hotelID;
	//商圈
	String area;
	
	public ClientRequirementVO(){
		
	}
	
	public ClientRequirementVO(String hotelID , String area){
		this.hotelID = hotelID;
		this.area = area;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
}
