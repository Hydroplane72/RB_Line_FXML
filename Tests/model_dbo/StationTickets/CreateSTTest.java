package model_dbo.StationTickets;

import static org.junit.Assert.*;

import org.junit.Test;
import java.sql.Date;
import java.time.LocalDateTime;

import dbo.Station_Ticket;

/**
 * @author MatthewsLaptop
 *
 */
public class CreateSTTest {

	@Test
	public void CreateSTDefaultTest() {
		Station_Ticket st = new Station_Ticket();
		/*
		 * ticket_id = 0;
		stt_id = 0;
		start_time = null;
		end_time = null;
		Excludes = "";
		Includes = "";
		 */
		assertEquals(0, st.getStt_id());
		assertEquals(0, st.getTicket_id());
		assertEquals(0, st.getFood_id());
		assertEquals(null, st.getStart_time());
		assertEquals(null, st.getEnd_time());
		assertEquals("", st.getExcludes());
		assertEquals("", st.getIncludes());
	}
	@SuppressWarnings("deprecation")
	@Test
	public void STCreateTest()
	{
		LocalDateTime start = LocalDateTime.now();
		Date end = new Date(start.getYear(), start.getMonthValue(), start.getDayOfMonth());
		Station_Ticket st = new Station_Ticket(1,1,start, end, "Berry", "Jam");
		
		assertEquals(0, st.getStt_id());
		assertEquals(1, st.getTicket_id());
		assertEquals(1, st.getFood_id());
		assertEquals(start, st.getStart_time());
		assertEquals(end, st.getEnd_time());
		assertEquals("Berry", st.getExcludes());
		assertEquals("Jam", st.getIncludes());
	}

}
