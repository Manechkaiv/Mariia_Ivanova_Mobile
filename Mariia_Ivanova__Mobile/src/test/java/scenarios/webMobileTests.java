package scenarios;

import org.openqa.selenium.JavascriptExecutor;;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import setup.BaseTest;
import properties.ConfProperties;

import java.util.List;
import static org.testng.Assert.assertTrue;

public class webMobileTests extends BaseTest {

    public static final String TEXT = "EPAM";

    @Test(groups = {"web"}, description = "Make sure that we've opened Google homepage")
    public void simpleWebTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {

        getDriver().get(ConfProperties.getProperty("URL"));

        new WebDriverWait(getDriver(), 10).until(
                wd -> ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete")
        );

        getPo().getWelement("searchField").sendKeys(TEXT);
        getPo().getWelement("searchButton").click();

        List<WebElement> actualResults = getPo().getWelements("results");

        assertTrue(!actualResults.isEmpty());

    }
}
