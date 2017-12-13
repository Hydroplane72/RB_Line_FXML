package model_dbo.StationTickets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dbo.Station_Ticket;

public class STSetTests {
	Station_Ticket st;
	@Before
	public void setUp() throws Exception {
		st = new Station_Ticket();
	}

	@Test
	public void SetNegativeFoodID() {
		st.setFood_id(-1);
		assertEquals(0, st.getFood_id());
	}
	@Test
	public void SetNegativeSTT_ID()
	{
		st.setStt_id(-1);
		assertEquals(0, st.getStt_id());
	}
	@Test
	public void SetNegativeTicket_ID()
	{
		st.setTicket_id(-1);
		assertEquals(0, st.getTicket_id());
	}
	
	@Test
	public void SetPositiveFoodID() {
		st.setFood_id(10);
		assertEquals(10, st.getFood_id());
	}
	@Test
	public void SetPositiveSTT_ID()
	{
		st.setStt_id(10);
		assertEquals(10, st.getStt_id());
	}
	@Test
	public void SetPositiveTicket_ID()
	{
		st.setTicket_id(10);
		assertEquals(10, st.getTicket_id());
	}

}
