package businesslogic.strategybl;

import java.util.List;

import Enum.VIPType;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.StrategyPO;
import vo.clientVO.ClientVO;

public class MarketingCreated extends Strategy{

	public double calDis(StrategyPO strt, ClientVO clientvo, String hotel,int minRooms,double minSum) {
		MarketingCreatedPO po=(MarketingCreatedPO) strt;
		if(super.isavailable(strt.getStartTime(), strt.getEndTime())&&minRooms>=po.getMinRooms()&&
				minSum>=po.getMinSum()&&clientvo.getLevel()>=po.getLevels()){
			//时间,最少房间数,最少消费金额,最低会员等级
			List<VIPType> viptypes=po.getViptypes();
			boolean isVIP=false,isArea=false;
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
			for(String area:po.getHotels()){
				if(area.equals(hotel)){//是否为选择的酒店之一
					isArea=true;
					break;
				}
			}
			if((isVIP||viptypes.size()==0)&&isArea)
				return po.getDiscount();//是某种会员或不对会员设限且满足酒店
			else
				return 1;//不是某种会员或不是选择的酒店之一
		}else {//时间不满足
			return 1;
		}

	}

}
