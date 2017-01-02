package businesslogic.hoteinfobl;

import java.util.Comparator;

import Enum.Star;
import vo.hotelinfoVO.HotelinfoVO;

public class SortHotelStar implements Comparator<HotelinfoVO>{
	
	@Override
	public int compare(HotelinfoVO o1, HotelinfoVO o2) {
			Star[] starArray = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,Star.SIX,Star.SEVEN};
			for(int i=0;i<starArray.length;i++){
				if(starArray[i]==o1.getStar()){
					o1.setRankhotelstar(i);
				}
				if(starArray[i]==o2.getStar()){
					o2.setRankhotelstar(i);
				}
			}
		//System.out.println(o1.getRankhotelstar()-o2.getRankhotelstar()+"result");
			
		return -o1.getRankhotelstar()+o2.getRankhotelstar();
	}
	
}
