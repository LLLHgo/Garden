package businesslogic.strategybl;

import java.util.List;

import Enum.VIPType;
import po.StrategyPO.HotelCreatedPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;

public class HotelCreated extends Strategy{

	public double calDis(StrategyPO strt,ClientVO clientvo, HotelinfoVO hotelinfovo,int num,double sum) {
		HotelCreatedPO po=(HotelCreatedPO) strt;
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&hotelinfovo.getHotelID().equals(((HotelStrategyPO) strt).getHotelID())&&
				num>=po.getMinRooms()&&sum>=po.getMinSum()&&clientvo.getLevel()>=po.getLevels()){
			//满足时间,酒店名字与促销中的名字一致,房间数超过最小房间数条件
			List<VIPType> viptypes=po.getViptypes();
			boolean isVIP=false;
			if(viptypes.size()==0)
				isVIP=true;
			else if(viptypes.size()>0&&clientvo.getType()==null)
				return 1;
			else if(viptypes.size()>0&&clientvo.getType()!=null){
				for(VIPType vip:viptypes){//该用户是否为某种会员
					if(vip.equals(clientvo.getType())){
						isVIP=true;
						break;
					}
				}
			}
			if(isVIP)
				return ((HotelCreatedPO) strt).getDiscount();
			else
				return 1;
		}else{//不满足时间,酒店名字与促销中的名字一致，,房间数超过最小房间数条件
			return 1;
		}
	}



}
