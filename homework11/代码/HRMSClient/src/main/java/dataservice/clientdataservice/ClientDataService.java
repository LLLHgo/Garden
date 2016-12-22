package dataservice.clientdataservice;

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.ResultMessage;
import po.ClientPO;
import po.LevelPO;
import vo.clientVO.ClientVO;
import vo.levelVO.LevelVO;

public interface ClientDataService extends Remote{
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	/**
	 * 查询信用记录
	 * @param clientID
	 * @return信用记录文件
	 */
	public File findCreditRecord(String clientID)throws RemoteException;
	/**
	 * 修改客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改是否成功
	 */
	public boolean setCredit(String clientID,int recharge)throws RemoteException;
	/**
	 * 查询客户个人基本信息
	 * @param clientID
	 * @return 客户PO
	 */
	public ClientVO  findPersonalInfo (String clientID)throws RemoteException;
	/**
	 * 修改客户个人基本信息
	 * @param po
	 * @return 修改是否成功
	 */
	public ResultMessage modifyPersonalInfo (ClientVO vo)throws RemoteException;
	/**
	 * 查找客户账户
	 * @param client_id
	 * @param password
	 * @return 账户是否存在
	 */
	public boolean checkAccount(String client_id,String password)throws RemoteException;
	/**
	 * 设置所有客户会员等级
	 * @param po
	 * @return 是否设置成功
	 */
	public boolean setAllLevel(LevelVO vo)throws RemoteException;
	/**
	 *得到客户的信用记录
	 * @param clientID
	 * @return 信用记录
	 */
	public ArrayList<String> getCreditRecord(String clientID);
	/**
	 * 创建新客户
	 * @param po
	 * @return 创建是否成功
	 */

	public boolean createClient(ClientVO vo)throws RemoteException;
	/**
	 * 删除客户
	 * @param po
	 * @return 删除是否成功
	 */
	public boolean deleteClient(String clientId)throws RemoteException;
}
