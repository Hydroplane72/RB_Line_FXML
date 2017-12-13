package dbo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author MatthewsLaptop
 * <h1>Over all class data access object</h1>
 * <p>This class connects to the database. This class connects to the overall_table in the database.</p>
 */
@Entity
@Table(name="overall_table")
public class overall {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="overall_id")
	private int overallId;

	@Column(name="server_num")
	private int serverNum;

	@Column(name="time_in")
	private Date timeIn;

	@Column(name="time_out")
	private Date timeOut;

	@Column(name="FIDS_pizza")
	private String FIDSPizza;

	@Column(name="FIDS_Saute")
	private String FIDSSaute;

	@Column(name="FIDS_Broil")
	private String FIDSBroil;

	@Column(name="FIDS_Pantry")
	private String FIDSPantry;

	@Column(name="FIDS_Fry")
	private String FIDSFry;

	@Column(name="Pizza_time")
	private Date PizzaTime;

	@Column(name="Saute_Time")
	private Date SauteTime;

	@Column(name="Broil_Time")
	private Date BroilTime;

	@Column(name="Pantry_Time")
	private Date PantryTime;

	@Column(name="Fry_Time")
	private Date FryTime;
	
	public overall()
	{

	}

	/**
	 * @param serverNum- The Server's Number
	 * @param timeIn - The time the ticket came in
	 * @param timeOut - The time the ticket was finished
	 * @param fIDSPizza - The Food IDs that pizza had to do
	 * @param fIDSSaute - The Food IDs that saute had to do
	 * @param fIDSBroil - The Food IDs that broil had to do
	 * @param fIDSPantry - The Food IDs that pantry had to do
	 * @param fIDSFry - The Food IDs that fry had to do
	 * @param pizzaTime
	 * @param sauteTime
	 * @param broilTime
	 * @param pantryTime
	 * @param fryTime
	 */
	public overall(int serverNum, Date timeIn, Date timeOut, String fIDSPizza, String fIDSSaute, String fIDSBroil,
			String fIDSPantry, String fIDSFry, Date pizzaTime, Date sauteTime, Date broilTime, Date pantryTime,
			Date fryTime) {
		this.serverNum = serverNum;
		this.timeIn = timeIn;
		this.timeOut = timeOut;
		FIDSPizza = fIDSPizza;
		FIDSSaute = fIDSSaute;
		FIDSBroil = fIDSBroil;
		FIDSPantry = fIDSPantry;
		FIDSFry = fIDSFry;
		PizzaTime = pizzaTime;
		SauteTime = sauteTime;
		BroilTime = broilTime;
		PantryTime = pantryTime;
		FryTime = fryTime;
	}
	public int getServerNum() {
		return serverNum;
	}

	public void setServerNum(int serverNum) {
		this.serverNum = serverNum;
	}

	public Date getTimeIn() {
		return timeIn;
	}

	public void setTimeIn(Date timeIn) {
		this.timeIn = timeIn;
	}

	public Date getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(Date timeOut) {
		this.timeOut = timeOut;
	}

	public String getFIDSPizza() {
		return FIDSPizza;
	}

	public void setFIDSPizza(String fIDSPizza) {
		FIDSPizza = fIDSPizza;
	}

	public String getFIDSSaute() {
		return FIDSSaute;
	}

	public void setFIDSSaute(String fIDSSaute) {
		FIDSSaute = fIDSSaute;
	}

	public String getFIDSBroil() {
		return FIDSBroil;
	}

	public void setFIDSBroil(String fIDSBroil) {
		FIDSBroil = fIDSBroil;
	}

	public String getFIDSPantry() {
		return FIDSPantry;
	}

	public void setFIDSPantry(String fIDSPantry) {
		FIDSPantry = fIDSPantry;
	}

	public String getFIDSFry() {
		return FIDSFry;
	}

	public void setFIDSFry(String fIDSFry) {
		FIDSFry = fIDSFry;
	}

	public Date getPizzaTime() {
		return PizzaTime;
	}

	public void setPizzaTime(Date pizzaTime) {
		PizzaTime = pizzaTime;
	}

	public Date getSauteTime() {
		return SauteTime;
	}

	public void setSauteTime(Date sauteTime) {
		SauteTime = sauteTime;
	}

	public Date getBroilTime() {
		return BroilTime;
	}

	public void setBroilTime(Date broilTime) {
		BroilTime = broilTime;
	}

	public Date getPantryTime() {
		return PantryTime;
	}

	public void setPantryTime(Date pantryTime) {
		PantryTime = pantryTime;
	}

	public Date getFryTime() {
		return FryTime;
	}

	public void setFryTime(Date fryTime) {
		FryTime = fryTime;
	}

	public int getOverallId() {
		return overallId;
	}





}
