package runner;

import java.rmi.RemoteException;
import java.util.ArrayList;


import impl.mysql.ClientDataServiceMySqlImpl;
import po.ClientPO;


public class ClientTest {
	// ClientDataServiceMySqlImpl  findCreditRecord
			void test1(){
				ClientDataServiceMySqlImpl c;
				ArrayList<String> creditlist=new ArrayList<String>();
				try {
					c = new ClientDataServiceMySqlImpl();
					creditlist=c.findCreditRecord("C00000001");
				} catch (RemoteException e) {
					e.printStackTrace();
				}
				for(int i=0;i<creditlist.size();i++)
				System.out.println(creditlist.get(i));

			}
			// ClientDataServiceMySqlImpl  setCredit
			void test2(){
				ClientDataServiceMySqlImpl c;
				boolean res=false;
				try {
					c = new ClientDataServiceMySqlImpl();
					res=c.setCredit("C00000001",0,"","");
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				System.out.println(res);
			}
			// ClientDataServiceMySqlImpl  findPersonalInfo
			void test3(){
				ClientDataServiceMySqlImpl c;
				ClientPO po=null;
				try {
					c = new ClientDataServiceMySqlImpl();
					po=c.findPersonalInfo("C00000001");
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				System.out.println(po.getTel());
			}
			// ClientDataServiceMySqlImpl checkAccount
			void test4(){
				ClientDataServiceMySqlImpl c;
				boolean res=false;
				try {
					c = new ClientDataServiceMySqlImpl();
					res=c.checkAccount("C00000001","000000");
				} catch (RemoteException e) {
					e.printStackTrace();
				}

				System.out.println(res);
			}

}
