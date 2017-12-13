import framework.ScreensController;

import javafx.application.Application;

import javafx.stage.Stage;


import javafx.scene.Group;

import javafx.scene.Scene;


/**
 * 
 */

/**
 * @author MatthewsLaptop
 *
 */
public class RB_Line_AppRunner extends Application {

	final public static String Fry = "Fry";
	final public static String Broil = "Broil";
	final public static String Pantry = "Pantry";
	final public static String Saute = "Saute";
	final public static String Pizza = "Pizza";
	final public static String LineScreenFile = "/Line/Line.fxml";
	final public static String Home = "Home";
	final public static String HomeScreenFile ="/home/home.fxml";
	final public static String NewTable = "AddNewTable";
	final public static String NewTableScreenFile = "/newTable/AddNewTable.fxml";
	final public static String AddNumPeopleScreenFile = "/newTable/AddNewTable.fxml";
    @Override

    public void start(Stage primaryStage) {

        ScreensController mainContainer = new ScreensController();
        
        //Load the Station Views
        mainContainer.loadScreen(RB_Line_AppRunner.Fry, RB_Line_AppRunner.LineScreenFile);
        mainContainer.loadScreen(RB_Line_AppRunner.Broil, RB_Line_AppRunner.LineScreenFile);
        mainContainer.loadScreen(RB_Line_AppRunner.Pantry, RB_Line_AppRunner.LineScreenFile);
        mainContainer.loadScreen(RB_Line_AppRunner.Saute, RB_Line_AppRunner.LineScreenFile);
        mainContainer.loadScreen(RB_Line_AppRunner.Pizza, RB_Line_AppRunner.LineScreenFile);
        
        //Load the Home screen
        mainContainer.loadScreen(RB_Line_AppRunner.Home, RB_Line_AppRunner.HomeScreenFile);
        //load the add new table screen
        mainContainer.loadScreen(RB_Line_AppRunner.NewTable, RB_Line_AppRunner.NewTableScreenFile);
        //add new orders to mainContainer
        mainContainer.setPrefWidth(mainContainer.getPrefWidth());
        mainContainer.setPrefHeight(mainContainer.getPrefHeight());
        Group root = new Group();

        root.getChildren().addAll(mainContainer);
        
        
        Scene scene = new Scene(root);
        //button.prefWidthProperty().bind(grid.heightProperty());
        
        primaryStage.setScene(scene);
        mainContainer.setScene(scene, primaryStage);
        mainContainer.setScreen(RB_Line_AppRunner.Home);
        
        primaryStage.show();

    }



    /**

     * The main() method is ignored in correctly deployed JavaFX application.

     * main() serves only as fallback in case the application can not be

     * launched through deployment artifacts, e.g., in IDEs with limited FX

     * support. NetBeans ignores main().

     *

     * @param args the command line arguments

     */

    public static void main(String[] args) {

        launch(args);

    }
    
}
