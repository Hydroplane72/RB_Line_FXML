package model_dbo.servers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import dbo.Servers;

/**
 * @author MatthewsLaptop
 *
 */
public class ServersSetTests {

	Servers s;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new Servers();
	}

	@Test
	public void SetNegativeIDTest() {
		s.setServerID(-1);
		assertEquals(0, s.getServerID());
	}
	public void SetPositiveIDTest()
	{
		s.setServerID(100);
		assertEquals(100, s.getServerID());
	}

}
