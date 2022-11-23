package testsuite;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter valid user name
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter valid Password
        sendTextToElement(By.name("password"),"secret_sauce");
        //Click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        // This is from requirement
        String expectedMessage= "PRODUCTS";
        // Find the text element and get the text
        String actualMessage = getTextFromElement(By.xpath("//span[@class='title']"));
        // Validate actual and expected message
        Assert.assertEquals(expectedMessage,actualMessage);
    }
    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Enter valid user name
        sendTextToElement(By.id("user-name"),"standard_user");
        //Enter valid Password
        sendTextToElement(By.name("password"),"secret_sauce");
        //Click on login button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        // Verify that six products are displayed on page
        List<WebElement> list = driver.findElements(By.className("inventory_item"));
        int size = list.size();
        System.out.println("Number of products per page:"+size);
    }
    @After
    public void tearDown(){
        closeBrowser();
    }
}
