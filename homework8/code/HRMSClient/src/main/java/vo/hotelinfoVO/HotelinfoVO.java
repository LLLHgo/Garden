package vo.hotelinfoVO;

import java.util.ArrayList;

import Enum.Star;

public class HotelinfoVO {
	//酒店名称
	public String name;
	//酒店地址
	public String address;
	//酒店所在商圈
	public String area;
	//酒店电话
	public String tel;
	//酒店所包含的房间
	public ArrayList<RoominfoVO> roominfoList;
	//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
	public Star star;
	//酒店评价
	public ArrayList<String> remark;
	//酒店简介
	public String introduction;
	//酒店ＩＤ
	public String hotelID;

	public HotelinfoVO(){

	}

	public HotelinfoVO(String name,String address,String area,
			String tel,ArrayList<RoominfoVO> arrayList,Star star,ArrayList<String> remark,
			String introduciton,String hotelID){
		this.name = name;
		this.address = address;
		this.area = area;
		this.tel = tel;
		this.roominfoList = arrayList;
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


	public ArrayList<RoominfoVO> getRoominfoList() {
		return roominfoList;
	}

	public void setRoominfoList(ArrayList<RoominfoVO> roominfoList) {
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
