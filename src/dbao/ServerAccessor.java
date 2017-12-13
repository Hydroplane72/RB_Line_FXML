package dbao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dbo.Servers;

public class ServerAccessor extends DatabaseAccessor<Object> {
	

	/**
	 * @param factory
	 * @param session
	 */
	public ServerAccessor(SessionFactory factory, Session session) {
		setFactory(factory);
		setSession(session);
	}

	// Create, update, query
/**
 * 	
 * @param server
 * @param SessionIn
 * @return
 */
public boolean AddNewRecord(Servers server, Session SessionIn) {
	
	return super.AddNewRecord(server, SessionIn, server.NotNull(), InsertValid(server));
}
	

private boolean InsertValid(Servers server) {
	if(server.NotNull())
	{
		if(server.getFirstname() == "" || server.getFirstname()  == null||
				server.getLastname() == "" || server.getLastname()  == null)
		{
			return false;
		}
	}
	else
	{
		return false;
	}
	return true;
}

/**
	 * @param server
	 * @param SessionIn
	 * @return
	 */
public boolean UpdateServer(Servers server, Session SessionIn)
	{
		try {
			session = SessionIn;
			session.beginTransaction();
			
			//get the server
			Servers serve = session.get(Servers.class, server.getServerID());
			
			//Update server
			serve.setFirstname(server.getFirstname());
			serve.setLastname(server.getLastname());
			
			//commit to database
			session.getTransaction().commit();
		} catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}

		return true;
	}
/**
 * 	
 * @param server
 * @param SessionIn
 * @return
 */
public List<Servers> getServer(Servers server, Session SessionIn)
	{
		String query = createServerQuery(server);
		
		try {
			session = SessionIn;
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Servers> theTickets = session.createQuery(query) // make sure to have the class object exactly not													// the table name
					.getResultList();
			return theTickets;
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
	}
/**
 * 
 * @param server
 * @return
 */
	private String createServerQuery(Servers server) {
		StringBuilder query = new StringBuilder();
		boolean second = false;
		query.append("from Servers s");
		
		if(server.NotNull())
		{
			query.append(" WHERE ");
			if(server.getFirstname() !="")
			{
				second = true;
				query.append(" firstname = " + server.getFirstname());
			}
			if(server.getLastname() != "")
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append(" lastname = " + server.getLastname());
				second = true;
			}
			if(server.getServerID() != 0)
			{
				if(second)
				{
					query.append(" AND ");
				}
				query.append("ServerID = " + server.getServerID());
			}
		}
		
		return query.toString();
	}
	
}
