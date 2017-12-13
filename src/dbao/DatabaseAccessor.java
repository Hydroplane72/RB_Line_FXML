package dbao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

abstract class DatabaseAccessor<T> {
	public SessionFactory factory;

	public Session session;

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

	/**
	 * This is to create a new object
	 * 
	 * @return if the item is created successfully the function returns true;
	 */
	protected boolean AddNewRecord(T obj, Session InSession, boolean NotNull, boolean Saveable) {
		session = InSession;
		System.out.println("Not Null: "+ NotNull);
		System.out.println("Savable: "+ Saveable);
		if(NotNull && Saveable)
		{
			try {
				// open new session transaction
				session.beginTransaction();
				// Save new food to database
				session.save(obj);
				// Commit to database
				session.getTransaction().commit();
				// close session
				session.close();
			} catch (Exception e) {
				System.out.println("Something went wrong.");
				e.printStackTrace();
				// Something went wrong return false
				return false;
			}
		}
		else
		{
			System.out.println("Returned false");
			return false;
		}
		// Everything went right return true
		return true;
	}
}

