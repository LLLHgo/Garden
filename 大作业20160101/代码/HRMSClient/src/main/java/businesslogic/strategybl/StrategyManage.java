package businesslogic.strategybl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import Enum.HotelStrategy;
import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.StrategyMaker;
import businesslogic.marketingbl.MarketingManage;
import businesslogicservice.marketinblservice.MarketingBLService;
import businesslogicservice.strategyblservice.StrategyBLService;
import dataservice.strategydataservice.StrategyDataService;
import po.StrategyPO.HotelBirthdayPO;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.HotelCreatedPO;
import po.StrategyPO.HotelOverThreeRoomsPO;
import po.StrategyPO.HotelSpecialdayPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;
import rmi.RemoteHelper;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelinfoVO.RoominfoVO;
import vo.levelVO.LevelVO;
import vo.priceVO.PriceVO;
import vo.strategyVO.HotelStrategyVO;
import vo.strategyVO.MarketingStrategyVO;

public class StrategyManage implements StrategyBLService{


	private MarketingBLService marketingblservice=new MarketingManage();
	public StrategyDataService strategyDataService;

	public StrategyManage(){
		RemoteHelper helper=RemoteHelper.getInstance();
		strategyDataService=helper.strategyDataService();
	}
	@Override
	public ResultMessage addMarketingStrategy(MarketingStrategyVO vo) {
		MarketingStrategyPO po=Mvo2po(vo);
		try {
			if(this.strategyDataService.addMarketingStrategy(po).equals(ResultMessage.SUCCESS))
				return ResultMessage.SUCCESS;
			else if(this.strategyDataService.addMarketingStrategy(po).equals(ResultMessage.FAIL))
				return ResultMessage.FAIL;
			else if(this.strategyDataService.addMarketingStrategy(po).equals(ResultMessage.DUPLICATESTRATEGY))
				return ResultMessage.DUPLICATESTRATEGY;
			else if(this.strategyDataService.addMarketingStrategy(po).equals(ResultMessage.SQLERROR))
				return ResultMessage.SQLERROR;
			else if(this.strategyDataService.addMarketingStrategy(po).equals(ResultMessage.CLASSFORNAME))
				return ResultMessage.CLASSFORNAME;
		} catch (RemoteException e) {
			return ResultMessage.REMOTEEXCEPTION;
		}
		return  ResultMessage.FAIL;
	}

	@Override
	public List<MarketingStrategyVO> getMarketingStrategy() {
		List<StrategyPO> pos;
		try {
			pos=this.strategyDataService.getMarketingStrategy();
		} catch (RemoteException e) {
			return null;
		}
		List<MarketingStrategyVO> vos=new ArrayList<MarketingStrategyVO>();
		for(StrategyPO po:pos){
			MarketingStrategyVO vo = Mpo2vo((MarketingStrategyPO) po);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public ResultMessage deleteMarketingStrategy(String vo) {
		try {
			if(this.strategyDataService.deleteMarketingStrategy(vo))
				return ResultMessage.SUCCESS;//删除成功
			else
				return ResultMessage.FAIL;//删除失败
		} catch (RemoteException e) {
			return ResultMessage.FAULT;//删除出现故障
		}
	}

	@Override
	public List<HotelStrategyVO> getHotelStrategy(String hotelID) {
		List<StrategyPO> pos;
		List<HotelStrategyVO> vos = new ArrayList<HotelStrategyVO>();
		try {
			pos=this.strategyDataService.getHotelStrategy(hotelID);
		} catch (RemoteException e) {
			return null;
		}
		for(StrategyPO po:pos){
			HotelStrategyVO vo=Hpo2vo((HotelStrategyPO) po);
			vos.add(vo);
		}
		return vos;
	}

	@Override
	public ResultMessage updateHotelStrategy(HotelStrategyVO vo) {
		HotelStrategyPO po=Hvo2po(vo);
		try {
			if(this.strategyDataService.updateHotelStrategy(po))
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;
		} catch (RemoteException e) {
			return ResultMessage.FAULT;
		}
	}

	@Override
	public PriceVO calculatePrice(ClientVO clientVO, RoominfoVO roomInfoVO, HotelinfoVO hotelInfoVO, int num,int days) {
		ArrayList<String> strategyUsed=new ArrayList<String>();
		List<StrategyPO> strategys=new ArrayList<StrategyPO>();
		Strategy[] strategy=new Strategy[8];
		strategy[0]=new MarketingPeriod();
		strategy[1]=new MarketingSpecial();
		strategy[2]=new MarketingCreated();
		strategy[3]=new HotelBirthday();
		strategy[4]=new HotelCompany();
		strategy[5]=new HotelSpecialday();
		strategy[6]=new HotelOverThreeRooms();
		strategy[7]=new HotelCreated();
		try {
			strategys.addAll(this.strategyDataService.getHotelStrategy(hotelInfoVO.getHotelID()));
			strategys.addAll(this.strategyDataService.getMarketingStrategy());
		} catch (RemoteException e) {
			return null;//从数据库中调策略的时候出现故障
		}

		double tem,price=1;
		for(StrategyPO strt:strategys){//对读出来的策略遍历
			if(strt.getMakerType().equals(StrategyMaker.MARKTING)){//该策略是网站营销人员制定的
				if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.PERIOD)){//特定时间促销策略
					tem=((MarketingPeriod) strategy[0]).calDis(strt);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL)){//专属商圈
					tem=((MarketingSpecial) strategy[1]).calDis(strt,clientVO,hotelInfoVO);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((MarketingStrategyPO) strt).getMarketingStrategyType().equals(MarketingStrategy.CREATED)){//新增策略
					tem=((MarketingCreated) strategy[2]).calDis(strt,clientVO,hotelInfoVO.getName(),num,roomInfoVO.getPrice()*num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}
			}else if(strt.getMakerType().equals(StrategyMaker.HOTEL)){//该策略是酒店工作人员制定的
				if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.BIRTHDAY)){//生日会员专属特惠
					tem=((HotelBirthday) strategy[3]).calDis(strt,clientVO,hotelInfoVO.getHotelID());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.COMPANY)){//企业会员专属折扣
					tem=((HotelCompany) strategy[4]).calDis(strt,clientVO,hotelInfoVO.getHotelID(),hotelInfoVO.getCompany());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());
					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.SPECIALDAY)){//特定日期专属折扣
					tem=((HotelSpecialday) strategy[5]).calDis(strt,hotelInfoVO.getHotelID());
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());

					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.OVERTHREEROOMS)){//超过或等于三间
					tem=((HotelOverThreeRooms) strategy[6]).calDis(strt,hotelInfoVO.getHotelID(),num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());

					}
				}else if(((HotelStrategyPO) strt).getHotelStrategy().equals(HotelStrategy.CREATED)){//新增促销策略
					tem=((HotelCreated) strategy[7]).calDis(strt,clientVO,hotelInfoVO,num,roomInfoVO.getPrice()*num);
					if(tem<1.0){
						price=price*tem;
						strategyUsed.add(strt.getName());

					}
				}
			}
		}
		price=price*roomInfoVO.getPrice()*num*days;//计算各种策略的价格
		List<LevelVO> levels=marketingblservice.findAllLevel();//计算出用户等级所享受的折扣
		for(LevelVO level:levels){
			if(clientVO.vip_level==level.getLevel()){
				price*=level.getDiscount();
				break;
			}
		}
		return new PriceVO((double)((int)price),strategyUsed);
	}

	private MarketingStrategyPO Mvo2po(MarketingStrategyVO vo){
		MarketingStrategyPO po = null;
		if(vo.getType().equals(MarketingStrategy.PERIOD))
			po=new MarketingPeriodPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getDiscount());
		else if(vo.getType().equals(MarketingStrategy.VIPSPECIAL))
			po=new MarketingSpecialPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getBusinessDistrict(),
					vo.getLevels(),vo.getDiscounts());
		else if(vo.getType().equals(MarketingStrategy.CREATED))
			po=new MarketingCreatedPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getDiscount(),
					vo.getHotels(),vo.getMinSum(),vo.getMinRooms(),vo.getMinLevel(),vo.getVipKinds());
		return po;
	}

	private MarketingStrategyVO Mpo2vo(MarketingStrategyPO po){
		MarketingStrategyVO vo = null;
		if(po.getMarketingStrategyType().equals(MarketingStrategy.PERIOD))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.PERIOD,po.getStartTime(),po.getEndTime(),((MarketingPeriodPO) po).getDiscount());
		else if(po.getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.VIPSPECIAL,po.getStartTime(),po.getEndTime(),
					((MarketingSpecialPO) po).getBusinessDistrict(),((MarketingSpecialPO) po).getLevels(),((MarketingSpecialPO) po).getDiscounts());
		else if(po.getMarketingStrategyType().equals(MarketingStrategy.CREATED))
			vo=new MarketingStrategyVO(po.getName(),MarketingStrategy.CREATED,po.getStartTime(),po.getEndTime(),((MarketingCreatedPO) po).getDiscount(),
					((MarketingCreatedPO) po).getHotels(),((MarketingCreatedPO) po).getMinSum(),((MarketingCreatedPO) po).getMinRooms(),
					((MarketingCreatedPO) po).getLevels(),((MarketingCreatedPO) po).getViptypes());
		return vo;
	}

	private HotelStrategyPO Hvo2po(HotelStrategyVO vo){
		HotelStrategyPO po = null;
		if(vo.getType().equals(HotelStrategy.BIRTHDAY)){
			po=new HotelBirthdayPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getHotelID(),vo.getDiscount());
		}else if(vo.getType().equals(HotelStrategy.COMPANY))
			po=new HotelCompanyPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getHotelID(),vo.getDiscount());
		else if(vo.getType().equals(HotelStrategy.SPECIALDAY))
			po=new HotelSpecialdayPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getHotelID(),vo.getDiscount());
		else if(vo.getType().equals(HotelStrategy.OVERTHREEROOMS))
			po=new HotelOverThreeRoomsPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getHotelID(),vo.getDiscount(),vo.getMinRooms());
		else if(vo.getType().equals(HotelStrategy.CREATED))
			po=new HotelCreatedPO(vo.getName(),vo.getStartTime(),vo.getEndTime(),vo.getHotelID(),vo.getDiscount(),vo.getVipKinds(),vo.getMinRooms(),vo.getMinSum(),vo.getLevel());
		return po;

	}
	private HotelStrategyVO Hpo2vo(HotelStrategyPO po){
		HotelStrategyVO vo=null;
		if(po.getHotelStrategy().equals(HotelStrategy.BIRTHDAY))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.BIRTHDAY,((HotelBirthdayPO) po).getViptype(),po.getStartTime(),po.getEndTime(),po.getDiscount());
		else if(po.getHotelStrategy().equals(HotelStrategy.COMPANY))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.COMPANY,((HotelCompanyPO) po).getViptype(),po.getStartTime(),po.getEndTime(),po.getDiscount());
		else if(po.getHotelStrategy().equals(HotelStrategy.SPECIALDAY))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.SPECIALDAY,po.getStartTime(),po.getEndTime(),po.getDiscount());
		else if(po.getHotelStrategy().equals(HotelStrategy.OVERTHREEROOMS))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.OVERTHREEROOMS,po.getStartTime(),po.getEndTime(),po.getDiscount(),((HotelOverThreeRoomsPO) po).getMinRooms());
		else if(po.getHotelStrategy().equals(HotelStrategy.CREATED))
			vo=new HotelStrategyVO(po.getName(),po.getHotelID(),HotelStrategy.CREATED,((HotelCreatedPO) po).getViptypes(),po.getStartTime(),po.getEndTime(),po.getDiscount(),
					((HotelCreatedPO) po).getMinRooms(),((HotelCreatedPO) po).getMinSum(),((HotelCreatedPO) po).getLevels());
		return vo;
	}

}
