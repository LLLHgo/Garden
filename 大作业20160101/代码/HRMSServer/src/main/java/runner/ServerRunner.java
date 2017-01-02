package runner;


import initial.DataBaseInit;
import rmi.RemoteHelper;
/**
 * server的runner
 * @author yilu
 *
 */
public class ServerRunner {

	public ServerRunner(){
		new RemoteHelper();
	}


	public static void main(String[] args) {
		new DataBaseInit();
		ServerRunner s=new ServerRunner();
	}
}
