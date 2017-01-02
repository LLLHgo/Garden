package impl.mysql;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Enum.RoomState;
import Enum.Star;
import initial.DataBaseInit;
import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataServiceMySqlImpl{

	private static final long serialVersionUID = 1L;
	Connection conn;


	public HotelinfoDataServiceMySqlImpl() throws RemoteException {
		super();
		init();
	}

	public void init() throws RemoteException {
		conn = DataBaseInit.getConnection();
	}

//	public void init(){
//	String driver = "com.mysql.jdbc.Driver";
//	try {
//		Class.forName(driver);
//		System.out.println("驱动加载成功");
//	} catch (ClassNotFoundException e) {
//		e.printStackTrace();
//	}
//
//	String url= "jdbc:mysql://127.0.0.1:3306/hrms";
//	String user = "root";
//	String password = "DNc38XPbZnD8fDQU";
//	try {
//		conn = DriverManager.getConnection(url, user, password);
//		System.out.println("连接成功");
//	} catch (SQLException e) {
//		e.printStackTrace();
//	}
//}

	//如果查找失败，返回null
	public List<RoominfoPO> findRoominfoList(String hotelID) throws RemoteException {
		RoominfoPO po = null;
		ArrayList<RoominfoPO> list = new ArrayList<RoominfoPO>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from roominfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(hotelID.equals((String)myRS.getObject("hotelID"))){
					po = new RoominfoPO();
					po.setHotelID(hotelID);
					po.setPrice(myRS.getDouble("price"));
					po.setType(String.valueOf(myRS.getObject("type")));
					po.setRoomNum((String)myRS.getObject("roomID"));
					int state = (Integer)myRS.getObject("roomState");
					//0可用，1不可用
					if(state == 0){
						po.setRoomState(RoomState.Usable);
					}else{
						po.setRoomState(RoomState.Unusable);
					}
					list.add(po);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!list.isEmpty())
		return list;
		return null;
	}

	public HotelinfoPO findhotelinfo(String hotelID) throws RemoteException {
		int id = Integer.parseInt(hotelID.substring(1));
		HotelinfoPO po = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(id==(Integer)myRS.getObject("hotelID")){
					po = new HotelinfoPO();
					if(myRS.getObject("star")!=null){
					int star = (Integer)myRS.getObject("star");
					Star[] starList = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,
							Star.SIX,Star.SEVEN};
					for(int i=0;i<starList.length;i++){
						if(i==star){
							po.setStar(starList[i]);
							break;
						}
					}
					}
					ArrayList<String> companyList = new ArrayList<String>();
					String company =(String)myRS.getObject("company");
					if(company!=null){
					String[] companyArray = company.split("&");
					for(int i=0;i<companyArray.length;i++){
						companyList.add(companyArray[i]);
					}
					}
					ArrayList<String> remarkList = new ArrayList<String>();
					String remark =(String)myRS.getObject("remark");
					if(remark!=null){
					String[] remarkArray = remark.split("&");
					for(int i=0;i<remarkArray.length;i++){
						remarkList.add(remarkArray[i]);
					}
					}
					po.setHotelID(hotelID);
					po.setName((String)myRS.getObject("name"));
					po.setAddress((String)myRS.getObject("address"));
					po.setArea((String)myRS.getObject("area"));
					po.setTel((String)myRS.getObject("tel"));
					po.setCompanyList(companyList);
					po.setIntroduction((String)myRS.getObject("introduction"));
					po.setFacility((String)myRS.getObject("facility"));
					po.setRemark(remarkList);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<HotelinfoPO> clientfindhotelinfo(String area,String hotelname,int hotelstar) throws RemoteException {
		HotelinfoPO po = null;
		ArrayList<HotelinfoPO> list = new ArrayList<HotelinfoPO>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(area==null){
					break;
				}
				if(hotelname!=null){
					break;
				}
				if(area.equals((String)myRS.getObject("area"))){
					po = new HotelinfoPO();
					int star = (Integer)myRS.getObject("star");
					Star[] starList = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,
							Star.SIX,Star.SEVEN};
					for(int i=0;i<starList.length;i++){
						if(i==star){
							po.setStar(starList[i]);
							break;
						}
					}

					ArrayList<String> companyList = new ArrayList<String>();
					String company =(String)myRS.getObject("company");

					if(company!=null){
						String[] companyArray = company.split("&");
						for(int i=0;i<companyArray.length;i++){
							companyList.add(companyArray[i]);
						}
					}

					ArrayList<String> remarkList = new ArrayList<String>();
					String remark =(String)myRS.getObject("remark");

					if(remark!=null){
						String[] remarkArray = remark.split("&");
							for(int i=0;i<remarkArray.length;i++){
								remarkList.add(remarkArray[i]);
							}
					}

					int id = (Integer)myRS.getObject("hotelID");
					String hotelID = String.valueOf(id);
					while(hotelID.length()<8){
						hotelID = "0"+hotelID;
					}
					hotelID = "H"+hotelID;

					po.setHotelID(hotelID);
					po.setName((String)myRS.getObject("name"));
					po.setAddress((String)myRS.getObject("address"));
					po.setArea((String)myRS.getObject("area"));
					po.setTel((String)myRS.getObject("tel"));
					po.setCompanyList(companyList);
					po.setIntroduction((String)myRS.getObject("introduction"));
					po.setFacility((String)myRS.getObject("facility"));
					po.setRemark(remarkList);

					if(hotelstar == 0){
						list.add(po);
					}else if(star+1 == hotelstar){
						list.add(po);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		//根据酒店名字查询
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(hotelname==null||area == null){
					break;
				}
				if(hotelname.equals((String)myRS.getObject("name"))&&area.equals((String)myRS.getObject("area"))){
					po = new HotelinfoPO();
					int star = (Integer)myRS.getObject("star");
					Star[] starList = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,
							Star.SIX,Star.SEVEN};
					for(int i=0;i<starList.length;i++){
						if(i==star){
							po.setStar(starList[i]);
							break;
						}
					}

					ArrayList<String> companyList = new ArrayList<String>();
					String company =(String)myRS.getObject("company");
					//TODO
					if(company!=null){
						String[] companyArray = company.split("&");
						for(int i=0;i<companyArray.length;i++){
							companyList.add(companyArray[i]);
						}
					}
					ArrayList<String> remarkList = new ArrayList<String>();
					String remark =(String)myRS.getObject("remark");
					if(remark!=null){
						String[] remarkArray = remark.split("&");
							for(int i=0;i<remarkArray.length;i++){
								remarkList.add(remarkArray[i]);
							}
					}
					int id = (Integer)myRS.getObject("hotelID");
					String hotelID = String.valueOf(id);
					while(hotelID.length()<8){
						hotelID = "0"+hotelID;
					}
					hotelID = "H"+hotelID;

					po.setHotelID(hotelID);
					po.setName((String)myRS.getObject("name"));
					po.setAddress((String)myRS.getObject("address"));
					po.setArea((String)myRS.getObject("area"));
					po.setTel((String)myRS.getObject("tel"));
					po.setCompanyList(companyList);
					po.setIntroduction((String)myRS.getObject("introduction"));
					po.setFacility((String)myRS.getObject("facility"));
					po.setRemark(remarkList);

					if(hotelstar == 0){
						list.add(po);
					}else if(star+1 == hotelstar){
						list.add(po);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


		if(!list.isEmpty()){
			return list;
		}
		return null;
	}

	public boolean hotelstaffUpdatehotelinfo(HotelinfoPO po) throws RemoteException {
		int id = Integer.parseInt(po.getHotelID().substring(1));
		try {
			String sql = "update hotelinfo set "
					+ "name=?,address=?,area=?,tel=?,star=?,introduction=?,facility=?,company=?"
					+ " where hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			Star[] starArray={Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,
					Star.SIX,Star.SEVEN};
			int star=0;
			for(;star<7;star++){
				if(starArray[star]==po.getStar()){
					break;
				}
			}
			ArrayList<String> companyList = po.getCompanyList();
			String company = "";
			if(companyList.size()>=1){
				for(int i=0;i<companyList.size()-1;i++){
					company=company+companyList.get(i)+"&";
				}
				company=company+companyList.get(companyList.size()-1);
			}
			ps.setString(1, po.getName());
			ps.setString(2, po.getAddress());
			ps.setString(3, po.getArea());
			ps.setString(4, po.getTel());
			ps.setInt(5, star);
			ps.setString(6,po.getIntroduction());
			ps.setString(7,po.getFacility());
			ps.setString(8,company);
			ps.setInt(9,id);
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean clientupdatehotelinfo(String remark,String hotelID) throws RemoteException {
		int id = Integer.parseInt(hotelID.substring(1));
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			String str = "";
			while(myRS.next()){
				if(id==(Integer)myRS.getObject("hotelID")){
					str =(String)myRS.getObject("remark");
					}
				}
			if(str!=null)
				remark = str+"&"+remark;

			sql = "update hotelinfo set "
					+ "remark=?"
					+ " where hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, remark);
			ps.setInt(2,id);
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public boolean updateroominfo(RoominfoPO po) throws RemoteException {
		try {
			String sql = "update roominfo set "
					+ "type=?,price=?,roomState=?"
					+ " where roomID=? and hotelID=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			RoomState state = po.getRoomState();
			int intState=1;
			if(state==RoomState.Usable){
				intState=0;
			}
			ps.setString(1, po.getType());
			ps.setDouble(2, po.getPrice());
			ps.setInt(3, intState);
			ps.setString(4,po.getRoomNum());
			ps.setString(5, po.getHotelID());
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean insertRoominfo(RoominfoPO po){
		try {
			String sql = "insert into roominfo (hotelID,type,roomID,price,roomState)values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, po.getHotelID());
			System.out.println(po.getHotelID());
			ps.setString(2, po.getType());
			ps.setString(3, po.getRoomNum());
			ps.setDouble(4, po.getPrice());
			int state = 1;
			if(po.getRoomState()==RoomState.Usable){
				state = 0;
			}
			ps.setInt(5, state);
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public String insertHotelinfo(String hotelName){
		try {
			Statement st = conn.createStatement();
			String sql = "select count(*) from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			myRS.next();
			int count = myRS.getInt(1);

			int id = count+1;
			String hotelID = String.valueOf(id);
			while(hotelID.length()<8){
				hotelID = "0"+hotelID;
			}
			hotelID = "H"+hotelID;

			sql = "select * from hotelinfo";
			myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(myRS.getObject("name").equals(hotelName)){
					return "R";
				}
			}

			sql = "insert into hotelinfo (hotelID,name) values (?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, hotelName);
			int result = ps.executeUpdate();
			if(result>0){
				return hotelID;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "";
	}

	public RoominfoPO findroominfo(String hotelID,String roomID) throws RemoteException{
		RoominfoPO po = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from roominfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(hotelID.equals((String)myRS.getObject("hotelID"))
						&&roomID.equals((String)myRS.getObject("roomID"))){
					po = new RoominfoPO();
					po.setHotelID(hotelID);
					po.setRoomNum(roomID);
					po.setPrice((Double)myRS.getObject("price"));
					po.setType((String)myRS.getObject("type"));
					RoomState state = RoomState.Usable;
					if((Integer)myRS.getObject("state")==1){
						state = RoomState.Unusable;
					}
					po.setRoomState(state);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return po;
	}

	public ArrayList<HotelinfoPO> findHotelinfoList(String area) throws RemoteException{
		HotelinfoPO po = null;
		ArrayList<HotelinfoPO> list = new ArrayList<HotelinfoPO>();
		try {
			Statement st = conn.createStatement();
			String sql = "select * from hotelinfo";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(area.equals((String)myRS.getObject("area"))){
					po = new HotelinfoPO();
					int star = (Integer)myRS.getObject("star");
					Star[] starList = {Star.ONE,Star.TWO,Star.THREE,Star.FOUR,Star.FIVE,
							Star.SIX,Star.SEVEN};
					for(int i=0;i<starList.length;i++){
						if(i==star){
							po.setStar(starList[i]);
							break;
						}
					}

					ArrayList<String> companyList = new ArrayList<String>();
					String company =(String)myRS.getObject("company");
					//TODO
					if(company!=null){
						String[] companyArray = company.split("&");
						for(int i=0;i<companyArray.length;i++){
							companyList.add(companyArray[i]);
						}
					}
					ArrayList<String> remarkList = new ArrayList<String>();
					String remark =(String)myRS.getObject("remark");
			//		System.out.println(remark);
					if(remark!=null){
						String[] remarkArray = remark.split("&");
							for(int i=0;i<remarkArray.length;i++){
								remarkList.add(remarkArray[i]);
							}
					}
					int id = (Integer)myRS.getObject("hotelID");
					String hotelID = String.valueOf(id);
					while(hotelID.length()<8){
						hotelID = "0"+hotelID;
					}
					hotelID = "H"+hotelID;

					po.setHotelID(hotelID);
					po.setName((String)myRS.getObject("name"));
					po.setAddress((String)myRS.getObject("address"));
					po.setArea((String)myRS.getObject("area"));
					po.setTel((String)myRS.getObject("tel"));
					po.setCompanyList(companyList);
					po.setIntroduction((String)myRS.getObject("introduction"));
					po.setFacility((String)myRS.getObject("facility"));
					po.setRemark(remarkList);

					list.add(po);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(!list.isEmpty())
		return list;
		return null;
	}

	public boolean deleteroom(String hotelID,String roomID) throws RemoteException{
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "delete from roominfo where hotelID="+"'"+hotelID+"'"+" and roomID="+"'"+roomID+"'";
			int result = st.executeUpdate(sql);
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public String[] getArea() {
		String data = "";
		String[] areas = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from area";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				data +=","+myRS.getString("area");
			}
			data = data.substring(1);
			areas = data.split(",");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return areas;
	}


	public boolean addArea(String area) {
		if(area.equals("")||area==null){
			return false;
		}
		Statement st;
		try {
			st = conn.createStatement();
			String sql = "select * from area";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				if(myRS.getString("area").equals(area)){
					return false;
				}
			}
			sql = "insert into area (area) values (?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, area);
			int result = ps.executeUpdate();
			if(result>0){
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}


	public String[] getRoomType() {
		String data = "";
		String[] rooms = null;
		try {
			Statement st = conn.createStatement();
			String sql = "select * from roomType";
			ResultSet myRS = st.executeQuery(sql);
			while(myRS.next()){
				data +=","+myRS.getString("roomType");
			}
			data = data.substring(1);
			rooms = data.split(",");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rooms;
	}

	public boolean addRoomType(String type)throws RemoteException{
		return true;
	}


	public void finish() throws RemoteException {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}


}
