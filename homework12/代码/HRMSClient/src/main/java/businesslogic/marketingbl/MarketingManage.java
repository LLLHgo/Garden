package businesslogic.marketingbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.ResultMessage;
import businesslogicservice.marketinblservice.MarketingBLService;
import dataservice.marketingdataservice.MarketingDataService;
import po.LevelPO;
import po.MarketingPO;
import rmi.RemoteHelper;
import vo.levelVO.LevelVO;
import vo.marketingVO.MarketingVO;

public class MarketingManage implements MarketingBLService{

	public MarketingDataService marketingDataService;

	public MarketingManage(){
		RemoteHelper helper=RemoteHelper.getInstance();
		marketingDataService=helper.marketingDataService();
	}


	@Override
	public ResultMessage updateLevel(List<LevelVO> vos) {
		List<LevelPO> pos=new ArrayList<LevelPO>();
		for(LevelVO vo:vos){
			pos.add(new LevelPO(vo.getLevel(),vo.getName(),vo.getCreditNeeded(),vo.getDiscount()));
		}
	    try {
			if(this.marketingDataService.updateLevel(pos)){//数据层更新成功
				return ResultMessage.SUCCESS;
			}else{//数据层更新失败
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {
			return ResultMessage.FAULT;//数据层更新出现故障
		}
	}

	@Override
	public List<LevelVO> findAllLevel() {
		List<LevelVO> vos=new ArrayList<LevelVO>();
		List<LevelPO> pos;
		try {
			pos=this.marketingDataService.findAllLevel();//POlist可以返回空的，但不是null
		} catch (RemoteException e) {
			return null;//数据层出现故障，返回null
		}
		for(LevelPO po:pos){
			vos.add(new LevelVO(po.getLevel(),po.getName(),po.getCreditNeeded(),po.getDiscount()));
		}
		return vos;
	}



	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO vo) {
		if(vo==null)
			return ResultMessage.FAIL;
        MarketingPO po=new MarketingPO(vo.getName(),vo.getPassword(),vo.getMarketingID(),vo.getTelephone());
		try {
			if(this.marketingDataService.MarketingAccountUpdate(po)){//更新账户成功
				return ResultMessage.SUCCESS;
			}else{//更新账户失败
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {//更新账户有故障
			return ResultMessage.FAULT;
		}
	}

	@Override
	public boolean checkAccount(String marketingID, String password) {
		try {
			if(this.marketingDataService.checkAccount(marketingID,password)){//用户登录信息匹配
				return true;
			}else{//用户登录信息不匹配
				return false;
			}
		} catch (RemoteException e) {//检查用户登录信息出故障
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public MarketingVO init(String id) {
		MarketingVO vo;
		MarketingPO po;
	    try {
			po=this.marketingDataService.getInfo(id);
		} catch (RemoteException e) {
			return null;//出现故障则返回null
		}
	    if(po==null)
	    	return null;//返回的是null 初始化失败
	    vo=new MarketingVO(po.getName(),po.getPassword(),po.getMarketingID(),po.getTelephone());//可以返回初始默认值的vo,但不能是null；
		return vo;
	}


	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO vo) {
		if(vo==null)
		    return ResultMessage.FAIL;
		if(vo.getPassword().length()==0)
			return ResultMessage.VOIDPASSWORD;
		MarketingPO po=new MarketingPO(vo.getName(),vo.getPassword(),vo.getMarketingID(),vo.getTelephone());
		try {
			if(this.marketingDataService.MarketingAccountAdd(po)){//增加账户成功
				return ResultMessage.SUCCESS;
			}else{//增加账户失败
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {//增加账户有故障
			return ResultMessage.FAULT;
		}
	}

	@Override
	public ResultMessage MarketingAccountDelete(MarketingVO vo) {
		MarketingPO po=new MarketingPO(vo.getName(),vo.getPassword(),vo.getMarketingID(),vo.getTelephone());
		try {
			if(this.marketingDataService.MarketingAccountDelete(po)){//删除账户成功
				return ResultMessage.SUCCESS;
			}else{//删除账户失败
				return ResultMessage.FAIL;
			}
		} catch (RemoteException e) {//删除账户有故障
			return ResultMessage.FAULT;
		}
	}

	@Override
	public MarketingVO MarketingAccountFind(String marketingID) {
		MarketingVO vo;
		MarketingPO po;
		try {
			po=this.marketingDataService.getInfo(marketingID);
		} catch (RemoteException e) {
			return null;//出现数据库或链接故障，返回null
		}
		vo=new MarketingVO(po.getName(),po.getPassword(),po.getMarketingID(),po.getTelephone());
		return vo;//可以返回初始默认值的vo,但不能是null
	}

}
