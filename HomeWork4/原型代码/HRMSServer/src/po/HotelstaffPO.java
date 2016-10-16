package po;

public class HotelstaffPO {
	String hotelID;
	String password;
	
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
