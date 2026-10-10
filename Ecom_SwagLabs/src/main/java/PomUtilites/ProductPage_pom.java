package PomUtilites;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage_pom {
	 WebDriver driver;
	 
	 
	 public ProductPage_pom(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }
	 
	 
	 

	    @FindBy(className = "product_sort_container")
	    WebElement sortDropdown;

	    @FindBy(className = "inventory_item_name")
	    List<WebElement> productNames;

	    @FindBy(className = "inventory_item_price")
	    List<WebElement> productPrices;

	    @FindBy(id = "add-to-cart-sauce-labs-backpack")
	    WebElement addBackpackBtn;

	    @FindBy(className = "shopping_cart_badge")
	    WebElement cartBadge;

	    @FindBy(className = "shopping_cart_link")
	    WebElement cartIcon;
	    
	    @FindBy(id = "remove-sauce-labs-backpack")
	    WebElement rmbtn;

	   

	    public void sortBy(String option) {
	         Select select = new Select(sortDropdown);
	        select.selectByVisibleText(option);
	    }

	    public int getProductCount() {
	        return productNames.size();
	    }

	    public String getFirstProductName() {
	        return productNames.get(0).getText();
	    }

	    public void addBackpackToCart() {
	        addBackpackBtn.click();
	    }

	    public String getCartCount() {
	        return cartBadge.getText();
	    }

	    public void openCart() {
	        cartIcon.click();
	    }

	    public void removebtn() {
	    	rmbtn.click();
	    }
	     
}
