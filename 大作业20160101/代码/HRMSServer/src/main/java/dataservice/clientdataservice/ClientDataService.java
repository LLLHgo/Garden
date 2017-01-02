package dataservice.clientdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.ResultMessage;
import po.ClientPO;
/**
 * 客户的数据操作的接口
 * @author ClaraLee
 *
 */
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
	public ArrayList<String> findCreditRecord(String clientID)throws RemoteException;
	/**
	 * 修改客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改是否成功
	 */
	public boolean setCredit(String clientID,int recharge,String date,String reason)throws RemoteException;
	/**
	 * 查询客户个人基本信息
	 * @param clientID
	 * @return 客户PO
	 */
	public ClientPO  findPersonalInfo (String clientID)throws RemoteException;
	/**
	 * 修改客户个人基本信息
	 * @param clientID
	 * @param po
	 * @return 修改是否成功
	 */
	public ResultMessage modifyPersonalInfo (ClientPO po)throws RemoteException;
	/**
	 * 查找客户账户
	 * @param client_id
	 * @param password
	 * @return 账户是否存在
	 */
	public boolean checkAccount(String client_id,String password)throws RemoteException;
		/**
	 * 创建新客户
	 * @param po
	 * @return 创建是否成功
	 */
	public String createClient(ClientPO po)throws RemoteException;

	/**
	 * 删除客户
	 * @param po
	 * @return 删除是否成功
	 */
	public boolean deleteClient(String clientId)throws RemoteException;

}
