package model_dbo.Ticket;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDateTime;


import dbo.Ticket;

public class TicketNotNullTests {
	Ticket t;
	@Before
	public void setUp() throws Exception {
		t = new Ticket();
	}

	@Test
	public void NullNNTest(){
		assertEquals(false, t.IsNotNull());
	}
	@Test
	public void SIdNNTest()
	{
		t.setServerID(1);
		assertEquals(true, t.IsNotNull());
	}
	@Test
	public void tableNNTest()
	{
		t.setTablenum(1);
		assertEquals(true, t.IsNotNull());
	}
	@Test
	public void TIdNNTest()
	{
		t.setTicket_ID(1);
		assertEquals(true, t.IsNotNull());
	}
	@Test
	public void TimeInNNTest()
	{
		LocalDateTime ti;
		ti = LocalDateTime.of(2001, 10, 2, 2, 30,30);
		t.setTime_in(ti);
		assertEquals(true, t.IsNotNull());
	}
	@Test
	public void TimeOutNNTest()
	{
		LocalDateTime ti;
		ti = LocalDateTime.of(2001, 10, 2, 2, 30,30);
		t.setTime_out(ti);
		assertEquals(true, t.IsNotNull());
	}
	

}
