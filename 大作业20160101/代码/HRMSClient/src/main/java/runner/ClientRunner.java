package runner;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.hoteinfobl.Hotelinfo;
import businesslogic.orderbl.OrderCheck;
import businesslogic.orderbl.OrderFind;
import dataservice.orderdataservice.OrderDataService;
import presentation.MainFrame;
import rmi.RemoteHelper;
import vo.orderVO.OrderVO;
/**
 * 客户端的main
 * @author yilu
 *
 */
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
		OrderCheck o=new OrderCheck();
		boolean result = false;
			result=o.checkTimeOperateAbnormal();
		System.out.println(result);
	}

	public static void main(String[] args){
		ClientRunner clientRunner = new ClientRunner();
		//clientRunner.test2();
	}
}
