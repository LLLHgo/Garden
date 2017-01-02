package businesslogic.hotelstaffbl;

public class Hotelstaff {
	//酒店工作人员账号,即酒店账号
	String hotelID;
	//就当工作人员密码
	String password;
	//酒店工作人员电话，用于网站工作人员与酒店工作人员联系（不同于酒店电话）
	String tel;
	
	
	public Hotelstaff(){
		
	}
	
	public Hotelstaff(String hotelID,String password,String tel){
		this.hotelID = hotelID;
		this.password = password;
		this.tel=tel;
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
	
	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
}
