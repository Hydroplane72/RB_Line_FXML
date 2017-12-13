package dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author Matthew Rozendaal
 * <h1>Food Class</h1>
 * <p>This is the Food class. The Food class is mapped to the database table named Food.</p>
 * <p>
 */
@Entity
@Table(name="Food")
public class Food {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="idFood")
	private int food_id;
	
	@Column(name="Food_name")
	private String food_name;
	
	@Column(name="Ingredients")
	private String ingredients;
	
	@Column(name="cook_time")
	private int cook_time;
	
	@Column(name="station_name")
	private String station_name;
	
	public Food()
	{
		cook_time = 0;
		food_id = 0;
		food_name = "";
		ingredients = "";
		station_name = "";
	}
	/**
	 * @param food_name - The name of the Food to be cooked
	 * @param ingredients - The ingredients needed to make the Food
	 * @param cook_time - The cook time of the Food
	 * @param station_name - The name of the station that makes the Food
	 */
	public Food( String food_name, String ingredients, int cook_time, String station_name) {
		
		this.food_name = food_name;
		this.ingredients = ingredients;
		this.cook_time = cook_time;
		this.station_name = station_name;
	}
	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public int getCook_time() {
		return cook_time;
	}

	public void setCook_time(int cook_time) {
		
		//checks input for out of range time
		if(cook_time <0)
		{
			this.cook_time =0;
		}
		else if(cook_time>60)
		{
			this.cook_time = 60;
		}
		else
		{
			this.cook_time = cook_time;
		}
	}

	public String getStation_name() {
		return station_name;
	}

	public void setStation_name(String station_name) {
		this.station_name = station_name;
	}

	public int getFood_id() {
		return food_id;
	}
	
	
	public void setFood_id(int food_id) {
		if(food_id<0)
		{
			this.food_id = 0;
		}
		else
		{
			this.food_id = food_id;
		}
		
	}
	public String getFood_name() {
		return food_name;
	}
	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}
	
	/**
	 * checks if the object is null
	 * @return True if the object is not null
	 */
	public boolean NotNull()
	{
		if(food_id != 0)
		{
			return true;
		}
		if(cook_time != 0)
		{
			return true;
		}
		if(food_name != "")
		{
			return true;
		}
		if(ingredients != "")
		{
			return true;
		}
		if(station_name != "")
		{
			return true;
		}
		
		//Everything is null or empty. Therefore return false
		return false;
	}
}
