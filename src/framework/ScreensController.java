/**
 * 
 */
package framework;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import dbo.Food;
import dbo.Servers;
import dbo.Station_Ticket;
import dbo.Ticket;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;



/**

 *

 * @author Angie

 */

public class ScreensController  extends StackPane {

    public static String ScreenNames = null;
    
	public Scene scene;
    public Stage stage;
    
    public static String getScreenName()
    {
    	return ScreenNames;
    }
    /**Holds the screens to be displayed
     * String - file name
     * Node - File route
     * */
	
    private HashMap<String, Node> screens = new HashMap<>();
    
    SessionFactory factory = new Configuration()
			 .configure("hibernate.cfg.xml")
			 .addAnnotatedClass(Food.class)
			 .addAnnotatedClass(Servers.class)
			 .addAnnotatedClass(Station_Ticket.class)
			 .addAnnotatedClass(Ticket.class)
			 .buildSessionFactory();

    public ScreensController() {
        super();
    }

    /**Add the screen to the collection*/

    public void addScreen(String name, Node screen) {

        screens.put(name, screen);
        
    }

    /**Returns the Node with the appropriate name*/
    public Node getScreen(String name) {
    		
    	//Set screen Name too
    	ScreenNames = name;
        return screens.get(name);

    }
    
    
    /**Loads the fxml file, add the screen to the screens collection and

    finally injects the screenPane to the controller.*/

    public boolean loadScreen(String name, String resource) {

        try {
        	//Set the Screen name
        	//DO NOT MOVE FROM POSITION
        	//SETS SCREEN NAME BEFORE PAGE LOAD
            ScreenNames = name;
            
        	//resource ="/Line/Line.fxml";
            FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
            
            Parent loadScreen = (Parent) myLoader.load();
            
            ControlledScreen myScreenControler = ((ControlledScreen) myLoader.getController());
            
            myScreenControler.setScreenParent(this);
            //set the factory
            myScreenControler.SetFactory(factory);
            
            addScreen(name, loadScreen);
           
            return true;

        } catch (Exception e) {

            System.out.println("In " +e.getMessage());

            return false;

        }

    }

    /**This method tries to displayed the screen with a predefined name.

    First it makes sure the screen has been already loaded.  Then if there is more than

    one screen the new screen is been added second, and then the current screen is removed.

     If there isn't any screen being displayed, the new screen is just added to the root.
*/
    public boolean setScreen(final String name) {       

        if (screens.get(name) != null) 
        {   //screen loaded

            final DoubleProperty opacity = opacityProperty();

          //Set the Screen name
            ScreenNames = name;
            
            
            if (!getChildren().isEmpty()) {    //if there is more than one screen open

                Timeline fade = new Timeline
                		(

                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 1.0)),
                        //Create Action Event
                        new KeyFrame(new Duration(1000), new EventHandler<ActionEvent>() {

                    @Override

                    public void handle(ActionEvent t) {

                        getChildren().remove(0);                    //remove the displayed screen

                        getChildren().add(0, screens.get(name));     //add the screen
                        
                        //Fade the screen in
                        Timeline fadeIn = new Timeline(

                                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),

                                new KeyFrame(new Duration(800), new KeyValue(opacity, 1.0)));

                        fadeIn.play();

                    }

                }, new KeyValue(opacity, 0.0)));

                fade.play();

            } 
            else //if no screen
            {

                setOpacity(0.0);

                getChildren().add(screens.get(name));       //no one else been displayed, then just show

                Timeline fadeIn = new Timeline(

                        new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),

                        new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));

                fadeIn.play();

            }
            stage.sizeToScene();
            
            return true;

        } else {

            System.out.println("screen hasn't been loaded!!! \n");

            return false;

        }



        

        /*Node screenToRemove;

         if(screens.get(name) != null){   //screen loaded

         if(!getChildren().isEmpty()){    //if there is more than one screen

         getChildren().add(0, screens.get(name));     //add the screen

         screenToRemove = getChildren().get(1);

         getChildren().remove(1);                    //remove the displayed screen

         }else{

         getChildren().add(screens.get(name));       //no one else been displayed, then just show

         }

         return true;

         }else {

         System.out.println("screen hasn't been loaded!!! \n");

         return false;

         }*/

    }

    //This method will remove the screen with the given name from the collection of screens

    public boolean unloadScreen(String name) {

        if (screens.remove(name) == null) {

            System.out.println("Screen didn't exist");

            return false;

        } else {

            return true;

        }

    }
    public void setScene(Scene scene, Stage stage)
    {
    	this.scene = scene;
    	this.stage = stage;
    	
    }
    
	
}
