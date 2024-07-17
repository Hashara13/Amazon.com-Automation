package Tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Driver.LoadDriver;
import pages.LandingPage;
import pages.SignIn;



public class BaseTest {
	 static WebDriver driver;
	    static LandingPage home;
	    static SignIn signin;
	    @BeforeClass
	    public void setUp() {
	    	 String url = "https://www.amazon.com";
	    	 driver = LoadDriver.getDriver("firefox", url);
			driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	        home = new LandingPage(driver);
	        signin = new SignIn(driver);
	    }
	    
	    @Test(priority = 1)
	    public void SignInNavigation() {
	    	home.navigateSignup();
	    }
	    @Test(priority = 2)
	    public void SignInTest() {
	    	signin.enterEmail(null);
	    	signin.enterEmail(null);
	    	signin.errorMessage("hashara","hashara","hashara","hashara");
	    }
	    
	    @AfterClass
	    public void tearDown() {
	        driver.quit();
	    }
	    
}
