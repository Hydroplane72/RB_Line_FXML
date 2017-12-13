package model_dbo.StationTickets;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.sql.Date;



import dbo.Station_Ticket;

public class STNotNullTests {
	
	Station_Ticket st;
	@Before
	public void setUp() throws Exception {
		st = new Station_Ticket();
	}

	@Test
	public void NullNNTest() {
		assertEquals(false, st.IsNotNull());
	}
	@Test
	public void NNTestStt_id()
	{
		st.setStt_id(1);
		assertEquals(true, st.IsNotNull());
	}
	@Test
	public void NNTestTicket_ID()
	{
		st.setTicket_id(1);
		assertEquals(true, st.IsNotNull());
	}
	@Test
	public void NNTestFood_ID()
	{
		st.setFood_id(1);
		assertEquals(true, st.IsNotNull());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void NNTestEndTime()
	{
		//Date start = new Date(2001,11,10);
		Date end = new Date(2001, 12, 10);
		st.setEnd_time(end);
		assertEquals(true, st.IsNotNull());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void NNTestStartTime()
	{
		Date start = new Date(2001,11,10);
		//Date end = new Date(2001, 12, 10);
		st.setEnd_time(start);
		assertEquals(true, st.IsNotNull());
	}
	public void NNTestIncludes()
	{
		st.setIncludes("Jerry");
		assertEquals(true, st.IsNotNull());
	}
	public void NNTestExcludes()
	{
		st.setExcludes("Tom");
		assertEquals(true, st.IsNotNull());
	}
	

}
