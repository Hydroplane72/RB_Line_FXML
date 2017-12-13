package home;
/**
 * Sample Skeleton for 'home.fxml' Controller Class
 */

import org.hibernate.SessionFactory;

import framework.ControlledScreen;
import framework.ScreensController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class homeController implements ControlledScreen{
	ScreensController myController;
	@SuppressWarnings("unused")
	private SessionFactory factory;
	
    @FXML // fx:id="MainPageContainer"
    private GridPane MainPageContainer; // Value injected by FXMLLoader

    @FXML // fx:id="FryBtn"
    private Button FryBtn; // Value injected by FXMLLoader

    @FXML // fx:id="PantryBtn"
    private Button PantryBtn; // Value injected by FXMLLoader

    @FXML // fx:id="BroilBtn"
    private Button BroilBtn; // Value injected by FXMLLoader

    @FXML // fx:id="SauteBtn"
    private Button SauteBtn; // Value injected by FXMLLoader

    @FXML // fx:id="PizzaBtn"
    private Button PizzaBtn; // Value injected by FXMLLoader

    @FXML // fx:id="Fry_Time"
    private Label Fry_Time; // Value injected by FXMLLoader

    @FXML // fx:id="Pantry_Time"
    private Label Pantry_Time; // Value injected by FXMLLoader

    @FXML // fx:id="Broil_Time"
    private Label Broil_Time; // Value injected by FXMLLoader

    @FXML // fx:id="Saute_Time"
    private Label Saute_Time; // Value injected by FXMLLoader

    @FXML // fx:id="Pizza_Time"
    private Label Pizza_Time; // Value injected by FXMLLoader

    @FXML // fx:id="AddNewTableBtn"
    private Button AddNewTableBtn; // Value injected by FXMLLoader

    @FXML // fx:id="AddToTable"
    private Button AddToTable; // Value injected by FXMLLoader

    @FXML // fx:id="AddFood"
    private Button AddFood; // Value injected by FXMLLoader

    @FXML // fx:id="EndTable"
    private Button EndTable; // Value injected by FXMLLoader

    @FXML
    void GetBroilScreen(ActionEvent event) {
    	myController.setScreen("Broil");
    }

    @FXML
    void GetFryScreen(ActionEvent event) {
    	myController.setScreen("Fry");
    }

    @FXML
    void GetPantryScreen(ActionEvent event) {
    	myController.setScreen("Pantry");
    }

    @FXML
    void GetPizzaScreen(ActionEvent event) {
    	myController.setScreen("Pizza");
    }

    @FXML
    void GetSauteScreen(ActionEvent event) {
    	myController.setScreen("Saute");
    }

    @FXML
    void GetNewTableScreen(ActionEvent event) {
    	myController.setScreen("AddNewTable");
    	
    }
    
	@Override
	public void setScreenParent(ScreensController screenParent) {
		
		myController = screenParent;
	}

	@Override
	public void SetFactory(SessionFactory factory) {
		// TODO Auto-generated method stub
		this.factory = factory;
	}

	

}
