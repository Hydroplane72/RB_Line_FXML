package dbao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dbo.Ticket;

public class TicketAccessor  extends DatabaseAccessor<Object>{
	
	/**
	 * @param factory
	 * @param session
	 */
	public TicketAccessor(SessionFactory factory, Session session) {
		setFactory(factory);
		setSession(session);
	}

	

	public TicketAccessor() {
		// TODO Auto-generated constructor stub
	}



	/**
	 * 
	 * @param t
	 * @param sessionIn
	 * @return
	 */
	public boolean AddTicket(Ticket t, Session sessionIn) {
		session = sessionIn;
		try {
			// open new session transaction
			session.beginTransaction();
			// Save new server to database
			session.save(t);
			// Commit to database
			session.getTransaction().commit();
			// close session
			session.close();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param t
	 * @param sessionIn
	 * @return
	 */
	public boolean DeleteTicket(Ticket t, Session sessionIn) {
		try {
			session = sessionIn;
			session.beginTransaction();

			// get Food
			Ticket myTicket = session.get(Ticket.class, t.getTicket_ID());

			// Delete food
			session.delete(myTicket);

			// commit to database
			session.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param t
	 * @param sessionIn
	 * @return
	 */
	public List<Ticket> getTicket(Ticket t, Session sessionIn) {
		String query = createStationQuery(t);

		try {
			session = sessionIn;
			session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Ticket> theTickets = session.createQuery(query) // make sure to have the class object exactly not //
																	// the table name
					.getResultList();
			return theTickets;

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 
	 * @param t
	 * @return
	 */
	private String createStationQuery(Ticket t) {
		StringBuilder query = new StringBuilder();
		query.append("from Ticket t");// Beginning of query
		// used to determine if there is a variable already in query
		Boolean second = false;
		if (t.IsNotNull()) {
			query.append(" WHERE ");
			if (t.getServerID() != 0) {
				query.append(" ServerID = " + t.getServerID());
				second = true;
			}
			if (t.getTablenum() != 0) {
				if (second) {
					query.append(" AND ");
				}
				query.append(" tablenum = " + t.getTablenum() + " ");
				second = true;
			}
			if (t.getTicket_ID() != 0) {
				if (second) {
					query.append(" AND ");
				}
				query.append(" Ticket_ID = " + t.getTicket_ID());
				second = true;
			}
			if (t.getTime_in() != null) {
				if (second) {
					query.append(" AND ");
				}
				query.append(" Time_in = " + t.getTime_in());
				second = true;
			}
			if (t.getTime_out() != null) {
				if (second) {
					query.append(" AND ");
				}
				query.append(" Time_out = " + t.getTime_out());
			}
		}
		return query.toString();
	}
}
