package model_dbo.servers;
import static org.junit.Assert.*;

import org.junit.Test;

import dbo.Servers;

public class ServersCreateTests {

	@Test
	public void serverDefaultCreate() {
		Servers s = new Servers();
		/*
		 * ServerID = 0;
		firstname = "";
		lastname= "";
		 */
		assertEquals(0, s.getServerID());
		assertEquals("", s.getFirstname());
		assertEquals("", s.getLastname());
	}
	
	@Test
	public void serverCreate()
	{
		Servers s = new Servers("Matt", "Rozendaal");
		assertEquals("Matt", s.getFirstname());
		assertEquals("Rozendaal", s.getLastname());
	}

}
