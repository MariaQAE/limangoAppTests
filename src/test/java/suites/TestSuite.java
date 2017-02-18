package suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.LimangoPositiveScenarioLogInTest;

@RunWith(Suite.class)
@SuiteClasses({

    LimangoPositiveScenarioLogInTest.class,
})
public class TestSuite {
}