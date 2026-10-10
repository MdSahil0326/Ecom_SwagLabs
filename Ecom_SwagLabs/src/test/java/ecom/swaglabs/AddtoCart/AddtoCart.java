package ecom.swaglabs.AddtoCart;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import PomUtilites.Addtocart_pom;
import PomUtilites.ProductPage_pom;

public class AddtoCart extends baseclass {

    @Test(groups = {"FT", "ST"})
    public void verifyAddToCart() {

        Addtocart_pom cart = new Addtocart_pom(driver);

        cart.addBackpackToCart();

        Assert.assertEquals( cart.getCartCount(),"1","Product was not added to cart");

        Reporter.log("Product added to cart successfully");
        cart.remove_Backpack();
    }

    @Test(groups = {"FT"})
    public void verifyOpenCart() {

        Addtocart_pom cart = new Addtocart_pom(driver);

        cart.addBackpackToCart();
        cart.openCart();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart.html"),"Cart page was not opened");

        Reporter.log("Cart page opened successfully");
        cart.removeBackpackFromCart();
    }

    @Test(groups = {"FT"})
    public void verifyRemoveFromCart() {

        Addtocart_pom cart = new Addtocart_pom(driver);

        cart.addBackpackToCart();
        cart.openCart();
        cart.removeBackpackFromCart();

        Assert.assertTrue(
                driver.findElements(By.id("remove-sauce-labs-backpack")).isEmpty(),
                "Product was not removed from cart");

        Reporter.log("Product removed successfully");
    }

    @Test(groups = {"IT"})
    public void verifyProductAndCartIntegration() {

        ProductPage_pom product = new ProductPage_pom(driver);
        Addtocart_pom cart = new Addtocart_pom(driver);

        product.addBackpackToCart();

        Assert.assertEquals(cart.getCartCount(),"1","Product was not added to cart");

        cart.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),"Cart page was not opened");

        Reporter.log("Product and Cart integration completed");
        cart.removeBackpackFromCart();
    }

    @Test(groups = {"System"})
    public void verifyCartSystemFlow() {

        ProductPage_pom product = new ProductPage_pom(driver);
        Addtocart_pom cart = new Addtocart_pom(driver);

        product.addBackpackToCart();
        cart.openCart();

        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),"System flow failed");
        Reporter.log("Cart system flow completed");
        cart.removeBackpackFromCart();
    }
}