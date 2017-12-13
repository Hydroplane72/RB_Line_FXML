package dbo;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author MatthewsLaptop
 * The Ticket class. 
 * This class is mapped to the ticket table in the database.
 *
 */
@Entity
@Table(name="tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ticket_id")
	private int Ticket_ID;
	
	@Column(name="ServerID")
	private int ServerID;
	
	@Column(name="Tablenum")
	private int tablenum;
	
	@Column(name="Time_In")
	private LocalDateTime Time_in;
	
	@Column(name="Time_Out")
	private LocalDateTime Time_out;
	
	public Ticket()
	{
		ServerID = 0;
		tablenum = 0;
		Ticket_ID = 0;
		Time_in = null;
		Time_out = null;
	}

	/**
	 * 
	 * @param serverID -The Server's id
	 * @param tablenum - The table number the ticket goes to
	 * @param a - The time the ticket came in
	 * @param time_out- The time the entire ticket was completed
	 */
	public Ticket(int serverID, int tablenum, LocalDateTime a, LocalDateTime a2) {
		
		Ticket_ID = 0;
		ServerID = serverID;
		this.tablenum = tablenum;
		Time_in = a;
		Time_out = a2;
	}

	public int getServerID() {
		return ServerID;
	}

	public void setServerID(int serverID) {
		if(serverID>0)
		ServerID = serverID;
		else {
			this.ServerID =0;
		}
	}

	public int getTablenum() {
		return tablenum;
	}

	public void setTablenum(int tablenum) {
		if(tablenum >0)
		this.tablenum = tablenum;
		else {
			this.tablenum =0;
		}
	}

	public LocalDateTime getTime_in() {
		return Time_in;
	}

	public void setTime_in(LocalDateTime time_in) {
		Time_in = time_in;
	}

	public LocalDateTime getTime_out() {
		return Time_out;
	}

	public void setTime_out(LocalDateTime time_out) {
		Time_out = time_out;
	}

	public int getTicket_ID() {
		return Ticket_ID;
	}

	public void setTicket_ID(int ticket_ID) {
		if(ticket_ID >0)
		Ticket_ID = ticket_ID;
		else
		{
			this.Ticket_ID = 0;
		}
	}

	@Override
	public String toString() {
		return "Ticket [Ticket_ID=" + Ticket_ID + ", ServerID=" + ServerID + ", tablenum=" + tablenum + ", Time_in="
				+ Time_in + ", Time_out=" + Time_out + "]";
	}
	
	public boolean IsNotNull()
	{
		if(ServerID != 0)
			return true;
		if(tablenum != 0)
			return true;
		if(Ticket_ID != 0)
			return true;
		if(Time_in != null)
			return true;
		if(Time_out != null)
			return true;
		return false;
	}
	
	
}
