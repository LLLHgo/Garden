package vo.hotelinfoVO;

import Enum.RoomState;

public class RoominfoVO {
	//酒店id
	String hotelID;
	//房间类型
	String type;
	//房间号
	String roomID;
	//入住1晚的原始价格
	double price;
	//房间状态，分为：可使用，不可使用
	RoomState roomState;
	
	public RoominfoVO(){
		
	}
	
	public RoominfoVO(String hotelID,String type, String roomID, double price, RoomState roomState) {
		super();
		this.hotelID = hotelID;
		this.type = type;
		this.roomID = roomID;
		this.price = price;
		this.roomState = roomState;
	}
	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRoomNum() {
		return roomID;
	}
	public void setRoomNum(String roomNum) {
		this.roomID = roomNum;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public RoomState getRoomState() {
		return roomState;
	}
	public void setRoomState(RoomState roomState) {
		this.roomState = roomState;
	}
}
