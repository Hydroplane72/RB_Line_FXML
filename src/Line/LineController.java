package Line;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;

import bo.Order;
import dbo.Station_Ticket;
import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class LineController implements ControlledScreen {
	ScreensController myController;
	private SessionFactory factory;
	protected static ArrayList<Order> orders = new ArrayList<Order>();
	private static ArrayList<String> orderStrings = new ArrayList<String>();
	private Timer timer = new Timer(); //Used to Auto update the page
	
	//Start FXML Variables
	@FXML
	GridPane Orders_Holder;
	@FXML
	Button Button_1;
	@FXML
	Button Button_2;
	@FXML
	Button Button_3;
	@FXML
	Button Button_4;
	@FXML
	Button Button_5;
	@FXML
	Button Button_6;
	@FXML
	Button Button_7;
	@FXML
	Button Button_8;
	@FXML
	Button Button_9;
	@FXML
	Button Button_10;
	@FXML
    private Label LineStationName;
	
	//Begin FXML Actions
	@FXML
    void GoBackToMainScreen(ActionEvent event) {
		myController.setScreen("Home");
    }
	@FXML
	protected void Button_1Clicked(ActionEvent event) {
		ButtonClicked(1);
	}

	@FXML
	protected void Button_2Clicked(ActionEvent event) {
		ButtonClicked(2);
	}

	@FXML
	protected void Button_3Clicked(ActionEvent event) {
		ButtonClicked(3);
	}

	@FXML
	protected void Button_4Clicked(ActionEvent event) {
		ButtonClicked(4);
	}

	@FXML
	protected void Button_5Clicked(ActionEvent event) {
		ButtonClicked(5);
	}

	@FXML
	protected void Button_6Clicked(ActionEvent event) {
		ButtonClicked(6);
	}

	@FXML
	protected void Button_7Clicked(ActionEvent event) {
		ButtonClicked(7);
	}

	@FXML
	protected void Button_8Clicked(ActionEvent event) {
		ButtonClicked(8);
	}

	@FXML
	protected void Button_9Clicked(ActionEvent event) {
		ButtonClicked(9);
	}

	@FXML
	protected void Button_10Clicked(ActionEvent event) {
		ButtonClicked(10);
	}

	/**
	 * When a button is clicked it calls this method. This method then updates with
	 * the information from the button.
	 * 
	 * @param buttonNum
	 *            The button number that called this function
	 */
	private void ButtonClicked(int buttonNum) {
		
		/*
		 * Go through and switch the orders to the next order. The program skips buttons
		 * that are after the button pressed The if statements in each case are for each
		 * individual button to know what order to take out of the orders array.
		 */
		switch (buttonNum) {
		case 1:
			Button_1.setText(Button_2.getText());

		case 2:
			Button_2.setText(Button_3.getText());

		case 3:
			Button_3.setText(Button_4.getText());

		case 4:
			Button_4.setText(Button_5.getText());

		case 5:

			Button_5.setText(Button_6.getText());
		case 6:

			Button_6.setText(Button_7.getText());
		case 7:

			Button_7.setText(Button_8.getText());
		case 8:

			Button_8.setText(Button_9.getText());
		case 9:

			Button_9.setText(Button_10.getText());
		case 10:

			Button_10.setText("");
			// getNextOrder()
			break;
		default:
			System.out.println("Something is wrong");
		}
		// Complete the order in the array and database
		completeOrder(buttonNum);
		//Relayout
		Orders_Holder.requestLayout();
		myController.stage.sizeToScene();
	}

	/**
	 * Signals and completes a ticket order
	 * 
	 * @param buttonNum
	 */
	private void completeOrder(int buttonNum) {
		// TODO: Implement in the database actually completing an order
		buttonNum -=1; //for array purposes
		
		//checks size and buttonNum compared to size
		if(!LineController.orders.isEmpty() && orders.size() > buttonNum)
		{
			//checks not null
			if(orders.get(buttonNum) != null)
			{ 
				completeDatabaseOrder(orders.get(buttonNum).getTicket().get(0).getStt_id());
				//checks passed
				//remove orders
				orders.remove(buttonNum);
				orderStrings.remove(buttonNum);
			}
			
		}		
	}
	@SuppressWarnings("deprecation")
	private boolean completeDatabaseOrder(int orderID)
	{
		try {
			int ticketID = orderID;
			Session session= factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("\nGetting ticket with id: "+ ticketID);
			//get ticket object based on ticketID
			Station_Ticket myticket = session.get(Station_Ticket.class, ticketID);
			
			//update object
			
			LocalDateTime timeNow = LocalDateTime.now();
			myticket.setEnd_time(new Date(timeNow.getYear(), timeNow.getMonthValue(), timeNow.getDayOfMonth()));
			
			//commit to database
			session.getTransaction().commit();
			
			System.out.println("Done");
			
		}
		catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		return true;
	}
	@Override
	public void setScreenParent(ScreensController screenParent) {
		myController = screenParent;

	}
	/**
	 * 	This is used to add a new order to the screen
	 * @param ticket --> The ticket information
	 * @param sf --> the Session Factory so that the function can look up information on order details
	 */
	public void AddOrder(List<Station_Ticket> ticket, SessionFactory sf)
	{
		//TODO: Initiate new order in database
		Order newOrder = new Order(ticket,  sf);
		orders.add(newOrder);
		ordersToScreen();
	}
	/**
	 * <p>This is used to reset the screen if there is ever a need to.
	 * <p>This is also used to add a new order to the screen. If the new order number is greater than 10 then it 
	 * will not be shown on the screen and only added to the orderStrings array.
	 */
	protected void ordersToScreen()
	{
		//get the new order and set it to the screen if within 10 otherwise wait
		int orderNum = orders.size();//Not converted to array because buttons start at 1
		
		//add to orderStrings
		orderStrings.add(orders.get(orderNum-1).getTicketText());
		
		//Check if new order would even be on screen
		if(orderNum<=10 && orderNum >=1)
		{
			switch(orderNum)
			{
			case 1:
				Button_1.setText(orderStrings.get(0));
			case 2:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_2.setText(orderStrings.get(1));
			case 3:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_3.setText(orderStrings.get(2));
			case 4:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_4.setText(orderStrings.get(3));
			case 5:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_5.setText(orderStrings.get(4));
			case 6:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_6.setText(orderStrings.get(5));
			case 7:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_7.setText(orderStrings.get(6));
			case 8:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_8.setText(orderStrings.get(7));
			case 9:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_9.setText(orderStrings.get(8));
			case 10:
				//when you have reached the size of the order strings
				//prevents out of bounds exceptions
				if(orderNum >=orderStrings.size())
				{
					break;
				}
				Button_10.setText(orderStrings.get(9));
				break;
			default:
				//Should not reach here because of the if statement
				Button_1.setText("Something is wrong");
			}
		}
	}

	@Override
	public void SetFactory(SessionFactory factory) {
		
		this.factory= factory;
	}
	
	@FXML
    void initialize() {
        assert Orders_Holder != null : "fx:id=\"Orders_Holder\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_1 != null : "fx:id=\"Button_1\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_2 != null : "fx:id=\"Button_2\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_3 != null : "fx:id=\"Button_3\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_4 != null : "fx:id=\"Button_4\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_5 != null : "fx:id=\"Button_5\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_6 != null : "fx:id=\"Button_6\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_7 != null : "fx:id=\"Button_7\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_8 != null : "fx:id=\"Button_8\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_9 != null : "fx:id=\"Button_9\" was not injected: check your FXML file 'Line.fxml'.";
        assert Button_10 != null : "fx:id=\"Button_10\" was not injected: check your FXML file 'Line.fxml'.";
        
        //set the gridpane to the window
        
        //set the station name
        LineStationName.setText(ScreensController.getScreenName());
        //Set layout of Window
       // SetLayout();
        //System.out.println("Screen Name: "+ ScreensController.getScreenName());
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                UpdateScreen();
            }
        }, 0, 5000);
        
        
	}
	/**
	 * Updates the screen with orders
	 */
	protected void UpdateScreen() {
		try {
			//makes sure session is ok
			if(factory.getCurrentSession() != null && factory.getCurrentSession().getTransaction().isActive())
    		{
    			//make sure session is clear
        		factory.getCurrentSession().clear();
        		factory.getCurrentSession().close();
    		}
			factory.getCurrentSession().beginTransaction();
			//call the procedure
			
			@SuppressWarnings("unchecked")
			NativeQuery<Station_Ticket> query =	factory.getCurrentSession().getNamedNativeQuery("GetStationTickets")
					.setParameter("StationName", ScreensController.getScreenName());
			System.out.println(ScreensController.getScreenName());
			List<Station_Ticket> result = query.getResultList();
			
			//Clear the orders array
			orders.clear();
			orderStrings.clear();
			//go through each and add to orders array
			int prevTID =-1;
			ArrayList<Station_Ticket> tickets = new ArrayList<Station_Ticket>();
			
			
			for(Station_Ticket st: result)
			{
				//see if previous ticket was of same table/ticketID
				if(prevTID != st.getTicket_id())
				{
					/*
					 * This next ticket to be added is a different ticket number
					 * Add tickets in tickets array to orders and go to next slot
					 * in orders array
					 */
					if(prevTID != -1)
					{
						//makes sure session is ok
						if(factory.getCurrentSession().getTransaction().isActive())
			    		{
			    			//make sure session is clear
			        		factory.getCurrentSession().clear();
			        		factory.getCurrentSession().close();
			    		}
						
						
						//add tickets to orders
						orders.add(new Order(tickets, factory));
						
						
						//set new order to screen
						ordersToScreen();
					}
					//set ticket_ID
					prevTID = st.getTicket_id();
					//reset tickets
					tickets = new ArrayList<Station_Ticket>();
				}
				//add ticket to tickets
				tickets.add(st);
			}
			
		
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		SetLayout();
	}
	
	private void SetLayout()
	{
		Orders_Holder.setPrefSize(myController.getWidth(), myController.getHeight());

		Orders_Holder.requestLayout();
		/*Orders_Holder.prefHeight(Orders_Holder.getParent().getScene().getHeight());
		Orders_Holder.prefWidth(Orders_Holder.getParent().getScene().getWidth());
		
		Button_1.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_1.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_2.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_2.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_3.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_3.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_4.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_4.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_5.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_5.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_6.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_6.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_7.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_7.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_8.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_8.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_9.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_9.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		Button_10.prefHeightProperty().bind(Orders_Holder.heightProperty());
		Button_10.prefWidthProperty().bind(Orders_Holder.widthProperty());
		
		LineStationName.prefHeightProperty().bind(Orders_Holder.heightProperty());
		*/
		
	}
	
	@FXML public void ResetPage(ActionEvent event) 
	{
		UpdateScreen();
		
		SetLayout();
	}
}
