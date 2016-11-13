package businesslogicservice.sitemanagerblservice;

import vo.logVO.LogVO;
import vo.sitemanager.SitemanagerVO;

import java.util.ArrayList;

import Enum.ResultMessage;

public interface SitemanagerBLService {
	/**
	 * 管理界面得到网站管理人员账户信息
	 * @return SitemanagerVO
	 */
	public SitemanagerVO sitemanagerAcountShow();
	
	/**
	 * 修改网站管理人员账户
	 * @param accountVO
	 * @return
	 */
	public ResultMessage sitemanagerAccountUpdate(SitemanagerVO accountVO);
	
	
	/**
	 * 检查登录的网站管理人员账户密码是否正确
	 * @param account
	 * @return 登录帐号或密码正确（true）或错误（false）的布尔值
	 */
	public ResultMessage checkAccount (SitemanagerVO accountVO);
	
	/**
	 * 管理界面得到日志列表
	 * @return ArrayList<LogVO>
	 */
	public ArrayList<LogVO> findLog();
	
	/**
	 * 添加日志
	 * @param logInfo
	 * @return 添加日志成功或失败的ResultMessage值
	 */
	public ResultMessage addLog(String logInfo);
	
}
	


