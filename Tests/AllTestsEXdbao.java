import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import dboTestSuites.*;

/**
 * To keep redundant and test data out of database as much as possible
 * @author MatthewsLaptop
 *
 */
@RunWith(Suite.class)
@SuiteClasses({DboAllTests.class })
public class AllTestsEXdbao {

}
