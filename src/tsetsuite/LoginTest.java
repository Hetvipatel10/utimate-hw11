package tsetsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseurl = "https://courses.ultimateqa.com/users/sign_in";

    @Before
    public void setUp() {
        openBrowser(baseurl);
    }


    @Test
    public void userShouldLoginSuccessFullyWithValidCredentials() {

        //click on sign in link
        WebElement sighnInLink = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        sighnInLink.click();

        //Verify the text ‘Welcome Back!’
        WebElement text = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        text.click();

    }

    @Test
    public void verifyTheErrorMessage() {

        //click on sign in link
        WebElement sighnInLink = driver.findElement(By.xpath("//li[@class='header__nav-item header__nav-sign-in']"));
        sighnInLink.click();

        //enter invalid username
        WebElement usernameField = driver.findElement(By.id("user[email]"));
        usernameField.sendKeys("patelhetvi20@gmail.com");

        //enter invalid password into password field
        WebElement passwordField = driver.findElement(By.name("user[password]"));
        passwordField.sendKeys("123456");

        //click on login button
        WebElement loginButton = driver.findElement(By.xpath("//button[@class='button button-primary g-recaptcha']"));
        loginButton.click();

        //Verify the error message ‘Invalid email or password.’
        WebElement text1 = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        text1.click();
        String actualText = text1.getText();
        String expectedText = "Invalid email or password";
        Assert.assertEquals(expectedText, actualText);
    }

    @After
    public void teardown() {
        closeBrowser();

    }
}





