package businesslogic.clientbl;

import java.io.File;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import Enum.OrderType;
import Enum.ResultMessage;
import businesslogicservice.clientblservice.ClientBLService;
import dataservice.clientdataservice.ClientDataService;
import datatool.ClientDataTool;
import po.ClientPO;
import rmi.RemoteHelper;
import vo.clientVO.ClientVO;
import vo.hotelinfoVO.HotelinfoVO;
import vo.levelVO.LevelVO;
import vo.orderVO.OrderVO;


public class ClientManage implements ClientBLService{
	static ClientDataService clientdata;
	@Override
	public ClientVO getclient(String clientID) {
		if(clientID.equals("")||clientID==null)
			return null;
		else if(clientID.charAt(0)=='C'&&clientID.length()==9){
		try{
			ClientPO po=RemoteHelper.getInstance().clientDataService().findPersonalInfo(clientID);
			if(po!=null){
			ClientVO vo=new ClientVO(po.getID(),po.getPassword(),po.getName(),po.getTel(),po.getType(),po.getLevel(),po.getBirth(),po.getFirm(),po.getCredit(),po.getRecord());
			return vo;
			}
		}catch(RemoteException e){
				e.printStackTrace();
			}

		}
	return null;

	}

	@Override
	public ResultMessage createClient(ClientVO vo) {

		// TODO Auto-generated method stub
		if(vo.getID().equals("")||vo.getID()==null)
			return ResultMessage.FAIL;
		else if(vo.getID().charAt(0)=='C'&&vo.getID().length()==9){
		try{
			ClientPO po=new ClientPO(vo.getID(),vo.getPassword(),vo.getName(),vo.getTel(),vo.getType(),vo.getLevel(),vo.getBirth(),vo.getFirm(),vo.getCreditRecord(),vo.getCredit());
			boolean rs=RemoteHelper.getInstance().clientDataService().createClient(po);
			if(rs)
				return ResultMessage.SUCCESS;
		}catch(RemoteException e){
				e.printStackTrace();
			}

		}

		return ResultMessage.FAIL;

	}

	@Override
	public ResultMessage saveSitemanagerDelete(String clientId) {
		// TODO Auto-generated method stub
		if(clientId==""||clientId==null)
			return ResultMessage.FAIL;
		else if(clientId.charAt(0)=='C'&&clientId.length()==9){
		try{
			if(RemoteHelper.getInstance().clientDataService().deleteClient(clientId))
				return ResultMessage.SUCCESS;
			}catch(RemoteException e){
				e.printStackTrace();

			}}
		return ResultMessage.FAIL;

	}

	@Override
	public boolean setCredit(String clientID, int recharge) {
		// TODO Auto-generated method stub
		try{
			if(RemoteHelper.getInstance().clientDataService().setCredit(clientID, recharge))
				return true;
			}catch(RemoteException e){
				e.printStackTrace();

			}
			 return false;
	}


	@Override
	public boolean setAllClientLevel(LevelVO vo) {
		// TODO Auto-generated method stub
		try{
			boolean res=clientdata. setAllLevel();
			return res;
			}catch(Exception e){
				e.printStackTrace();
			}
		return false;
	}


	@Override
	public ResultMessage updateInfo(ClientVO vo) {
		// TODO Auto-generated method stub
		try{
			ClientPO po=new ClientPO(vo.getID(),vo.getPassword(),vo.getName(),vo.getTel(),vo.getType(),vo.getLevel(),vo.getBirth(),vo.getFirm(),vo.getCreditRecord(),vo.getCredit());
			ResultMessage rs=RemoteHelper.getInstance().clientDataService().modifyPersonalInfo(po);
				return rs;
			}catch(RemoteException e){
				e.printStackTrace();

			}
		return ResultMessage.FAIL;
	}



	@Override
	public ArrayList<String> getCreditRecord(String clientID) {
		// TODO Auto-generated method stub
		if(clientID==""||clientID==null)
			return null;
		else if(clientID.charAt(0)=='C'&&clientID.length()==9){
		try{
			ArrayList<String> list=RemoteHelper.getInstance().clientDataService().findCreditRecord(clientID);
			if(list!=null)
			return list;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean checkAccount(String clientID, String password)  {
		// TODO Auto-generated method stub
		try{
		if(RemoteHelper.getInstance().clientDataService().checkAccount(clientID,password))
			return true;
		}catch(RemoteException e){
			e.printStackTrace();

		}
		 return false;
	}



}
