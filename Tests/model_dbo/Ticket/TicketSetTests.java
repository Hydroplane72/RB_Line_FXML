package model_dbo.Ticket;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import dbo.Ticket;

/**
 * @author MatthewsLaptop
 *
 */
public class TicketSetTests {
	Ticket t;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		t = new Ticket();
	}

	@Test
	public void SetPositiveServerIDTest() {
		t.setServerID(1);
		assertEquals(1, t.getServerID());
	}
	@Test
	public void SetPositiveTableNum()
	{
		t.setTablenum(1);
		assertEquals(1, t.getTablenum());
	}
	@Test
	public void SetPositiveTicketID()
	{
		t.setTicket_ID(1);
		assertEquals(1, t.getTicket_ID());
	}
	
	@Test
	public void SetNegativeServerIDTest() {
		t.setServerID(-1);
		assertEquals(0, t.getServerID());
	}
	@Test
	public void SetNegativeTableNum()
	{
		t.setTablenum(-1);
		assertEquals(0, t.getTablenum());
	}
	@Test
	public void SetNegativeTicketID()
	{
		t.setTicket_ID(-1);
		assertEquals(0, t.getTicket_ID());
	}

}
