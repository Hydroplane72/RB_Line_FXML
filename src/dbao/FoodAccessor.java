package dbao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import dbo.Food;

/**
 * 
 * @author MatthewsLaptop
 * @see Food
 * @version 1.0.0 This class is used in conjunction with the Food class. It is
 *          the go between for the database and the program code.
 * @param <T>
 */

public class FoodAccessor extends DatabaseAccessor<Object>{
	/**
	 * @param factory
	 *            - The SessionFactory is passed over to the class so it can use the
	 *            factory
	 * @param session
	 *            - The session is made for the SessionFactory to use it
	 */
	public FoodAccessor(SessionFactory factory, Session session) {
		setFactory(factory);
		setSession(session);
	}

	public FoodAccessor() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Updates the food item
	 * 
	 * @param food
	 *            - the food item to be changed
	 * @param InSession
	 * @return
	 */
	public Boolean UpdateFoodItem(Food food, Session InSession) {
		try {
			session = InSession;
			session.beginTransaction();

			// get Food
			Food myfood = session.get(Food.class, food.getFood_id());

			// update object
			myfood.setCook_time(food.getCook_time());
			myfood.setFood_name(food.getFood_name());
			myfood.setIngredients(food.getIngredients());
			myfood.setStation_name(food.getStation_name());

			// commit to database
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean AddNewRecord(Food food, Session InSession)
	{
		return super.AddNewRecord(food, InSession, food.NotNull(), InsertValid(food));
	}
	public Boolean DeleteFoodItem(Food food, Session InSession) {
		session = InSession;
		try {
			session = InSession;
			session.beginTransaction();

			// get Food
			Food myfood = session.get(Food.class, food.getFood_id());

			// Delete food
			session.delete(myfood);

			// commit to database
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	public List<Food> getFoodItem(Food food, Session InSession) {

		// Create query string
		String query = createFoodQuery(food);
		try {
			session = InSession;
			session.beginTransaction();
			// Query Food
			@SuppressWarnings("unchecked")
			List<Food> theTickets = session.createQuery(query) // make sure to have the class object exactly not													// the table name
					.getResultList();
			System.out.println(theTickets + " The Food");
			return theTickets;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Food getFoodItem(int foodId, Session InSession)
	{
		// Create query string
				
				try {
					session = InSession;
					session.beginTransaction();
					// get Food
					Food myfood = session.get(Food.class, foodId);
					//clean up session
					session.close();
					return myfood;
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return null;
				}
	}
	public List<Food> getFoodItem(Session InSession)
	{
		final String query = "from Food";
		try {
			session = InSession;
			session.beginTransaction();
			// Query Food
			@SuppressWarnings("unchecked")
			List<Food> theTickets = session.createQuery(query) // make sure to have the class object exactly not													// the table name
					.getResultList();
			
			return theTickets;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	/**
	 * This function creates a string to query the data base.
	 * 
	 * @param food
	 *            - The details of the food item to help narrow down the search
	 * @return the string in a queryable format
	 */
	private String createFoodQuery(Food food) {
		StringBuilder query = new StringBuilder();
		query.append("from Food f");// Beginning of query
		// used to determine if there is a variable already in query
		Boolean second = false;

		if (food.NotNull())// Enables query all
		{
			// add where clause
			query.append(" WHERE ");
			// check food id
			if (food.getFood_id() != 0) {
				query.append(" f.food_id = " + food.getFood_id() + " ");
				second = true;
			}
			if (food.getCook_time() != 0) {
				// Checks if previous is true
				if (second) {
					query.append(" AND ");
				}
				query.append("f.cook_time = " + food.getCook_time() + " ");
				second = true;
			}
			if (food.getFood_name() != "") {
				// checks if seconded
				if (second) {
					query.append(" AND ");
				}
				query.append("f.food_name = " + food.getFood_name() + " ");
				second = true;
			}
			if (food.getStation_name() != "") {
				// checks if seconded
				if (second) {
					query.append(" AND ");
				}
				query.append("f.station_name = " + food.getStation_name() + " ");
				second = true;
			}
			if (food.getIngredients() != "") {
				// checks if seconded
				if (second) {
					query.append(" AND ");
				}

				// split the list of food items into an array of items
				List<String> items = Arrays.asList(food.getIngredients().split("\\s*,\\s*"));

				Boolean twice = false;
				int counter = 0;
				if (items.size() > 1) // Make sure there is more than one item
				{
					twice = true;
				}
				/**
				 * Learned about this and how to do it from App Shaw
				 * http://crunchify.com/how-to-iterate-through-java-list-4-way-to-iterate-through-loop/
				 * Collection stream() util: Returns a sequential Stream with this collection as
				 * its source
				 */

				if (twice) //Make sure there is more than one item in the list
				{
					for (String temp : items) 
					{
						// Go through each item and search for it in the database
						if (counter + 1 == temp.length()) // if on last item
						{
							query.append(" f.ingredients = " + temp.toString());
						} else {
							query.append(" f.ingredients = " + temp.toString() + " AND ");
						}
						counter++;
					} 
				}
				else
				{
					query.append(" f.ingredients = " + items.get(0));
				}
			} //end ingredients if
		} //end not null if

		return query.toString();
	}
	private boolean InsertValid(Food food)
	{
		if(!food.NotNull())
		{
			return false;
		}
		else
		{
			if(food.getCook_time()<=0)
			{
				return false;
			}
			else if(food.getFood_name() == "" || food.getFood_name() == null)
			{
				return false;
			}
			else if(food.getIngredients() == "" ||food.getIngredients() == null)
			{
				return false;
			}
			else if(food.getStation_name() == ""|| food.getStation_name() == null)
			{
				return false;
			}
		}
		return true;
	}
}
