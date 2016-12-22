package bltest.orderbltest.orderFindTester;

import java.util.ArrayList;

import businesslogic.orderbl.OrderFind;
import vo.orderVO.OrderVO;

public class FindOther {
	public void test1(){
		ArrayList<OrderVO>list=new ArrayList<OrderVO>();
		OrderFind f=new OrderFind();
		list=f.findAbnormalOrderList("2016-12-02");
		System.out.println(list.get(0).orderId);
	}
	public void test2(){
		ArrayList<OrderVO>list=new ArrayList<OrderVO>();
		OrderFind f=new OrderFind();
		list=f.findUserOrderList("H00000001");
		if(list!=null){
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getClientName());
			}
		}
	}
	
}
