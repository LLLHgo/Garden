package presentation.sitemanager.controller;

import java.util.ArrayList;

import Enum.ResultMessage;
import presentation.sitemanager.view.ProcessSitemanagerViewControllerService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;

public class ProcessSitemanagerViewController implements ProcessSitemanagerViewControllerService {
	
	@Override
	public ResultMessage clientAccountUpdate(ClientVO clientVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage accountDelete(String userId) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ClientVO clientAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountAdd(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage MarketingAccountUpdate(MarketingVO marketing) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public MarketingVO MarketingAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage MarketingAccountAdd(HotelinfoVO hotelinfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage HotelAccountAdd(HotelinfoVO hotelinfoVO, HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public HotelstaffVO HotelStaffAccountFind(String findInfo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage HotelStaffAccountUpdate(HotelstaffVO hotelstaffVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public SitemanagerVO sitemanagerAcountShow() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ResultMessage checkAccount(SitemanagerVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

}
