package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;
    @FindBy(xpath="//*[@id=\"nav-link-accountList\"]")
    WebElement SignInContainer;
    @FindBy(id="twotabsearchtextbox")
    WebElement searchInput;
    
    public LandingPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
 

	public void navigateSignup() {
    	SignInContainer.click();
    }
    public void searchItem(String searchItem) {
    	searchInput.sendKeys(searchItem);
    }

}
