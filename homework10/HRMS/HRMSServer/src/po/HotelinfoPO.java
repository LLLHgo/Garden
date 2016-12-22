package po;

import java.util.ArrayList;

import Enum.Star;

public class HotelinfoPO {
	//酒店名称
	private String name;
	//酒店地址
	private String address;
	//酒店所在商圈
	private String area;
	//酒店电话
	private String tel;
	//酒店所包含的房间
	private ArrayList<RoominfoPO> roominfoList;
	//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
	private Star star;
	//酒店评价
	private ArrayList<String> remark;
	//酒店简介
	private String introduction;
	//酒店ＩＤ
	private String hotelID;
	
	public HotelinfoPO(){
		
	}
	
	public HotelinfoPO(String name,String address,String area,
			String tel,ArrayList<RoominfoPO> roominfoList,Star star,ArrayList<String> remark,
			String introduciton,String hotelID){
		this.name = name;
		this.address = address;
		this.area = area;
		this.tel = tel;
		this.roominfoList = roominfoList;
		this.star = star;
		this.remark = remark;
		this.introduction = introduciton;
		this.hotelID = hotelID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}


	public ArrayList<RoominfoPO> getRoominfoList() {
		return roominfoList;
	}

	public void setRoominfoList(ArrayList<RoominfoPO> roominfoList) {
		this.roominfoList = roominfoList;
	}

	public Star getStar() {
		return star;
	}

	public void setStar(Star star) {
		this.star = star;
	}

	public ArrayList<String> getRemark() {
		return remark;
	}

	public void setRemark(ArrayList<String> remark) {
		this.remark = remark;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getHotelID() {
		return hotelID;
	}

	public void setHotelID(String hotelID) {
		this.hotelID = hotelID;
	}
}
