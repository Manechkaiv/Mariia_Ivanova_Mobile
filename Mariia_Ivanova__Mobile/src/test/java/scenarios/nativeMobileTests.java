package scenarios;

import org.testng.Assert;
import org.testng.annotations.Test;
import properties.ConfProperties;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException{

        getPo().getWelement("registerButton").click();
        getPo().getWelement("registrationEmail").sendKeys(ConfProperties.getProperty("Email"));
        getPo().getWelement("registrationUserName").sendKeys(ConfProperties.getProperty("UserName"));
        getPo().getWelement("registrationPassword").sendKeys(ConfProperties.getProperty("Password"));
        getPo().getWelement("registrationConfirmPassword").sendKeys(ConfProperties.getProperty("Password"));
        getPo().getWelement("registerNewAccountButton").click();
        getPo().getWelement("loginEmail").sendKeys(ConfProperties.getProperty("Email"));
        getPo().getWelement("loginPassword").sendKeys(ConfProperties.getProperty("Password"));
        getPo().getWelement("signInButton").click();
        String pageText = getPo().getWelement("pageText").getText();
        System.out.println(pageText);
        Assert.assertEquals(pageText, "BudgetActivity");
        System.out.println("Simple Android native test done");

    }
}