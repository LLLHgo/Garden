package vo.priceVO;

import java.util.List;

public class PriceVO {
	private double price;
	private List<String> strategys;

	public PriceVO(double price,List<String> strategys){
		this.price=price;
		this.strategys=strategys;
	}

	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public List<String> getStrategys() {
		return strategys;
	}
	public void setStrategys(List<String> strategys) {
		this.strategys = strategys;
	}

}
