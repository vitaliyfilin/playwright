import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/java/features"},
        stepNotifications = true,
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        publish = true
)
public class TestRunner {
}
