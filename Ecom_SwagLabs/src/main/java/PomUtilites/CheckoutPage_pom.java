package PomUtilites;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage_pom {
	 WebDriver driver;
	 
	 
	 public CheckoutPage_pom(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(id = "checkout")
	    private WebElement checkoutBtn;

	    @FindBy(id = "first-name")
	    private WebElement firstName;

	    @FindBy(id = "last-name")
	    private WebElement lastName;

	    @FindBy(id = "postal-code")
	    private WebElement postalCode;

	    @FindBy(id = "continue")
	    private WebElement continueBtn;

	    @FindBy(id = "finish")
	    private WebElement finishBtn;

	    @FindBy(css = "[data-test='error']")
	    private WebElement errorMsg;

	    @FindBy(className = "complete-header")
	    private WebElement successMsg;
	     
	    @FindBy(id = "react-burger-menu-btn")
	    private WebElement burger;
	    
	    @FindBy(id="reset_sidebar_link")
	    private WebElement reset;
	    
	    

	    public void clickCheckout() {
	        checkoutBtn.click();
	    }

	    public void enterDetails(String fName, String lName, String zip) {
	        firstName.sendKeys(fName);
	        lastName.sendKeys(lName);
	        postalCode.sendKeys(zip);
	    }
	    
	    
	    
	    public void getFirstName(String fname) {
	    	firstName.sendKeys(fname);
	    }
	    
	    
	    public void getLastName(String lname) {
	    	lastName.sendKeys(lname);
	    }
	    
	    public void getPostalCode(String code) {
	    	postalCode.sendKeys(code);
	    }
	    
	    

	    public void clickContinue() {
	        continueBtn.click();
	    }

	    public void clickFinish() {
	        finishBtn.click();
	    }
	    
	    

	    public String getErrorMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(errorMsg));
	        return errorMsg.getText();
	    }

	    public String getSuccessMessage() {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.visibilityOf(successMsg));
	        return successMsg.getText();
	    }
	    
	    public void clickBurger_and_reset() {
	    	burger.click();
	    	reset.click();
	    	driver.navigate().refresh();
	    	
	    }
	    
	    
	    
	    
	    
	    

}
