package dboTestSuites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import model_dbo.food.*;


@RunWith(Suite.class)
@SuiteClasses({FoodCreateTests.class, FoodNotNullTests.class, FoodSetTests.class})
public class FoodTestSuite {

}
