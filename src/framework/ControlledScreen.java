/**
 * 
 */
package framework;

import org.hibernate.SessionFactory;

/**
 * @author MatthewsLaptop
 *
 */
public interface ControlledScreen {
	public String ScreenNames = "";
	//This method will allow the injection of the Parent ScreenPane
    public void setScreenParent(ScreensController screenPage);
    public void SetFactory(SessionFactory factory);
    
}
