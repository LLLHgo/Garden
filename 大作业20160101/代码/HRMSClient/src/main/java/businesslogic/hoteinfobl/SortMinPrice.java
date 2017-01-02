package businesslogic.hoteinfobl;

import java.util.ArrayList;
import java.util.Comparator;

import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;

public class SortMinPrice implements Comparator<HotelinfoVO>{

	@Override
	public int compare(HotelinfoVO o1, HotelinfoVO o2) {
		//System.out.println(getMinPrice(o1)-getMinPrice(o2)+".............");
		if((getMinPrice(o1)-getMinPrice(o2))<0){
			return -1;
		}else if((getMinPrice(o1)-getMinPrice(o2))>0){
			return 1;
		}else{
			return 0;
		}
	}
	

private double getMinPrice(HotelinfoVO vo){
	if(vo.getRoominfoList()==null){
		return Double.MAX_VALUE;
	}
	ArrayList<RoominfoVO> roomList= vo.getRoominfoList();
	RoominfoVO roominfo;
	double min=0;
	if(!roomList.isEmpty()){
		min = vo.getRoominfoList().get(0).getPrice();
	}
	for(int i=0;i<roomList.size();i++){
		roominfo = roomList.get(i);
		double price = roominfo.getPrice();
		if(min>price){
			min = price;
		}
	}
	return min;
}
}