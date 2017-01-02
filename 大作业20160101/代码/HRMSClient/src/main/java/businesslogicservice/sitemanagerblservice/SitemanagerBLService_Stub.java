package businesslogicservice.sitemanagerblservice;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import Enum.ResultMessage;
import vo.logVO.LogVO;
import vo.sitemanagerVO.SitemanagerVO;
/**
 * 网站管理人员模块bl层的桩
 * @author yilu
 *
 */
public class SitemanagerBLService_Stub implements SitemanagerBLService{
	
	SitemanagerVO sitemanagerVO;
	ArrayList<LogVO> list;
	SitemanagerVO currentSitemanagerVO;
	ImageIcon image=null;

	public SitemanagerBLService_Stub(){
		sitemanagerVO=new SitemanagerVO("S00000001","025-88888825","HRMSSitemanager");
		currentSitemanagerVO=new SitemanagerVO("S00000001","025-88888825","HRMSSitemanager");
	}
	
	public SitemanagerVO init(String id){
		return currentSitemanagerVO;
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
	public ResultMessage sitemanagerAccountUpdatePO(SitemanagerVO accountVO) {
		// TODO Auto-generated method stub
		if(accountVO.getSitemanagerPhoneNumber().equals(sitemanagerVO.getSitemanagerPhoneNumber())&&
				(accountVO.getPassword().equals(sitemanagerVO.getPassword()))
			){
			return ResultMessage.FAIL;
		}
		else{
			sitemanagerVO=accountVO;
			return ResultMessage.SUCCESS;
		}
	}

	//@Override
	/*public ArrayList<LogVO> findLog() {
		// TODO Auto-generated method stub
		return list;
	}

	@Override
	public ResultMessage addLog(String logInfo) {
		// TODO Auto-generated method stub
		return ResultMessage.SUCCESS;
	}
	*/
}
