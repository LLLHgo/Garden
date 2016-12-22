package impl.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import dataservice.hotelinfodataservice.HotelinfoDataService;
import po.HotelinfoPO;
import po.RoominfoPO;

public class HotelinfoDataServiceTxtImpl{

	public HotelinfoDataServiceTxtImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public String[] getArea() {
		BufferedReader br = null;
		String data = "";
		String[] areas = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resources/txt/Area.txt")));
			while((data = br.readLine())!=null)
			{
				areas = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return areas;
	}

	public boolean addArea(String area) {
		if(area==null||area.equals("")){
			return false;
		}
		String[] areas = getArea();
		int flag = 0;
		for(int i=0;i<areas.length;i++){
			if(area.equals(areas[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		String data = "";
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resources/txt/Area.txt"),true));
			bw.write(","+area);	
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public String[] getRoomType() {
		BufferedReader br = null;
		String data = "";
		String[] roomtypes = null;
		try {
			br = new BufferedReader(new FileReader(new File("./src/main/resources/txt/RoomType.txt")));
			while((data = br.readLine())!=null)
			{
				roomtypes = data.split(",");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return roomtypes;
	}
	

	public boolean addRoomType(String type) {
		if(type==null||type.equals("")){
			return false;
		}
		String[] roomtypes = getRoomType();
		int flag = 0;
		for(int i=0;i<roomtypes.length;i++){
			if(type.equals(roomtypes[i])){
				flag = 1;
			}
		}
		if(flag == 1){
			return false;
		}
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(
					new File("./src/main/resources/txt/RoomType.txt"),true));
			bw.write(","+type);	
			bw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public void finish() throws RemoteException {
		// TODO Auto-generated method stub
	}
}
