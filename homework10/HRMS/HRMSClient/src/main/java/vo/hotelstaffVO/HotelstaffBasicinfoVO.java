package vo.hotelstaffVO;

public class HotelstaffBasicinfoVO {
	//酒店工作人员密码
	String password;
	
	public HotelstaffBasicinfoVO(){
		
	}
	
	public HotelstaffBasicinfoVO(String password) {
		super();
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
}
