package Mock;

import Enum.ResultMessage;
import datatool.SitemanagerDataTool;
import vo.sitemanager.SitemanagerVO;

public class MockSitemanagerManage {
	 // 网站管理人员帐号
	private String sitemanagerId;
	// 网站管理人员手机号
	private String servicePhoneNumber;
	// 网站管理人员密码
	private String password;

	public MockSitemanagerManage(){

	}

	SitemanagerDataTool sitemanagerDataTool=new SitemanagerDataTool();

	public SitemanagerVO sitemanagerAcountShow(){
		return SitemanagerDataTool.sitemanagerVO;
	}

	public boolean checkAccount (SitemanagerVO accountVO){

		if(accountVO.getSitemanagerId()==SitemanagerDataTool.sitemanagerVO.getSitemanagerId()&&
				(accountVO.getPassword()==SitemanagerDataTool.sitemanagerVO.getPassword())&&
				(accountVO.getSitemanagerPhoneNumber()==SitemanagerDataTool.sitemanagerVO.getSitemanagerPhoneNumber()))
			return true;
		else
			return false;
	}

	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO){

		return ResultMessage.SUCCESS;
	}
}
