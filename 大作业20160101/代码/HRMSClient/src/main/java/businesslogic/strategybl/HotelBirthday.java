package businesslogic.strategybl;

import Enum.VIPType;
import po.StrategyPO.HotelBirthdayPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class HotelBirthday extends Strategy{

	public double calDis(StrategyPO strt, ClientVO clientVO, String id) {
		if(clientVO.getType()==null)//用户会员类型为null
			return 1;
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&id.equals(((HotelStrategyPO) strt).getHotelID())&&
				clientVO.getType().equals(VIPType.ORDINARYVIP)){//满足时间,酒店ID与促销中的名字一致，是生日会员条件
			return ((HotelBirthdayPO) strt).getDiscount();
		}else{//不满足时间,酒店ID与促销中的名字一致，是生日会员条件
			return 1;
		}
	}



}
