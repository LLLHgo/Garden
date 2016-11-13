package businesslogic.hoteinfobl;

import Enum.RoomState;

public class Roominfo {
	//房间类型
	private String type;
	//房间号
	private String roomID;
	//入住1晚的原始价格
	private double price;
	//房间状态，分为：可使用，不可使用
	private RoomState roomState;
			
	public Roominfo(){
				
	}
			
	public Roominfo(String type, String roomID, double price, RoomState roomState) {
		this.type = type;
		this.roomID = roomID;
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
