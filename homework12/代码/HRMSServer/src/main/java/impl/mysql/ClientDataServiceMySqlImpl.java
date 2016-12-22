package impl.mysql;

import java.io.File;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Enum.ResultMessage;
import Enum.VIPType;
import dataservice.clientdataservice.ClientDataService;
import initial.DataBaseInit;
import po.ClientPO;
import po.LevelPO;

public class ClientDataServiceMySqlImpl extends UnicastRemoteObject implements ClientDataService{

	private static final long serialVersionUID = 1L;

	public ClientDataServiceMySqlImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> findCreditRecord(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<String> list=new ArrayList<String>();
		Connection conn=DataBaseInit.getConnection();
		try{
			 Statement stat = conn.createStatement();
			 ResultSet count = stat.executeQuery("select * from client  where  clientID='"+clientID+"'");
			 if(count.next()){
	            ResultSet count1 = stat.executeQuery("select * from "+clientID);

	              //如果用户名存在,开始进行信用记录提取
	            	  while(count1.next()) {
	            		  String str="";
	                      str=str+count1.getString("date")+" ";
	                      str=str+count1.getString("reason")+" ";
	                      str=str+count1.getInt("recharge");
	                      list.add(str);
	                  }
	            	  return list;
			}} catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		return null;
	}

	public boolean setCredit(String clientID, int recharge) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn=DataBaseInit.getConnection();
		try{
			 Statement stat = conn.createStatement();
	            ResultSet count1 = stat.executeQuery("select credit from client  where  clientID='"+clientID+"'");

	              //如果用户名存在,开始进行信用值修改
	              if(count1.next()){
	                //    取出该用户名对应的信用值并计算出更新后的信用值
	            	  int k=count1.getInt("credit")+recharge;
            	  String c=""+k;
               int i= stat.executeUpdate("update client set credit="+c+" where clientID='"+clientID+"'" );

                 if(i==1){
                 //如果该更新操作成功，返回true
                  System.out.println("SUCCESS UPDATE CREDIT");
                  return true;
                  }

              }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");
		return false;
	}

	public ClientPO findPersonalInfo(String clientID) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn=DataBaseInit.getConnection();
		try{
			 Statement stat = conn.createStatement();
	         ResultSet count1 = stat.executeQuery("select * from client  where  clientID='"+clientID+"'");

	              //如果用户名存在,开始进行信息提取
	              if(count1.next()){
	            	  ClientPO po=new ClientPO();
	                //    取出该用户名对应的信息
	            	  po.setID(count1.getString("clientID"));
	            	  po.setPassword(count1.getString("password"));
	            	  po.setName(count1.getString("name"));
	            	  po.setTel(count1.getString("tel"));
	            	  switch(count1.getString("type").charAt(0)){
	            	  case 'N':po.setType(null);break;
	            	  case 'O':po.setType(VIPType.ORDINARYVIP);break;
	            	  case 'E':po.setType(VIPType.ENTERPRISEVIP);break;
	            	  default:po.setType(null);break;
	            	  }
	            	  po.setBirth(count1.getString("birth"));
	            	  po.setLevel(count1.getInt("level"));
	            	  po.setFirm(count1.getString("firm"));
	            	  po.setCredit(count1.getInt("credit"));
	            	  ArrayList<String> list=new ArrayList<String>();
	            	  list.add(" ");
	            	  if(findCreditRecord(clientID)!=null)
	            	  po.setRecord(findCreditRecord(clientID));
	            	  else
	            		  po.setRecord(list);
	            	  return po;
	              }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");

		return null;
	}

	public ResultMessage modifyPersonalInfo(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn=DataBaseInit.getConnection();
		try{
			 Statement stat = conn.createStatement();
	            ResultSet count1 = stat.executeQuery("select credit from client  where  clientID='"+po.getID()+"'");

	              //如果用户名存在,开始进行信息修改
	              if(count1.next()){
	            	  int i= stat.executeUpdate("UPDATE `HRMS`.`client` SET `name`='"+po.getName()+"', `tel`='"+po.getTel()+"', `level`='"+po.getLevel()+"', `type`='"+po.getType().toString()+"', `birth`='"+po.getBirth()+"', `password`='"+po.getPassword()+"', `credit`='"+po.getCredit()+"', `firm`='"+po.getFirm()+"' WHERE `clientID`='"+po.getID()+"'" );

                 if(i==1){
                 //如果该更新操作成功，返回true
                  System.out.println("SUCCESS UPDATE CREDIT");
                  return ResultMessage.SUCCESS;
                  }

              }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");
		return ResultMessage.FAIL;
	}

	public boolean checkAccount(String client_id, String password) throws RemoteException {
		// TODO Auto-generated method stub

		Connection conn=DataBaseInit.getConnection();

		try{
			Statement stat = conn.createStatement();
            ResultSet count1 = stat.executeQuery("select clientID from client  where  clientID='"+client_id+"'");
              //如果用户名存在，验证该用户名的密码
              if(count1.next()){
                //    取出该用户名对应的密码
                ResultSet count2 = stat.executeQuery   ("select password from client   where clientID='"+client_id+"'" );

                 if(count2.next()){
                 //如果该用户对应的密码与输入的密码相等，说明验证通过
                  if(count2.getString("password").equals(password)){
                	  	return true;
                   }

                  }

              }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");
		return false;
	}
	//先等弄清楚
	public boolean setAllLevel() throws RemoteException {
		// TODO Auto-generated method stub

		return false;
	}

	public boolean createClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn=DataBaseInit.getConnection();
		try{
			Statement stat = conn.createStatement();
            ResultSet count= stat.executeQuery("select clientID from client  where  clientID='"+po.getID()+"'");
            //用户没重名就注册
            if(!count.next()){
            int res = stat.executeUpdate("INSERT INTO `HRMS`.`client` (`clientID`, `password`,`type`) VALUES ('"+po.getID()+"', '"+po.getPassword()+"', '"+"NONVIP"+"')");
            boolean res0=stat.execute("CREATE TABLE `HRMS`.`"+po.getID()+"` (`ID` INT NOT NULL AUTO_INCREMENT,`date` VARCHAR(45) NULL,`reason` VARCHAR(45) NULL,`recharge` INT NULL,PRIMARY KEY (`ID`))");
            if(res==1)
            	return true;
            System.out.println("OK");
            }

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");
		return false;
	}
	public boolean deleteClient(String clientId)throws RemoteException{
		Connection conn=DataBaseInit.getConnection();
		try{
			Statement stat = conn.createStatement();
            ResultSet count= stat.executeQuery("select clientID from client  where  clientID='"+clientId+"'");
            //用户存在就进行删除
            if(count.next()){
            boolean res = stat.execute("DELETE FROM `HRMS`.`client` WHERE `clientID`='"+clientId+"'");
            if(!res)
            	return true;
            System.out.println("OK");
            }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("OK!");
		return false;
	}
}
