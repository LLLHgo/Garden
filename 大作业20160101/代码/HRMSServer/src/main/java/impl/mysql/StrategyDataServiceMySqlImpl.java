package impl.mysql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import Enum.HotelStrategy;
import Enum.MarketingStrategy;
import Enum.ResultMessage;
import Enum.VIPType;
import dataservice.strategydataservice.StrategyDataService;
import initial.DataBaseInit;
import po.StrategyPO.HotelBirthdayPO;
import po.StrategyPO.HotelCompanyPO;
import po.StrategyPO.HotelCreatedPO;
import po.StrategyPO.HotelOverThreeRoomsPO;
import po.StrategyPO.HotelSpecialdayPO;
import po.StrategyPO.HotelStrategyPO;
import po.StrategyPO.MarketingCreatedPO;
import po.StrategyPO.MarketingPeriodPO;
import po.StrategyPO.MarketingSpecialPO;
import po.StrategyPO.MarketingStrategyPO;
import po.StrategyPO.StrategyPO;

public class StrategyDataServiceMySqlImpl extends UnicastRemoteObject implements StrategyDataService{
	public StrategyDataServiceMySqlImpl() throws RemoteException {
		super();
	}

	private static final long serialVersionUID = 1L;

	public ResultMessage addMarketingStrategy(MarketingStrategyPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String start=sdf.format(po.getStartTime().getTime());
		String end=sdf.format(po.getEndTime().getTime());
		Statement stmt;
		try{
			stmt=conn.createStatement();
			String sql="";

			sql="SELECT * FROM MarketingStrategy WHERE name='" +po.getName()+ "'";
			ResultSet re=stmt.executeQuery(sql);
			while(re.next()){
				return ResultMessage.DUPLICATESTRATEGY;
			}

			if(po.getMarketingStrategyType().equals(MarketingStrategy.PERIOD))
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,discount)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+((MarketingPeriodPO)po).getDiscount()+"')";
			else if(po.getMarketingStrategyType().equals(MarketingStrategy.VIPSPECIAL)){
				MarketingSpecialPO sp=(MarketingSpecialPO)po;
				String levels="";
				String discounts="";
				for(int l:sp.getLevels()){
					levels=levels+l+"-";
				}
				for(double d:sp.getDiscounts()){
					discounts=discounts+d+"-";
				}
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,area,levels,discounts)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+sp.getBusinessDistrict()+"','"+levels+"','"+discounts+"')";

			}else if(po.getMarketingStrategyType().equals(MarketingStrategy.CREATED)){
				MarketingCreatedPO cp=(MarketingCreatedPO)po;
				String hotels="";
				for(String h:cp.getHotels()){
					hotels=hotels+h+"-";
				}
				String viptypes="";
				for(VIPType v:cp.getViptypes()){
					viptypes=viptypes+v+"-";
				}
				sql="INSERT INTO MarketingStrategy(name,type,starttime,endtime,discount,hotels,minSum,minRooms,minLevel,viptypes)VALUES('"+po.getName()+"','"+po.getMarketingStrategyType()+"','"+start+"','"+end+"','"+cp.getDiscount()+"','"+hotels+"','"+cp.getMinSum()+"','"+cp.getMinRooms()+"','"+cp.getLevels()+"','"+viptypes+"')";
			}else
				return ResultMessage.FAIL;
			int rs = stmt.executeUpdate(sql);
			if(rs>0)
				return ResultMessage.SUCCESS;
			else
				return ResultMessage.FAIL;

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return ResultMessage.SQLERROR;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return ResultMessage.CLASSFORNAME;
		}
	}

	public List<StrategyPO> getMarketingStrategy() throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		List<StrategyPO> list=new ArrayList<StrategyPO>();
		try{
			stmt=conn.createStatement();
			String sql="";

			sql="SELECT * FROM MarketingStrategy";
			ResultSet rs=stmt.executeQuery(sql);

			while(rs.next()){
				String name=rs.getString("name");
				String type=rs.getString("type");
				String st=rs.getString("starttime");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=sdf.parse(st);
				Calendar start=Calendar.getInstance();
				start.setTime(date);

				String en=rs.getString("endtime");
				date=sdf.parse(en);
				Calendar end=Calendar.getInstance();
				end.setTime(date);

				if(type.equals("PERIOD")){
					MarketingPeriodPO po=new MarketingPeriodPO(name,start,end,rs.getDouble("discount"));
					list.add(po);
				}else if(type.equals("VIPSPECIAL")){
					String[] l=rs.getString("levels").split("-");
					int[] levels=new int[l.length];
					int index=0;
					for(String s:l){
						levels[index++]=Integer.parseInt(s);
					}

					String[] d=rs.getString("discounts").split("-");
					double[] discounts=new double[d.length];
					index=0;
					for(String s:d){
						discounts[index++]=Double.parseDouble(s);
					}

					MarketingSpecialPO po=new MarketingSpecialPO(name,start,end,rs.getString("area"),levels,discounts);
					list.add(po);
				}else if(type.equals("CREATED")){
					String[] h=rs.getString("hotels").split("-");
					List<String> hotels=new ArrayList<String>();
					for(String s:h){
						hotels.add(s);
					}

					String[] v=rs.getString("viptypes").split("-");
					List<VIPType> viptypes=new ArrayList<VIPType>();
					for(String s:v){
						if(s.equals("ENTERPRISEVIP"))
							viptypes.add(VIPType.ENTERPRISEVIP);
						else if(s.equals("ORDINARYVIP"))
							viptypes.add(VIPType.ORDINARYVIP);
					}
					MarketingCreatedPO po=new MarketingCreatedPO(name,start,end,rs.getDouble("discount"),hotels,rs.getDouble("minSum"),rs.getInt("minRooms"),rs.getInt("minLevel"),viptypes);
					list.add(po);
				}
			}
		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return null;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return null;
		}
		return list;
	}


	public boolean deleteMarketingStrategy(String marketingStrategy) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		try{
			stmt=conn.createStatement();
			String sql="DELETE FROM MarketingStrategy WHERE name='" +marketingStrategy+ "'";
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

	public List<StrategyPO> getHotelStrategy(String hotelID) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		Statement stmt;
		String sql="SELECT * FROM HotelStrategy WHERE hotelID='"+hotelID+ "'";
		List<StrategyPO> pos=new ArrayList<StrategyPO>();
		try{
			stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				String type=rs.getString("type");
				String name=rs.getString("name");
				String st=rs.getString("starttime");
				double discount=rs.getDouble("discount");
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				Date date=sdf.parse(st);
				Calendar start=Calendar.getInstance();
				start.setTime(date);

				String en=rs.getString("endtime");
				date=sdf.parse(en);
				Calendar end=Calendar.getInstance();
				end.setTime(date);

				if(type.equals("BIRTHDAY")){
					HotelBirthdayPO po=new HotelBirthdayPO(name,start,end,hotelID,discount);
					pos.add(po);
				}else if(type.equals("COMPANY")){
					HotelCompanyPO po=new HotelCompanyPO(name,start,end,hotelID,discount);
					pos.add(po);
				}else if(type.equals("SPECIALDAY")){
					HotelSpecialdayPO po=new HotelSpecialdayPO(name,start,end,hotelID,discount);
					pos.add(po);
				}else if(type.equals("OVERTHREEROOMS")){
					int minRooms=rs.getInt("minRooms");
					HotelOverThreeRoomsPO po=new HotelOverThreeRoomsPO(name,start,end,hotelID,discount,minRooms);
					pos.add(po);
				}else if(type.equals("CREATED")){
					int minLevel=rs.getInt("minLevel");
					int minRooms=rs.getInt("minRooms");
					double minSum=rs.getDouble("minSum");
					String[] v=rs.getString("viptypes").split("-");
					List<VIPType> viptypes=new ArrayList<VIPType>();
					for(String s:v){
						if(s.equals("ORDINARYVIP"))
							viptypes.add(VIPType.ORDINARYVIP);
						else if(s.equals("ENTERPRISEVIP"))
							viptypes.add(VIPType.ENTERPRISEVIP);
					}
					HotelCreatedPO po=new HotelCreatedPO(name,start,end,hotelID,discount,viptypes,minRooms,minSum,minLevel);
					pos.add(po);
				}
			}

		}catch(SQLException se){
			// 处理 JDBC 错误
			se.printStackTrace();
			return null;
		}catch(Exception e){
			// 处理 Class.forName 错误
			e.printStackTrace();
			return null;
		}

		return pos;
	}

	public boolean updateHotelStrategy(HotelStrategyPO po) throws RemoteException {
		Connection conn=DataBaseInit.getConnection();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String type=po.getHotelStrategy().toString();
		String start=sdf.format(po.getStartTime().getTime());
		String end=sdf.format(po.getEndTime().getTime());
		String name=po.getName();
		String hotelID=po.getHotelID();
		double discount=po.getDiscount();
		Statement stmt;

		String insertSql = "";
		if(type.equals("BIRTHDAY")||type.equals("COMPANY")||type.equals("SPECIALDAY")){
			insertSql="INSERT INTO HotelStrategy(name,type,starttime,endtime,hotelID,discount)VALUES('"+name+"','"+po.getHotelStrategy()+"','"+start+"','"+end+"','"+hotelID+"','"+discount+"')";
		}else if(type.equals("OVERTHREEROOMS")){
			insertSql="INSERT INTO HotelStrategy(name,type,starttime,endtime,hotelID,discount,minRooms)VALUES('"+name+"','"+HotelStrategy.OVERTHREEROOMS+"','"+start+"','"+end+"','"+hotelID+"','"+discount+"','"+((HotelOverThreeRoomsPO) po).getMinRooms()+"')";
		}else if(type.equals("CREATED")){
			HotelCreatedPO cp=(HotelCreatedPO)po;
			String vip="";
			List<VIPType> viptypes=cp.getViptypes();
			for(VIPType v:viptypes){
				vip=vip+v.toString()+"-";
			}
			int minRooms=cp.getMinRooms();
			double minSum=cp.getMinSum();
			int minLevel=cp.getLevels();
			insertSql="INSERT INTO HotelStrategy(name,type,starttime,endtime,hotelID,discount,viptypes,minRooms,minSum,minLevel)VALUES('"+name+"','"+HotelStrategy.CREATED+"','"+start+"','"+end+"','"+hotelID+"','"+discount+"','"+vip+"','"+minRooms+"','"+minSum+"','"+minLevel+"')";
		}else{
			return false;
		}

		try{
			stmt=conn.createStatement();
			String sql="SELECT * FROM HotelStrategy WHERE name='"+name+"' AND hotelID='"+hotelID+"'";
			ResultSet rs=stmt.executeQuery(sql);
			while(rs.next()){
				sql="DELETE  FROM HotelStrategy WHERE name='"+name+"' AND hotelID='"+hotelID+"'";
				int delete=stmt.executeUpdate(sql);
				if(delete<=0)
					return false;
				break;
			}
			int res=stmt.executeUpdate(insertSql);
			if(res>0)
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

}























