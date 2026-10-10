package PomUtilites;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Addtocart_pom {

    WebDriver driver;

    public Addtocart_pom(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement addBackpackBtn;

    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removeBackpackBtn;

    @FindBy(id = "remove-sauce-labs-backpack")
    WebElement removebtn;
    
    public void addBackpackToCart() {
        addBackpackBtn.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public void openCart() {
        cartIcon.click();
    }

    public void removeBackpackFromCart() {
        removeBackpackBtn.click();
    }
    public void remove_Backpack() {
    	 removebtn.click();
    	     
}  
}