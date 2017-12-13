/**
 * 
 */
package bo;

/**
 * @author MatthewsLaptop
 *
 */
public class TableOrder {
	private int ticketNum;
	private int customerNum;
	private int foodId;
	private String excludes;
	private String includes;
	private String allergy;
	
	/**
	 * @param ticketNum
	 * @param customerNum
	 * @param foodId
	 * @param excludes
	 * @param includes
	 * @param allergy
	 */
	public TableOrder(int ticketNum, int customerNum, int foodId, String excludes, String includes, String allergy) {
		
		this.ticketNum = ticketNum;
		this.customerNum = customerNum;
		this.foodId = foodId;
		this.excludes = excludes;
		this.includes = includes;
		this.allergy = allergy;
	}
	/**
	 * 
	 */
	public TableOrder() 
	{
		this.ticketNum = 0;
		this.customerNum = 0;
		this.foodId = 0;
		this.excludes = null;
		this.includes = null;
		this.allergy = null;
	}
	/**
	 * @return the ticketNum
	 */
	public int getTicketNum() {
		return ticketNum;
	}
	/**
	 * @param ticketNum the ticketNum to set
	 */
	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}
	/**
	 * @return the customerNum
	 */
	public int getCustomerNum() {
		return customerNum;
	}
	/**
	 * @param customerNum the customerNum to set
	 */
	public void setCustomerNum(int customerNum) {
		this.customerNum = customerNum;
	}
	/**
	 * @return the foodId
	 */
	public int getFoodId() {
		return foodId;
	}
	/**
	 * @param foodId the foodId to set
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	/**
	 * @return the excludes
	 */
	public String getExcludes() {
		return excludes;
	}
	/**
	 * @param excludes the excludes to set
	 */
	public void setExcludes(String excludes) {
		this.excludes = excludes;
	}
	/**
	 * @return the includes
	 */
	public String getIncludes() {
		return includes;
	}
	/**
	 * @param includes the includes to set
	 */
	public void setIncludes(String includes) {
		this.includes = includes;
	}
	/**
	 * @return the allergy
	 */
	public String getAllergy() {
		return allergy;
	}
	/**
	 * @param allergy the allergy to set
	 */
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	
	
	
}
