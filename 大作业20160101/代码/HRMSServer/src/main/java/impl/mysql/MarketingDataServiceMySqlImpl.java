package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dataservice.marketingdataservice.MarketingDataService;
import initial.DataBaseInit;
import po.LevelPO;
import po.MarketingPO;
/**
 * 浏览订单界面类
 * @author ClaraLee
 *
 */
public class MarketingDataServiceMySqlImpl extends UnicastRemoteObject implements MarketingDataService{

	private static final long serialVersionUID = 1L;

	public MarketingDataServiceMySqlImpl() throws RemoteException {
		super();
	}

	public List<LevelPO> findAllLevel() throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		List<LevelPO> pos=new ArrayList<LevelPO>();
		try{
			stmt=conn.createStatement();
			String sql;
			sql = "SELECT * FROM Level ORDER BY level";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				// 展开结果集数据库
				int level=rs.getInt("level");
				String name= rs.getString("name");
				int credit=rs.getInt("credit");
				double discount=rs.getDouble("discount");
				LevelPO po=new LevelPO(level,name,credit,discount);
				pos.add(po);
			}
		}catch(SQLException se){
			// 处理 JDBC 错误
			return null;
		}catch(Exception e){
			// 处理 Class.forName 错误
			return null;
		}
		return pos;
	}

	public MarketingPO getInfo(String id) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		MarketingPO po=null;
		try{
			stmt=conn.createStatement();
			String sql;
			sql = "SELECT * FROM MarketingProfile WHERE MarketingID='"+id+"'";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				// 展开结果集数据库
				String name=rs.getString("name");
				String passwordfromDatabase = rs.getString("password");
				String password  = "";
				for(int i=0;i<passwordfromDatabase.length();i++){
					char c = (char) (passwordfromDatabase.charAt(i)-1);
					password+=c;
				}
				String tel=rs.getString("tel");
				po=new MarketingPO(name,password,id,tel);
				return po;
			}
			return null;
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return null;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return null;
		}

	}

	public boolean checkAccount(String ID, String password) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		boolean res = false;
		try{
			stmt=conn.createStatement();
			String sql;

			String newpassword  = "";
			for(int i=0;i<password.length();i++){
				char c = (char) (password.charAt(i)+1);
				newpassword+=c;
			}
			sql = "SELECT * FROM MarketingProfile WHERE MarketingID='"+ID+"' AND password='"+newpassword+"'";
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()){
				// 展开结果集数据库
					return true;
			}
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
		}
		return res;
	}


	public boolean updateLevel(List<LevelPO> pos) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		boolean res = true;
		try{
			stmt=conn.createStatement();
			String sql;
			//先删除原先的数据
			sql="DELETE FROM Level";
			stmt.executeUpdate(sql);
			//插入新的level数据
			for(LevelPO po:pos){
				sql="INSERT INTO  Level(level,name,credit,discount)VALUES ('"+po.getLevel()+"','"+po.getName()+"','"+po.getCreditNeeded()+"','"+po.getDiscount()+"')";
				stmt.executeUpdate(sql);
			}
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return false;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return false;
		}
		return res;
	}


	public boolean MarketingAccountUpdate(MarketingPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		try{
			stmt=conn.createStatement();
			String sql;
			String passwrodfromUI = po.getPassword();
			String passwordtoDatabase = "";
			for(int i=0;i<passwrodfromUI.length();i++){
				char c = (char) (passwrodfromUI.charAt(i)+1);
				passwordtoDatabase+=c;
			}
			sql="UPDATE MarketingProfile SET name='"+po.getName()+"',password='"+passwordtoDatabase+"',tel='"+po.getTelephone()+"' WHERE MarketingID='"+po.getMarketingID()+"'";
			int rs=stmt.executeUpdate(sql);
			if(rs>0)
				return true;
			else
				return false;
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return false;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return false;
		}
	}


	public boolean MarketingAccountAdd(MarketingPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		boolean res = true;
		try{
			stmt=conn.createStatement();
			String sql;
			sql="SELECT  MAX(id) FROM MarketingProfile";
			ResultSet rs=stmt.executeQuery(sql);
			int max=0;
			while(rs.next()){
				max=rs.getInt(1);
			}
			max++;
			String MarketingID="M"+String.format("%08d", max);
			String passwrodfromUI = po.getPassword();
			String passwordtoDatabase = "";
			for(int i=0;i<passwrodfromUI.length();i++){
				char c = (char) (passwrodfromUI.charAt(i)+1);
				passwordtoDatabase+=c;
			}
			sql="INSERT INTO MarketingProfile (id,name,MarketingID,password,tel)VALUES ('"+max+"','"+po.getName()+"','"+MarketingID+"','"+passwordtoDatabase+"','"+po.getTelephone()+"')";
			stmt.executeUpdate(sql);

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return false;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return false;
		}
		return res;
	}


	public boolean MarketingAccountDelete(MarketingPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		try{
			stmt=conn.createStatement();
			String sql;
			sql="DELETE FROM MarketingProfile WHERE MarketingID='"+po.getMarketingID()+"'";
			int rs=stmt.executeUpdate(sql);
			if(rs>0)
				return true;
			else
				return false;
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return false;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return false;
		}
	}

	public String getMarketingID() throws RemoteException{
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		String id="";
		int max=0;
		try{
			stmt=conn.createStatement();
			String sql;
			sql="SELECT  MAX(id) FROM MarketingProfile";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				max=rs.getInt(1);
			}
			sql="SELECT * FROM MarketingProfile WHERE id='"+max+"'";
			ResultSet r=stmt.executeQuery(sql);
			while(r.next()){
				id=r.getString("MarketingID");
				if(id==null)
					return "";
				return id;
			}

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return "";
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return "";
		}
		return id;
	}

}
