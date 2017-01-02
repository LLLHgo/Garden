package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import dataservice.sitemanagerdataservice.SitemanagerDataService;
import initial.DataBaseInit;
import po.SitemanagerPO;
/**
 * sitamanger的数据库实现
 * @author yilu
 *
 */
public class SitemanagerDataServiceMySqlImpl extends UnicastRemoteObject implements SitemanagerDataService{

	private static final long serialVersionUID = 1L;
	//DataFactoryMySqlImpl mysql = new DataFactoryMySqlImpl();;
	SitemanagerPO sitemanagerPO;
	String sql;
	ResultSet resultSet;

	String id;
	String tel;
	String password;

	Connection conn;
	Statement stmt;
	PreparedStatement preStatement;

	public SitemanagerDataServiceMySqlImpl() throws RemoteException{
		super();
		this.conn = DataBaseInit.getConnection();
	}


    public SitemanagerPO getAccount() throws RemoteException {
		// TODO Auto-generated method stub

    	sql="SELECT id, tel, password FROM sitemanager_account";
    	try {
    		if(conn==null){
    			System.out.println("null!");
    		}
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(sql);
			while(resultSet.next()){
				id  = resultSet.getString("id");
				tel = resultSet.getString("tel");
				password = resultSet.getString("password");
				// 从数据库读取密码时，各char值-1得到密码明文
				String passwordMing="";
				for(int i=0;i<password.length();i++){
					char c=password.charAt(i);
					c--;
					passwordMing+=c;
				}
				System.out.println(passwordMing);
				sitemanagerPO=new SitemanagerPO(id,tel,passwordMing);
	    		return sitemanagerPO;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    		return null;
	}


	public boolean SitemanagerAccountUpdate(SitemanagerPO sitemanagerPO) throws RemoteException {
		// TODO Auto-generated method stub
		String sql1="update sitemanager_account set tel=? where id=?";
		String sql2="update sitemanager_account set password=? where id=?";
		int row1=0;
		int row2=0;
		 try {
			 if(conn==null)
				 System.out.println("null!");
			preStatement = conn.prepareStatement(sql1);
			preStatement.setObject(1, sitemanagerPO.getSitemanagerPhoneNumber());
			preStatement.setObject(2, sitemanagerPO.getSitemanagerId());
			row1=preStatement.executeUpdate();

			preStatement = conn.prepareStatement(sql2);
			// 将更新的密码存入数据库时+1
			String passwordStoreToDataBase="";
			String passwordInPO=sitemanagerPO.getPassword();
			for(int i=0;i<passwordInPO.length();i++){
				char c=passwordInPO.charAt(i);
				c++;
				passwordStoreToDataBase+=c;
			}
			preStatement.setObject(1, passwordStoreToDataBase);
			preStatement.setObject(2, sitemanagerPO.getSitemanagerId());
			row2=preStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(row1!=0&&row2!=0)
			return true;
		else
			return false;
	}

}
