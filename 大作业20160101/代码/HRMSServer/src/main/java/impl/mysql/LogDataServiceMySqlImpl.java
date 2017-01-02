package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataservice.logdataservice.LogDataService;
import initial.DataBaseInit;
import po.LogPO;
/*
 * 日志的数据库实现
 */
public class LogDataServiceMySqlImpl extends UnicastRemoteObject  implements LogDataService{
	private static final long serialVersionUID = 1L;
	Statement stmt;
	Connection conn;
	
	
	public LogDataServiceMySqlImpl() throws RemoteException{
		super();
		conn=DataBaseInit.getConnection();
	}

	public ArrayList<LogPO> getLogList() throws RemoteException {
		ArrayList<LogPO> list=new ArrayList<LogPO>();
		ResultSet rs = null;
		String sql = "SELECT info FROM log";
		try {
			stmt=conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				// 通过字段检索
				String info  = rs.getString("info");
				LogPO po=new LogPO(info);
				list.add(po);
			}
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	// 增加日志条目
	public boolean addLog(LogPO logPo) throws RemoteException {
		String logInfo=logPo.getLogInfo();
		String sql = "INSERT INTO log (info) VALUES ('"+logInfo+"')";
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	
}
