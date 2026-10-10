package ecom.swaglabs.Checkout;

import java.io.IOException;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.TakeScreenShot;
import PomUtilites.CheckoutPage_pom;
import PomUtilites.ProductPage_pom;
import PomUtilites.Addtocart_pom;



public class CheckoutPositive extends baseclass {

    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData() throws Exception {

        ExcelUtility eu = new ExcelUtility();
        String firstName =eu.readDataFromExcel("Sheet1", 1, 0);
        String lastName =eu.readDataFromExcel("Sheet1", 1, 1);
        String postalCode =eu.readDataFromExcel("Sheet1", 1, 2);
        return new Object[][] {{firstName, lastName, postalCode}};
    }

    
    
    
    
    @Test(groups = {"FT", "ST"},dataProvider = "checkoutData")
    public void verifyCheckout(String firstName,String lastName,String postalCode) {
        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout =new CheckoutPage_pom(driver);
        
        checkout.clickBurger_and_reset();
        
        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.enterDetails(firstName,lastName,postalCode);
        checkout.clickContinue();
        checkout.clickFinish();
        Assert.assertEquals(checkout.getSuccessMessage(),"Thank you for your order!","Checkout failed");
        Reporter.log("Checkout completed successfully");
    }

    
    
    
    
    @Test(groups = {"IT"},dataProvider = "checkoutData")
    public void verifyCartToCheckoutIntegration(String firstName,String lastName,String postalCode) {

        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout =new CheckoutPage_pom(driver);
        
        checkout.clickBurger_and_reset();
        
        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.enterDetails(firstName,lastName,postalCode);
        checkout.clickContinue();
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two.html"),"Cart to Checkout integration failed");

        Reporter.log("Cart to Checkout integration completed");
    }

    
    
    
    @Test(groups = {"System"},dataProvider = "checkoutData")
    public void verifyCompleteSystemFlow(String firstName,String lastName,String postalCode) {
        ProductPage_pom product = new ProductPage_pom(driver);
        Addtocart_pom cart =new Addtocart_pom(driver);
        CheckoutPage_pom checkout =new CheckoutPage_pom(driver);
        
        checkout.clickBurger_and_reset();
        
        product.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.enterDetails(firstName,lastName,postalCode);
        checkout.clickContinue();
        checkout.clickFinish();
        Assert.assertEquals(
                checkout.getSuccessMessage(),"Thank you for your order!","Complete system flow failed");

        Reporter.log("Complete system testing flow passed");
    }








@Test(groups = {"FT"})
public void verifyCheckoutValidation() throws IOException {

    Addtocart_pom cart = new Addtocart_pom(driver);
    CheckoutPage_pom checkout =new CheckoutPage_pom(driver);
    
    checkout.clickBurger_and_reset();

    cart.addBackpackToCart();
    cart.openCart();

    checkout.clickCheckout();
    checkout.clickContinue();

    String error =checkout.getErrorMessage();
 

    Assert.assertTrue(error.contains("First Name"),"Validation message not displayed");
    TakeScreenShot tks= new TakeScreenShot();
    tks.takeScreenShot(driver,"Checkouterror");

    Reporter.log("Checkout validation completed");
}


}
