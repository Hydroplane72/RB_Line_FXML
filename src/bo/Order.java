package bo;

import java.util.List;

import org.hibernate.SessionFactory;

import dbo.Station_Ticket;


public class Order {


	private List<Station_Ticket> ticket;
	private String ticketText;
	/**
	 * @param orderButton
	 * @param ticket
	 */
	public Order(List<Station_Ticket> ticket, SessionFactory sf) {


		//to make sure ticket text is set

		setTicket(ticket, sf);


	}



	/**
	 * @return the ticket
	 */
	public List<Station_Ticket> getTicket() {
		return ticket;
	}
	/**
	 * @param ticket the ticket to set
	 */
	public void setTicket(List<Station_Ticket> tickets, SessionFactory sf) {
		StringBuilder ticketTexts = new StringBuilder();
		for(Station_Ticket ticket: tickets)
		{
			//create string to output to text
			ticketTexts.append(ticket.showOrder(sf.getCurrentSession()));
			//new line for next item
			ticketTexts.append("\n");
		}
		ticketText = ticketTexts.toString();
		this.ticket = tickets;
	}
	/**
	 * @return the ticketText
	 */
	public String getTicketText() {

		return ticketText;
	}
}
