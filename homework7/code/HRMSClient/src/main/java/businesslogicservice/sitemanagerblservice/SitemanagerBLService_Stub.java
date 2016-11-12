package businesslogicservice.sitemanagerblservice;

import java.io.File;
import java.util.ArrayList;

import Enum.ResultMessage;
import businesslogicservice.sitemanagerblservice.SitemanagerBLService;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.hotelstaffVO.HotelstaffVO;
import vo.logVO.LogVO;
import vo.marketingVO.MarketingVO;
import vo.sitemanager.SitemanagerVO;
import Enum.VIPType;

public class SitemanagerBLService_Stub implements SitemanagerBLService{
	SitemanagerVO sitemanagerVO;
	ArrayList<LogVO> list;

	public SitemanagerBLService_Stub(SitemanagerVO sitemanagerVO){
		this.sitemanagerVO=sitemanagerVO;
	}
	
	public SitemanagerBLService_Stub(ArrayList<LogVO> list){
		this.list=list;
	}
	

	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	@Override
	public ResultMessage checkAccount(SitemanagerVO account) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public SitemanagerVO sitemanagerAcountShow() {
		// TODO Auto-generated method stub
		return sitemanagerVO;
	}


	@Override
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}

	@Override
	public ArrayList<LogVO> findLog() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	
}
