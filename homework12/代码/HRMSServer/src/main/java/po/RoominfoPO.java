package po;

import java.io.Serializable;

import Enum.RoomState;

public class RoominfoPO implements Serializable{

	private static final long serialVersionUID = 1L;
	String hotelID;
	String type;
	String roomNum;
	double price;
	RoomState roomState;
	
	public RoominfoPO(){
		
	}
	
	public RoominfoPO(String hotelID,String type, String roomNum, double price, RoomState roomState) {
		super();
		this.hotelID = hotelID;
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

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}
