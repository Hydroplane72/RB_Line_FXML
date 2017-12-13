package model_dbo.food;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import dbo.Food;

public class FoodSetTests {
	//The food objects to be set tested
	Food fe = new Food();
	Food ff = new Food("Jap","Seeds",5,"Broil");

	@Before
	public void setUp() throws Exception {
		fe = new Food();
	}
	@Test
	public void SetEmptyFoodName() {
		fe.setFood_name("Poppers");
		assertEquals("Poppers", fe.getFood_name());
	}
	
	@Test
	public void SetEmptyFoodIngredient()
	{
		fe.setIngredients("Bacon");
		assertEquals("Bacon", fe.getIngredients());
	}
	
	@Test
	public void SetEmptyFoodTime()
	{
		fe.setCook_time(5);
		assertEquals(5, fe.getCook_time());
	}
	@Test
	public void SetEmptyFoodID()
	{
		fe.setFood_id(10);
		assertEquals(10, fe.getFood_id());
	}
	
	@Test
	public void SetEmptyFoodStation()
	{
		fe.setStation_name("Fry");
		assertEquals("Fry", fe.getStation_name());
	}
	
	@Test
	public void SetFullFoodName() {
		ff.setFood_name("Poppers");
		assertEquals("Poppers", ff.getFood_name());
	}
	
	@Test
	public void SetFullFoodIngredient()
	{
		ff.setIngredients("Bacon");
		assertEquals("Bacon", ff.getIngredients());
	}
	
	@Test
	public void SetFullFoodTime()
	{
		ff.setCook_time(5);
		assertEquals(5, ff.getCook_time());
	}
	@Test 
	public void SetFullFoodID()
	{
		ff.setFood_id(10);
		assertEquals(10, ff.getFood_id());
	}
	@Test
	public void SetFullFoodStation()
	{
		ff.setStation_name("Fry");
		assertEquals("Fry", ff.getStation_name());
	}
	
	@Test
	public void SetNegativeCookTime()
	{
		ff.setCook_time(-1);
		assertEquals(0, ff.getCook_time());
	}
	
	@Test
	public void SetLargeCookTime()
	{
		ff.setCook_time(80);
		assertEquals(60, ff.getCook_time());
	}
	public void SetNegativeFoodID()
	{
		ff.setCook_time(-10);
		assertEquals(0, ff.getFood_id());
	}
}