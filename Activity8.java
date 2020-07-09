package Alchemy;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity8 {
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
        // Get the UserName Field (Find and select the username and password fields)
        WebElement userName = driver.findElement(By.id("user_name"));
        Assert.assertTrue(userName.isDisplayed(), "Username Field is displayed");
        userName.sendKeys("admin");   
               
        // Get the Password Field( Find and select the username and password fields)
        WebElement pwd = driver.findElement(By.id("username_password"));
        Assert.assertTrue(pwd.isDisplayed(), "Password Field is displayed");
        pwd.sendKeys("pa$$w0rd");  
        
        // Login Button( Click login)
        WebElement loginBtn = driver.findElement(By.xpath("//input[@title='Log In']"));
        Assert.assertTrue(loginBtn.isDisplayed(), "Login button is displayed");
        loginBtn.click();  
        
        // Homepage is opened(find Accounts )
        Actions builder = new Actions(driver);
        WebElement mainMenuElement= driver.findElement(By.id("grouptab_0"));
        builder.moveToElement(mainMenuElement).build().perform();
        mainMenuElement.click();
        WebElement accountsMenu = driver.findElement(By.xpath("//a[@id='moduleTab_9_Accounts']"));
        System.out.println("Accountsmenu exists : "	+ accountsMenu.getText());
        Assert.assertTrue(accountsMenu.isDisplayed(), "Accounts is displayed");
        accountsMenu.click();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.className("moduleTitle")));
        
        //Find the table on the page and print the names of the first 5 odd-numbered rows of the table to the console
        List<WebElement> listOfElements = driver.findElements(By.xpath("//tr[@class='oddListRowS1']/td[3]/b/a"));
        int listSize = listOfElements.size();
        System.out.println("List size is : "	+ listSize);
        for(int i = 0;i<5;i++)
        {
        System.out.println(listOfElements.get(i).getText());
        }     
    }

    @AfterMethod
    public void afterMethod() {
        //Close the browser
        driver.quit();
    }


}
