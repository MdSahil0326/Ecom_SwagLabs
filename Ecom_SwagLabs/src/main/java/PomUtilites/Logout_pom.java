package PomUtilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout_pom {
	WebDriver driver;
	public Logout_pom(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "react-burger-menu-btn")
	private WebElement hamburgerbtn;
	
	@FindBy(id = "logout_sidebar_link")
	private WebElement logoutbtn;
	
	
	public void logout() throws InterruptedException {
		hamburgerbtn.click();
		Thread.sleep(2000);
		logoutbtn.click();
		
	}
}
