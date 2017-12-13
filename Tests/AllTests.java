import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import dbaoTestSuites.*;

/**
 * Used to test everything in the program
 * @author MatthewsLaptop
 *
 */
@RunWith(Suite.class)
@SuiteClasses({DbaoTestSuite.class, AllTestsEXdbao.class})
public class AllTests {

}
