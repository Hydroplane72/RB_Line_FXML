package dbao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Do not use. Not yet implemented
 * @author MatthewsLaptop
 *
 */
public class OverallAccessor {
	private SessionFactory factory;

	private Session session;

	/**
	 * @param factory
	 * @param session
	 */
	public OverallAccessor(SessionFactory factory, Session session) {
		this.factory = factory;
		this.session = session;
	}
	
	public SessionFactory getFactory() {
		return factory;
	}

	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	/*
	 * public Boolean AddNewFoodItem(Food food, Session InSession)
	{
		session = InSession;
		try {
			//open new session transaction
			session.beginTransaction();
			//Save new food to database
			session.save(food);
			//Commit to database
			session.getTransaction().commit();
			//close session
			session.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//Something went wrong return false
			return false;
		}
		//Everything went right return true
		return true;
	}
	 */
	
	
}
