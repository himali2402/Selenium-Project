package Alchemy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {


		    WebDriver driver;
		    
		    @BeforeMethod
		    public void beforeMethod() {
		        //Create a new instance of the Firefox driver
		        driver = new FirefoxDriver();
		        
		        //Open browser
		        driver.get("http://alchemy.hguy.co/crm");
		    }

		    @Test
		    public void getFooterText() {
		        // Get the Footer
		        WebElement footerTxt = driver.findElement(By.id("admin_options"));	                    
		        //Print the  copyright text in the footer
		        System.out.println("First Footer Copyright is: " +  footerTxt.getText());
		        
		       
		    }

		    @AfterMethod
		    public void afterMethod() {
		        //Close the browser
		        driver.quit();
		    }

}
