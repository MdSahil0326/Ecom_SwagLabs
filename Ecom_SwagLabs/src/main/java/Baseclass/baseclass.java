package Baseclass;


import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import PomUtilites.Login_pom;
import PomUtilites.Logout_pom;


public class baseclass {
	protected WebDriver driver = null;
	
	 @BeforeSuite(alwaysRun = true)
		public void Bs() {
			System.out.println("establish database connectivity");
		}
		@AfterSuite(alwaysRun = true)
		public void As() {
			System.out.println("close database connectivity");
		}
		@BeforeTest(alwaysRun = true)
		public void Bt() {
			System.out.println("pre conditions");
		}
		
		
		
		@Parameters("browser")
		@BeforeClass(alwaysRun = true)
		public void Bc( String browser) throws IOException {


		    FileInputStream fis =
		            new FileInputStream("src/test/resources/DDT/Config.properties");

		    Properties p = new Properties();
		    p.load(fis);

		    //String browser = p.getProperty("browser");
		    if (browser.equalsIgnoreCase("chrome")) {
		        ChromeOptions options = new ChromeOptions();
		        options.addArguments("--incognito");
		        driver = new ChromeDriver(options);
		        driver.manage().window().maximize();
		    }
		    else if (browser.equalsIgnoreCase("edge")) {
		    	driver= new EdgeDriver();
		    	driver.manage().window().maximize();
		    	
		    }
		    else if(browser.equalsIgnoreCase("firefox")) {
		    	driver= new FirefoxDriver();
		    	driver.manage().window().maximize();
		    }
		    

		    fis.close();
		}
		
		@BeforeMethod(alwaysRun = true)
		public void Bm() throws Exception{
		
			Login_pom s= new Login_pom(driver);
			//load the property file 
			FileInputStream fis= new FileInputStream("src/test/resources/DDT/Config.properties");
			 Properties p= new Properties();
			 p.load(fis);
			 //get the url using the property file 
			driver.get(p.getProperty("url"));
			 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			 s.getusern(p.getProperty("Username"));
			 s.getPwtf(p.getProperty("Password"));
			 s.getLogin();
			System.out.println("login done");   
		}	
		@AfterMethod(alwaysRun = true)
		public void Am() throws InterruptedException {
			Logout_pom logO= new Logout_pom(driver);
			logO.logout();
			
			System.out.println("logout executed");
		}
		@AfterClass(alwaysRun = true)
		public void Ac() throws InterruptedException{
			Thread.sleep(2000);
			driver.quit();
			System.out.println("close browser");
		}
		@AfterTest(alwaysRun = true)
		public void At() {
			System.out.println("post conditions");
		}	
}

