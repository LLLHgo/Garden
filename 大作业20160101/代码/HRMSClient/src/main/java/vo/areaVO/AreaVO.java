package vo.areaVO;

import java.util.ArrayList;
import java.util.List;

public class AreaVO {

	//商圈名字
	private String name;
	//商圈类为维护一个酒店名字组成的list
	private List<String> hotels;

	public AreaVO(String name){
		this.name=name;
		setHotels(new ArrayList<String>());
	}
	public AreaVO(String name,List<String> hotels){
		this.name=name;
		this.hotels = hotels;
	}
	public List<String> getHotels() {
		return hotels;
	}
	public void setHotels(List<String> hotels) {
		this.hotels = hotels;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
