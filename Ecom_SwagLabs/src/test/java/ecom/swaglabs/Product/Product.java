package ecom.swaglabs.Product;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Baseclass.baseclass;
import PomUtilites.ProductPage_pom;


	public class Product extends baseclass {

	    @Test(groups = {"FT", "ST"})
	    public void verifyProductPage() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        int count = product.getProductCount();

	        Assert.assertTrue(count >0,"Products are not displayed");

	        Reporter.log("Products displayed successfully");
	    }

	    @Test(groups = {"FT"})
	    public void verifyNameAToZ() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        product.sortBy("Name (A to Z)");

	        Assert.assertEquals(product.getFirstProductName(),"Sauce Labs Backpack");

	        Reporter.log("Name A-Z sorting completed");
	    }

	    @Test(groups = {"FT"})
	    public void verifyNameZToA() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        product.sortBy("Name (Z to A)");

	        Assert.assertEquals(product.getFirstProductName(),"Test.allTheThings() T-Shirt (Red)");

	        Reporter.log("Name Z-A sorting completed");
	    }

	    @Test(groups = {"FT"})
	    public void verifyPriceLowToHigh() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        product.sortBy("Price (low to high)");

	        Assert.assertEquals(product.getFirstProductName(),"Sauce Labs Onesie");

	        Reporter.log("Price low-high sorting completed");
	    }

	    @Test(groups = {"FT"})
	    public void verifyPriceHighToLow() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        product.sortBy("Price (high to low)");

	        Assert.assertEquals(product.getFirstProductName(),"Sauce Labs Fleece Jacket");

	        Reporter.log("Price high-low sorting completed");
	    }

	    @Test(groups = {"IT"})
	    public void verifyProductToCart() {
	        ProductPage_pom product = new ProductPage_pom(driver);
	        product.addBackpackToCart();
	        product.openCart();
	        Assert.assertTrue(driver.getCurrentUrl().contains("cart.html"),"Product page flow failed");
	        Reporter.log("Product to Cart integration completed");
	    }

	    @Test(groups = {"System"})
	    public void verifyProductPurchaseFlow() {

	        ProductPage_pom product = new ProductPage_pom(driver);

	        product.addBackpackToCart();

	        Assert.assertTrue(product.getProductCount()> 0,"Product purchase flow failed");

	        System.out.println("Product system flow completed");
	        product.removebtn();
	    }
	}

