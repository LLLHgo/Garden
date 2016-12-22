package runner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.orderbl.OrderFind;
import po.OrderPO;
import po.SitemanagerPO;
import presentation.MainFrame;
import rmi.RemoteHelper;
import vo.orderVO.OrderVO;

public class ClientRunner {
	private RemoteHelper remoteHelper;
	
	public ClientRunner() {
		
		try {
			linkToServer();
		} catch (MalformedURLException e) {
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
		
		initGUI();
	}
	
	private void linkToServer() throws MalformedURLException, NotBoundException {
		remoteHelper = RemoteHelper.getInstance();
		//remoteHelper.init();
		System.out.println("linked");
	}
	private void initGUI() {
		@SuppressWarnings("unused")
		MainFrame mainFrame = new MainFrame();
	}
	
	public void test2(){
		ArrayList<OrderVO>list=new ArrayList<OrderVO>();
		OrderFind f=new OrderFind();
		list=f.findUserOrderList("H00000001");
		if(list!=null){
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getOrderType());
			}
		}
	}
	
	public static void main(String[] args){
		ClientRunner clientRunner = new ClientRunner();
		//clientRunner.test2();
	}
}
