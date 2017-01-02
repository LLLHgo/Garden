package vo.hotelinfoVO;

import java.util.ArrayList;
import java.util.Comparator;

import Enum.Star;

public class HotelinfoVO {
	//酒店名称
	private String name;
	//酒店地址
	private String address;
	//酒店所在商圈
	private String area;
	//酒店电话
	private String tel;
	//酒店所包含的房间
	private ArrayList<RoominfoVO> roominfoList;
	//酒店星级 ，ONE，TOW...SEVEN表示一星级到七星级
	private Star star;
	//酒店评价
	private ArrayList<String> remark;
	//酒店简介
	private String introduction;
	//酒店ＩＤ
	private String hotelID;
	//酒店设施
	private String facility;
	//合作企业
	private ArrayList<String> company;
	//每种类型对应的数量
	private ArrayList<Integer> availableNum;
	//用于实现排序的hotelstar
	private int rankhotelstar;
	//用于实现实现排序的评价star
	private double remarkstar;
	//用于实现排序的minprice
	private double minprice;
	public HotelinfoVO(){

	}

	public HotelinfoVO(String name,String address,String area,String introduction,String facility
			,String tel,Star star,String hotelID,ArrayList<String> company){
		this.name = name;
		this.address = address;
		this.area = area;
		this.introduction = introduction;
		this.facility = facility;
		this.tel = tel;
		this.star = star;
		this.hotelID = hotelID;
		this.company = company;
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

	public String getFacility() {
		return facility;
	}

	public void setFacility(String facility) {
		this.facility = facility;
	}

	public ArrayList<String> getCompany() {
		return company;
	}

	public void setCompany(ArrayList<String> company) {
		this.company = company;
	}
	public ArrayList<Integer> getAvailableNum() {
		return availableNum;
	}
	public void setAvailableNum(ArrayList<Integer> availableNum) {
		this.availableNum = availableNum;
	}
	
	public int getRankhotelstar() {
		return rankhotelstar;
	}

	public void setRankhotelstar(int rankhotelstar) {
		this.rankhotelstar = rankhotelstar;
	}

	public double getRemarkstar() {
			ArrayList<String> remarklist = getRemark();
			ArrayList<Integer> starList = new ArrayList<Integer>();
			for(int i=0;i<remarklist.size();i++){
				String remark = remarklist.get(i);
				String[] remarkArray = remark.split(" ");
				int star = Integer.parseInt(remarkArray[0]);
				starList.add(star);
			}
			double averagestar =0  ;
			for(int i=0;i<starList.size();i++){
				averagestar+=starList.get(i);
			}
			averagestar = averagestar/starList.size();
			return averagestar;
		
	}

	public void setRemarkstar(double remarkstar) {
		this.remarkstar = remarkstar;
	}

	public double getMinprice() {
		return minprice;
	}

	public void setMinprice(double minprice) {
		this.minprice = minprice;
	}
}
