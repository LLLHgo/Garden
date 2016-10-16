package po;

public class HotelstaffPO {
	String hotelID;
	String password;
	//酒店工作人员电话，用于网站工作人员与酒店工作人员联系（不同于酒店电话）
	String tel;
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public HotelstaffPO(){
		
	}
	
	public HotelstaffPO(String hotelID,String password){
		this.hotelID = hotelID;
		this.password = password;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
