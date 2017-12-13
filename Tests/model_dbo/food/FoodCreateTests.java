/**
 * 
 */
package model_dbo.food;
import static org.junit.Assert.*;

import org.junit.Test;
import dbo.Food;

/**
 * @author MatthewsLaptop
 * Tests the food class and if it works
 */
public class FoodCreateTests {

	
	/**
	 * Tests the default constructor of the food class works correctly
	 */
	@Test
	public void CreateDefualtFoodObjectTest() {
		//Default constructor
		Food f = new Food();
		/*Default constructor assignment variables
		 *  cook_time = 0;
			food_id = 0;
			food_name = "";
			ingredients = "";
			station_name = "";
		 */
		assertEquals(0, f.getCook_time());
		assertEquals(0, f.getFood_id());
		assertEquals("", f.getFood_name());
		assertEquals("", f.getIngredients());
		assertEquals("", f.getStation_name());
	}
	
	/**
	 * Tests the constructor of the food class works correctly
	 */
	@Test
	public void CreateFoodObjectTest()
	{
		//constructor
		Food f = new Food("Jap","Seeds",5,"Fry");
		//Asserts
		assertEquals("Jap", f.getFood_name());
		assertEquals("Seeds", f.getIngredients());
		assertEquals(5, f.getCook_time());
		assertEquals("Fry", f.getStation_name());
	}
	

}
