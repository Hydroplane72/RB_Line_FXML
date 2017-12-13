package model_dbo.food;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import dbo.Food;

public class FoodNotNullTests {

	//The food objects to be set tested
		Food fnull;
		
		Food ff = new Food("Jap","Seeds",5,"Broil");
	@Before
	public void setUp() throws Exception {
		fnull = new Food();
	}
	@Test
	public void NullNNTest() {
		//test null object
		assertEquals(false, fnull.NotNull());
	}
	@Test
	public void NameNNTest()
	{
		//test food not null
		fnull.setFood_name("Pop");
		assertEquals(true, fnull.NotNull());
	}
	@Test
	public void IngredientNNTest()
	{
		fnull.setIngredients("Item");
		assertEquals(true, fnull.NotNull());
	}
	@Test
	public void TimeNNTest()
	{
		fnull.setCook_time(5);
		assertEquals(true, fnull.NotNull());
	}
	@Test
	public void StationNNTest()
	{
		fnull.setStation_name("Fry");
		assertEquals(true, fnull.NotNull());
	}
	@Test
	public void IDNNTest()
	{
		fnull.setFood_id(2);
		assertEquals(true, fnull.NotNull());
	}
}
