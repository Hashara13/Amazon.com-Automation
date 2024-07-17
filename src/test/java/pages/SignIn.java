package pages;
import org.testng.Assert;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn {
	private WebDriver driver;
	@FindBy(id="ap_email")
	private WebElement EmailInput;
    @FindBy(xpath="//*[@id=\"continue\"]")
    private WebElement SignINButton;
    @FindBy(className="a-button-inner")
    private WebElement CreateButton;
    @FindBy(id="auth-error-message-box")
	private WebElement ErrorAlert;
    @FindBy(id="ap_customer_name")
	private WebElement name;
    @FindBy(id="ap_email")
	private WebElement emailInput;
    @FindBy(id="ap_password")
	private WebElement passwordInput;
    @FindBy(id="ap_password_check")
	private WebElement Confirmpassword;
    @FindBy(id="continue")
	private WebElement continueButton;
    @FindBy(id="cvf-input-code")
   	private WebElement OTPInput;
    @FindBy(id="a-button-input")
   	private WebElement OTPEnter;
    
    public SignIn(WebDriver driver) {
    	this.driver=driver;
        PageFactory.initElements(driver, this);	
    }
    
    public void enterEmail(String Email) {
    	EmailInput.sendKeys(Email);
    }
    public void pressButton() {
    	SignINButton.click();
    }
    public void errorMessage(String Username,String Email,String Password,String expectedTitle) {
    	pressButton();
    	if(IsError()) {
    		CreateAxccount(Username,Email,Password,expectedTitle);
    	}
    	else {
    		verifyPageTitle(expectedTitle);
    	}
    	
    }
    
    public boolean IsError() {
    	  try {
              return ErrorAlert.isDisplayed();
          } catch (NoSuchElementException e) {
              return false;
          }
    }
    
    public void CreateAxccount(String Username,String Email,String Password,String expectedTitle) {
    	CreateButton.click();
    	name.sendKeys(Username);
    	emailInput.sendKeys(Email);
    	passwordInput.sendKeys(Password);
    	continueButton.click();
    	verifyPageTitle(expectedTitle);
    }
    public void sendOTP(String OTPKey) {
    	OTPInput.sendKeys(OTPKey);
    	OTPEnter.click();
    }
    public void verifyPageTitle(String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match!");
        driver.quit();
    }
    
}
