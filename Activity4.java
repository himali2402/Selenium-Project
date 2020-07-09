package Alchemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity4 {

    WebDriver driver;
    
    @BeforeMethod
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        
        //Open browser
        driver.get("http://alchemy.hguy.co/crm");
    }

    @Test
    public void loginToCRM() {
        // Get the UserName Field (c. Find and select the username and password fields)
        WebElement userName = driver.findElement(By.id("user_name"));
        Assert.assertTrue(userName.isDisplayed(), "Username Field is displayed");
        userName.sendKeys("admin");   
               
        // Get the Password Field(c. Find and select the username and password fields)
        WebElement pwd = driver.findElement(By.id("username_password"));
        Assert.assertTrue(pwd.isDisplayed(), "Password Field is displayed");
        pwd.sendKeys("pa$$w0rd");  
        
        // Login Button(e. Click login)
        WebElement loginBtn = driver.findElement(By.xpath("//input[@title='Log In']"));
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is displayed");
        loginBtn.click();  
        
        // Homepage is opened(f. Verify that the homepage has opened)
        WebElement homePage = driver.findElement(By.xpath("//a[@id='moduleTab_Home']"));
        homePage.click();
        System.out.println("HomePage text is: " +  homePage.getText());
        Assert.assertTrue(homePage.isDisplayed(), "Home Page is displayed");
        
        //Assert.assertEquals(homePage.getText(), "Home", "Homepage is displayed");
                       
    
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
