package dataservice.clientdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import Enum.ResultMessage;
import po.ClientPO;

public class ClientDataService_Stub implements ClientDataService{
	String clientId;
	/**
	 * 初始化持久化数据库
	 * @throws RemoteException
	 */
	public void init() throws RemoteException{

	}
	/**
	 * 查询信用记录
	 * @param clientID
	 * @return信用记录文件
	 */
	public ArrayList<String> findCreditRecord(String clientID)throws RemoteException{
		return new ArrayList<String>();
	}
	/**
	 * 修改客户信用值
	 * @param clientID
	 * @param recharge
	 * @return 修改是否成功
	 */
	public boolean setCredit(String clientID,int recharge,String date,String reason)throws RemoteException{
		if(recharge==0)
			return false;
		else
			return true;
	}
	/**
	 * 查询客户个人基本信息
	 * @param clientID
	 * @return 客户PO
	 */
	public ClientPO  findPersonalInfo (String clientID)throws RemoteException{
		return new ClientPO();
	}
	/**
	 * 修改客户个人基本信息
	 * @param clientID
	 * @param po
	 * @return 修改是否成功
	 */
	public ResultMessage modifyPersonalInfo (ClientPO po)throws RemoteException{
		if(clientId!=null)
			return ResultMessage.SUCCESS;
		else
			return ResultMessage.FAIL;
	}
	/**
	 * 查找客户账户
	 * @param client_id
	 * @param password
	 * @return 账户是否存在
	 */
	public boolean checkAccount(String client_id,String password)throws RemoteException{
		if(client_id!=null)
			return true;
		else
			return false;
	}
	/**
	 * 设置所有客户会员等级
	 * @param po
	 * @return 是否设置成功
	 */
	public boolean setAllLevel()throws RemoteException{

			return false;
	}
	/**
	 * 创建新客户
	 * @param po
	 * @return 创建是否成功
	 */
	public String createClient(ClientPO po)throws RemoteException{
		if(po!=null)
			return "SUCCESS";
		else
			return "FAIL";
	}
	/**
	 * 删除客户
	 * @param po
	 * @return 删除是否成功
	 */
	public boolean deleteClient(String clientId)throws RemoteException{
		if(clientId!=null)
			return true;
		else
			return false;
	}


}
