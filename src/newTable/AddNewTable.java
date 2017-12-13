package newTable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.procedure.ProcedureCall;

import bo.TableOrder;
import dbao.FoodAccessor;
import dbao.StationTicketAccessor;
import dbao.TicketAccessor;
import dbo.Food;
import dbo.Station_Ticket;
import dbo.Ticket;
import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * Used by multiple views to create a new table and add info about it
 * @author MatthewsLaptop
 */
public class AddNewTable implements ControlledScreen{
	
	//Screen Controller Global Private Variables
	ScreensController myController;
	SessionFactory factory;
	
	private Ticket ticket = new Ticket();
	private List<Food> food;
	private ArrayList<TableOrder> tableOrders = new ArrayList<TableOrder>();
	private FoodAccessor fa = new FoodAccessor();
	
	private int numCustomer =0;
    private int customerFocus = 1;
    
    //Start FXML Variables
    @FXML // fx:id="ServerNumber"
    private Tab ServerNumberTab; // Value injected by FXMLLoader

    @FXML // fx:id="SetServerBtn"
    private Button SetServerBtn; // Value injected by FXMLLoader

    @FXML // fx:id="ServerNumberTxt"
    private TextField ServerNumberTxt; // Value injected by FXMLLoader
    
	@FXML // fx:id="TabParent"
    private TabPane TabParent; // Value injected by FXMLLoader
	
    @FXML // fx:id="TableNumberTab"
    private Tab TableNumberTab; // Value injected by FXMLLoader

    @FXML // fx:id="CreateTableTicketBTn"
    private Button CreateTableTicketBTn; // Value injected by FXMLLoader

    @FXML // fx:id="tableNumberTxt"
    private TextField tableNumberTxt; // Value injected by FXMLLoader

    @FXML // fx:id="NumberPeopleTab"
    private Tab NumberPeopleTab; // Value injected by FXMLLoader

    @FXML // fx:id="numberPeopleSpinner"
    private Spinner<Integer> numberPeopleSpinner = new Spinner<Integer>(); // Value injected by FXMLLoader
    
    @FXML // fx:id="NumPeople"
    private Button NumPeople; // Value injected by FXMLLoader

    @FXML // fx:id="CustomerNumberTab"
    private Tab CustomerNumberTab; // Value injected by FXMLLoader

    @FXML // fx:id="addFoodBtn"
    private Button addFoodBtn; // Value injected by FXMLLoader

    @FXML // fx:id="NextCustomerBtn"
    private Button NextCustomerBtn; // Value injected by FXMLLoader

    @FXML // fx:id="customerNumberLbl"
    private Label customerNumberLbl; // Value injected by FXMLLoader

    @FXML // fx:id="AddFoodToCustomerTab"
    private Tab AddFoodToCustomerTab; // Value injected by FXMLLoader

    @FXML // fx:id="FoodList"
    private ListView<String> FoodList = new ListView<String>(); // Value injected by FXMLLoader

    @FXML // fx:id="FinishTicketTab"
    private Tab FinishTicketTab; // Value injected by FXMLLoader

    @FXML // fx:id="TicketReview"
    private Label TicketReview; // Value injected by FXMLLoader
    
    
    /*
     * Begin FXML Functions and EventHandlers
     */
    @FXML
    void SetServerNumber(ActionEvent event) {
    	//SetEnabled Tabs
    	//disable table
    	disableAllTabs();
    	//Set number people tab disable false
    	TableNumberTab.setDisable(false);
    	TabParent.getSelectionModel().selectNext();
    	//get table number
    	try
    	{
    		//gets the text and sets it to the ticket table number
    		ticket.setServerID(Integer.parseInt(ServerNumberTxt.getText()));
    		//for testing only
    		//tableNumberTxt.setText("Input accepted: " + ticket.getTablenum());	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		ServerNumberTxt.setText("Value entered is not allowed");
    		disableAllTabs();
    		ServerNumberTab.setDisable(false);
    		//go back to the screen
    		TabParent.getSelectionModel().selectPrevious();
    	}
    }
    
    /**
     * 
     * @param event - The create table number button is fired
     */
    @FXML
    void createTableTicket(ActionEvent event) {
    	//get table number
    	try
    	{
    		//gets the text and sets it to the ticket table number
    		ticket.setTablenum(Integer.parseInt(tableNumberTxt.getText()));
    		//for testing only
    		//tableNumberTxt.setText("Input accepted: " + ticket.getTablenum());
    		//Go to next screen
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		tableNumberTxt.setText("Value entered is not allowed");
    		
    	}
    	finally
    	{
    		
    	}
    	
    }

    @Override
	public void setScreenParent(ScreensController screenParent) {
		
		myController = screenParent;
	}
    @FXML
    void AddFoodToCustomer(ActionEvent event) {
    	//tab enabling
    	disableAllTabs();
    	AddFoodToCustomerTab.setDisable(false);
    	TabParent.getSelectionModel().selectNext();
    }

    /**
     * Edits the Ticket
     * @param event
     */
    @FXML
    void EditEndTicket(ActionEvent event) {

    }

    /**
     * Finish the ticket and send it off to the database. 
     * The database then is read by the individual stations for each ticket.
     * @param event
     */
    @FXML
    void FinishTicket(ActionEvent event) {
    	TicketAccessor ta = new TicketAccessor();
    	StationTicketAccessor sta = new StationTicketAccessor();
    	Station_Ticket st = new Station_Ticket();
    	//consolidate data
    	//Set ticketTime
    	ticket.setTime_in(LocalDateTime.now());
    	//create ticket in database
    	try
    	{
    		//make sure session is clear
    		factory.getCurrentSession().close();
    		ta.AddTicket(ticket, factory.getCurrentSession());
    		factory.getCurrentSession().close();
    		factory.getCurrentSession().beginTransaction();
    		
    		//Call the procedure
    		ProcedureCall result = factory.getCurrentSession().createStoredProcedureCall("GetNewestTicketID");
    		@SuppressWarnings("rawtypes")
			//Get result
    		List resultlist =result.getResultList();
    		factory.getCurrentSession().getTransaction().commit();
    		int num = (int) resultlist.get(0);
        	//set the ticket id
        	st.setTicket_id(num);
        	//Set Excludes and Includes
        	st.setExcludes("");
        	st.setIncludes("");
        	st.setStart_time(ticket.getTime_in());
        	//for each food item in the list
        	for(TableOrder to: tableOrders)
        	{
        		if(factory.getCurrentSession().getTransaction().isActive())
        		{
        			//make sure session is clear
            		factory.getCurrentSession().clear();
        		}
        		//set station ticket food id
        		st.setFood_id(to.getFoodId());
        		//add to database
        		
        		sta.AddStationTicket(st, factory.getCurrentSession());
        	}
        	myController.setScreen("Home");
    	}
    	catch (Exception ex)
    	{
    		ex.printStackTrace();
    	}
    }

    @FXML
    void FoodItemSelected(MouseEvent event) {
    	//disabling
    	disableAllTabs();
    	CustomerNumberTab.setDisable(false);
    	TabParent.getSelectionModel().selectPrevious();
    	
    	/*Get the index of the food item
    	 * The foodlist and list of food is a parallel array
    	 * It is for that reason FoodList index can be used as foodID
    	 */
    	/*
    	 * TODO: Add Exclude, Include, and Allergy Functionality
    	 * Exclude, Include, and Allergy auto null until functionality is added for it
    	 */
    	AddFoodItemToOrder(customerFocus, FoodList.getSelectionModel().getSelectedIndex(), "", "", ""); 
    }

    @FXML
    void GoToNextCustomer(ActionEvent event) {
    	//disabling
    	disableAllTabs();
    	//if not on last customer
    	if(customerFocus +1<= numCustomer)
    	{
    		
        	CustomerNumberTab.setDisable(false);
    		customerFocus +=1;
    		customerNumberLbl.setText("Customer Number: " + customerFocus);
    	}
    	else //end of customer orders
    	{
    		
    		//go to finish ordering
    		TabParent.getSelectionModel().selectLast();
    		FinishTicketTab.setDisable(false);
    		setTicketReview();
    	}
    	
    }

    

	@FXML
    void SetTableNumber(ActionEvent event) {
    	//SetEnabled Tabs
    	//disable table
    	disableAllTabs();
    	//Set number people tab disable false
    	NumberPeopleTab.setDisable(false);
    	TabParent.getSelectionModel().selectNext();
    	//get table number
    	try
    	{
    		//gets the text and sets it to the ticket table number
    		ticket.setTablenum(Integer.parseInt(tableNumberTxt.getText()));
    		//for testing only
    		//tableNumberTxt.setText("Input accepted: " + ticket.getTablenum());	
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();
    		tableNumberTxt.setText("Value entered is not allowed");
    		disableAllTabs();
    		TableNumberTab.setDisable(false);
    		//go back to the screen
    		TabParent.getSelectionModel().selectPrevious();
    	}
    	//Set up spinner Value factory.
    	SpinnerValueFactory<Integer> valueFactory =
    	new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 3000, 1);
    	numberPeopleSpinner.setValueFactory(valueFactory);
    	
    }

    @FXML
    void StartFoodOrder(ActionEvent event) {
    	//Set Disables
    	disableAllTabs();
    	CustomerNumberTab.setDisable(false);
    	customerNumberLbl.setText("Customer Number: " + 1);
    	//get the number of customers
    	numCustomer = numberPeopleSpinner.getValue();
    	TabParent.getSelectionModel().selectNext();
    	SetListViewOfFood();
    }
    

	/**
     * Disables all of the tabs
     */
    private void disableAllTabs()
    {
    	TabParent.setPrefSize(myController.getWidth(), myController.getHeight());
    	TabParent.requestLayout();
    	ServerNumberTab.setDisable(true);
    	TableNumberTab.setDisable(true);
    	NumberPeopleTab.setDisable(true);
    	CustomerNumberTab.setDisable(true);
    	AddFoodToCustomerTab.setDisable(true);
    	TableNumberTab.setDisable(true);
    	TableNumberTab.setDisable(true);
    }
    
    /**
     * Creates the review label
     */
    private void setTicketReview() {
		// TODO Auto-generated method stub
		StringBuilder str = new StringBuilder();
		int previousCustomer =0;
		//input the table number
		str.append("Table Number: "+ ticket.getTablenum());
		//go through all of the orders in the array
		for(TableOrder tbo: tableOrders)
		{
			if(previousCustomer != tbo.getCustomerNum()) //next customer
			{
				str.append("\n\nCustomer Number: " + tbo.getCustomerNum());
				previousCustomer = tbo.getCustomerNum();
			}
			//output food for customer
			str.append("\n\t"+foodIdToName(tbo.getFoodId()));
		}
		//set TicketReviewText
		TicketReview.setText(str.toString());
	}
    /**
     * Gets the food name from the according to the foodID
     * @param foodId - the food ID
     * @return the food name in a strings
     */
    private String foodIdToName(int foodId) {
		return food.get(foodId).getFood_name();
	}

	/**
     * Sets the list view for the servers to be able to pick it
     */
    private void SetListViewOfFood() {
		// TODO Auto-generated method stub
		if(factory.getCurrentSession().isOpen())
		{
			factory.getCurrentSession().close();
		}
		if(factory.isOpen())
		{
			//Get all the food from the database and display it
			food = fa.getFoodItem(factory.getCurrentSession());
			//Add it all to the list view
			for(Food foods: food) {
				
				FoodList.getItems().add(foods.getFood_name());
			}
		}
		
		
	}
    
    /**
     * Adds a food item to the customer and subsequently table
     * @param custNum
     * @param FoodId
     * @param Excludes
     * @param Includes
     * @param Allergy
     */
    private void AddFoodItemToOrder(int custNum, int FoodId, String Excludes, String Includes, String Allergy)
    {
    	TableOrder tb = new TableOrder(0,custNum,FoodId,Excludes,Includes,Allergy);
    	tableOrders.add(tb);
    }
	@Override
	public void SetFactory(SessionFactory factory) {
		
		
		this.factory=factory;
	}

	
}
