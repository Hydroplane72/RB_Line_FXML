package model_dbo.Ticket;

import static org.junit.Assert.*;

import org.junit.Test;

import java.time.*;



import dbo.Ticket;

public class CreateTicketTest {


	@Test
	public void TicketDefaultCreateTest() {
		Ticket t = new Ticket();
		/*
		 * ServerID = 0;
		tablenum = 0;
		Ticket_ID = 0;
		Time_in = null;
		Time_out = null;
		 */
		assertEquals(0, t.getServerID());
		assertEquals(0, t.getTablenum());
		assertEquals(0, t.getTicket_ID());
		assertEquals(null, t.getTime_in());
		assertEquals(null, t.getTime_out());
	}
	@Test
	public void TicketCreateTest()
	{
		
		LocalDateTime t;
		t = LocalDateTime.of(2001, 10, 2, 2, 30,30);
		Ticket ti = new Ticket(1,1,t,t);
		assertEquals(1, ti.getServerID());
		assertEquals(1, ti.getTablenum());
		assertEquals(0, ti.getTicket_ID());
		assertEquals(t, ti.getTime_in());
		assertEquals(t, ti.getTime_out());
		
	}

}
