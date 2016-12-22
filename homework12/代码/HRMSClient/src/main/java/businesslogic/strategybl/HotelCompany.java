package businesslogic.strategybl;

import java.util.ArrayList;

import Enum.VIPType;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class HotelCompany extends Strategy{

	public double calDis(StrategyPO strt, ClientVO clientVO, String ID,ArrayList<String> companys) {
		if(clientVO.getType()==null)//用户会员类型为null
			return 1;
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&ID.equals(((HotelStrategyPO) strt).getHotelID())&&
				clientVO.getType().equals(VIPType.ENTERPRISEVIP)){//满足时间,酒店名字与促销中的名字一致，是企业会员条件
			if(companys==null||companys.size()==0)//没有合作企业
				return 1;
			for(String company:companys){
				if(company.equals(clientVO.getFirm())){//满足是企业之一的条件
					return ((HotelCompanyPO) strt).getDiscount();
				}
			}
			return 1;//不满足是企业之一的条件
		}else{//不满足时间,酒店名字与促销中的名字一致，是企业会员条件
			return 1;
		}
	}



}
