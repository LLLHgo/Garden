package po;

import Enum.RoomState;

public class RoominfoPO {
	String type;
	String roomNum;
	double price;
	RoomState roomState;
	
	public RoominfoPO(){
		
	}
	
	public RoominfoPO(String type, String roomNum, double price, RoomState roomState) {
		super();
		this.type = type;
		this.roomNum = roomNum;
		this.price = price;
		this.roomState = roomState;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRoomNum() {
		return roomNum;
	}
	public void setRoomNum(String roomNum) {
		this.roomNum = roomNum;
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
