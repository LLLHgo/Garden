package impl.txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import dataservice.logdataservice.LogDataService;
import po.LogPO;

public class LogDataServiceTxtImpl extends UnicastRemoteObject implements LogDataService{
	
	private static final long serialVersionUID = 1L;
	File file;
	String fileName;
	FileReader fileReader;
	BufferedReader bfReader;
	ArrayList<LogPO> listPO;
	InputStreamReader reader;

	public LogDataServiceTxtImpl() throws RemoteException {
		super();
		listPO=new ArrayList<LogPO>();
		fileName="src/main/resources/txt/Log.txt";
		try {
			bfReader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		file=new File(fileName);
	}


	public ArrayList<LogPO> getLogList() throws RemoteException {
		// TODO Auto-generated method stub
		String logInfo="";
		LogPO logPO=null;
		try {
			while((logInfo = bfReader.readLine())!=null){
				logPO=new LogPO(logInfo);
				listPO.add(logPO);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listPO;
	}


	public boolean addLog(LogPO logPO) throws RemoteException {
		
		try {
			BufferedWriter out = new BufferedWriter(new FileWriter(fileName,true));
			out.write(logPO.getLogInfo()+"\r\n");
			out.flush();
			out.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}  
			
		return false;
	}

}
