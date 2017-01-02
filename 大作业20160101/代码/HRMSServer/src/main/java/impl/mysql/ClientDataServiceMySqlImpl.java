package impl.mysql;

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
/**
 * 客户的数据操作的实现
 * @author ClaraLee
 *
 */
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

	public boolean setCredit(String clientID, int recharge,String date,String reason) throws RemoteException {
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

                  }
                 int ress = stat.executeUpdate("INSERT INTO `HRMS`.`"+clientID+"` (`date`, `reason`,`recharge`) VALUES ('"+date+"', '"+reason+"', '"+recharge+"')");
                 if(ress==1){
                     //如果该更新操作成功，返回true
                      System.out.println("SUCCESS INCREATE CREDIT RECORD");
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
	            	  String passbefore=count1.getString("password");
	            	  String pass="";
	            	  for(int i=0;i<passbefore.length();i++){
	            		  char c= passbefore.charAt(i);
	            		 c--;
	            		 pass+=c;
	            	  }
	            	  po.setPassword(pass);
	            	  po.setName(count1.getString("name"));
	            	  po.setTel(count1.getString("tel"));
	            	  switch(count1.getString("type").charAt(0)){
	            	  case 'N':po.setType(VIPType.NONVIP);break;
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
	            	  String passbefore=po.getPassword();
	            	  String pass="";
	            	  for(int i=0;i<passbefore.length();i++){
	            		  char c= passbefore.charAt(i);
	            		 c++;
	            		 pass+=c;
	            	  }
	            	  int i= stat.executeUpdate("UPDATE `HRMS`.`client` SET `name`='"+po.getName()+"', `tel`='"+po.getTel()+"', `level`='"+po.getLevel()+"', `type`='"+po.getType().toString()+"', `birth`='"+po.getBirth()+"', `password`='"+pass+"', `credit`='"+po.getCredit()+"', `firm`='"+po.getFirm()+"' WHERE `clientID`='"+po.getID()+"'" );

                 if(i==1){
                 //如果该更新操作成功，返回true
                  System.out.println("SUCCESS UPDATE CREDIT");
                  return ResultMessage.SUCCESS;
                  }

              }
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return ResultMessage.DATEBASEFAIL;
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
                	 String passbefore=password;
	            	  String pass="";
	            	  for(int i=0;i<passbefore.length();i++){
	            		  char c= passbefore.charAt(i);
	            		 c++;
	            		 pass+=c;
	            	  }
                  if(count2.getString("password").equals(pass)){
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


	public String createClient(ClientPO po) throws RemoteException {
		// TODO Auto-generated method stub
		Connection conn=DataBaseInit.getConnection();
		try{
			Statement stat = conn.createStatement();
            ResultSet count= stat.executeQuery("select clientID from client  where  tel='"+po.getTel()+"'");
            //用户没重名就注册
            if(!count.next()){
            	String passbefore=po.getPassword();
          	  String pass="";
          	  for(int i=0;i<passbefore.length();i++){
          		  char c= passbefore.charAt(i);
          		 c++;
          		 pass+=c;
          	  }
            int ress = stat.executeUpdate("INSERT INTO `HRMS`.`client` (`tel`, `password`,`type`) VALUES ('"+po.getTel()+"', '"+pass+"', '"+"NONVIP"+"')");
            int id=0;
            ResultSet count1= stat.executeQuery("select * from client  where  tel='"+po.getTel()+"'");
            if(count1.next())
             id=count1.getInt("ID");
            int i=0;
            for(;;i++)
            	if(id<Math.pow(10,i))
            		break;
            String clientID="C";
            for(int k=0;k<8-i;k++)
            	clientID+="0";
            	clientID+=id;
            	int c= stat.executeUpdate("UPDATE `HRMS`.`client` SET `clientID`='"+clientID+"' WHERE `ID`='"+id+"'");
            boolean res0=stat.execute("CREATE TABLE `HRMS`.`"+clientID+"` (`ID` INT NOT NULL AUTO_INCREMENT,`date` VARCHAR(45) NULL,`reason` VARCHAR(45) NULL,`recharge` INT NULL,PRIMARY KEY (`ID`))");
            if(ress==1)

            System.out.println("OK");
            return clientID;
            }


		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		System.out.println("Create OK!");
		return "Fail";
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
