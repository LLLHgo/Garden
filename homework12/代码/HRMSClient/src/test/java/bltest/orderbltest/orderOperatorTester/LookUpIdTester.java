package bltest.orderbltest.orderOperatorTester;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.orderbl.OrderOperator;

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
