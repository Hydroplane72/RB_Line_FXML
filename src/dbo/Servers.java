package dbo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="servers")
public class Servers {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ServerID")
	private int ServerID;
	
	@Column(name="firstname")
	private String firstname;
	
	@Column(name="lastname")
	private String lastname;
	public Servers()
	{
		ServerID = 0;
		firstname = "";
		lastname= "";
	}
	/**
	 * @param firstname - Server's first name
	 * @param lastname - Server's last name
	 */
	public Servers(String firstname, String lastname) {
		
		this.firstname = firstname;
		this.lastname = lastname;
	}
	public int getServerID() {
		return ServerID;
	}
	public void setServerID(int serverID) {
		if(serverID <0)
		{
			this.ServerID = 0;
		}
		else
		{
			ServerID = serverID;
		}
		
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public boolean NotNull()
	{
		if(firstname != "")
			return true;
		if(lastname != "")
			return true;
		if(ServerID != 0)
			return true;
		return false;
	}
	
}
