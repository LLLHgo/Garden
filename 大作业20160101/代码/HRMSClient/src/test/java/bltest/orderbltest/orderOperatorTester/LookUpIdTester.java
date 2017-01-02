package bltest.orderbltest.orderOperatorTester;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import businesslogic.orderbl.OrderOperator;
/**
 * order模块的bl层lookUpId方法的测试
 * @author yilu
 *
 */
public class LookUpIdTester {
	
	OrderOperator orderOperator;

	public LookUpIdTester(){
		orderOperator=new OrderOperator();
	}
	@Test
	public void test() {
		assertEquals("000000105",orderOperator.lookUpIdinDatabase());
	}

}
