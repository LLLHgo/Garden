package vo.priceVO;

import java.util.ArrayList;

public class PriceVO {
	private double price;
	private ArrayList<String> strategys;

	public PriceVO(double price,ArrayList<String> strategys){
		this.price=price;
		this.strategys=strategys;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ArrayList<String> getStrategys() {
		return strategys;
	}
	public void setStrategys(ArrayList<String> strategys) {
		this.strategys = strategys;
	}

}
