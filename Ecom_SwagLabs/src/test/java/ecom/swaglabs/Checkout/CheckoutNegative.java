package ecom.swaglabs.Checkout;



import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import GenericUtilities.ExcelUtility;
import GenericUtilities.TakeScreenShot;
import PomUtilites.Addtocart_pom;
import PomUtilites.CheckoutPage_pom;

public class CheckoutNegative extends baseclass {


    @Test(groups = {"FT", "Negative"})
    public void verifyFirstNameValidation() throws Exception {
        ExcelUtility eu = new ExcelUtility();
        //String firstName = eu.readDataFromExcel("Sheet1", 2, 0);
        String lastName = eu.readDataFromExcel("Sheet1", 2, 1);
        String postalCode = eu.readDataFromExcel("Sheet1", 2, 2);

        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout = new CheckoutPage_pom(driver);

        checkout.clickBurger_and_reset();

        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        // First Name is empty in Excel
        checkout.getLastName(lastName);
        checkout.getPostalCode(postalCode);
        checkout.clickContinue();
        String error = checkout.getErrorMessage();
        TakeScreenShot tks = new TakeScreenShot();
        tks.takeScreenShot(driver, "FirstNameValidation");
        Assert.assertTrue(error.contains("First Name"),"First Name validation message not displayed");
        Reporter.log("First Name validation completed");
    }


    @Test(groups = {"FT", "Negative"})
    public void verifyLastNameValidation() throws Exception {

        ExcelUtility eu = new ExcelUtility();

        String firstName = eu.readDataFromExcel("Sheet1", 3, 0);
       // String lastName = eu.readDataFromExcel("Sheet1", 3, 1);
        String postalCode = eu.readDataFromExcel("Sheet1", 3, 2);
        
        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout = new CheckoutPage_pom(driver);
        checkout.clickBurger_and_reset();
        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.getFirstName(firstName);
        // Last Name is empty in Excel
        checkout.getPostalCode(postalCode);
        checkout.clickContinue();
        String error = checkout.getErrorMessage();
        TakeScreenShot tks = new TakeScreenShot();
        tks.takeScreenShot(driver, "LastNameValidation");
        Assert.assertTrue(error.contains("Last Name"),"Last Name validation message not displayed");
        Reporter.log("Last Name validation completed");
    }



    @Test(groups = {"FT", "Negative"})
    public void verifyPostalCodeValidation() throws Exception {

        ExcelUtility eu = new ExcelUtility();

        String firstName = eu.readDataFromExcel("Sheet1", 4, 0);
        String lastName = eu.readDataFromExcel("Sheet1", 4, 1);
        //String postalCode = eu.readDataFromExcel("Sheet1", 4, 2);

        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout = new CheckoutPage_pom(driver);
        checkout.clickBurger_and_reset();
        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.getFirstName(firstName);
        checkout.getLastName(lastName);
        // Postal Code is empty in Excel
        checkout.clickContinue();
        String error = checkout.getErrorMessage();
        TakeScreenShot tks = new TakeScreenShot();
        tks.takeScreenShot(driver, "PostalCodeValidation");
        Assert.assertTrue(error.contains("Postal Code"),"Postal Code validation message not displayed");

        Reporter.log("Postal Code validation completed");
    }

    
    

    @Test(groups = {"FT", "Negative"})
    public void verifyAllFieldsValidation() throws Exception {

    	
    	
        Addtocart_pom cart = new Addtocart_pom(driver);
        CheckoutPage_pom checkout = new CheckoutPage_pom(driver);
        checkout.clickBurger_and_reset();
        cart.addBackpackToCart();
        cart.openCart();
        checkout.clickCheckout();
        checkout.clickContinue();
        String error = checkout.getErrorMessage();
        TakeScreenShot tks = new TakeScreenShot();
        tks.takeScreenShot(driver, "AllFieldsValidation");
        Assert.assertTrue(error.contains("First Name"),"First Name validation message not displayed");
        Reporter.log("All fields validation completed");
    }
}