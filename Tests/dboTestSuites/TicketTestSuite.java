package dboTestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import model_dbo.Ticket.*;

@RunWith(Suite.class)
@SuiteClasses({CreateTicketTest.class, TicketNotNullTests.class, TicketSetTests.class})
public class TicketTestSuite {

}
