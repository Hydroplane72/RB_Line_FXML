package dboTestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import model_dbo.StationTickets.*;

@RunWith(Suite.class)
@SuiteClasses({CreateSTTest.class, STNotNullTests.class, STSetTests.class})
public class StationTicketsTestSuite {

}
