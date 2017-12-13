package dboTestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import model_dbo.servers.*;

@RunWith(Suite.class)
@SuiteClasses({ServersCreateTests.class,ServersSetTests.class, ServersNotNullTests.class})
public class ServersTestSuite {

}
