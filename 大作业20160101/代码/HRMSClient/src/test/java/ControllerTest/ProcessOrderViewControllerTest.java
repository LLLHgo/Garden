package ControllerTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import Enum.ResultMessage;
import Mock.MockLogManage;
/**
 *订单界面的controller测试（后来没有该controller）
 * @author yilu
 *
 */

public class ProcessOrderViewControllerTest {
	ResultMessage result;
	String logInfo;
	
	@Before
	public void setup(){
		result=ResultMessage.SUCCESS;
		logInfo="";
	}
	MockLogManage logManageMock=new MockLogManage();
	
	@Test
	public void addLogTest() {
		assertEquals(result,logManageMock.addLog(logInfo));
	}

}
