package dboTestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ FoodTestSuite.class, ServersTestSuite.class, 
	StationTicketsTestSuite.class, TicketTestSuite.class})
public class DboAllTests {

}
