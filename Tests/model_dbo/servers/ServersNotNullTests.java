/**
 * 
 */
package model_dbo.servers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dbo.Servers;

/**
 * @author MatthewsLaptop
 *
 */
public class ServersNotNullTests {
	Servers s;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		s = new Servers();
	}

	@Test
	public void NullNNTest() {
		
		assertEquals(false,s.NotNull());
	}
	@Test
	public void NNTestID()
	{
		s.setServerID(1);
		assertEquals(true, s.NotNull());
	}
	@Test
	public void NNTestFName()
	{
		s.setFirstname("Matt");
		assertEquals(true, s.NotNull());
	}
	@Test
	public void NNTestLName()
	{
		s.setLastname("Rozendaal");
		assertEquals(true, s.NotNull());
	}

}
