package bltest.logbltest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Enum.ResultMessage;
import businesslogic.logbl.LogManage;
/**
 * addLog方法的测试
 * @author yilu
 *
 */
public class AddLogTester {
	LogManage logManage;
	String logInfo1;
	String logInfo2;
	String logInfo3;
	String logInfo4;
	String logInfo5;
	String logInfo6;
	String logInfo7;
	String logInfo8;
	
	public AddLogTester(){
		logManage=new LogManage();
		logInfo1="S00000001 Mon May 04 09:51:52 CDT 2009 修改个人账户信息";
		logInfo2="S00000001 Mon May 04 09:51:52 CDT 2009";
		logInfo3="Mon May 04 09:51:52 CDT 2009 修改个人账户信息";
		logInfo4="S00000001 修改个人账户信息";
		logInfo5="M0000001 Mon May 04 09:51:52 CDT 2009 修改个人账户信息";
		logInfo6="R00000001 Mon May 04 09:51:52 CDT 2009 修改个人账户信息";
		logInfo7="R00wm0001 Mon May 04 09:51:52 CDT 2009 修改个人账户信息";
		logInfo8="";
		
	}

	@Test
	public void test1() {
		assertEquals(ResultMessage.SUCCESS,logManage.addLog(logInfo1));
	}
	
	@Test
	public void test2() {
		// 缺少操作记录
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo2));
	}
	
	@Test
	public void test3() {
		// 缺少帐号
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo3));
	}
	
	@Test
	public void test4() {
		// 缺少时间记录
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo4));
	}
	
	@Test
	public void test5() {
		// 帐号格式错误，帐号位数错误
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo5));
	}
	
	@Test
	public void test6() {
		// 帐号格式错误，第一个字符不合法
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo6));
	}
	
	@Test
	public void test7() {
		// 帐号格式错误，帐号2-8位中不全为数字
		assertEquals(ResultMessage.WRONGFORMAT,logManage.addLog(logInfo7));
	}
	
	@Test
	public void test8() {
		// 空的loginfo
		assertEquals(ResultMessage.VOIDINFO,logManage.addLog(logInfo8));
	}
	
	
	

}
